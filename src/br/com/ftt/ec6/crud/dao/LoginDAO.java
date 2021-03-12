package br.com.ftt.ec6.crud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ftt.ec6.crud.config.Database;
import br.com.ftt.ec6.crud.entity.Login;

public class LoginDAO {

	private static final String FILE_NAME = "login.txt";
	
	private static LoginDAO instance;
	
	public static LoginDAO getInstance() {
		if(instance == null) {
			instance = new LoginDAO();
		}
		return instance;
	}
	
	public Login getLogin(String username) {
		List<Login> retrievedLoginList = getLoginListFromFile();
		
		Optional<Login> loginOptional =  retrievedLoginList.stream()
												.filter(login -> login.getUsername().equals(username))
												.findFirst();
		
		if(loginOptional.isPresent() == false) { return null; }
		
		return loginOptional.get();
			
	}
	
	private List<Login> getLoginListFromFile(){
		List<Login> loginList = new ArrayList<Login>();
		try {
			List<String> loginListByFile = Database.readFile(FILE_NAME);
			
			loginListByFile.forEach(loginByFile -> {
				String[] object = loginByFile.split(",");
				loginList.add(transformToLogin(object));
			});
			
			return loginList;
		}catch(Exception ex) { return null; }
	}
	
	private Login transformToLogin(String[] object) {
		return new Login(Long.parseLong(object[0]), object[1], object[2]);
	}
	
}
