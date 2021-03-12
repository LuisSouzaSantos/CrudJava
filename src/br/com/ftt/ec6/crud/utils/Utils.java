package br.com.ftt.ec6.crud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

	public static boolean validateDate (String dateString) {

        try {
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        	simpleDateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            System.out.println("Data inválida. Digite uma data válida!!");
            return false;
        }
    }
	
}
