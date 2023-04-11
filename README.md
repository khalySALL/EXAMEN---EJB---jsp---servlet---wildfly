# Documentation 

La thématique qui sera traitée dans ce travail sera du domaine de la 
recherche d'emploi. Il sera lieu de faciliter à un demandeur d'emploi une 
interface d’accès pour voir les offres d'emplois postées et la notification 
d'offres suivant les catégories concernées. Dans le dispositif qui sera mis en 
place les accès essentiels sont et pour cela vous allez créer les endpoints 
suivants :
§ Inscription (Création de son CV enrégistré dans la base MySQL) : 
page publique
§ Authentification après creation du CV : page publique
§ Edition d’un CV enrégistré dans la base MySQL : page privée
§ Supprimer d’un CV enrégistré dans la base MySQL: page privée
§ Modification d’un CV enrégistré dans la base MySQL: page privée
§ Visualisation des CV enrégistrés dans la base MySQL: page privée
§ Générer au format PDF les CV de la base de données
§ Envoyer un mail de notification après chaque inscription
§ Ajouter un forum de discussion entre demandeurs d’emplois
NB:
- Pour le CV, vous avez les rubriques suivantes: nom, prenom, age, 
adresse, email, telephone specialite, niveauEetude, 
experienceProfessionnelle

# Inscription (Création de son CV enrégistré dans la base MySQL)

# --------CVSERVLET
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



# --------UserVue.jsp


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="public/login/fonts/icomoon/style.css">

    <link rel="stylesheet" href="public/login/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="public/login/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="public/login/css/style.css">

    <title>Login #5</title>
  </head>
  <body>
  

  <div class="d-md-flex half">
    <div class="bg" style="background-image: url('public/login/images/bg_1.jpg');"></div>
    <div class="contents">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="form-block mx-auto">
              <div class="text-center mb-5">
                <h3 class="text-uppercase"> <strong>Login</strong></h3>
              </div>
              
              <form id="loginform" class="form-horizontal" role="form" action="login" method="post">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										id="login" type="text" class="form-control"
										name="login" value="" placeholder="Login">
								</div>

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input
										id="password" type="password" class="form-control"
										name="password" placeholder="password">
								</div>



								<div class="input-group">
									<div class="checkbox">
										<label> <input id="login-remember" type="checkbox"
											name="remember" value="1"> Remember me
										</label>
									</div>
								</div>


								<div style="margin-top: 10px" class="form-group">
									<!-- Button -->

									<div class="col-sm-12 controls">
										<button type="submit" name="action" value="connexion" class="btn btn-success">Connexion</button>
										<a id="btn-fblogin" href="#" class="btn btn-outline-info "data-toggle="modal" data-target="#myModalHorizontal"><strong>Créer un CV</strong></a>

									</div>
								</div>


								<div class="form-group">
									<div class="col-md-12 control">
										<div
											style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
											Don't have an account! <a href="#"
												onClick="$('#loginbox').hide(); $('#signupbox').show()">
												Sign Up Here </a>
										</div>
									</div>
								</div>
							</form>
              
              
             
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal -->
		<div class="modal fade" id="myModalHorizontal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header"style="background-color: #ead8be;">
					    <c:if test="${not empty errorremplir}">
					    <div class="alert alert-dismissible alert-danger">${error}</div>
				        </c:if>
						<h4 class="modal-title text-secondary" id="myModalLabel">Créer un utilisateur</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body">
					
					
						<form class="form-horizontal" role="form" action="cvmalick" method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputLogin">Login:</label>
								<div class="col-sm-10"><input type="text" name="login" class="form-control" id="inputEmail3" placeholder="Prenom" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputpassword">Password:</label>
								<div class="col-sm-10"><input type="password"  name="password" class="form-control" id="inputEmail3" placeholder="Password" />
								</div>
							</div>
							
							<!-- Modal Footer -->
					        <div class="modal-footer">
						    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						    <button type="submit"name="action" value="Enregistrer" class="btn"style="background-color: #015D53;color: white;">Suivant</button>
					        </div>
						</form>
					</div>

					
				</div>
			</div>
		</div>
<!-- Modal -->

    
  </div>
    
    

    <script src="public/login/js/jquery-3.3.1.min.js"></script>
    <script src="public/login/js/popper.min.js"></script>
    <script src="public/login/js/bootstrap.min.js"></script>
    <script src="public/login/js/main.js"></script>
  </body>
</html>

	
  
  # --------ListCvServlet
  
  
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




