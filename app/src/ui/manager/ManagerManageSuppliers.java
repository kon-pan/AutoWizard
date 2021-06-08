package ui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.Employee;
import models.SupplierContact;
import models.SupplierContactList;
import models.SupplierList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ManagerManageSuppliers extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ManagerManageSuppliers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage Suppliers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 144, 20);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(430, 42, 427, 418);
		contentPane.add(panel);
		CardLayout cardLayout = new CardLayout(0, 0);
		panel.setLayout(cardLayout);

		JPanel messagePanel = new JPanel();
		panel.add(messagePanel, "name_450927381104100");
		messagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel(
				"<html>\r\nTo select a supplier simply click on an item in the list. <br>\r\nTo edit a supplier's info double click on an item in the list.\r\n</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		messagePanel.add(lblNewLabel_1, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, "Supplier info");

		JPanel supplierInfoPanel = new JPanel();
		tabbedPane.addTab("Supplier Info", null, supplierInfoPanel, null);
		supplierInfoPanel.setLayout(null);
		
		// Panel border styling
		TitledBorder border = new TitledBorder(null, "Pending orders", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane pendingOrderPanel = new JScrollPane();
		pendingOrderPanel.setBorder(border);
		pendingOrderPanel.setBounds(10, 61, 402, 150);
		supplierInfoPanel.add(pendingOrderPanel);
		
		// Panel border styling
		border = new TitledBorder(null, "Completed orders", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane completedOrdersPanel = new JScrollPane();
		completedOrdersPanel.setBorder(border);
		completedOrdersPanel.setBounds(10, 222, 402, 150);
		supplierInfoPanel.add(completedOrdersPanel);

		JLabel supplierNameLabel = new JLabel("New label");
		supplierNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supplierNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		supplierNameLabel.setBounds(10, 11, 402, 24);
		supplierInfoPanel.add(supplierNameLabel);

		JLabel supplierLocationLabel = new JLabel("New label, Label");
		supplierLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supplierLocationLabel.setBounds(10, 36, 402, 14);
		supplierInfoPanel.add(supplierLocationLabel);

		JPanel supplierContactsPanel = new JPanel();
		tabbedPane.addTab("Supplier Contacts", null, supplierContactsPanel, null);
		supplierContactsPanel.setLayout(null);
		
		JScrollPane supplierContactsListPanel = new JScrollPane();
		supplierContactsListPanel.setBounds(10, 11, 402, 152);
		supplierContactsPanel.add(supplierContactsListPanel);
		
		JPanel supplierContactDetailsPanel = new JPanel();
		supplierContactDetailsPanel.setBounds(10, 174, 402, 205);
		supplierContactsPanel.add(supplierContactDetailsPanel);

		JScrollPane suppliersListPanel = new JScrollPane();
		suppliersListPanel.setBounds(10, 42, 410, 418);
		contentPane.add(suppliersListPanel);

		// ************************************************************************
		// Create the suppliers list
		// ************************************************************************
		SupplierList sl = new SupplierList();
		DefaultTableModel tableModel = sl.createEmployeesList();

		JTable suppliersList = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Add listener to the list
		suppliersList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panel, "Supplier info");
				
				int selectedRowIndex = suppliersList.getSelectedRow();
				int selectedSupplierId = (int) tableModel.getValueAt(selectedRowIndex, 0);
				String selectedSupplierName = (String) tableModel.getValueAt(selectedRowIndex, 1);
				String selectedSupplierCountry = (String) tableModel.getValueAt(selectedRowIndex, 2);
				String selectedSupplierCity = (String) tableModel.getValueAt(selectedRowIndex, 3);
				String selectedSupplierLocation = selectedSupplierCountry + ", " + selectedSupplierCity;
				
				supplierNameLabel.setText(selectedSupplierName);
				supplierLocationLabel.setText(selectedSupplierLocation);
				
				SupplierContactList scl = new SupplierContactList();
				ArrayList<SupplierContact> supplierContacts = scl.getSupplierContactsById(selectedSupplierId);
				DefaultTableModel tableModel = scl.createSupplierContactsList(supplierContacts);
				JTable supplierContactsList = new JTable(tableModel) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				supplierContactsListPanel.setViewportView(supplierContactsList);
//				Employee employee = el.getEmployeeById(selectedEmployeeId);	
//				
//				idTextField.setText(Integer.toString(employee.getEmployeeId()));
//				firstNameTextField.setText(employee.getFirstName());
//				lastNameTextField.setText(employee.getLastName());
//				departmentTextField.setText(employee.getDepartment());
//				dobTextField.setText(employee.getDateOfBirth());
			}
		});

		suppliersListPanel.setViewportView(suppliersList);

	}
}
