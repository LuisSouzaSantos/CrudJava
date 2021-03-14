package br.com.ftt.ec6.crud.state;

import java.util.Scanner;

public abstract class StateMachine {

	public abstract StatesResponse run(Scanner scanner);
}
