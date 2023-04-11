package sn.isi.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ICv;
import sn.isi.dao.IUser;
import sn.isi.entities.Cv;
import sn.isi.entities.User;

/**
 * Servlet implementation class CvServletKha
 */
@WebServlet("/cvkhaly")
public class CvServletKha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final User user = null;
	
	@EJB
	private ICv cvdao;
	
	@EJB
	private IUser userdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CvServletKha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cv c = new Cv();
        List<Cv> cvList = cvdao.list(c);
       
        request.setAttribute("cvList",cvList);
        request.getRequestDispatcher("UserVue.jsp").forward(request, response);
        
		
		
	}

	/**
	 * @param id1 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
			
			
			String action = request.getParameter("action");
			if(action.equals("Enregistrer")) {
				String name = request.getParameter("name");
				String prenom = request.getParameter("prenom");
				String age = request.getParameter("age");
				int ageint = Integer.parseInt(request.getParameter("age"));
				String adresse = request.getParameter("adresse");
				String email = request.getParameter("email");
				String telephone = request.getParameter("telephone");
				String specialite = request.getParameter("specialite");
				String niveauetude = request.getParameter("niveauetude");
				String experiencepro = request.getParameter("experiencepro");
				
				
		               
				if (name.isEmpty()) {
					
					request.setAttribute("ERROR", "ERROR");
					request.getRequestDispatcher("VueCv.jsp").forward(request, response);	
				}
				Cv c = new Cv();
				
				c.setName(name);
				c.setPrenom(prenom);
				c.setAge(ageint);
				c.setAdresse(adresse);
				c.setEmail(email);
				c.setTelephone(telephone);
				c.setSpecialite(specialite);
				c.setNiveauetude(niveauetude);
				c.setExperiencepro(experiencepro);
				
				cvdao.add(c);
				
				 List<Cv> cvList = cvdao.list(c);
		         request.setAttribute("cvList", cvList);
				request.getRequestDispatcher("UserVue.jsp").forward(request, response);
		
			}
			
	}
	
	
}
