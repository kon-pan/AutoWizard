package models;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CustomerList {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public CustomerList() {
		customerList.add(new Customer(123456, "Stylianos", "27/04/2002", "6983486910", "avlakiotis@email.com", 16000));
		customerList.add(new Customer(123457, "Panos", "27/04/2002", "6983486910", "avlakiotis@email.com", 16000));
		customerList.add(new Customer(123458, "kostas", "27/04/2002", "6983486910", "avlakiotis@email.com", 16000));
		customerList.add(new Customer(123459, "Ioanna", "27/04/2002", "6983486910", "avlakiotis@email.com", 16000));
	}
	
	private ArrayList<Customer> getAllCustomers(){
		return this.customerList;
	}
	
	public Customer getCustomerById(int id) {
		ArrayList<Customer> customers = this.getAllCustomers();
		Customer customer = null;
		
		for (int i=0; i < customers.size(); i++) {
			Customer element = customers.get(i);
			if(element.getCustomerId() == id) {
				customer = element;
				break;
			}
		}
		return customer;
	}
	
	public DefaultTableModel createCustomersList() {
		String columnHeaders[] = {"ID", "Customer Name", "Registration Date", "Phone Number", "Email", "Total Spent"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		CustomerList cl = new CustomerList();
		ArrayList<Customer> customers = cl.getAllCustomers();
		
		for(int i=0; i<customers.size(); i++) {
			int customerId = customers.get(i).getCustomerId();
			String customerName = customers.get(i).getCustomerName();
			String registrationDate = customers.get(i).getRegistrationDate();
			String phoneNumber = customers.get(i).getPhoneNumber();
			String customerEmail = customers.get(i).getCustomerEmail();
			int totalSpent = customers.get(i).getTotalSpent();
			
			Object[] row = {customerId, customerName, registrationDate, phoneNumber, customerEmail, totalSpent};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public DefaultTableModel createCustomersList(ArrayList<Customer> searchResults) {
		String columnHeaders[] = {"ID", "Customer Name", "Registration Date", "Phone Number", "Email", "Total Spent"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for(int i=0; i<searchResults.size(); i++) {
			int customerId = searchResults.get(i).getCustomerId();
			String customerName = searchResults.get(i).getCustomerName();
			String registrationDate = searchResults.get(i).getRegistrationDate();
			String phoneNumber = searchResults.get(i).getPhoneNumber();
			String customerEmail = searchResults.get(i).getCustomerEmail();
			int totalSpent = searchResults.get(i).getTotalSpent();
			
			Object[] row = {customerId, customerName, registrationDate, phoneNumber, customerEmail, totalSpent};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public static ArrayList<Customer> searchCustomer(String searchQuery){
		CustomerList cl = new CustomerList();
		ArrayList<Customer> customers = cl.getAllCustomers();
		
		ArrayList<Customer> searchResults = new ArrayList<Customer>();
		
		for (int i=0; i<customers.size(); i++) {
			Customer element = customers.get(i);
			if(element.getCustomerName().equals(searchQuery) || element.getPhoneNumber().equals(searchQuery)) {
				searchResults.add(element);
			}
		}
		return searchResults;
	}
	
	public ArrayList<Customer> updateCustomer(int customerId, String customerName, String registrationDate, String phoneNumber, String customerEmail) {
		Customer customer = this.getCustomerById(customerId);
		customer.setCustomerName(customerName);
		customer.setRegistrationDate(registrationDate);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerEmail(customerEmail);
		
		ArrayList<Customer> customers = this.getAllCustomers();
		
		// Update previous record
		for (int i = 0; i < customers.size(); i++) {
			Customer element = customers.get(i);
			if(element.getCustomerId() == customerId) {
				customers.set(i, element);
			}
		}
		
		return customers;
	}
	
	public ArrayList<Customer> registerCustomer(Customer customer) {
		
		ArrayList<Customer> customers = this.getAllCustomers();
		customers.add(customer);
		System.out.println(customers);
		return customers;
	}
	
	public int generateId(ArrayList<Customer> customers) {
		customers = this.getAllCustomers();
		Customer element = customers.get(customers.size()-1);
		int id;
		id = element.getCustomerId();
		id++;
		
		return id;
	}
}
