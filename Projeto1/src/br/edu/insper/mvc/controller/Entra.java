package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.insper.mvc.model.DAOLogin;
import br.edu.insper.mvc.model.DAOTarefas;
import br.edu.insper.mvc.model.Login;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Entra")
public class Entra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
          dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOLogin dao = new DAOLogin();
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        Login login = new Login();
	        login.setUsername(username);
	        login.setPassword(password);
	        
	        try {
	            if (dao.validate(login)) {
	            	DAOTarefas daotarefas =new DAOTarefas();
	          		List<br.edu.insper.mvc.model.Tarefas> tarefas = daotarefas.getLista();
	          		request.setAttribute("listTodo", tarefas);
	          		daotarefas.close();
	          		
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
	                dispatcher.forward(request, response);
	            } else {
	            	 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Erro.jsp");
		             dispatcher.forward(request, response);
	             
					
	           
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	     
	}

}
