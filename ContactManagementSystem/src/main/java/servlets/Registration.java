package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.User;
import dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("cpass");
		
		if(!password.equals(confirmPassword)) {
			request.setAttribute("errorMessage", "Password doesn't match");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		else if (email != "" && contact != "" && name != "" && password != "" && confirmPassword != "") {

			User user = new User(email, contact, name, password);
			UserDaoImpl userDao = new UserDaoImpl();

			try {
				if (userDao.add(user) == 1) {
					response.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
				request.setAttribute("errorMessage", e.getMessage());
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
			}
		}else {
			request.setAttribute("errorMessage", "Fill all the details!!");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

}
