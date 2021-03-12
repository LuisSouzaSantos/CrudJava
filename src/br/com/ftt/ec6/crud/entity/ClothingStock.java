package br.com.ftt.ec6.crud.entity;

import java.util.Date;

import br.com.ftt.ec6.crud.helpers.Color;
import br.com.ftt.ec6.crud.helpers.Size;

public class ClothingStock {

	private Long id;
	private Date entryDate;
	private String purchaseLocation;
	private String type;
	private String brand;
	private String description;
	private Size size;
	private Color color;
	private Double tagValue;
	private Double valuePaid;
	private Double profitValue;
	private Double suggestedValue;
	
	public ClothingStock(Long id, Date entryDate, String purchaseLocation, String type, String brand,
			String description, Size size, Color color, Double tagValue, Double valuePaid, Double profitValue,
			Double suggestedValue) {
		this.id = id;
		this.entryDate = entryDate;
		this.purchaseLocation = purchaseLocation;
		this.type = type;
		this.brand = brand;
		this.description = description;
		this.size = size;
		this.color = color;
		this.tagValue = tagValue;
		this.valuePaid = valuePaid;
		this.profitValue = profitValue;
		this.suggestedValue = suggestedValue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getPurchaseLocation() {
		return purchaseLocation;
	}
	public void setPurchaseLocation(String purchaseLocation) {
		this.purchaseLocation = purchaseLocation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Double getTagValue() {
		return tagValue;
	}
	public void setTagValue(Double tagValue) {
		this.tagValue = tagValue;
	}
	public Double getValuePaid() {
		return valuePaid;
	}
	public void setValuePaid(Double valuePaid) {
		this.valuePaid = valuePaid;
	}
	public Double getProfitValue() {
		return profitValue;
	}
	public void setProfitValue(Double profitValue) {
		this.profitValue = profitValue;
	}
	public Double getSuggestedValue() {
		return suggestedValue;
	}
	public void setSuggestedValue(Double suggestedValue) {
		this.suggestedValue = suggestedValue;
	}
	
}
