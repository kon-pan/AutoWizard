package models;

import java.util.ArrayList;

public class Employee extends Person {
	private String dateOfEmployment;
	private String socialSecuirityNumber;
	protected int baseSalary = 560;
	private int employeeId;
	private String email;
	private String department;
	private String password;

	public Employee(String dateOfBirth, String firstName, String lastName, String socialIdNumber,
			String dateOfEmployment, String socialSecuirityNumber, int employeeId, String email, String department,
			String password) {
		super(dateOfBirth, firstName, lastName, socialIdNumber);
		this.dateOfEmployment = dateOfEmployment;
		this.socialSecuirityNumber = socialSecuirityNumber;
		this.employeeId = employeeId;
		this.email = email;
		this.department = department;
		this.password = password;
	}
	
	public static ArrayList<Employee> search(String searchQuery) {
		// Get all employee records
		EmployeeList el = new EmployeeList();
		ArrayList<Employee> employees = el.getAllEmployees();
		
		ArrayList<Employee> searchResults = new ArrayList<Employee>();
		
		// Full name
		
		for (int i = 0; i < employees.size(); i++) {
			Employee element = employees.get(i);
			if(element.getFirstName().equals(searchQuery) || element.getLastName().equals(searchQuery)) {
				searchResults.add(element);
;
			}
		}
		
		return searchResults;
	}

	@Override
	public String getDateOfBirth() {
		// TODO Auto-generated method stub
		return super.getDateOfBirth();
	}

	@Override
	public void setDateOfBirth(String dateOfBirth) {
		// TODO Auto-generated method stub
		super.setDateOfBirth(dateOfBirth);
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}

	@Override
	public String getSocialIdNumber() {
		// TODO Auto-generated method stub
		return super.getSocialIdNumber();
	}

	@Override
	public void setSocialIdNumber(String socialIdNumber) {
		// TODO Auto-generated method stub
		super.setSocialIdNumber(socialIdNumber);
	}

	public String getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public String getSocialSecuirityNumber() {
		return socialSecuirityNumber;
	}

	public void setSocialSecuirityNumber(String socialSecuirityNumber) {
		this.socialSecuirityNumber = socialSecuirityNumber;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
