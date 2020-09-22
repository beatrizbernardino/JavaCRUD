package br.edu.insper.mvc.model;

import java.io.Serializable;

public class Login implements Serializable {
	
		
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static String username;
	    private static String password;
		public static String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			Login.username = username;
		}
		public static String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			Login.password = password;
		}

}
