package models;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class SupplierList {
	private ArrayList<Supplier> suppliersList = new ArrayList<Supplier>();
	
	public SupplierList() {
		suppliersList.add(new Supplier(12, "Supplier #1", "Greece", "Patras", "Address #1", "supplierone.com"));
		suppliersList.add(new Supplier(14, "Supplier #2", "Greece", "Athens", "Address #2", "suppliertwo.gr"));
	}
	
	public ArrayList<Supplier> getAllSuppliers(){
		return this.suppliersList;
	}
	
	public DefaultTableModel createEmployeesList() {
		String columnHeaders[] = {"ID","Name", "Country", "City", "Address", "Website"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		// Get data to populate table
		SupplierList sl = new SupplierList();
		ArrayList<Supplier> suppliers = sl.getAllSuppliers();
		
		for (int i = 0; i < suppliers.size(); i++) {
			int supplierId = suppliers.get(i).getSupplierId();
			String supplierName = suppliers.get(i).getName();
			String supplierCountry = suppliers.get(i).getCountry();
			String supplierCity = suppliers.get(i).getCity();
			String supplierAddress = suppliers.get(i).getAddress();
			String supplierWebsite = suppliers.get(i).getWebsiteUrl();
			
			Object[] row = {supplierId, supplierName, supplierCountry, supplierCity, supplierAddress, supplierWebsite};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
}
