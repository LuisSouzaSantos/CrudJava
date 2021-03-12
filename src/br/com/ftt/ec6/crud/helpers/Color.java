package br.com.ftt.ec6.crud.helpers;

public enum Color {
	
	AMARELO("AMARELO"),
    AZUL("AZUL"),
    VERDE("VERDE"),
    PRETO("preto");

    private String color;

    Color(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    
    public static Color getColorByString(String color) {
    	if(validate(color) == false) { return null; }
    	
    	return Color.valueOf(color.toUpperCase());
    }
    
    public static boolean validate(String color) {
    	String colorUpper = color.toUpperCase();
    	return AMARELO.getColor().equals(colorUpper) || AZUL.getColor().equals(colorUpper) || 
    			VERDE.getColor().equals(colorUpper) || PRETO.getColor().equals(colorUpper);
    }
}
