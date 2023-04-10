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
		//User u = new User();
       // List<User> userList = userdao.list(u);
        
        //request.setAttribute("userList", userList);
		//Cv c = new Cv();
		//List<Cv> cvList = cvdao.list(c);
		
		//request.getRequestDispatcher("VueCv.jsp").forward(request, response);
		//List<Cv> cvList = cvdao.list(cv);
		//request.getRequestDispatcher("list.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 doGet(request, response);
		 
			
		
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
			
			request.getRequestDispatcher("VueCv.jsp").forward(request, response);
			 
	            
	}
	 */
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
	    User user =new User();
		if (action.equals("Enregistrer")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			/*if (login.isEmpty() & password.isEmpty()) {
				request.setAttribute("errorremplir", "veuillez remplir tous les champs*");
				request.getRequestDispatcher("UserVue.jsp").forward(request, response);
			}else {*/
				user.setLogin(login);
				user.setPassword(password);
				userdao.add(user);
				
				//String subject="vos informations apres inscriptions"+"Prenom:"+firstname+"Nom:"+lastname;
            	//String body="Merci!!!";
//            	try {
//					mailsender.sendEmail(email ,subject, body);
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
            	request.getRequestDispatcher("VueCv.jsp").forward(request, response);
                
				
			//}
			
		
		//si action est egale a enregistrer CV
		
            	
			/*if (action.equals("Enregistrercv")) {
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
			
                //			    verification des champs 
				if (name.isEmpty()||prenom.isEmpty()||email.isEmpty()||adresse.isEmpty()||specialite.isEmpty()||niveauetude.isEmpty()||experiencepro.isEmpty()) {
					 request.setAttribute("error", "veuillez remplir tous les champs*");
					 request.getRequestDispatcher("VueCv.jsp").forward(request, response);
				}else {
                    	
							Cv cv =new Cv();
							cv.setName(name);
							cv.setPrenom(prenom);
							cv.setAge(ageint);
							cv.setAdresse(adresse);
							cv.setEmail(email);
							cv.setTelephone(telephone);
							cv.setSpecialite(specialite);
							cv.setNiveauetude(niveauetude);
							cv.setExperiencepro(experiencepro);
							 // Récupère le candidat par son identifiant
							
							cvdao.add(cv);	
							
							// Envoyer un e-mail de bienvenue
					        String to = cv.getEmail();
					        String subject = "Bienvenue sur notre site";
					        String body = "Hello " + cv.getPrenom() + ",\n\n" +
					                      "Nous vous remercions de votre inscription à notre site.\n\n" +
					                      "Kind Regards,\n" +
					                      "TEAM !";
					        
							request.setAttribute("message", "Vos informations de connexion vous ont été envoyé par mail *");
							
							request.setAttribute("success", "votre  Cv est crée*");
							request.getRequestDispatcher("UserVue.jsp").forward(request, response);
						}
					 }
		}else {
			if (action.equals("report")){
				String email = (String) session.getAttribute( "email" );
				if (email!= null) {
					Integer  id1 = (int) session.getAttribute( "id" );
					
					// Récupération des informations du candidat depuis la base de données
					User userinfo= userdao.get(id1, user);
					Cv cv = userdao.getCvByUserId(id1);
					 if (cv != null) {
					        // Afficher les informations du CV
						    request.setAttribute("user", userinfo);
							request.setAttribute("cv", cv);
							System.out.println("============================================"+cv);
							request.getRequestDispatcher("cvreport.jsp").forward(request, response);
							if (action.equals("imprimer")) {
								
							}
							
					    } else {
					        // Gérer le cas où le candidat n'a pas de CV enregistré
					    	request.getRequestDispatcher("VueCv.jsp").forward(request, response);
					    }
					// Stockage du candidat en tant qu'attribut de la requête
					
					
				}
				
			}*/
		}
	}
		
} 
	 
	
