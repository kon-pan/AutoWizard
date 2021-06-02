package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class SalesHistory {

	private ArrayList<Sale> salesHistory = new ArrayList<Sale>();
	
	public SalesHistory() {
		salesHistory.add(new Sale(101, "Giannis", "16/04/2021", "Yaris", "Stylianos", 4000, "Recurring"));
		salesHistory.add(new Sale(102, "George", "20/04/2021", "ThunderBolt Exhaust Tip", "Stylianos", 300, "Total Sum"));
		salesHistory.add(new Sale(103, "Nick", "23/05/2021", "BBS RW2 Tyre Rims", "Stylianos", 400, "Total Sum"));
		salesHistory.add(new Sale(104, "Ntinos", "27/05/2021", "RX8 Mazda", "Stylianos", 48000, "Total Sum"));
		salesHistory.add(new Sale(105, "Ntinos", "07/06/2021", "BBS Windshield Sticker", "Stylianos", 4000, "Total Sum"));
	}
	
	public ArrayList<Sale> getAllSales(){
		return this.salesHistory;
	}
	
	public Sale getSaleById(int id) {
		ArrayList<Sale> sales = this.getAllSales();
		Sale sale = null;
		
		for (int i=0; i < sales.size(); i++) {
			Sale element = sales.get(i);
			if(element.getSaleId() == id) {
				sale = element;
				break;
			}
		}
		return sale;
	}
	
	public DefaultTableModel createSalesList() {
		String columnHeaders[] = {"ID", "Customer Name", "Date of Sale", "Sold Item", "Salesperson", "Sale Price", "Payment Plan"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		SalesHistory sh = new SalesHistory();
		ArrayList<Sale> sales = sh.getAllSales();
		
		for(int i=0; i<sales.size(); i++) {
			int saleId = sales.get(i).getSaleId();
			String customerName = sales.get(i).getCustomerName();
			String dateOfSale = sales.get(i).getDateOfSale();
			String soldItemName = sales.get(i).getSoldItemName();
			String salespersonName = sales.get(i).getSalespersonName();
			int priceOfSale = sales.get(i).getPriceOfSale();
			String paymentPlan = sales.get(i).getPaymentPlan();
			
			Object[] row = {saleId, customerName, dateOfSale, soldItemName, salespersonName, priceOfSale, paymentPlan};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
//	public DefaultTableModel createSalesList(ArrayList<Sale> sales) {
//		String columnHeaders[] = {"ID", "Customer Name", "Date of Sale", "Sold Item", "Salesperson", "Sale Price", "Payment Plan"};
//		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
//		
//		for (int i = 0; i < employees.size(); i++) {
//			int employeeId = employees.get(i).getEmployeeId();
//			String firstName = employees.get(i).getFirstName();
//			String lastName = employees.get(i).getLastName();
//			String department = employees.get(i).getDepartment();
//			
//			Object[] row = {employeeId, firstName, lastName, department};
//			
//			tableModel.addRow(row);
//		}
//		return tableModel;
//	}
	
	public DefaultTableModel createSalesList(ArrayList<Sale> searchResults) {
		String columnHeaders[] = {"ID", "Customer Name", "Date of Sale", "Sold Item", "Salesperson", "Sale Price", "Payment Plan"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for (int i = 0; i < searchResults.size(); i++) {
			int saleId = searchResults.get(i).getSaleId();
			String customerName = searchResults.get(i).getCustomerName();
			String dateOfSale = searchResults.get(i).getDateOfSale();
			String soldItemName = searchResults.get(i).getSoldItemName();
			String salespersonName = searchResults.get(i).getSalespersonName();
			int priceOfSale = searchResults.get(i).getPriceOfSale();
			String paymentPlan = searchResults.get(i).getPaymentPlan();
			
			Object[] row = {saleId, customerName, dateOfSale, soldItemName, salespersonName, priceOfSale, paymentPlan};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public static ArrayList<Sale> searchSale(String searchQuery){
		
		SalesHistory sh = new SalesHistory();
		ArrayList<Sale> sales = sh.getAllSales();
		
		ArrayList<Sale> searchResults = new ArrayList<Sale>();
		
		for (int i=0; i<sales.size(); i++) {
			Sale element = sales.get(i);
			if(element.getSoldItemName().equals(searchQuery) || element.getPaymentPlan().equals(searchQuery) || element.getCustomerName().equals(searchQuery) || element.getDateOfSale().equals(searchQuery)) {
				searchResults.add(element);
			}
		}
		return searchResults;
	}
	
	public ArrayList<Sale> registerSale(Sale sale) {
		// Get all employees
		ArrayList<Sale> sales = this.getAllSales();
		sales.add(sale);
		System.out.println(sales);
		return sales;
	}
}
