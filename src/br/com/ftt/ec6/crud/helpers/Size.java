package br.com.ftt.ec6.crud.helpers;

public enum Size {

	P("P"),
    M("M"),
    G("G"),
    GG("GG");

    private String size;

    Size(String size) {
        this.size = size;
    }
    
    public String getSize() {
        return size;
    }
    
    public static Size getSizeByString(String size) {
    	if(validate(size) == false) { return null; }
    	
    	return Size.valueOf(size.toUpperCase());
    }
    
    public static boolean validate(String size) {
    	String sizeUpper = size.toUpperCase();
    	return P.getSize().equals(sizeUpper) || M.getSize().equals(sizeUpper) || G.getSize().equals(sizeUpper) || GG.getSize().equals(sizeUpper);
    }
	
}
