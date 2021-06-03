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

public class ManagerManageStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable itemListTable;
	public static DefaultTableModel tableModel;
	private JTextField itemIdTextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtQuantity;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		itemListScrollPane.setBounds(304, 80, 444, 364);
		contentPane.add(itemListScrollPane);

		JLabel lblNewLabel_1 = new JLabel("Search stock");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 55, 89, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 80, 284, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(204, 106, 89, 23);
		contentPane.add(btnSearch);

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

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 145, 284, 296);
		contentPane.add(layeredPane);

		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(0, 0, 284, 296);
		layeredPane.add(messagePanel);
		messagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel(
				"<html>Click an item from the list on the right to edit or remove it.</html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		messagePanel.add(lblNewLabel_2, BorderLayout.CENTER);

		JPanel editItemPanel = new JPanel();
		editItemPanel.setBounds(0, 0, 284, 296);
		layeredPane.add(editItemPanel);
		editItemPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Edit item");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 96, 14);
		editItemPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 36, 77, 14);
		editItemPanel.add(lblNewLabel_4);

		itemIdTextField = new JTextField();
		itemIdTextField.setEditable(false);
		itemIdTextField.setBounds(97, 33, 177, 20);
		editItemPanel.add(itemIdTextField);
		itemIdTextField.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("Title");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(10, 64, 77, 14);
		editItemPanel.add(lblNewLabel_4_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 61, 177, 20);
		editItemPanel.add(textField_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Price");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1.setBounds(10, 92, 77, 14);
		editItemPanel.add(lblNewLabel_4_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 89, 177, 20);
		editItemPanel.add(textField_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Category");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1_1.setBounds(10, 120, 77, 14);
		editItemPanel.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1_1_1.setBounds(10, 148, 77, 14);
		editItemPanel.add(lblNewLabel_4_1_1_1_1);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(97, 145, 177, 20);
		editItemPanel.add(txtQuantity);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 117, 177, 22);
		editItemPanel.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("Supplied from:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 242, 81, 14);
		editItemPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("<Supplier Name>");
		lblNewLabel_6.setBounds(97, 242, 177, 14);
		editItemPanel.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(202, 176, 72, 23);
		editItemPanel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Remove");
		btnNewButton_2_1.setBounds(97, 176, 89, 23);
		editItemPanel.add(btnNewButton_2_1);

		JButton btnNewButton_3 = new JButton("View supplier info");
		btnNewButton_3.setBounds(97, 262, 115, 23);
		editItemPanel.add(btnNewButton_3);

		// Create items list
		ItemList il = new ItemList();
		tableModel = il.createItemsList();

		itemListTable = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		itemListScrollPane.setViewportView(itemListTable);

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

				int selectedRowIndex = itemListTable.getSelectedRow();
				int itemId = (int) itemListTable.getModel().getValueAt(selectedRowIndex, 0);

				itemIdTextField.setText(Integer.toString(itemId));
			}
		});
	}
}
