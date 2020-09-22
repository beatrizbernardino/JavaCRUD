package br.edu.insper.mvc.model;

import java.io.InputStream;
import java.util.Calendar;

public class Tarefas {
	
	private Integer id;
	private String nome;
	private Calendar data;
	private String categoria;
	private Integer user;
	private InputStream imagem;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public InputStream getImagem() {
		return imagem;
	}
	public void setImagem(InputStream inputStream) {
		this.imagem = inputStream;
	}
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}

}
