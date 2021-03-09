package br.com.ftt.ec6.crud;

import java.util.Scanner;

import br.com.ftt.ec6.crud.entity.Login;
import br.com.ftt.ec6.crud.entity.dao.LoginDAO;

public class Start{
	
	public static void main(String[] args) {
		
		String option = null;
		Scanner scanner = new Scanner(System.in);
		
		while(option != "9") {
			try {
				option = scanner.nextLine();
				
				if(option.equals("1")) {
					System.out.println("Escreva o username");
					String username = scanner.nextLine();
					System.out.println("Escreva o username");
					String password = scanner.nextLine();
					LoginDAO loginDAO = new LoginDAO();
					Login login = loginDAO.getLogin(username);
					System.out.println(login.getUsername()+login.getPassword());
				}
				
				
			}catch(Exception e) {
				
			}
		}
		
		scanner.close();
	}

}
