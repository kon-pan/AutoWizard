package models;

import java.util.ArrayList;
import java.util.List;

public class VehiclePart extends Item {
	
	private String condition;
	private String category;
	

	public VehiclePart(int itemId, int itemPrice, String itemName, String itemType, String category, String condition) {
		super(itemId, itemPrice, itemName, itemType);
		
		this.category = category;
		this.condition = condition;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
