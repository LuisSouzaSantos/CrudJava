package br.com.ftt.ec6.crud.state;

import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;

public class StateMenu extends StateMachine {

	@Override
	public StatesResponse run(Scanner scanner) {
		System.out.println("-------------  Menu Principal -------------");
		
		System.out.println("0 - Leitura");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Editar");
        System.out.println("3 - Listar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Sair");
		
		int option = scanner.nextInt();
		
		switch (option)
        {
            case 0:
                Start.stateMachine = States.MENU.getStateMachine();
                break;
            case 1:
            	Start.stateMachine = States.CREATE_CLOTHING.getStateMachine();
                break;
            case 2:
            	Start.stateMachine = States.EDIT_CLOTHING.getStateMachine();
                break;
            case 3:
            	Start.stateMachine = States.LIST_CLOTHING.getStateMachine();
                break;
            case 4:
            	Start.stateMachine = States.DELETE_CLOTHING.getStateMachine();
                break;
            case 5:
                return StatesResponse.TERMINATE;
            default:
            	break;
        }

		return StatesResponse.SUCCESS;
	}

}
