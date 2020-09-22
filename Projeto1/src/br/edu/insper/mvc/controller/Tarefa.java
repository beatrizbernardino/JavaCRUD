package br.edu.insper.mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.edu.insper.mvc.model.DAOTarefas;
import br.edu.insper.mvc.model.Tarefas;
import br.edu.insper.mvc.model.Usuarios;

/**
 * Servlet implementation class Tarefas
 */
@WebServlet("/Tarefas")
public class Tarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();

		 try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertTodo(request, response);
	                    break;
	                case "/del":
	                	showDeleteForm(request, response);
	                   // deleteTodo(request, response);
	                    break;
	                case "/delete":
	                	//showDeleteForm(request, response);
	                   deleteTodo(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateTodo(request, response);
	                    break;
	                case "/list":
	                    listTodo(request, response);
	                    break;
	                case "/filt":
	                    filtList(request, response);
	                    break;
	                case "/search":
	                    filtra(request, response);
	                    break;
	                default:
	                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
	                    dispatcher.forward(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listTodo(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    
		        
		        
				DAOTarefas dao =new DAOTarefas();
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getLista();
				request.setAttribute("listTodo", tarefas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
				dispatcher.forward(request, response);
				dao.close();
		        
		    }
	private void filtList(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    
		        
		        
				DAOTarefas dao =new DAOTarefas();
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getListaFiltrada();
				request.setAttribute("listTodo", tarefas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
				dispatcher.forward(request, response);
				dao.close();
		        
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/NovaTarefa.jsp");
		        dispatcher.forward(request, response);
		    }
		    
		    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
				    throws ServletException, IOException {
				        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/DeletarTarefa.jsp");
				        dispatcher.forward(request, response);
				    }
				    
		    

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		
				Tarefas tarefa = new Tarefas();
				tarefa.getNome();
				tarefa.getData();
				tarefa.getCategoria();
				tarefa.getId();
				tarefa.getUser();
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/NovaTarefa.jsp");
		        request.setAttribute("todo", tarefa);
		        dispatcher.forward(request, response);

		    }

		    private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		    	DAOTarefas dao =new DAOTarefas();
				Tarefas tarefa =new Tarefas();
				tarefa.setNome(request.getParameter("nome"));
				String date = request.getParameter("data");
				Date data = null;
				try {
					data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar dataPostagem = Calendar.getInstance();
				 dataPostagem.setTime(data);
				 tarefa.setData(dataPostagem);
				 
			//	 Part filePart = null;
				//try {
					//filePart = request.getPart("imagem");
				//} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
			//	} catch (ServletException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
				 //InputStream inputStream = filePart.getInputStream();
				 
				// tarefa.setImagem(inputStream);
				
				 tarefa.setCategoria(request.getParameter("categoria"));
				Usuarios usuario= new Usuarios();
				tarefa.setUser(usuario.getId());
				
				
				
				dao.adiciona(tarefa);
		        response.sendRedirect("list");
		    }
		    
		    
		    private void filtra(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		    	DAOTarefas dao =new DAOTarefas();
				Tarefas tarefa =new Tarefas();
				tarefa.setNome(request.getParameter("nome"));
				
				
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getListaPesquisa(tarefa);
				request.setAttribute("listTodo", tarefas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao.close();
		    }
				

		    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        DAOTarefas dao = new DAOTarefas();
				Tarefas tarefa = new Tarefas();
				tarefa.setId(Integer.valueOf(request.getParameter("id")));
				tarefa.setNome(request.getParameter("nome"));
				Usuarios usuario= new Usuarios();
				tarefa.setUser(usuario.getId());
				
				
				
				String date = request.getParameter("data");
				Date data = null;
				try {
					data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar dataPostagem = Calendar.getInstance();
				dataPostagem.setTime(data);
				tarefa.setData(dataPostagem);
				tarefa.setCategoria(request.getParameter("categoria"));
				dao.altera(tarefa);
		        response.sendRedirect("list");
		    }

		    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		    	DAOTarefas dao = new DAOTarefas();
				dao.remove(Integer.valueOf(request.getParameter("id")));
		        response.sendRedirect("list");
		    }

}
