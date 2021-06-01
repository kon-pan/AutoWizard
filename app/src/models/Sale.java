package models;

import java.util.ArrayList;

public class Sale {
	private int saleId;
	private String customerName;
	private String dateOfSale;
	private String soldItemName;
	private String salespersonName;
	private int priceOfSale;
	private String paymentPlan;
	
	public Sale(int saleId, String customerName, String dateOfSale, String soldItemName, String salespersonName, int priceOfSale,
			String paymentPlan) {
		super();
		this.saleId = saleId;
		this.customerName = customerName;
		this.dateOfSale = dateOfSale;
		this.soldItemName = soldItemName;
		this.salespersonName = salespersonName;
		this.priceOfSale = priceOfSale;
		this.paymentPlan = paymentPlan;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public String getSoldItemName() {
		return soldItemName;
	}

	public void setSoldItemName(String soldItemName) {
		this.soldItemName = soldItemName;
	}

	public String getSalespersonName() {
		return salespersonName;
	}

	public void setSalespersonName(String salespersonName) {
		this.salespersonName = salespersonName;
	}

	public int getPriceOfSale() {
		return priceOfSale;
	}

	public void setPriceOfSale(int priceOfSale) {
		this.priceOfSale = priceOfSale;
	}

	public String getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}
}
