package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.IUser;
import sn.isi.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	private IUser userdao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("UserVue.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("connexion")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			if (login.isEmpty() & password.isEmpty()) {
				request.setAttribute("error", "Invalide remplir les champs ");
				request.getRequestDispatcher("UserVue.jsp").forward(request, response);
			} else {
			User user = userdao.authenticateuser(login, password);
			if (user == null) {
				request.setAttribute("error", "user Invalide ");
				request.getRequestDispatcher("UserVue.jsp").forward(request, response);
			} else {
				
				HttpSession session = request.getSession();
				
				int id=user.getId();
				session.setAttribute("login", login);
				session.setAttribute("password", password);
				
				session.setAttribute("id",id);
				response.sendRedirect("listcvservlet");
				

			}
			// fin if
		}
		// fin if
	}

	}
}
