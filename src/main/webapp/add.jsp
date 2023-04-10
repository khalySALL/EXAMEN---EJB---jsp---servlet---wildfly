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
              <form action="cvadd" role="form" method="post">
              
              
                
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