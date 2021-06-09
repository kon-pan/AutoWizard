package ui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.Employee;
import models.EmployeeList;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ManagerManageEmployees extends JFrame {

	private JPanel contentPane;
	private JTable empoloyeesList;
	private JTextField idTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JComboBox departmentComboBox;
	private JTextField dobTextField;
	private JTextField searchQueryTextField;
	public static JScrollPane employeesListPanel;
	public static DefaultTableModel tableModel;
	public static EmployeeList el;

	/**
	 * Create the frame.
	 */
	public ManagerManageEmployees() {
		setTitle("AutoWizard (Manager) - Manage Employees");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage Employees");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 277, 21);
		contentPane.add(lblNewLabel);
		
		// Panel border styling
		TitledBorder border = new TitledBorder(null, "Edit employee", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel editPanel = new JPanel();
		editPanel.setBorder(border);
		editPanel.setBounds(8, 37, 369, 193);
		contentPane.add(editPanel);
		editPanel.setLayout(null);

		idTextField = new JTextField();
		idTextField.setBounds(113, 18, 244, 20);
		editPanel.add(idTextField);
		idTextField.setEditable(false);
		idTextField.setColumns(10);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(113, 45, 244, 20);
		editPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(113, 72, 244, 20);
		editPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		departmentComboBox = new JComboBox();
		departmentComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Manager", "Sales", "Mechanic" }));
		departmentComboBox.setBounds(113, 99, 244, 20);
		editPanel.add(departmentComboBox);

		dobTextField = new JTextField();
		dobTextField.setBounds(113, 126, 244, 20);
		editPanel.add(dobTextField);
		dobTextField.setColumns(10);
		
		employeesListPanel = new JScrollPane();
		employeesListPanel.setBounds(389, 126, 353, 307);
		contentPane.add(employeesListPanel);
		
		// ************************************************************************
		// Create the employees list
		// ************************************************************************
		el = new EmployeeList();
		tableModel = el.createEmployeesList();

		empoloyeesList = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Add listener to the list
		// TODO: add below listener to separate ActionListener object (DRY)
		empoloyeesList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Populate form fields when an employee from the list is
				// clicked
				int selectedRowIndex = empoloyeesList.getSelectedRow();
				int selectedEmployeeId = (int) tableModel.getValueAt(selectedRowIndex, 0);
				System.out.println(selectedEmployeeId);

				Employee employee = el.getEmployeeById(selectedEmployeeId);

				idTextField.setText(Integer.toString(employee.getEmployeeId()));
				firstNameTextField.setText(employee.getFirstName());
				lastNameTextField.setText(employee.getLastName());
				
				// Set combobox value
				switch (employee.getDepartment()) {
				case "Manager":
					departmentComboBox.setSelectedIndex(1);
					break;

				case "Sales":
					departmentComboBox.setSelectedIndex(2);
					break;
					
				case "Mechanic":
					departmentComboBox.setSelectedIndex(3);
					break;
					
				default:
					break;
				}
				
				dobTextField.setText(employee.getDateOfBirth());
			}
		});

		employeesListPanel.setViewportView(empoloyeesList);

		

		// Remove employee
		JButton removeEmployeeButton = new JButton("Remove employee");
		removeEmployeeButton.setBounds(49, 158, 147, 23);
		editPanel.add(removeEmployeeButton);

		JButton saveChangesButton = new JButton("Save changes");
		saveChangesButton.setBounds(208, 158, 149, 23);
		editPanel.add(saveChangesButton);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 20, 83, 16);
		editPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("First name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(12, 47, 83, 16);
		editPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Last name");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(12, 74, 83, 16);
		editPanel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(12, 101, 83, 16);
		editPanel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Date of birth");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_2.setBounds(12, 128, 83, 16);
		editPanel.add(lblNewLabel_1_1_1_2);
		saveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeId = idTextField.getText();
				if (employeeId != null) {
					// Get text fields values
					String firstName = firstNameTextField.getText();
					String lastName = lastNameTextField.getText();
					String department = departmentComboBox.getSelectedItem().toString();
					String dob = dobTextField.getText();

					EmployeeList el = new EmployeeList();
					ArrayList<Employee> updatedList = el.updateEmployee(employeeId, firstName, lastName, department,
							dob);
					tableModel.setRowCount(0); // make list empty
					tableModel = el.createEmployeesList(updatedList); // Get new table model

					empoloyeesList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					// Add listener to new list
					// TODO: add below listener to separate ActionListener object (DRY)
					empoloyeesList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							// Populate form fields when an employee from the list is
							// clicked
							int selectedRowIndex = empoloyeesList.getSelectedRow();
							System.out.println(selectedRowIndex);

							int selectedEmployeeId = (int) tableModel.getValueAt(selectedRowIndex, 0);
							System.out.println(selectedEmployeeId);

							Employee employee = el.getEmployeeById(selectedEmployeeId);

							idTextField.setText(Integer.toString(employee.getEmployeeId()));
							firstNameTextField.setText(employee.getFirstName());
							lastNameTextField.setText(employee.getLastName());
							// Set combobox value
							switch (employee.getDepartment()) {
							case "Manager":
								departmentComboBox.setSelectedIndex(1);
								break;

							case "Sales":
								departmentComboBox.setSelectedIndex(2);
								break;
								
							case "Mechanic":
								departmentComboBox.setSelectedIndex(3);
								break;
								
							default:
								break;
							}
							dobTextField.setText(employee.getDateOfBirth());
						}
					});

					employeesListPanel.setViewportView(empoloyeesList);
				}
			}
		});
		removeEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeId = idTextField.getText();
				if (employeeId != null) {

					// Confirmation dialog
					boolean confirm = false;
					try {
						ManagerConfirmRemove dialog = new ManagerConfirmRemove(employeeId);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						confirm = dialog.getRemoveConfirmation();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					System.out.println("Remove? " + confirm);

					if (confirm == true) {
						EmployeeList el = new EmployeeList();
						ArrayList<Employee> updatedList = el.removeEmployee(Integer.parseInt(employeeId));

						tableModel.setRowCount(0); // make list empty
						tableModel = el.createEmployeesList(updatedList); // Get new table model

						empoloyeesList = new JTable(tableModel) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						employeesListPanel.setViewportView(empoloyeesList);
					}

				}
			}
		});
		
		
		// Panel border styling
		border = new TitledBorder(null, "Search employees", TitledBorder.CENTER, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(border);
		searchPanel.setBounds(389, 37, 353, 79);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);

		searchQueryTextField = new JTextField();
		searchQueryTextField.setBounds(12, 20, 329, 20);
		searchPanel.add(searchQueryTextField);
		searchQueryTextField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(252, 44, 89, 23);
		searchPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchQuery = searchQueryTextField.getText();
				ArrayList<Employee> searchResults = Employee.search(searchQuery);

				System.out.println(searchResults);

				if (!searchQuery.equals("")) {
					// Clear JTable values
					tableModel.setRowCount(0);

					EmployeeList el = new EmployeeList();
					DefaultTableModel tableModel = el.createEmployeesList(searchResults);

					JTable searchResultsList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					// Add listener to new list
					// TODO: add below listener to separate ActionListener object (DRY)
					searchResultsList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							// Populate form fields when an employee from the list is
							// clicked
							int selectedRowIndex = searchResultsList.getSelectedRow();
							System.out.println(selectedRowIndex);

							int selectedEmployeeId = (int) tableModel.getValueAt(selectedRowIndex, 0);
							System.out.println(selectedEmployeeId);

							Employee employee = el.getEmployeeById(selectedEmployeeId);

							idTextField.setText(Integer.toString(employee.getEmployeeId()));
							firstNameTextField.setText(employee.getFirstName());
							lastNameTextField.setText(employee.getLastName());
							// Set combobox value
							switch (employee.getDepartment()) {
							case "Manager":
								departmentComboBox.setSelectedIndex(1);
								break;

							case "Sales":
								departmentComboBox.setSelectedIndex(2);
								break;
								
							case "Mechanic":
								departmentComboBox.setSelectedIndex(3);
								break;
								
							default:
								break;
							}
							dobTextField.setText(employee.getDateOfBirth());
						}
					});

					employeesListPanel.setViewportView(searchResultsList);
				} else {
					EmployeeList el = new EmployeeList();
					DefaultTableModel tableModel = el.createEmployeesList();

					empoloyeesList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					// Add listener to new list
					// TODO: add below listener to separate ActionListener object (DRY)
					empoloyeesList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							// Populate form fields when an employee from the list is
							// clicked
							int selectedRowIndex = empoloyeesList.getSelectedRow();
							System.out.println(selectedRowIndex);

							int selectedEmployeeId = (int) tableModel.getValueAt(selectedRowIndex, 0);
							System.out.println(selectedEmployeeId);

							Employee employee = el.getEmployeeById(selectedEmployeeId);

							idTextField.setText(Integer.toString(employee.getEmployeeId()));
							firstNameTextField.setText(employee.getFirstName());
							lastNameTextField.setText(employee.getLastName());
							// Set combobox value
							switch (employee.getDepartment()) {
							case "Manager":
								departmentComboBox.setSelectedIndex(1);
								break;

							case "Sales":
								departmentComboBox.setSelectedIndex(2);
								break;
								
							case "Mechanic":
								departmentComboBox.setSelectedIndex(3);
								break;
								
							default:
								break;
							}
							dobTextField.setText(employee.getDateOfBirth());
						}
					});

					employeesListPanel.setViewportView(empoloyeesList);
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Export list...");
		btnNewButton_1.setBounds(637, 445, 105, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register new employee");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerRegisterNewEmployee dialog = new ManagerRegisterNewEmployee();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 274, 369, 37);
		contentPane.add(btnNewButton_2);
		
		// Remove multiple employees
		JButton btnNewButton_3_1_1 = new JButton("Remove multiple employees");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Employee> updatedList = new ArrayList<Employee>();
				try {
					ManagerRemoveMultipleEmployees dialog = new ManagerRemoveMultipleEmployees();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					updatedList = dialog.getUpdatedList();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				tableModel.setRowCount(0); // make list empty
				tableModel = el.createEmployeesList(updatedList); // Get new table model

				empoloyeesList = new JTable(tableModel) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				employeesListPanel.setViewportView(empoloyeesList);
			}
		});
		btnNewButton_3_1_1.setBounds(10, 322, 369, 37);
		contentPane.add(btnNewButton_3_1_1);

		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(653, 9, 89, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("Main Menu");
		btnNewButton_4_1.setBounds(10, 464, 115, 23);
		contentPane.add(btnNewButton_4_1);
	}
}
