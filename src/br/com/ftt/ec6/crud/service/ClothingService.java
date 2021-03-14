package br.com.ftt.ec6.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ftt.ec6.crud.dao.ClothingStockDAO;
import br.com.ftt.ec6.crud.entity.ClothingStock;

public class ClothingService {
	
	ClothingStockDAO clothingStockDAO = ClothingStockDAO.getInstance();
	
	public String save(ClothingStock clothingStock) {
		
		return clothingStockDAO.save(clothingStock);
	}
	
	public String delete(Long id) {
		List<ClothingStock> clothingStockList = getClothingStockList();
		
		if(clothingStockList.isEmpty()) { return "Lista vazia";}
		
		ClothingStock clothingStock = getClothingStockById(id);
		
		if(clothingStock == null) { return "Objecto não encontrado";} 
		
		return clothingStockDAO.delete(clothingStock);
	}
	
	public String edit(Long currentClothingStockId, ClothingStock newClothingStock) {
		List<ClothingStock> clothingStockList = getClothingStockList();
		
		if(clothingStockList.isEmpty()) { return "Lista vazia";}
		
		ClothingStock clothingStock = getClothingStockById(currentClothingStockId);
		
		if(clothingStock == null) { return "Objecto não encontrado";}
		
		newClothingStock.setId(currentClothingStockId);
		return clothingStockDAO.edit(clothingStock);
	}
	
	public ClothingStock getClothingStockById(Long id) {
		List<ClothingStock> clothingStockList = getClothingStockList();
		
		if(clothingStockList.isEmpty()) { return null;}
		
		Optional<ClothingStock> optionalClothingStock = clothingStockList.stream()
														 .filter(clothingStock -> clothingStock.getId().equals(id))
														 .findFirst();
		
		if(optionalClothingStock.isPresent() == false) { return null;}
		
		return optionalClothingStock.get();		
	}
	
	public List<ClothingStock> getClothingStockList(){
		List<ClothingStock> clothingStockList = clothingStockDAO.getClothingStockList();
		
		if(clothingStockList == null || clothingStockList.isEmpty()) { return new ArrayList<ClothingStock>();}
		
		return clothingStockList;	
	}

}
