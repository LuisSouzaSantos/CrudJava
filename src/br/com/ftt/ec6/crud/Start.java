package br.com.ftt.ec6.crud;

import br.com.ftt.ec6.crud.state.StateMachine;
import br.com.ftt.ec6.crud.state.States;
import br.com.ftt.ec6.crud.state.StatesResponse;

public class Start{
	
	public static StateMachine stateMachine;
	
	public static void main(String[] args) {
		
		stateMachine = States.LOGIN.getStateMachine();
		StatesResponse statesResponse = StatesResponse.SUCCESS;
		
		while(statesResponse != StatesResponse.TERMINATE) {
			statesResponse = stateMachine.run();
		}
		
		System.out.println("Sistema encerrado");
		
	}

}
