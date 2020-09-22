package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAOTarefas;
import br.edu.insper.mvc.model.DAOUsuarios;
import br.edu.insper.mvc.model.Tarefas;
import br.edu.insper.mvc.model.Usuarios;

/**
 * Servlet implementation class Registra
 */
@WebServlet("/Registra")
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Cadastro.jsp");
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOUsuarios dao =new DAOUsuarios();
		DAOTarefas daotarefas= new DAOTarefas();
		String nome = request.getParameter("nome");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuarios usuario = new Usuarios();
     
        usuario.setNome(nome);
        usuario.setUsername(username);
        usuario.setPassword(password);
        dao.adiciona(usuario);
        


  
      
		List<br.edu.insper.mvc.model.Tarefas> tarefas = daotarefas.getLista();
		request.setAttribute("listTodo", tarefas);
		

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
        dispatcher.forward(request, response);
        daotarefas.close();
        dao.close();
    }

}
