package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
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
		String otp = request.getParameter("otp");
		
		HttpSession s = request.getSession();
		Object sentOtp = s.getAttribute("otp");
		
		if(sentOtp!=null) {
			if(otp.equals(sentOtp.toString())) {
				response.sendRedirect("reset.jsp");
			}else {
				request.setAttribute("message", "Invalid OTP! Try again!!");
				request.getRequestDispatcher("validate.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "Timeout!! Try again!!");
			request.getRequestDispatcher("forget.jsp").forward(request, response);
		}
		
	}

}
