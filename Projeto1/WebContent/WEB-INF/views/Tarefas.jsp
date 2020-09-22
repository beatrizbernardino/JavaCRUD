<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Tarefas</title>
<style>
.btn-group-lg {
  margin: auto;
  display: flex;
  flex-direction: row;
  justify-content: center;
}
.container{

margin-top: 30px;


}

.searchBar{
	flex:1;
	margin-top:30px;
	justify-content: center;
	margin-left:120px;
	margin-right:120px;
}

</style>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>


 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h2 class="text-center">Lista de Tarefas</h2>
   <hr>
   <div class= "btn-group-lg col-md-10">
   <div class="btn">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Adicionar Tarefa</a>
   </div>
   <div class="btn">

    <a href="<%=request.getContextPath()%>/edit"
     class="btn btn-success">Editar Tarefa</a>
   </div>
   <div class="btn ">

    <a href="<%=request.getContextPath()%>/del"
     class="btn btn-success">Deletar Tarefa</a>
   </div>
   
     <div class="btn ">

   

    <a href="<%=request.getContextPath()%>/list"
     class="btn btn-success">Ver a lista Completa</a>
   </div>
   
     <div class="btn ">
   
    <a href="<%=request.getContextPath()%>/filt"
     class="btn btn-success">Ordenar pela data de entrega mais próxima</a>
   </div>
 
   </div>
      <div class="searchBar">
 	 <form action="search" method="post"  >
 	 <fieldset class="form-group">
     <label>Pesquisar Tarefa</label> <input type="text"
      class="form-control"
      name="nome" >
    </fieldset>
    
    
    <div class="button">
     <button type="submit" class="btn btn-success">Pesquisar</button>
     </div>
 	 
 	 </form>
 	</div>  
   </div>
   
   
  

   <hr>
	<div class="container"> 
    <h4 class="text-left">Tarefas Pessoais</h4>
 

   <table class="table table-bordered">
    <thead>
     <tr>
     <th>ID</th>
      <th>Tarefa</th>
      <th>Data de Entrega</th>
      <th>Categoria</th>
      <th>user</th>
   
     </tr>
    </thead>
    <tbody>

     <c:forEach var="todo" items="${listTodo}">
     
     <c:if test="${todo.categoria == 'pessoal'}">

      <tr>
      <td><c:out value="${todo.id}" /></td>
       <td><c:out value="${todo.nome}" /></td>
       <td><c:out value="${todo.data.getTime()}" /></td>
       <td><c:out value="${todo.categoria}" /></td>
        <td></td>
       


       
      </tr>
      </c:if>
     
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
   
   <br>
   
    <h4 class="text-lef">Tarefas Profissionais</h4>
   
   <table class="table table-bordered">
    <thead>
     <tr>
     <th>ID</th>
      <th>Tarefa</th>
      <th>Data de Entrega</th>
      <th>Categoria</th>
      <th>user</th>
   
     </tr>
    </thead>
    <tbody>

     <c:forEach var="todo" items="${listTodo}">
     
     <c:if test="${todo.categoria == 'trabalho'}">

      <tr>
      <td><c:out value="${todo.id}" /></td>
       <td><c:out value="${todo.nome}" /></td>
       <td><c:out value="${todo.data.getTime()}" /></td>
       <td><c:out value="${todo.categoria}" /></td>
        <td></td>
     

       
      </tr>
      </c:if>
     
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
   

  </div>
</div>

 
</body>
</html>