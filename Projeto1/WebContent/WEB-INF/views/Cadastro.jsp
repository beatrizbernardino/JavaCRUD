<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
 <body>
    
        <div class="container">

            <h2>Cadastro</h2>
            <div class="col-md-6 col-md-offset-3">
               

                <form  action="<%=request.getContextPath()%>/Cadastro" method="post">

                    <div class="form-group">
                        <label for="uname">Nome:</label> <input type="text" class="form-control" id="nome" placeholder="Nome" name="nome" required>
                    </div>


                    <div class="form-group">
                        <label for="uname">UserName:</label> <input type="text" class="form-control" id="username" placeholder="UserName" name="username" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                    </div>

                    <button type="submit" class="btn btn-success">Submit</button>
                    
                    <div class="btn">

				    <a href="<%=request.getContextPath()%>/Login"
				     class="btn btn-success">Login</a>
				   </div>

                </form>
            </div>
        </div>
       
    </body>
</html>