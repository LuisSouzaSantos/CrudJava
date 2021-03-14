package br.com.ftt.ec6.crud;

import java.util.Scanner;

import br.com.ftt.ec6.crud.state.StateMachine;
import br.com.ftt.ec6.crud.state.States;
import br.com.ftt.ec6.crud.state.StatesResponse;

public class Start{
	
	public static StateMachine stateMachine;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		stateMachine = States.LOGIN.getStateMachine();
		StatesResponse statesResponse = StatesResponse.SUCCESS;
		
		while(statesResponse != StatesResponse.TERMINATE) {
			statesResponse = stateMachine.run(scanner);
		}
		
		scanner.close();
		System.out.println("Sistema encerrado");
		
	}

}
