<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persona</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
<div class="container">
                      <div class="row ">
                          <div class="col s12">
                           <div class="card   darken-1">
                              <div class="card-content ">

	<form action="PersonaController" method="post">
		
			
				<div>
					<label for="id">Persona ID</label> 
					<input type="text" name="id" class="form-control"
						value="<c:out value="${persona.id}" />" readonly="readonly" 
						placeholder="Persona ID" />
				</div>
				<div>
					<label for="nombres">Nombres</label> <input type="text" class="form-control"
						name="nombres" value="<c:out value="${persona.nombres}" />"
						placeholder="Nombres" />
				</div>
				<div>
					<label for="apellidos">Apellidos</label> <input type="text" class="form-control"
						name="apellidos" value="<c:out value="${persona.apellidos}" />"
						placeholder="Apellidos" />
				</div>

				
					<input type="submit" class="btn-small green " value="Guardar" />
					
				
			
		
	</form>
	</div> </div> </div> </div> </div>
</body>
</html>