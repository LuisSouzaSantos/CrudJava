package br.com.ftt.ec6.crud.state;

import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;

public class StateMenu extends StateMachine {

	@Override
	public StatesResponse run() {
		System.out.println("-------------  Menu Principal -------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("0 - Leitura");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Editar");
        System.out.println("3 - Listar");
        System.out.println("4 - Excluir");
		
		int option = scanner.nextInt();
		
		switch (option)
        {
            case 0:
                Start.stateMachine = States.MENU.getStateMachine();
                break;
            case 1:
            	Start.stateMachine = States.CREATE_CLOTHING.getStateMachine();
                break;
//            case 2:
//                Main.estadoConsole = EnumEstadoConsole.EDITAR.getEstadoMaquina();
//                break;
//            case 3:
//                Main.estadoConsole = EnumEstadoConsole.LISTAR.getEstadoMaquina();
//                break;
//            case 4:
//                Main.estadoConsole = EnumEstadoConsole.EXCLUIR.getEstadoMaquina();
//                break;
//            case 5:
//                Main.estadoConsole = EnumEstadoConsole.SALVAR.getEstadoMaquina();
//                break;
//            case 6:
//                exit = true;
//                break;
            default:
            	break;
        }
		
		
		return StatesResponse.SUCCESS;
	}

}
