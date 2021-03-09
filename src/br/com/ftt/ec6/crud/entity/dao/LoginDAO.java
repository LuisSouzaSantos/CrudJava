package br.com.ftt.ec6.crud.entity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ftt.ec6.crud.config.Database;
import br.com.ftt.ec6.crud.entity.Login;

public class LoginDAO {

	private static final String FILE_NAME = "login.txt";
	
	private List<Login> getLoginList(){
		List<Login> loginList = new ArrayList<Login>();
		try {
			List<String> loginListByFile = Database.accessFile(FILE_NAME);
			
			loginListByFile.forEach(loginByFile -> {
				String[] object = loginByFile.split(",");
				Login login = new Login(Long.parseLong(object[0]), object[1], object[2]);
				loginList.add(login);
			});
			
			return loginList;
		}catch(Exception ex) { return null; }
	}
	
	public Login getLogin(String username) {
		List<Login> retrievedLoginList = getLoginList();
		
		Optional<Login> loginOptional =  retrievedLoginList.stream()
												.filter(login -> login.getUsername().equals(username))
												.findFirst();
		
		if(loginOptional.isPresent() == false) { return null; }
		
		return loginOptional.get();
			
	}
	
}