#-------- VueCv.jsp


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="public/login/fonts/icomoon/style.css">

    <link rel="stylesheet" href="public/login/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="public/login/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="public/login/css/style.css">

    <title>Login #5</title>
  </head>
  <body>
  

  <div class="d-md-flex half">
    <div class="bg" style="background-image: url('public/login/images/bg_1.jpg');"></div>
    <div class="contents">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="form-block mx-auto">
              <div class="text-center mb-5">
                <h3 class="text-uppercase">Créer votre <strong>Cv</strong></h3>
              </div>
              <form action="cvkhaly" role="form" method="post">
              
              
                
                <div class="form-group first">
                  <label for="name">Nom</label>
                  <input type="text" class="form-control" placeholder="name" name="name">
                </div>
                <div class="form-group first">
                  <label for="prenom">Prenom</label>
                  <input type="text" class="form-control" placeholder="prenom" name="prenom">
                </div>
                <div class="form-group first">
                  <label for="age">Age</label>
                  <input type="text" class="form-control" placeholder="age" name="age">
                </div>
                <div class="form-group first">
                  <label for="adresse">Adresse</label>
                  <input type="text" class="form-control" placeholder="adresse" name="adresse">
                </div>
                <div class="form-group first">
                  <label for="email">Email</label>
                  <input type="text" class="form-control" placeholder="email" name="email">
                </div>
                <div class="form-group first">
                  <label for="telephone">Telephone</label>
                  <input type="text" class="form-control" placeholder="telephone" name="telephone">
                </div>
                <div class="form-group first">
                  <label for="specialite">Specialite</label>
                  <input type="text" class="form-control" placeholder="specialite" name="specialite">
                </div>
                <div class="form-group first">
                  <label for="niveauetude">Niveau d'etude</label>
                  <input type="text" class="form-control" placeholder="niveauetude" name="niveauetude">
                </div>
                <div class="form-group first">
                  <label for="experiencepro">Experience professionnelle</label>
                  <input type="text" class="form-control" placeholder="experiencepro" name="experiencepro">
                </div>
                
                
                
                <div class="d-sm-flex mb-5 align-items-center">
                  <label class="control control--checkbox mb-3 mb-sm-0"><span class="caption">Remember me</span>
                    <input type="checkbox" checked="checked"/>
                    <div class="control__indicator"></div>
                  </label>
                  <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
                </div>
                
                <input type="reset" name="action" value="Annuler" class="btn btn-block py-2 btn-danger">
                <input type="submit" name="action" value="Enregistrer" class="btn btn-block py-2 btn-info">
                

            
              </form>
            </div>
           
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    

    <script src="public/login/js/jquery-3.3.1.min.js"></script>
    <script src="public/login/js/popper.min.js"></script>
    <script src="public/login/js/bootstrap.min.js"></script>
    <script src="public/login/js/main.js"></script>
  </body>
</html>


# Authentification après creation du CV : page publique

# -------LoginServlet

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
			
		}
		
	}

	}
}

# -------UserVue.jsp

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="public/login/fonts/icomoon/style.css">

    <link rel="stylesheet" href="public/login/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="public/login/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="public/login/css/style.css">

    <title>Login #5</title>
  </head>
  <body>
  

  <div class="d-md-flex half">
    <div class="bg" style="background-image: url('public/login/images/bg_1.jpg');"></div>
    <div class="contents">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="form-block mx-auto">
              <div class="text-center mb-5">
                <h3 class="text-uppercase"> <strong>Login</strong></h3>
              </div>
              
              <form id="loginform" class="form-horizontal" role="form" action="login" method="post">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										id="login" type="text" class="form-control"
										name="login" value="" placeholder="Login">
								</div>

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input
										id="password" type="password" class="form-control"
										name="password" placeholder="password">
								</div>



								<div class="input-group">
									<div class="checkbox">
										<label> <input id="login-remember" type="checkbox"
											name="remember" value="1"> Remember me
										</label>
									</div>
								</div>


								<div style="margin-top: 10px" class="form-group">
									<!-- Button -->

									<div class="col-sm-12 controls">
										<button type="submit" name="action" value="connexion" class="btn btn-success">Connexion</button>
										<a id="btn-fblogin" href="#" class="btn btn-outline-info "data-toggle="modal" data-target="#myModalHorizontal"><strong>Créer un CV</strong></a>

									</div>
								</div>


								<div class="form-group">
									<div class="col-md-12 control">
										<div
											style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
											Don't have an account! <a href="#"
												onClick="$('#loginbox').hide(); $('#signupbox').show()">
												Sign Up Here </a>
										</div>
									</div>
								</div>
							</form>
              
              
             
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal -->
		<div class="modal fade" id="myModalHorizontal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header"style="background-color: #ead8be;">
					    <c:if test="${not empty errorremplir}">
					    <div class="alert alert-dismissible alert-danger">${error}</div>
				        </c:if>
						<h4 class="modal-title text-secondary" id="myModalLabel">Créer un utilisateur</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body">
					
					
						<form class="form-horizontal" role="form" action="cvmalick" method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputLogin">Login:</label>
								<div class="col-sm-10"><input type="text" name="login" class="form-control" id="inputEmail3" placeholder="Prenom" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputpassword">Password:</label>
								<div class="col-sm-10"><input type="password"  name="password" class="form-control" id="inputEmail3" placeholder="Password" />
								</div>
							</div>
							
							<!-- Modal Footer -->
					        <div class="modal-footer">
						    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						    <button type="submit"name="action" value="Enregistrer" class="btn"style="background-color: #015D53;color: white;">Suivant</button>
					        </div>
						</form>
					</div>

					
				</div>
			</div>
		</div>
