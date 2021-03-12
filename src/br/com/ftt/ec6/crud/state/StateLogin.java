package br.com.ftt.ec6.crud.state;

import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;
import br.com.ftt.ec6.crud.dao.LoginDAO;
import br.com.ftt.ec6.crud.service.LoginService;

public class StateLogin extends StateMachine {

	
	Scanner scanner = new Scanner(System.in);
	LoginService loginService =  new LoginService(LoginDAO.getInstance());
	
	@Override
	public StatesResponse run() {
		boolean isInvalidLogin = true;
		System.out.println("1 - Realizar Login");
		System.out.println("2 - Sair");
		
		try {
			String option = scanner.nextLine();
			if(Integer.parseInt(option) != 1) {
				return StatesResponse.TERMINATE;
			}
		}catch(NumberFormatException e) {
			return StatesResponse.ERROR;
		}
		
		while(isInvalidLogin) {
			System.out.println("#######LOGIN############");
			System.out.println("Insira o username");
			String username = scanner.nextLine();
			System.out.println("Insira o password");
			String password = scanner.nextLine();
			isInvalidLogin = loginService.validate(username, password) ? false: true;
		}
		
		Start.stateMachine = States.MENU.getStateMachine();
		return StatesResponse.SUCCESS;
		
	}

}
