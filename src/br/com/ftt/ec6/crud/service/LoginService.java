package br.com.ftt.ec6.crud.service;

import br.com.ftt.ec6.crud.dao.LoginDAO;
import br.com.ftt.ec6.crud.entity.Login;

public class LoginService {
	
	private LoginDAO loginDAO;
	
	public LoginService(LoginDAO loginDAO){
		this.loginDAO = loginDAO;
	}
	
	public boolean validate(String username, String password) {
		Login login = loginDAO.getLogin(username);
		
		if(login == null) { return false; }
		
		return login.getUsername().equals(username) && login.getPassword().equals(password);
	}
	
}
