package br.edu.insper.mvc.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DAOTarefas {
	private Connection connection =null;
	public DAOTarefas(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost/projeto1","root","pbeatriz18");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public List<Tarefas> getLista(){
		 
		
		List<Tarefas> tarefas =new ArrayList<Tarefas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM tarefas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			
			//tarefa.setUser(rs.getInt("user"));
			tarefas.add(tarefa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefas;
		}
	
public List<Tarefas> getListaFiltrada(){
		 
		
		List<Tarefas> tarefas =new ArrayList<Tarefas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM tarefas ORDER BY data ASC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			
			//tarefa.setUser(rs.getInt("user"));
			tarefas.add(tarefa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefas;
		}

	public void adiciona(Tarefas tarefa){
		String sql ="INSERT INTO tarefas"+"(nome,imagem, data, categoria) values(?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			stmt.setString(1,tarefa.getNome());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			

			stmt.setBlob(2,tarefa.getImagem());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			stmt.setDate(3, new java.sql.Date(
					tarefa.getData().getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(4,tarefa.getCategoria());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	//	try {
		//	stmt.setInt(5,tarefa.getUser());
		//} catch (SQLException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
	//	}
	
		
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	public void altera(Tarefas tarefa) {
		String sql = "UPDATE tarefas SET " +
		 "nome=?, data=?, categoria=? WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, tarefa.getNome());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setDate(2, new Date(tarefa.getData()
			.getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(3, tarefa.getCategoria());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setInt(4, tarefa.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void remove(Integer id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM tarefas WHERE id=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setLong(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	
public List<Tarefas> getListaPesquisa(Tarefas tarefa){
		 
		
		List<Tarefas> tarefas =new ArrayList<Tarefas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM tarefas WHERE nome LIKE CONCAT(\"%\", ?, \"%\")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, tarefa.getNome());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){Tarefas tarefafilt = new Tarefas();
			tarefafilt.setId(rs.getInt("id"));
			tarefafilt.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefafilt.setData(data);
			tarefafilt.setCategoria(rs.getString("categoria"));
			
			tarefas.add(tarefafilt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefas;
		}
	
}

