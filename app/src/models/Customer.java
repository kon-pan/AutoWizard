package models;

public class Customer {
	private int customerId;
	private String customerName;
	private String registrationDate;
	private String phoneNumber;
	private String customerEmail;
	private int totalSpent;
	
	public Customer(int customerId, String customerName, String registrationDate, String phoneNumber, String customerEmail, int totalSpent) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
		this.phoneNumber = phoneNumber;
		this.customerEmail = customerEmail;
		this.totalSpent = totalSpent;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(int totalSpent) {
		this.totalSpent = totalSpent;
	}
}
