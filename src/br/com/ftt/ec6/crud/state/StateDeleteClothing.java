package br.com.ftt.ec6.crud.state;

import java.util.List;
import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;
import br.com.ftt.ec6.crud.entity.ClothingStock;
import br.com.ftt.ec6.crud.service.ClothingService;

public class StateDeleteClothing extends StateMachine{

	ClothingService clothingService = new ClothingService();
	
	@Override
	public StatesResponse run(Scanner scanner) {
		List<ClothingStock> clothingStockList = clothingService.getClothingStockList();
		
		if(clothingStockList.isEmpty()) { 
			System.out.println("Lista Vazia");
			Start.stateMachine = States.MENU.getStateMachine();
			return StatesResponse.SUCCESS;
		}
		
		System.out.println("------------------------  Listagem para remoção  ------------------------");
		clothingStockList.stream().forEach(clothingStock -> System.out.println(clothingStock.toString()));
		System.out.println("------------------------  Fim Listagem remoção ------------------------");
		System.out.println();
		System.out.println("------------------------  Escolha um id para ser removido ------------------------");
		String inputChosenId = null;
		
		while(inputChosenId == null) { 
			try {
				inputChosenId = scanner.nextLine();
				Long choseId = Long.parseLong(inputChosenId);
				String response = clothingService.delete(choseId);
				System.out.println("REPOSTA DO SERVIDOR: "+response);
			} catch (Exception e) {
				inputChosenId = null;
			}
		}
		
		Start.stateMachine = States.MENU.getStateMachine();
		return StatesResponse.SUCCESS;
	}

	
	
}
