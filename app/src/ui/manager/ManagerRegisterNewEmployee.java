package ui.manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Employee;
import models.EmployeeList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class ManagerRegisterNewEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField socialIdTextField;
	private JTextField ssnTextField;
	private JTextField dobTextField;
	private JTextField emailTextField;


	/**
	 * Create the dialog.
	 * @param empoloyeesList 
	 * @param tableModel 
	 */
	public ManagerRegisterNewEmployee() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 446, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register new employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 225, 14);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("First name");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(46, 38, 124, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(180, 36, 225, 20);
		contentPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(46, 65, 124, 14);
		contentPanel.add(lblNewLabel_1);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(180, 63, 225, 20);
		contentPanel.add(lastNameTextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Social ID number");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(46, 92, 124, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		socialIdTextField = new JTextField();
		socialIdTextField.setColumns(10);
		socialIdTextField.setBounds(180, 90, 225, 20);
		contentPanel.add(socialIdTextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Social security number");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 119, 160, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		ssnTextField = new JTextField();
		ssnTextField.setColumns(10);
		ssnTextField.setBounds(180, 117, 225, 20);
		contentPanel.add(ssnTextField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Date of birth");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(10, 146, 160, 14);
		contentPanel.add(lblNewLabel_1_2_1);
		
		dobTextField = new JTextField();
		dobTextField.setText("dd/mm/yyyy");
		dobTextField.setColumns(10);
		dobTextField.setBounds(180, 144, 225, 20);
		contentPanel.add(dobTextField);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail address");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(46, 173, 124, 14);
		contentPanel.add(lblNewLabel_1_3);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(180, 171, 225, 20);
		contentPanel.add(emailTextField);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Department");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_1.setBounds(46, 200, 124, 14);
		contentPanel.add(lblNewLabel_1_3_1);
		
		JComboBox departmentComboBox = new JComboBox();
		departmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Sales", "Mechanic", "Manager"}));
		departmentComboBox.setBounds(180, 197, 225, 17);
		contentPanel.add(departmentComboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton registerButton = new JButton("Register");
				registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String firstName = firstNameTextField.getText();
						String lastName = lastNameTextField.getText();
						String socialIdNumber = socialIdTextField.getText();
						String ssn = ssnTextField.getText();
						String dob = dobTextField.getText();
						String email = emailTextField.getText();
						String department = departmentComboBox.getSelectedItem().toString();
						
						// Get current date
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
						LocalDateTime now = LocalDateTime.now();  
						String currentDate = dtf.format(now).toString();
						
						EmployeeList el = new EmployeeList();
						
						// Generate a 7-digit id for the new employee - ex. 1043805
						int employeeId = -1;
						boolean idExists = false;	
						do {
							
							employeeId = (int) ((Math.random() * 9000000) + 1000000);
							System.out.println(employeeId);
							// Check if id already exists
							if (el.getEmployeeById(employeeId) != null) { // id exists
								idExists = true;
							}
						} while(idExists == true);
						
						
						// Create new employee object
						Employee  employee = new Employee(dob, firstName, lastName, socialIdNumber, currentDate, ssn, employeeId, email, department, "password");
						// Register new employee to the database
						ArrayList<Employee> employees = el.registerEmployee(employee);
						
						// Clear JTable values
						ManagerManageEmployees.tableModel.setRowCount(0);
						ManagerManageEmployees.tableModel = el.createEmployeesList(employees);
						
						JTable employeesList = new JTable(ManagerManageEmployees.tableModel) {
							public boolean isCellEditable(int row, int column){
						        return false;
						   }
						};
						
						ManagerManageEmployees.employeesListPanel.setViewportView(employeesList);
						
						// Close the dialog window
						Component component = (Component) e.getSource();
				        JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
				        dialog.setVisible(false);
					}
				});
//				registerButton.setActionCommand("OK");
				buttonPane.add(registerButton);
				getRootPane().setDefaultButton(registerButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Component component = (Component) e.getSource();
				        JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
				        dialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
