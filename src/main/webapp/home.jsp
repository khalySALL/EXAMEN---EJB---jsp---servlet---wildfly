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