package ui.sales;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.Employee;
import models.EmployeeList;
import models.Item;
import models.ItemList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditItemDialog extends JFrame {

	private JPanel contentPane;
	private JTextField itemIdTextField;
	private JTextField itemPriceTextField;
	private JTextField itemNameTextField;
	private JTextField itemTypeTextField;
	
	
	/**
	 * Create the frame.
	 * @param itemId 
	 */
	public EditItemDialog(int itemId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		itemIdTextField = new JTextField();
		itemIdTextField.setText(Integer.toString(itemId));
		itemIdTextField.setEnabled(false);
		itemIdTextField.setBounds(10, 61, 273, 20);
		contentPane.add(itemIdTextField);
		itemIdTextField.setColumns(10);
		
		itemPriceTextField = new JTextField();
		itemPriceTextField.setBounds(10, 108, 273, 20);
		contentPane.add(itemPriceTextField);
		itemPriceTextField.setColumns(10);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(10, 156, 273, 20);
		contentPane.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		itemTypeTextField = new JTextField();
		itemTypeTextField.setBounds(10, 208, 273, 20);
		contentPane.add(itemTypeTextField);
		itemTypeTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edit Item Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 248, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(293, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(293, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(293, 156, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(293, 203, 46, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemId = itemIdTextField.getText();
				if(itemId != null) {
					// Get text fields values
					String itemPrice = itemPriceTextField.getText();
					String itemName = itemNameTextField.getText();
					String itemType = itemTypeTextField.getText();
					
					ItemList il = new ItemList();
					ArrayList<Object> updatedList = il.updateItem(itemId, itemPrice, itemName, itemType);
					SalesMainMenu.tableModel.setRowCount(0); // make list empty
					SalesMainMenu.tableModel = il.createItemsList(updatedList); // Get new table model
					
					JTable itemsList = new JTable(SalesMainMenu.tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
					
					// Add listener to new list
					// TODO: add below listener to separate ActionListener object (DRY)
//					SalesMainMenu.itemsList.addMouseListener(new MouseAdapter() {
//						@Override
//						public void mouseClicked(MouseEvent e) {
//							// Populate form fields when an employee from the list is 
//							// clicked
//							int selectedRowIndex = empoloyeesList.getSelectedRow();
//							System.out.println(selectedRowIndex);
//							
//							int selectedEmployeeId = (int) tableModel.getValueAt(selectedRowIndex, 0);
//							System.out.println(selectedEmployeeId);
//							
//							Employee employee = el.getEmployeeById(selectedEmployeeId);	
//							
//							idTextField.setText(Integer.toString(employee.getEmployeeId()));
//							firstNameTextField.setText(employee.getFirstName());
//							lastNameTextField.setText(employee.getLastName());
//							departmentTextField.setText(employee.getDepartment());
//							dobTextField.setText(employee.getDateOfBirth());
//						}
//					});
					
					SalesMainMenu.itemsListPanel.setViewportView(itemsList);
					Component component = (Component) e.getSource();
                    JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
                    dialog.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(585, 356, 161, 52);
		contentPane.add(btnNewButton);
		
		ItemList il = new ItemList();
		Item item = il.getItemById(itemId);
		
		itemPriceTextField.setText(Integer.toString(item.getItemPrice()));
		itemNameTextField.setText(item.getItemName());
		itemTypeTextField.setText(item.getItemType());
	}
}