<!-- Modal -->

    
  </div>
    
    

    <script src="public/login/js/jquery-3.3.1.min.js"></script>
    <script src="public/login/js/popper.min.js"></script>
    <script src="public/login/js/bootstrap.min.js"></script>
    <script src="public/login/js/main.js"></script>
  </body>
</html>

   # Visualisation des CV enrégistrés dans la base MySQL: page privée
   
   
   # -------ListCvServlet
   
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


# -------home.jsp

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="public/login/fonts/icomoon/style.css">

    <link rel="stylesheet" href="public/login/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="public/login/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="public/login/css/style.css">

    <title>Login #5</title>
  </head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<form action="logout" method="get">
			<button type="submit" class="btn btn-primary"><strong>DECONNEXION</strong></button>
									
			</form>
		</nav>

<div class="text-center mb-5">

 </div>
 
  
							
	<div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            
              
				
	
			<form  class="form-horizontal" role="form" action="listcvservlet" method="post">
			
              	<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="name" class="form-control" id="inputName" placeholder="name" />
								</div>
							</div>
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="prenom" class="form-control" id="inputPrenom" placeholder="prenom" />
								</div>
							</div>		
						
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="age" class="form-control" id="inputAge" placeholder="age" />
								</div>
						</div>
						
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="adresse" class="form-control" id="inputAdresse" placeholder="adresse" />
								</div>
							</div>	
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="email" class="form-control" id="inputEmail" placeholder="email" />
								</div>
							</div>
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="specialite" class="form-control" id="inputSpecialite" placeholder="specialite" />
								</div>
							</div>
							
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="niveauetude" class="form-control" id="inputNiveauetude" placeholder="niveaud'étude" />
								</div>
							</div>
					<div class="form-group">
								
								<div class="col-sm-10"><input type="text" name="experiencepro" class="form-control" id="inputExperiencepro" placeholder="experience professionnelle" />
								</div>
							</div>						
							
							<!-- Modal Footer -->
					        <div class="modal-footer">
						    
						    <button type="submit" name="action" value="Enregistrer" class="btn"style="background-color: #015D53;color: white;">Ajouter</button>
					        </div>
						</form>
					
            	  </div>
            	  </div> 
          </div>
       
      
	
	
		<div class="col-6">
				<div class="panel panel-info">
					<div class="panel-heading">
					
					</div>
					
					
					<div class="panel-body">
					
						<table border="1" width="80%" class="table table-hover">
						<thead>
								<tr class="table-primary">
									<th scope="col"></th>
									<th scope="col">Nom</th>
									<th scope="col">Prenom</th>
									<th scope="col">Adresse</th>
									<th scope="col">Email</th>
									<th scope="col">Age</th>
									<th scope="col">Telephone</th>
									<th scope="col">Spécialité</th>
									<th scope="col">Niveau Etude</th>
									<th scope="col">Expérience professionnelle</th>
									
								</tr>
							</thead>
						
							 <tbody>
							 <c:forEach var="c" items="${listcv}">
							
							  <tr class="table-dark"> 
							 	<td>${c.id}</td>
							
							    <td>${c.name}</td>
							    
							    <td>${c.prenom}</td>
							   
							    <td>${c.adresse}"</td>
							   
							    <td>${c.email}</td>
							     
							    <td>${c.age}</td>
							  
							    <td>${c.telephone}</td>
							  
							    <td>${c.specialite}</td>
							    
							    <td>${c.niveauetude}</td>		   
							   
							    <td>${c.experiencepro}</td>
							    
							    <td><a href="listcvservlet?action=delete&telephone=${c.telephone}" onclick="return confirm('Are you sure?')">Supprimer</a> 
							     <td><a href="">Editer</a></td>
							   </tr>
							       
							
							  
							</c:forEach>
							</tbody>
							</table>
							</div>
						</div>
						
					</div>
				
</body>
</html>
