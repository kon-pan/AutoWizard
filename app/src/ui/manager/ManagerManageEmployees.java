package ui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ManagerManageEmployees extends JFrame {

	private JPanel contentPane;
	private JTable empoloyeesList;
	private JTextField idTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField departmentTextField;
	private JTextField dobTextField;
	private JTextField searchQueryTextField;
	public static JScrollPane employeesListPanel;
	public static DefaultTableModel tableModel;
	public static EmployeeList el;

	/**
	 * Create the frame.
	 */
	public ManagerManageEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage Employees");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 277, 14);
		contentPane.add(lblNewLabel);

		employeesListPanel = new JScrollPane();
		employeesListPanel.setBounds(389, 135, 353, 299);
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
				departmentTextField.setText(employee.getDepartment());
				dobTextField.setText(employee.getDateOfBirth());
			}
		});

		employeesListPanel.setViewportView(empoloyeesList);

		JLabel lblNewLabel_1 = new JLabel("Edit Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 58, 139, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 84, 105, 14);
		contentPane.add(lblNewLabel_2);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(135, 82, 244, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);

		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(135, 109, 244, 20);
		contentPane.add(firstNameTextField);

		JLabel lblNewLabel_2_1 = new JLabel("FIrst Name");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(20, 111, 105, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(20, 138, 105, 14);
		contentPane.add(lblNewLabel_2_1_1);

		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(135, 136, 244, 20);
		contentPane.add(lastNameTextField);

		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		departmentTextField.setBounds(135, 163, 244, 20);
		contentPane.add(departmentTextField);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Department");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(20, 165, 105, 14);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Date of birth");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_2.setBounds(20, 192, 105, 14);
		contentPane.add(lblNewLabel_2_1_1_2);

		dobTextField = new JTextField();
		dobTextField.setColumns(10);
		dobTextField.setBounds(135, 190, 244, 20);
		contentPane.add(dobTextField);

		JLabel lblNewLabel_3 = new JLabel("Search employee");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(389, 60, 167, 14);
		contentPane.add(lblNewLabel_3);

		searchQueryTextField = new JTextField();
		searchQueryTextField.setBounds(389, 82, 353, 20);
		contentPane.add(searchQueryTextField);
		searchQueryTextField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
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
							departmentTextField.setText(employee.getDepartment());
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
							departmentTextField.setText(employee.getDepartment());
							dobTextField.setText(employee.getDateOfBirth());
						}
					});

					employeesListPanel.setViewportView(empoloyeesList);
				}
			}
		});
		btnNewButton.setBounds(653, 108, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Export list...");
		btnNewButton_1.setBounds(637, 445, 105, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register new employee");
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
		btnNewButton_2.setBounds(135, 383, 244, 51);
		contentPane.add(btnNewButton_2);

		JButton saveChangesButton = new JButton("Save changes");
		saveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeId = idTextField.getText();
				if (employeeId != null) {
					// Get text fields values
					String firstName = firstNameTextField.getText();
					String lastName = lastNameTextField.getText();
					String department = departmentTextField.getText();
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
							departmentTextField.setText(employee.getDepartment());
							dobTextField.setText(employee.getDateOfBirth());
						}
					});

					employeesListPanel.setViewportView(empoloyeesList);
				}
			}
		});
		saveChangesButton.setBounds(230, 221, 149, 23);
		contentPane.add(saveChangesButton);

		// Remove employee
		JButton removeEmployeeButton = new JButton("Remove employee");
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
		removeEmployeeButton.setBounds(230, 252, 147, 23);
		contentPane.add(removeEmployeeButton);

		JButton btnNewButton_3_1_1 = new JButton("Remove multiple employees");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1_1.setBounds(135, 287, 244, 37);
		contentPane.add(btnNewButton_3_1_1);

		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(653, 9, 89, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("Main Menu");
		btnNewButton_4_1.setBounds(10, 445, 89, 23);
		contentPane.add(btnNewButton_4_1);
	}

}
