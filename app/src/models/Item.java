package models;

public class Item {
	private int itemId;
	private int itemPrice;
	private String itemName;
	private String itemType;
	
	public Item(int itemId, int itemPrice, String itemName, String itemType) {
		super();
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.itemType = itemType;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}
