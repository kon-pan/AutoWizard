package models;

public class SupplierContact extends Person {
	
	private String phoneNumber;
	private String email;
	private int supplierId;
	
	public SupplierContact(String dateOfBirth, String firstName, String lastName, String socialIdNumber, String phoneNumber, String email, int supplierId) {
		super(dateOfBirth, firstName, lastName, socialIdNumber);
		// TODO Auto-generated constructor stub
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.supplierId = supplierId;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	int getSupplierId() {
		return supplierId;
	}

	void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}
