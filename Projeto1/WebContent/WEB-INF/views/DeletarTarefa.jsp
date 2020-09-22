<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Deletar Tarefa</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
<div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    
     <form action="delete" method="post"> 
   

     <h2> Deletar Tarefa</h2>
     <hr>
     
  

    
     <fieldset class="form-group">
     <label>ID:</label> <input type="number"
      value="<c:out value='${todo.id}' />" class="form-control"
      name="id" required="required" >
    </fieldset>
   

  
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

    </body>
</html>