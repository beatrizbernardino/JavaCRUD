<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Nova Tarefa</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">


</head>
<body>
 
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${todo != null}">
     <form action="update" method="post"> 
    </c:if>
    <c:if test="${todo == null}">
     <form action="insert" method="post"> 
    </c:if>


     <h2>
      <c:if test="${todo != null}">
               Edit Todo
              </c:if>
      <c:if test="${todo == null}">
               Add New Todo
              </c:if>
     </h2>
     
  
	
    <c:if test="${todo != null}">
     <fieldset class="form-group">
     <label>ID:</label> <input type="number"
      value="<c:out value='${todo.id}' />" class="form-control"
      name="id" required="required" >
    </fieldset>
    </c:if>

    <fieldset class="form-group">
     <label>Título</label> <input type="text"
      value="<c:out value='${todo.nome}' />" class="form-control"
      name="nome" required="required">
    </fieldset>
    
     
  
    
	<fieldset class="form-group">
     <label>Categoria</label> <select class="form-control"
      name="categoria">
      <option value="pessoal">Pessoal</option>
      <option value="trabalho">Trabalho</option>
     </select>
    </fieldset>
    

    
    
    <fieldset class="form-group">
     <label>Data de entrega</label> <input type="date"
      value="<c:out value='${todo.data}' />" class="form-control"
      name="data" >
    </fieldset>
    
    
    <input type="hidden"
      value="<c:out value='${userId}' />" name="userId" >


    <button type="submit" class="btn btn-success">Salvar</button>
    </form>
   </div>
  </div>
 </div>

</body>
</html>