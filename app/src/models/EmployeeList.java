package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeList {
	// Mock data - Employee records
	// 
	private ArrayList<Object> employeesList  = new ArrayList<Object>();
	//Employee 1
    private List<Object> employee1 = Arrays.asList( 1043805, "Konstantinos", "Panos", "kpanos@email.com", "password", "Manager");
    //Employee 2
    private List<Object> employee2 = Arrays.asList( 1042675, "Stylianos", "Avlakiotis", "avlakiotis@email.com", "password", "Sales");
    
    public EmployeeList() {
    	this.employeesList.add(employee1);
    	this.employeesList.add(employee2);
    }
    
    // This function emulates a call to the database
    // Returns all employees stored in the database
    public ArrayList<Object> getAllEmployees() {
		return this.employeesList;
    }
    
    @SuppressWarnings("unchecked")
	public List<Object> getEmployeeByEmail(String email) {
    	// Get all employees
    	ArrayList<Object> employees = this.getAllEmployees();
    	
    	// Iterate all employees until a matching email is found
    	List<Object> employee  = new ArrayList<Object>();
    	
    	// For Loop for iterating ArrayList
        for (int i = 0; i < employees.size(); i++) {
        	List<Object> element  = (List<Object>) employees.get(i);
        	if (element.get(3).equals(email)) {
        		employee = element;
        	}
    	}
        
		return employee;
    }
}
