package models;

public class Supplier {
	private int supplierId;
	private String name;
	private String country;
	private String city;
	private String address;
	private String websiteUrl;
	
	public Supplier(int supplierId, String name, String country, String city, String address, String websiteUrl) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.country = country;
		this.city = city;
		this.address = address;
		this.websiteUrl = websiteUrl;
	}

	int getSupplierId() {
		return supplierId;
	}

	void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getCountry() {
		return country;
	}

	void setCountry(String country) {
		this.country = country;
	}

	String getCity() {
		return city;
	}

	void setCity(String city) {
		this.city = city;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}

	String getWebsiteUrl() {
		return websiteUrl;
	}

	void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}


}
