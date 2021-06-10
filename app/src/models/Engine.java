package models;

public class Engine extends VehiclePart {
	
	private int horsePower;
	private int kmPerLitre;
	private int dimensions;
	
	public Engine(int itemId, int itemPrice, String itemName, String itemType, String category, String condition, int horsePower, int kmPerLitre, int dimensions) {
		super(itemId, itemPrice, itemName, itemType, category, condition);
		
		this.horsePower = horsePower;
		this.kmPerLitre = kmPerLitre;
		this.dimensions = dimensions;
	}
}
