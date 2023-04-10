package sn.isi.controller;

import java.io.IOException;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ICv;
import sn.isi.entities.Cv;

/**
 * Servlet implementation class ListCvServlet
 */
@WebServlet("/listcvservlet")
public class ListCvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ICv cvdao;
	
	private Object cvlist;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cv c = new Cv();
        List<Cv> listcv = cvdao.list(c);
        String action = request.getParameter("action");
        request.setAttribute("listcv",listcv);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
        if("delete".equalsIgnoreCase("action")) {
        	try {
				String name = request.getParameter("name");
				cvdao.remove(cvdao.find(name));
				response.sendRedirect("listservlet");
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				request.setAttribute("listcv",listcv);
		        request.getRequestDispatcher("liscvservlet").forward(request, response);
			}
        }
        
	}

	/**
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
			
			
	        
			Cv c = new Cv();
			//c.setUser(u);
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
			
			 List<Cv> listcv = cvdao.list(c);
	         request.setAttribute("listcv", listcv);
	         request.getRequestDispatcher("home.jsp").forward(request, response);
	         
	         
								
	
		}
		
	}
}


