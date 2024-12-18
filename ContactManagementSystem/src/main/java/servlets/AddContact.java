package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Contact;
import beans.User;
import dao.ContactDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddContact
 */
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String name = request.getParameter("name");
		
		HttpSession sess = request.getSession();	
		String owner= ((User) sess.getAttribute("user")).getEmail();
		
		if (email != "" && name != "" && contact != "") {
			
			Contact con = new Contact();
			con.setEmail(email);
			con.setContact(contact);
			con.setName(name);
			con.setOwner(owner);
			
			ContactDaoImpl dao = new ContactDaoImpl();
			
			try {
				if(dao.ifExists(contact, owner)) {
					request.setAttribute("message", "Contact Already Exists!!");
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				}else {
					dao.addContact(con);
					response.sendRedirect("dashboard.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, e);
	            request.setAttribute("errorMessage", e.getMessage());
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
			}
		}else {
			request.setAttribute("message", "Input all the details");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

}
