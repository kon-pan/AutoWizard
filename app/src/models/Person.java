package models;

public class Person {
	private String dateOfBirth;
	private String firstName;
	private String lastName;
	private String socialIdNumber;

	public Person(String dateOfBirth, String firstName, String lastName, String socialIdNumber) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialIdNumber = socialIdNumber;
	}

	protected String getDateOfBirth() {
		return dateOfBirth;
	}

	protected void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected String getSocialIdNumber() {
		return socialIdNumber;
	}

	protected void setSocialIdNumber(String socialIdNumber) {
		this.socialIdNumber = socialIdNumber;
	}

}
