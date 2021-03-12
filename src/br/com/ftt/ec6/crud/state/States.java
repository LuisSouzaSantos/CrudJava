package br.com.ftt.ec6.crud.state;

public enum States {
	
	LOGIN(new StateLogin()),
	MENU(new StateMenu()),
	CREATE_CLOTHING(new StateCreateClothing());
	
	private StateMachine stateMachine;
	
	States(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	
	public StateMachine getStateMachine() {
		return this.stateMachine;
	}

}
