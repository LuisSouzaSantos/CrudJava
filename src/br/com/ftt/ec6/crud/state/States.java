package br.com.ftt.ec6.crud.state;

public enum States {
	
	LOGIN(new StateLogin()),
	MENU(new StateMenu()),
	CREATE_CLOTHING(new StateCreateClothing()),
	LIST_CLOTHING(new StateListClothing()),
	DELETE_CLOTHING(new StateDeleteClothing()),
	EDIT_CLOTHING(new StateEditClothing());
	
	private StateMachine stateMachine;
	
	States(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	
	public StateMachine getStateMachine() {
		return this.stateMachine;
	}

}
