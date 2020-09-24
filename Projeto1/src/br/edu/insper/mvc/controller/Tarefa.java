package br.edu.insper.mvc.controller;


import java.io.IOException;
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
import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefas;


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
	                	inserirTarefa(request, response);
	                    break;
	                case "/del":
	                	showDeleteForm(request, response);
	                   // deleteTodo(request, response);
	                    break;
	                case "/delete":
	                	//showDeleteForm(request, response);
	                   deletaTarefa(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                	atualizaTarefa(request, response);
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
		    
		        
		        
				DAO dao =new DAO();
				
				Integer userId = Integer.valueOf(request.getParameter("userId"));
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getLista(userId);
				request.setAttribute("listTodo", tarefas);
				request.setAttribute("userId", userId);
				dao.close();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
				dispatcher.forward(request, response);
				
				
				
		        
	       
		        
		    }
	private void filtList(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    
		        
		        
				DAO dao =new DAO();

				Integer userId = Integer.valueOf(request.getParameter("userId"));
				request.setAttribute("userId", userId);
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getListaFiltrada(userId);
				request.setAttribute("listTodo", tarefas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Tarefas.jsp");
				dispatcher.forward(request, response);
				dao.close();
				
				
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	
		    
		    	String userId = request.getParameter("userId");
		    	request.setAttribute("userId", userId);
				
		    	
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/NovaTarefa.jsp");
		        dispatcher.forward(request, response);
		       
		    }
		    
		    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
    			String userId = request.getParameter("userId");
    			request.setAttribute("userId", userId);
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
				
				request.setAttribute("todo", tarefa);
				String userId = request.getParameter("userId");
		    	request.setAttribute("userId", userId);
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/NovaTarefa.jsp");
		        
		        dispatcher.forward(request, response);

		    }

		    private void inserirTarefa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		    	DAO dao =new DAO();
				Tarefas tarefa =new Tarefas();
				
				
				tarefa.setNome(request.getParameter("nome"));		
				tarefa.setUser(Integer.valueOf(request.getParameter("userId")));
				
				
				String userId = request.getParameter("id");
				request.setAttribute("userId", userId);
		       
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
				 dao.adiciona(tarefa);
				 dao.close();
				 RequestDispatcher dispatcher = request.getRequestDispatcher("list");
				 try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		      
		    }
		    
		    
		    private void filtra(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		    	DAO dao =new DAO();
				Tarefas tarefa =new Tarefas();
				tarefa.setNome(request.getParameter("nome"));
				
				Integer userId = Integer.valueOf(request.getParameter("userId"));
				List<br.edu.insper.mvc.model.Tarefas> tarefas = dao.getListaPesquisa(tarefa, userId);
				request.setAttribute("listTodo", tarefas);
				request.setAttribute("userId", userId);
				dao.close();
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
				
		    }
				

		    private void atualizaTarefa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        DAO dao = new DAO();
				Tarefas tarefa = new Tarefas();
				tarefa.setId(Integer.valueOf(request.getParameter("id")));
				tarefa.setNome(request.getParameter("nome"));
				
				String userId = request.getParameter("userId");
				request.setAttribute("userId", userId);
		       
				
				
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
				dao.close();
				 RequestDispatcher dispatcher = request.getRequestDispatcher("list");
				 try {
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		    private void deletaTarefa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		    	DAO dao = new DAO();
				
				String userId = request.getParameter("userId");
				request.setAttribute("userId", userId);
				dao.remove(Integer.valueOf(request.getParameter("id")));
				dao.close();
				RequestDispatcher dispatcher = request.getRequestDispatcher("list");
				try {
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		    

}
		    }
