package br.com.ftt.ec6.crud.state;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;
import br.com.ftt.ec6.crud.entity.ClothingStock;
import br.com.ftt.ec6.crud.helpers.Color;
import br.com.ftt.ec6.crud.helpers.Size;
import br.com.ftt.ec6.crud.service.ClothingService;

public class StateEditClothing extends StateMachine {

	ClothingService clothingService = new ClothingService();

	@Override
	public StatesResponse run(Scanner scanner) {
		List<ClothingStock> clothingStockList = clothingService.getClothingStockList();
		
		if(clothingStockList.isEmpty()) { 
			System.out.println("Lista Vazia");
			Start.stateMachine = States.MENU.getStateMachine();
			return StatesResponse.SUCCESS;
		}
		
		System.out.println("------------------------  Listagem para edição  ------------------------");
		clothingStockList.stream().forEach(clothingStock -> System.out.println(clothingStock.toString()));
		System.out.println("------------------------  Fim Listagem edição ------------------------");
		
		System.out.println("------------------------  Escolha um id para ser editado ------------------------");
		String inputChosenId = null;
		Long choseId = null;
		
		while(inputChosenId == null) { 
			try {
				inputChosenId = scanner.nextLine();
				choseId = Long.parseLong(inputChosenId);
			} catch (Exception e) {
				System.out.println("ID inválido");
				inputChosenId = null;
			}
		}
		
		ClothingStock retrievedClothingStock = clothingService.getClothingStockById(choseId);
		
		if(retrievedClothingStock == null) { 
			System.out.println("Esse item não existe");
			Start.stateMachine = States.MENU.getStateMachine();
			return StatesResponse.SUCCESS;
		}
		
		
		System.out.println("------------- Edição -------------");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Data de entrada: ");
        Date date = null;
        String inputDate = null;
        while (inputDate == null){
            try {
            	inputDate = scanner.nextLine();
            	date = simpleDateFormat.parse(inputDate);
    		} catch (ParseException e) {
    			inputDate = "";
    			date = retrievedClothingStock.getEntryDate();
    		}
        }
        
        System.out.println("Local da compra: ");
        String inputLocation = null;
        while (inputLocation == null){
	        try {
	        	inputLocation = scanner.nextLine();
    		} catch (Exception e) {
    			inputLocation = retrievedClothingStock.getPurchaseLocation();
    		}
        }
        
        System.out.println("Tipo: ");
        String inputType = null;
        while (inputType == null){
	        try {
	        	inputType = scanner.nextLine();
    		} catch (Exception e) {
    			inputType = retrievedClothingStock.getType();
    		}
        }
        
        System.out.println("Marca: ");
        String inputBrand = null;
        while (inputBrand == null){
	        try {
	        	inputBrand = scanner.nextLine();
    		} catch (Exception e) {
    			inputBrand = retrievedClothingStock.getBrand();
    		}
        }
        
        System.out.println("Descrição: ");
        String inputDescription = null;
        while (inputDescription == null){
	        try {
	        	inputDescription = scanner.nextLine();
    		} catch (Exception e) {
    			inputDescription = retrievedClothingStock.getDescription();
    		}
        }
        
        System.out.println("Tamanho: P, M, G ou GG");
        String inputSize = null;
        while (inputSize == null){
	        try {
	        	inputSize = scanner.nextLine();
    		} catch (Exception e) {
    			inputSize = retrievedClothingStock.getSize().name();
    		}
        }
        
        System.out.println("Cor: Amarelo, Azul, Verde ou Preto");
        String inputColor = null;
        while (inputColor == null){
	        try {
	        	inputColor = scanner.nextLine();
    		} catch (Exception e) {
    			inputColor = retrievedClothingStock.getColor().name();
    		}
        }
        
        System.out.println("Valor na etiqueta: ");
        Double inputTagValue = null;
        while (inputTagValue == null){
	        try {
	        	inputTagValue = scanner.nextDouble();
    		} catch (Exception e) {
    			inputTagValue = retrievedClothingStock.getTagValue();
    		}
        }
        
        
        System.out.println("Valor pago na compra: ");
        Double inputValuePaid = null;
        while (inputValuePaid == null){
	        try {
	        	inputValuePaid = scanner.nextDouble();
    		} catch (Exception e) {
    			inputValuePaid = retrievedClothingStock.getValuePaid();
    		}
        }
        
        Double profitValue = inputValuePaid*2;

        System.out.println("Valor sugerido: ");
        Double inputSuggestedValue = scanner.nextDouble();
        while (inputSuggestedValue == null){
	        try {
	        	inputSuggestedValue = scanner.nextDouble();
    		} catch (Exception e) {
    			inputSuggestedValue = retrievedClothingStock.getSuggestedValue();
    		}
        }
		
		ClothingStock clothingStock =  new ClothingStock(null, date, inputLocation, inputType, 
															inputBrand, inputDescription, Size.getSizeByString(inputSize), Color.getColorByString(inputColor), 
																inputTagValue, inputValuePaid, profitValue, inputSuggestedValue);
		
		String systemResponse = clothingService.edit(choseId, clothingStock);
		
		if(systemResponse.equals("SUCCESS")) {
			System.out.println("Edição realizado com sucesso");
		}else {
			System.out.println(systemResponse);
		}
		
		Start.stateMachine = States.MENU.getStateMachine();
		return StatesResponse.SUCCESS;
	}
}
