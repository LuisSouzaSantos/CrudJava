package br.com.ftt.ec6.crud.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.ftt.ec6.crud.config.Database;
import br.com.ftt.ec6.crud.entity.ClothingStock;
import br.com.ftt.ec6.crud.helpers.Color;
import br.com.ftt.ec6.crud.helpers.Size;

public class ClothingStockDAO {
	
	private static final String FILE_NAME = "clothingStock.txt";
	private static final String SEPARATOR = ",";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private static ClothingStockDAO instance;
	
	public static ClothingStockDAO getInstance() {
		if(instance == null) {
			instance = new ClothingStockDAO();
		}
		return instance;
	}
	
	public ClothingStock getClothingStockById(Long id) {
		
		Optional<ClothingStock> clothingStockOptional = getClothingStockList()
																		.stream()
																		.filter(clothingStock -> clothingStock.getId().equals(id))
																		.findFirst();
		
		if(clothingStockOptional.isPresent() == false) { return null; }
		
		return clothingStockOptional.get();
	}
	
	public List<ClothingStock> getClothingStockList(){
		return getClothingStockListFromFile();
	}
	
	public String save(ClothingStock clothingStock) {
		Long id = getLastId();
		clothingStock.setId(id);
		
		String clothingStockString = transformToString(clothingStock);
		
		return Database.saveLine(FILE_NAME, clothingStockString);
	}
	
	public String delete(ClothingStock clothingStock) {
		return Database.deleteLine(FILE_NAME, clothingStock.getId());
	}
	
	public String edit(ClothingStock clothingStock) {
		String clothingStockString = transformToString(clothingStock);
		return Database.editLine(FILE_NAME, clothingStock.getId(), clothingStockString);
	}
	
	private List<ClothingStock> getClothingStockListFromFile(){
		List<ClothingStock> clothingStockList = new ArrayList<ClothingStock>();
		try {
			List<String> clothingStockListByFile = Database.readFile(FILE_NAME);
			
			clothingStockListByFile.forEach(clothingStockByFile -> {
				String[] object = clothingStockByFile.split(SEPARATOR);
				try {
					clothingStockList.add(transformToClothingStock(object));
				} catch (ParseException e) {
					System.err.println("ClothingStockDAO: Erro ao usar a função transformToClothingStock()"); }
			});
			
			return clothingStockList;
		}
		catch(Exception ex) { return null; }
	}
	
	private ClothingStock transformToClothingStock(String[] object) throws ParseException {
		
		Long id = Long.parseLong(object[0]);
		Date entryDate = simpleDateFormat.parse(object[1]);
		String purchaseLocation = object[2];
		String type = object[3];
		String brand = object[4];
		String description = object[5];
		Size size = Size.getSizeByString(object[6]);
		Color color = Color.getColorByString(object[7]);
		Double tagValue = Double.parseDouble(object[8]);
		Double valuePaid= Double.parseDouble(object[9]);
		Double profitValue = Double.parseDouble(object[10]);
		Double suggestedValue = Double.parseDouble(object[11]);
		
		return new ClothingStock(id, entryDate, purchaseLocation, type, brand, description, size, color, tagValue, valuePaid, profitValue, suggestedValue);
	}
	
	private Long getLastId() {
		
		List<ClothingStock> clothingStockList = getClothingStockList();
		
		if(clothingStockList == null || clothingStockList.isEmpty()) { return 1L;}
		
		Optional<ClothingStock> lastclothingStockStored =  clothingStockList.stream().max(new Comparator<ClothingStock>() {
			@Override
			public int compare(ClothingStock clothingStock, ClothingStock clothingStock2) {
				return Long.compare(clothingStock.getId(), clothingStock2.getId());
			}
		});
		
		return lastclothingStockStored.get().getId()+1; 
	}
	
	private String transformToString(ClothingStock clothingStock) {
		
		String clothingStockString = clothingStock.getId().toString()+SEPARATOR+
				 simpleDateFormat.format(clothingStock.getEntryDate()).toString()+SEPARATOR+
				 clothingStock.getPurchaseLocation()+SEPARATOR+
				 clothingStock.getType()+SEPARATOR+
				 clothingStock.getBrand()+SEPARATOR+
				 clothingStock.getDescription()+SEPARATOR+
				 clothingStock.getSize().name()+SEPARATOR+
				 clothingStock.getColor().name()+SEPARATOR+
				 clothingStock.getTagValue().toString()+SEPARATOR+
				 clothingStock.getValuePaid().toString()+SEPARATOR+
				 clothingStock.getProfitValue().toString()+SEPARATOR+
				 clothingStock.getSuggestedValue().toString();
		
		return clothingStockString;
		
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(getInstance().delete(2L));
//	}
	
	
}
