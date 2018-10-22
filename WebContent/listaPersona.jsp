<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Personas</title>

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
                          
	<div class="responsive-table">
		<table class="highlight centered responsive-table striped">
			<thead>
				<tr class="info">
					<th>ID</th>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th >Modificar</th>
					<th >Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${personas}" var="persona">
					<tr class="active">
						<td><c:out value="${persona.id}" /></td>
						<td><c:out value="${persona.nombres}" /></td>
						<td><c:out value="${persona.apellidos}" /></td>
						
							<td>
                                        <a class="#4fc3f7 light-blue lighten-2  btn-floating   modal-trigger " href="PersonaController?accion=editar&id=<c:out value="${persona.id }"/>"><i class="material-icons left">edit</i></a> 
                                        </td>
                                        
                                          <td>
                                        <a class="red  btn-floating modal-trigger " id="eliminar"  href="PersonaController?accion=eliminar&id=<c:out value="${persona.id }"/>"><i class="material-icons left">delete</i></a>

                                    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p>
	<form method="get" action="PersonaController">
		<input type="hidden" name="accion" value="insertar">
		<button class="btn green " >Agregar</button>
	</form>
	</p>
	
	
	</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>