package ui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.ItemList;
import ui.sales.EditItemDialog;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;

public class ManagerManageStock extends JFrame {

	private JPanel contentPane;
	private JTable itemListTable;
	public static DefaultTableModel tableModel;
	private JTextField itemIdTextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtQuantity;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ManagerManageStock() {
		setTitle("AutoWizard (Manager) - Manage Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 145, 284, 296);
		contentPane.add(layeredPane);

		JPanel editItemPanel = new JPanel();
		
		// Panel border styling
		TitledBorder border = new TitledBorder(null, "Edit Item", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahome", Font.BOLD, 14));
		
		editItemPanel.setBorder(border);
		editItemPanel.setBounds(0, 0, 284, 296);
		layeredPane.add(editItemPanel);
		editItemPanel.setLayout(null);
		editItemPanel.setVisible(false);

		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 34, 67, 14);
		editItemPanel.add(lblNewLabel_4);

		itemIdTextField = new JTextField();
		itemIdTextField.setEditable(false);
		itemIdTextField.setBounds(87, 31, 177, 20);
		editItemPanel.add(itemIdTextField);
		itemIdTextField.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("Title");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(10, 62, 67, 14);
		editItemPanel.add(lblNewLabel_4_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 59, 177, 20);
		editItemPanel.add(textField_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Price");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1.setBounds(10, 90, 67, 14);
		editItemPanel.add(lblNewLabel_4_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 87, 177, 20);
		editItemPanel.add(textField_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Category");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1_1.setBounds(10, 118, 67, 14);
		editItemPanel.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1_1_1.setBounds(10, 146, 67, 14);
		editItemPanel.add(lblNewLabel_4_1_1_1_1);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(87, 143, 177, 20);
		editItemPanel.add(txtQuantity);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 115, 177, 22);
		editItemPanel.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("Supplied from:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 242, 81, 14);
		editItemPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("<Supplier Name>");
		lblNewLabel_6.setBounds(97, 242, 177, 14);
		editItemPanel.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(192, 174, 72, 23);
		editItemPanel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Remove");
		btnNewButton_2_1.setBounds(87, 174, 89, 23);
		editItemPanel.add(btnNewButton_2_1);

		JButton btnNewButton_3 = new JButton("View supplier info");
		btnNewButton_3.setBounds(87, 262, 133, 23);
		editItemPanel.add(btnNewButton_3);

		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(0, 0, 284, 296);
		layeredPane.add(messagePanel);
		messagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel(
				"<html>Click an item from the list on the right to edit or remove it.</html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		messagePanel.add(lblNewLabel_2, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Manage Stock");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 224, 21);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setBounds(10, 452, 121, 23);
		contentPane.add(btnNewButton);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(659, 9, 89, 23);
		contentPane.add(btnLogOut);

		JScrollPane itemListScrollPane = new JScrollPane();
		itemListScrollPane.setBounds(304, 71, 444, 370);
		contentPane.add(itemListScrollPane);

		JButton btnExportList = new JButton("Export list...");
		btnExportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExportList.setBounds(646, 452, 102, 23);
		contentPane.add(btnExportList);

		JButton addNewItemButton = new JButton("Add new item");
		addNewItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerAddNewItem dialog = new ManagerAddNewItem();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		addNewItemButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		addNewItemButton.setBounds(515, 452, 121, 23);
		contentPane.add(addNewItemButton);

		// Create items list
		ItemList il = new ItemList();
		tableModel = il.createItemsList();

		itemListTable = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		itemListScrollPane.setViewportView(itemListTable);
		
		JPanel searchPanel = new JPanel();
		
		// Panel border styling
		border = new TitledBorder(null, "Search stock", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahome", Font.BOLD, 14));
		
		searchPanel.setBorder(border);
		searchPanel.setBounds(10, 65, 284, 78);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 21, 264, 20);
		searchPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(185, 44, 89, 23);
		searchPanel.add(btnNewButton_1);

		// Action listener for clicking a table row
		itemListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Remove message panel
				layeredPane.removeAll();
				// Show edit panel
				layeredPane.add(editItemPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				editItemPanel.setVisible(true);

				int selectedRowIndex = itemListTable.getSelectedRow();
				int itemId = (int) itemListTable.getModel().getValueAt(selectedRowIndex, 0);

				itemIdTextField.setText(Integer.toString(itemId));
			}
		});
	}
}
