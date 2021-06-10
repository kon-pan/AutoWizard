package models;

public class Tire extends VehiclePart{
	
	private String brand;
	private int size;
	private int diameter;
	
	public Tire(int itemId, int itemPrice, String itemName, String itemType, String category, String condition, String brand, int size, int diameter) {
		super(itemId, itemPrice, itemName, itemType, category, condition);
		this.brand = brand;
		this.size = size;
		this.diameter = diameter;
	}

}
