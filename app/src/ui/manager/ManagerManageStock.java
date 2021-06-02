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

public class ManagerManageStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable itemListTable;
	public static DefaultTableModel tableModel;
	private JTextField itemIdTextField;

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
		lblNewLabel.setBounds(10, 11, 224, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setBounds(10, 452, 89, 23);
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
		
		JButton btnNewButton_1 = new JButton("Add new item");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(515, 452, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 145, 284, 296);
		contentPane.add(layeredPane);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(0, 0, 284, 296);
		layeredPane.add(messagePanel);
		messagePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("<html>Click an item from the list on the right to edit or remove it.</html>");
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
		lblNewLabel_4.setBounds(10, 36, 46, 14);
		editItemPanel.add(lblNewLabel_4);
		
		itemIdTextField = new JTextField();
		itemIdTextField.setEditable(false);
		itemIdTextField.setBounds(66, 33, 208, 20);
		editItemPanel.add(itemIdTextField);
		itemIdTextField.setColumns(10);
		
		// Create items list
				ItemList il = new ItemList();
				tableModel = il.createItemsList();
				
				itemListTable = new JTable(tableModel){
					public boolean isCellEditable(int row, int column){
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
