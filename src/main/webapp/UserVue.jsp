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
