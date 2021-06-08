package models;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class SupplierContactList {
	private ArrayList<SupplierContact> supplierContactList = new ArrayList<SupplierContact>();
	
	public SupplierContactList() {
		supplierContactList.add(new SupplierContact("21/09/1978", "Giannis", "Nikolaou", "AH123456", "6971256989", "gnikolaou@emai.com", 12));
		supplierContactList.add(new SupplierContact("21/09/1978", "Giannis", "Nikolaou", "AH123456", "6971256989", "gnikolaou@emai.com", 12));
		supplierContactList.add(new SupplierContact("21/09/1978", "Giannis", "Nikolaou", "AH123456", "6971256989", "gnikolaou@emai.com", 12));
		supplierContactList.add(new SupplierContact("21/09/1978", "Giannis", "Nikolaou", "AH123456", "6971256989", "gnikolaou@emai.com", 14));
	}
	
	public ArrayList<SupplierContact>  getAllSupplierContacts() {
		return this.supplierContactList;
	}
	
	public ArrayList<SupplierContact>  getSupplierContactsById(int supplierId) {
		// Get all supplier contacts
		ArrayList<SupplierContact> contacts = getAllSupplierContacts();
		ArrayList<SupplierContact> supplierContacts = new ArrayList<SupplierContact>(); // to be returned
		// Filter by supplier id
		for (int i = 0; i < contacts.size(); i++) {
			SupplierContact element = contacts.get(i);
			if(element.getSupplierId() == supplierId) {
				supplierContacts.add(element);
			}
		}
		
		return supplierContacts;
	}

	public DefaultTableModel createSupplierContactsList(ArrayList<SupplierContact> supplierContacts) {
		String columnHeaders[] = {"#", "First name", "Last name"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for (int i = 0; i < supplierContacts.size(); i++) {
			int counter = i + 1;
			String firstName = supplierContacts.get(i).getFirstName();
			String lastName = supplierContacts.get(i).getLastName();
			
			Object[] row = {counter, firstName, lastName};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
}
