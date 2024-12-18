package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.UserDaoImpl;

/**
 * Servlet implementation class Reset
 */
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reset() {
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
		String password = request.getParameter("password");
		String cPassword = request.getParameter("confirm");
		
		HttpSession s = request.getSession();
		String username = s.getAttribute("username").toString();
		
		if(password.equals(cPassword)) {
			try {
				UserDaoImpl dao = new UserDaoImpl();
				dao.reset(username, password);
				response.sendRedirect("login.jsp");
			} catch (SQLException e) {
				Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
	            request.setAttribute("errorMessage", e.getMessage());
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
				e.printStackTrace();
			}
		}else {
			 request.setAttribute("message", "Password doesn't matched!!...Try again");
			 request.getRequestDispatcher("reset.jsp").forward(request, response);
		}
	}

}
