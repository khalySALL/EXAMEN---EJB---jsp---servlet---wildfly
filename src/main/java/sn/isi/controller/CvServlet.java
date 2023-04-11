package sn.isi.controller;

import java.io.IOException;


import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sn.isi.dao.ICv;
import sn.isi.dao.IUser;
import sn.isi.entities.Cv;
import sn.isi.entities.User;


/**
 * Servlet implementation class CvServlet
 */
@WebServlet("/cvmalick")
public class CvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICv cvdao;
	
	@EJB
	private IUser userdao;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String login = (String) session.getAttribute( "login" );
		String password = (String) session.getAttribute( "password" );
		
		if (login !=null) {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Veillez-vous authentifier svp !");
			request.getRequestDispatcher("UserVue.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
	    User user =new User();
		if (action.equals("Enregistrer")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
				user.setLogin(login);
				user.setPassword(password);
				userdao.add(user);
				
				
		}
	}
		
} 
	 
	
