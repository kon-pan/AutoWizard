package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ItemList {
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	
	public ItemList() {
		itemList.add(new Item(101, 4000, "Yaris", "Vehicle"));
		itemList.add(new Item(102, 400, "BBS RW2 Tyre Rims", "Vehicle Part"));
		itemList.add(new Item(103, 300, "ThunderBolt Exhaust Tip", "Vehicle Part"));
		itemList.add(new Item(104, 20, "BBS Windshield Sticker", "Accessory"));
		itemList.add(new Item(105, 48000, "RX8 Mazda", "Vehicle"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
		itemList.add(new Item(106, 1000, "Scroll Test", "Accessory"));
	}
	
	public ArrayList<Item> getAllItems(){
		return this.itemList;
	}
	
	public Item getItemById(int id) {
		ArrayList<Item> items = this.getAllItems();
		Item item = null;
		
		for (int i=0; i < items.size(); i++) {
			Item element = items.get(i);
			if(element.getItemId() == id) {
				item = element;
				break;
			}
		}
		return item;
	}
	
	public DefaultTableModel createItemsList() {
		String columnHeaders[] = {"ID", "Unit Price", "Name", "Type"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		ItemList il = new ItemList();
		ArrayList<Item> items = il.getAllItems();
		
		for(int i=0; i<items.size(); i++) {
			int itemId = items.get(i).getItemId();
			int itemPrice = items.get(i).getItemPrice();
			String itemName = items.get(i).getItemName();
			String itemType = items.get(i).getItemType();
			
			Object[] row = {itemId, itemPrice, itemName, itemType};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public DefaultTableModel createItemsList(ArrayList<Item> searchResults) {
		String columnHeaders[] = {"ID", "Unit Price", "Name", "Type"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for (int i = 0; i < searchResults.size(); i++) {
			int itemId = searchResults.get(i).getItemId();
			int itemPrice = searchResults.get(i).getItemPrice();
			String itemName = searchResults.get(i).getItemName();
			String itemType = searchResults.get(i).getItemType();
			
			Object[] row = {itemId, itemPrice, itemName, itemType};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public static ArrayList<Item> searchItem(String searchQuery){
		ItemList il = new ItemList();
		ArrayList<Item> items = il.getAllItems();
		
		ArrayList<Item> searchResults = new ArrayList<Item>();
		
		for (int i=0; i<items.size(); i++) {
			Item element = items.get(i);
			if(element.getItemName().equals(searchQuery) || element.getItemType().equals(searchQuery)) {
				searchResults.add(element);
			}
		}
		return searchResults;
	}
	
	public ArrayList<Item> updateItem(String itemId, String itemPrice, String itemName, String itemType) {
		// Get employee that will be updated
		Item item = this.getItemById(Integer.parseInt(itemId));
		item.setItemPrice(Integer.parseInt(itemPrice));
		item.setItemName(itemName);
		item.setItemType(itemType);
		
		// Get employees list
		ArrayList<Item> items = this.getAllItems();
		
		// Update previous record
		for (int i = 0; i < items.size(); i++) {
			Item element = items.get(i);
			if(element.getItemId() == Integer.parseInt(itemId)) {
				items.set(i, element);
			}
		}
		
		return items;
	}
}
