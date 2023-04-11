package sn.isi.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import sn.isi.dao.IUser;


import sn.isi.entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/khalyservlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IUser userdao;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		User user = new User();
		List<User> userList =userdao.list(user);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("UserVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
			
		
		String action = request.getParameter("action");
		if(action.equals("Enregistrer")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			if (login.isEmpty()) {
				
				request.setAttribute("ERROR", "ERROR");
				request.getRequestDispatcher("UserVue.jsp").forward(request, response);	
			}
			User u = new User();
			u.setLogin(login);
			u.setPassword(password);
	
			userdao.add(u);
			
			
			List<User> userList =userdao.list(u);
			request.setAttribute("userList", userList);
			 
			request.getRequestDispatcher("VueCv.jsp").forward(request, response);
			
			}
		
	}
		
}
