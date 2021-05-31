package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class EmployeeList {
	// Mock data - Employee records
	//
//	private ArrayList<Object> employeesList  = new ArrayList<Object>();
	private ArrayList<Employee> employeesList = new ArrayList<Employee>();
	// Employee 1
//	private List<Object> employee1 = Arrays.asList(1043805, "Konstantinos", "Panos", "kpanos@email.com", "password",
//			"Manager");
	// Employee 2
//	private List<Object> employee2 = Arrays.asList(1042675, "Stylianos", "Avlakiotis", "avlakiotis@email.com",
//			"password", "Sales");

	public EmployeeList() {
//    	this.employeesList.add(employee1);
//    	this.employeesList.add(employee2);
		employeesList.add(new Employee("26/07/1996", "Konstantinos", "Panos", "AB 123456", "16/07/2019", "87651234",
				1043895, "kpanos@email.com", "Manager", "password"));
		employeesList.add(new Employee("17/09/1998", "Stylianos", "Avlakiotis", "EB 125676", "16/07/2019", "12651234",
				1046292, "avlakiotis@email.com", "Sales", "password"));
		employeesList.add(new Employee("28/09/1992", "Konstantinos", "Papadopoulos", "AB 123456", "16/07/2019", "87651234",
				3653895, "kpanos@email.com", "Manager", "password"));
	}

	// This function emulates a call to the database
	// Returns all employees stored in the database
//    public ArrayList<Object> getAllEmployees() {
//		return this.employeesList;
//    }

	public ArrayList<Employee> getAllEmployees() {
		return this.employeesList;
	}

	public Employee getEmployeeByEmail(String email) {
		// Get all employees
		ArrayList<Employee> employees = this.getAllEmployees();
		Employee employee = null;
		
		// Iterate all employees until a matching email is found
		// For Loop for iterating ArrayList
		for (int i = 0; i < employees.size(); i++) {
			Employee element = employees.get(i);
			if(element.getEmail().equals(email)) {
				employee = element;
				break;
			}
		}

		return employee;
	}
	
	public DefaultTableModel createEmployeesList() {
		String columnHeaders[] = {"ID","First name", "Last name", "Department"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		// Get data to populate table
		EmployeeList el = new EmployeeList();
		ArrayList<Employee> employees = el.getAllEmployees();
		
		for (int i = 0; i < employees.size(); i++) {
			int employeeId = employees.get(i).getEmployeeId();
			String firstName = employees.get(i).getFirstName();
			String lastName = employees.get(i).getLastName();
			String department = employees.get(i).getDepartment();
			
			Object[] row = {employeeId, firstName, lastName, department};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}
	
	public DefaultTableModel createEmployeesList(ArrayList<Employee> employees) {
		String columnHeaders[] = {"ID","First name", "Last name", "Department"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);
		
		for (int i = 0; i < employees.size(); i++) {
			int employeeId = employees.get(i).getEmployeeId();
			String firstName = employees.get(i).getFirstName();
			String lastName = employees.get(i).getLastName();
			String department = employees.get(i).getDepartment();
			
			Object[] row = {employeeId, firstName, lastName, department};
			
			tableModel.addRow(row);
		}
		return tableModel;
	}

	public Employee getEmployeeById(int employeeId) {
		// Get all employees
		ArrayList<Employee> employees = this.getAllEmployees();
		Employee employee = null;
		
		for (int i = 0; i < employees.size(); i++) {
			Employee element = employees.get(i);
			if(element.getEmployeeId() == employeeId) {
				employee = element;
				break;
			}
		}

		return employee;
	}
	
	public ArrayList<Employee> registerEmployee(Employee employee) {
		// Get all employees
		ArrayList<Employee> employees = this.getAllEmployees();
		employees.add(employee);
		System.out.println(employees);
		return employees;
	}
	
	public ArrayList<Employee> updateEmployee(String id, String firstName, String lastName, String department, String dob) {
		// Get employee that will be updated
		Employee employee = this.getEmployeeById(Integer.parseInt(id));
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDepartment(department);
		employee.setDateOfBirth(dob);
		
		// Get employees list
		ArrayList<Employee> employees = this.getAllEmployees();
		
		// Update previous record
		for (int i = 0; i < employees.size(); i++) {
			Employee element = employees.get(i);
			if(element.getEmployeeId() == Integer.parseInt(id)) {
				employees.set(i, element);
			}
		}
		
		return employees;
	}
}
