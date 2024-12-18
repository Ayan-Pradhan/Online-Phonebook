package servlets;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDaoImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.GenerateOTP;
import service.SendMail;

/**
 * Servlet implementation class Forget
 */
public class Recovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recovery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		
		UserDaoImpl dao = new UserDaoImpl();
		
		try {
			if(dao.ifExists(username)) {
				int otp = GenerateOTP.generate();
				SendMail mail = new SendMail(username,"Recover Credential","One time password for account recovery is : "+otp+"\n OTP is valid for 5 minutes");
				HttpSession s = request.getSession(true);
				s.setMaxInactiveInterval(300);
				s.setAttribute("otp", otp);
				s.setAttribute("username", username);
				response.sendRedirect("validate.jsp");
			}else {
				request.setAttribute("message", "You're not registered with us!!");
				request.getRequestDispatcher("forget.jsp").forward(request, response);
			}
		} catch (SQLException | MessagingException e) {
			e.printStackTrace();
		}
	}

}
