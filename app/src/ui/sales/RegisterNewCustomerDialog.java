package ui.sales;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.Customer;
import models.CustomerList;
import models.Sale;
import models.SalesHistory;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegisterNewCustomerDialog extends JFrame {

	private JPanel contentPane;
	private JTextField registerCustomerNameTextField;
	private JTextField registrationDateTextField;
	private JTextField registerPhoneNumberTextField;
	private JTextField registerEmailTextField;

	/**
	 * Create the frame.
	 */
	public RegisterNewCustomerDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register New Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 291, 29);
		contentPane.add(lblNewLabel);
		
		registerCustomerNameTextField = new JTextField();
		registerCustomerNameTextField.setBounds(10, 72, 291, 20);
		contentPane.add(registerCustomerNameTextField);
		registerCustomerNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(311, 75, 141, 14);
		contentPane.add(lblNewLabel_1);
		
		registrationDateTextField = new JTextField();
		registrationDateTextField.setBounds(10, 103, 291, 20);
		contentPane.add(registrationDateTextField);
		registrationDateTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Registration Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(311, 106, 155, 17);
		contentPane.add(lblNewLabel_2);
		
		registerPhoneNumberTextField = new JTextField();
		registerPhoneNumberTextField.setBounds(10, 134, 291, 20);
		contentPane.add(registerPhoneNumberTextField);
		registerPhoneNumberTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(311, 137, 141, 17);
		contentPane.add(lblNewLabel_3);
		
		registerEmailTextField = new JTextField();
		registerEmailTextField.setBounds(10, 165, 291, 20);
		contentPane.add(registerEmailTextField);
		registerEmailTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(311, 165, 59, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerName = registerCustomerNameTextField.getText();
				String registrationDate = registrationDateTextField.getText();
				String phoneNumber = registerPhoneNumberTextField.getText();
				String customerEmail = registerEmailTextField.getText();
				
				CustomerList cl = new CustomerList();
				ArrayList<Customer> elements = new ArrayList<Customer>();
				int customerId = cl.generateId(elements);
				Customer customer = new Customer(customerId, customerName, registrationDate, phoneNumber, customerEmail, 0);
				ArrayList<Customer> customers = cl.registerCustomer(customer);
				
				SalesMainMenu.tableModelCustomerSupport.setRowCount(0);
				SalesMainMenu.tableModelCustomerSupport = cl.createCustomersList(customers);
				
				SalesMainMenu.customerList = new JTable(SalesMainMenu.tableModelCustomerSupport){
					public boolean isCellEditable(int row, int column){
				        return false;
				   }
				};
				SalesMainMenu.customerSupportPanel.setViewportView(SalesMainMenu.customerList);
				Component component = (Component) e.getSource();
				JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
				
				currentFrame.setVisible(false);		
			}
		});
		btnNewButton.setBounds(637, 391, 141, 47);
		contentPane.add(btnNewButton);
	}

}
