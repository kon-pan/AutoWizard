package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ItemList {
	
	private ArrayList<Object> itemList = new ArrayList<Object>();
	
	
	public ItemList() {
//		itemList.add(new Item(101, 4000, "Yaris", "Vehicle"));
//		itemList.add(new Item(102, 400, "BBS RW2 Tyre Rims", "Vehicle Part"));
//		itemList.add(new Item(103, 300, "ThunderBolt Exhaust Tip", "Vehicle Part"));
//		itemList.add(new Item(104, 20, "BBS Windshield Sticker", "Accessory"));
//		itemList.add(new Item(105, 48000, "RX8 Mazda", "Vehicle"));
		itemList.add(new Vehicle(101, 4000, "Yaris", "Vehicle"));
		itemList.add(new VehiclePart(102, 400, "BBS RW2 Tyre Rims", "Vehicle Part", "Uncategorized", "New"));
		itemList.add(new VehiclePart(103, 300, "ThunderBolt Exhaust Tip", "Vehicle Part", "Uncategorized", "New"));
		itemList.add(new Accessory(104, 20, "BBS Windshield Sticker", "Accessory"));
		itemList.add(new Vehicle(105, 48000, "RX8 Mazda", "Vehicle"));
	}
	
	public ArrayList<Object> getAllItems(){
		return this.itemList;
	}
	
	public Item getItemById(int id) {
		ArrayList<Object> items = this.getAllItems();
		Item item = null;
		
		for (int i=0; i < items.size(); i++) {
			Item element = (Item) items.get(i);
			if(element.getItemId() == id) {
				item = element;
				break;
			}
		}
		return item;
	}
	
	public DefaultTableModel createItemsList() {
		String columnHeaders[] = {"ID", "Unit Price", "Name", "Type", "Category"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		ItemList il = new ItemList();
		ArrayList<Object> items = il.getAllItems();
		
		for(int i=0; i<items.size(); i++) {
			int itemId = ((Item) items.get(i)).getItemId();
			int itemPrice = ((Item) items.get(i)).getItemPrice();
			String itemName = ((Item) items.get(i)).getItemName();
			String itemType = ((Item) items.get(i)).getItemType();
			String category = items.get(i) instanceof VehiclePart ? ((VehiclePart) items.get(i)).getCategory() : "Uncategorized";
			
			Object[] row = {itemId, itemPrice, itemName, itemType, category};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public DefaultTableModel createItemsList(ArrayList<Object> searchResults) {
		String columnHeaders[] = {"ID", "Unit Price", "Name", "Type", "Category"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for (int i = 0; i < searchResults.size(); i++) {
			int itemId = ((Item) searchResults.get(i)).getItemId();
			int itemPrice = ((Item) searchResults.get(i)).getItemPrice();
			String itemName = ((Item) searchResults.get(i)).getItemName();
			String itemType = ((Item) searchResults.get(i)).getItemType();
			String category = searchResults.get(i) instanceof VehiclePart ? ((VehiclePart) searchResults.get(i)).getCategory() : "Uncategorized";
			
			Object[] row = {itemId, itemPrice, itemName, itemType, category};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public static ArrayList<Object> searchItem(String searchQuery){
		ItemList il = new ItemList();
		ArrayList<Object> items = il.getAllItems();
		
		ArrayList<Object> searchResults = new ArrayList<Object>();
		
		for (int i=0; i<items.size(); i++) {
			Item element = (Item) items.get(i);
			if(element.getItemName().equals(searchQuery) || element.getItemType().equals(searchQuery)) {
				searchResults.add(element);
			}
		}
		return searchResults;
	}
	
	public ArrayList<Object> updateItem(String itemId, String itemPrice, String itemName, String itemType) {
		// Get employee that will be updated
		Item item = this.getItemById(Integer.parseInt(itemId));
		item.setItemPrice(Integer.parseInt(itemPrice));
		item.setItemName(itemName);
		item.setItemType(itemType);
		
		// Get employees list
		ArrayList<Object> items = this.getAllItems();
		
		// Update previous record
		for (int i = 0; i < items.size(); i++) {
			Item element = (Item) items.get(i);
			if(element.getItemId() == Integer.parseInt(itemId)) {
				items.set(i, element);
			}
		}
		
		return items;
	}
}
