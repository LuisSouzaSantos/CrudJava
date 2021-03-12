package br.com.ftt.ec6.crud.state;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.ftt.ec6.crud.Start;
import br.com.ftt.ec6.crud.dao.ClothingStockDAO;
import br.com.ftt.ec6.crud.entity.ClothingStock;
import br.com.ftt.ec6.crud.helpers.Color;
import br.com.ftt.ec6.crud.helpers.Size;

public class StateCreateClothing extends StateMachine {

	@Override
	public StatesResponse run() {
		System.out.println("------------- Criação -------------");
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Data de entrada: ");
        Date date = null;
        String inputDate = null;
        while (inputDate == null){
            try {
            	inputDate = scanner.nextLine();
            	date = simpleDateFormat.parse(inputDate);
    		} catch (ParseException e) { 
    			System.out.println("Data inválida. Digite uma data válida!!");
    			inputDate = null;
    		}
        }
        
        System.out.println("Local da compra: ");
        String inputLocation = null;
        while (inputLocation == null){
	        try {
	        	inputLocation = scanner.nextLine();
            	if(inputLocation == null || inputLocation.isEmpty()) { throw new Exception("Local não pode ser vazio");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputLocation = null;
    		}
        }
        
        System.out.println("Tipo: ");
        String inputType = null;
        while (inputType == null){
	        try {
	        	inputType = scanner.nextLine();
            	if(inputType == null || inputType.isEmpty()) { throw new Exception("Tipo não pode ser vazio");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputType = null;
    		}
        }
        
        System.out.println("Marca: ");
        String inputBrand = null;
        while (inputBrand == null){
	        try {
	        	inputBrand = scanner.nextLine();
            	if(inputBrand == null || inputBrand.isEmpty()) { throw new Exception("Marca não pode ser vazio");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputBrand = null;
    		}
        }
        
        System.out.println("Descrição: ");
        String inputDescription = null;
        while (inputDescription == null){
	        try {
	        	inputDescription = scanner.nextLine();
            	if(inputDescription == null || inputDescription.isEmpty()) { throw new Exception("Descrição não pode ser vazio");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputDescription = null;
    		}
        }
        
        System.out.println("Tamanho: P, M, G ou GG");
        String inputSize = null;
        while (inputSize == null){
	        try {
	        	inputSize = scanner.nextLine();
            	if(Size.validate(inputSize) == false) { throw new Exception("Tamanho inválido. Escolha entre P, M, G ou GG");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputSize = null;
    		}
        }
        
        System.out.println("Cor: Amarelo, Azul, Verde ou Preto");
        String inputColor = null;
        while (inputColor == null){
	        try {
	        	inputColor = scanner.nextLine();
            	if(Color.validate(inputColor) == false) { throw new Exception("Cor inválida. Escolha entre Amarelo, Azul, Verde ou Preto");}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputColor = null;
    		}
        }
        
        System.out.println("Valor na etiqueta: ");
        Double inputTagValue = null;
        while (inputTagValue == null){
	        try {
	        	inputTagValue = scanner.nextDouble();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputTagValue = null;
    		}
        }
        
        
        System.out.println("Valor pago na compra: ");
        Double inputValuePaid = null;
        while (inputValuePaid == null){
	        try {
	        	inputValuePaid = scanner.nextDouble();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputValuePaid = null;
    		}
        }
        
        Double profitValue = inputValuePaid*2;

        System.out.println("Valor sugerido: ");
        Double inputSuggestedValue = scanner.nextDouble();
        while (inputSuggestedValue == null){
	        try {
	        	inputSuggestedValue = scanner.nextDouble();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			inputSuggestedValue = null;
    		}
        }
		
		ClothingStock clothingStock =  new ClothingStock(null, date, inputLocation, inputType, 
															inputBrand, inputDescription, Size.getSizeByString(inputSize), Color.getColorByString(inputColor), 
																inputTagValue, inputValuePaid, profitValue, inputSuggestedValue);
		
		ClothingStockDAO.getInstance().save(clothingStock);
		scanner.close();
		System.out.println("Cadastro realizado com sucesso");
		Start.stateMachine = States.MENU.getStateMachine();
		return StatesResponse.SUCCESS;
	}

}
