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
import models.Item;
import models.ItemList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditCustomerInfoDialog extends JFrame {

	private JPanel contentPane;
	private JTextField customerIdTextField;
	private JTextField customerNameTextField;
	private JTextField registrationDateTextField;
	private JTextField phoneNumberTextField;
	private JTextField customerEmailTextField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditCustomerInfoDialog frame = new EditCustomerInfoDialog();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditCustomerInfoDialog(int customerId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Customer Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 235, 29);
		contentPane.add(lblNewLabel);
		
		customerIdTextField = new JTextField();
		customerIdTextField.setText(Integer.toString(customerId));
		customerIdTextField.setEnabled(false);
		customerIdTextField.setBounds(10, 68, 235, 20);
		contentPane.add(customerIdTextField);
		customerIdTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(255, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(10, 99, 235, 20);
		contentPane.add(customerNameTextField);
		customerNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(255, 102, 136, 14);
		contentPane.add(lblNewLabel_2);
		
		registrationDateTextField = new JTextField();
		registrationDateTextField.setBounds(10, 130, 235, 20);
		contentPane.add(registrationDateTextField);
		registrationDateTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Registration Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(255, 130, 154, 17);
		contentPane.add(lblNewLabel_3);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(10, 161, 235, 20);
		contentPane.add(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(255, 161, 136, 14);
		contentPane.add(lblNewLabel_4);
		
		customerEmailTextField = new JTextField();
		customerEmailTextField.setBounds(10, 192, 235, 20);
		contentPane.add(customerEmailTextField);
		customerEmailTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(255, 195, 56, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerId = customerIdTextField.getText();
				if(customerId != null) {
					// Get text fields values
					String customerName = customerNameTextField.getText();
					String registrationDate = registrationDateTextField.getText();
					String phoneNumber = phoneNumberTextField.getText();
					String customerEmail = customerEmailTextField.getText();
					
					CustomerList cl = new CustomerList();
					ArrayList<Customer> updatedList = cl.updateCustomer(Integer.parseInt(customerId), customerName, registrationDate, phoneNumber, customerEmail);
					SalesMainMenu.tableModelCustomerSupport.setRowCount(0); // make list empty
					SalesMainMenu.tableModelCustomerSupport = cl.createCustomersList(updatedList); // Get new table model
					
					JTable customersList = new JTable(SalesMainMenu.tableModelCustomerSupport) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
					
					SalesMainMenu.customerSupportPanel.setViewportView(customersList);
					Component component = (Component) e.getSource();
                    JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
                    dialog.setVisible(false);
				}
			
			}
		});
		btnNewButton.setBounds(632, 361, 114, 47);
		contentPane.add(btnNewButton);
	}

}
