package ui.sales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import models.Employee;
import models.EmployeeList;
import models.Item;
import models.ItemList;
import models.Sale;
import models.SalesHistory;
import ui.manager.ManagerRegisterNewEmployee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SalesMainMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel stock;
	private JPanel history;
	private JPanel newSale;
	private JPanel customerSupport;
	private JTextField historySearchQueryTextField;
	private JTextField customerNameField;
	private JTextField dateOfSaleField;
	private JTextField itemNameField;
	private JTextField salespersonNameField;
	private JTextField itemPriceField;
	private JTextField paymentPlanField;
	public static JTable itemsList;
	public static JTable salesHistory;
	private JTextField stockSearchQueryTextField;
	
	public static DefaultTableModel tableModel;
	public static DefaultTableModel tableModelHistory;
	public static ItemList il;
	public static JScrollPane itemsListPanel;
	public static JScrollPane salesHistoryPanel;
	
	
	public void switchTabs(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
	/**
	 * Create the frame.
	 */
	public SalesMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 556);
		
		/*
		 * Create menu bar and buttons
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton stockButton = new JButton("Stock");
		menuBar.add(stockButton);
		
		JButton historyButton = new JButton("History");
		menuBar.add(historyButton);
		
		JButton newSaleButton = new JButton("New Sale");
		menuBar.add(newSaleButton);
		
		JButton customerSupportButton = new JButton("Customer Support");
		menuBar.add(customerSupportButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/*
		 * Create layered pane and panels for each button
		 */
		layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addContainerGap())
		);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		
		
		
		
		//*************************************
		//Stock tab
		//*************************************
		stock = new JPanel();
		layeredPane.add(stock, "name_1120213382907199");
		stock.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setBounds(10, 11, 133, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		stock.add(lblNewLabel);
		
		itemsListPanel = new JScrollPane();
		itemsListPanel.setBounds(10, 109, 890, 340);
		stock.add(itemsListPanel);
		
		//**************************************
		//Create item list for Stock tab
		//**************************************
		ItemList il = new ItemList();
		tableModel = il.createItemsList();
		
		itemsList = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		
		itemsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // If a row is double-clicked
            	int itemId = 0;
                if (e.getClickCount() == 2) {
                    int selectedRowIndex = itemsList.getSelectedRow();
                    itemId = (int) itemsList.getModel().getValueAt(selectedRowIndex, 0);
                    try {
    					EditItemDialog dialog = new EditItemDialog(itemId);
    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    					dialog.setVisible(true);
    				} catch (Exception e1) {
    					e1.printStackTrace();
    				}
                    System.out.println(itemId); 
                }
            }
        });
		itemsListPanel.setViewportView(itemsList);
		
		stockSearchQueryTextField = new JTextField();
		stockSearchQueryTextField.setBounds(10, 78, 214, 20);
		stock.add(stockSearchQueryTextField);
		stockSearchQueryTextField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Search Inventory");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(10, 53, 148, 14);
		stock.add(lblNewLabel_11);
		
		JButton stockSearchButton = new JButton("Search");
		stockSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchQuery = stockSearchQueryTextField.getText();
				ArrayList<Item> searchResults = ItemList.searchItem(searchQuery);
				
				System.out.println(searchResults);
				
				if (!searchQuery.equals("")) {
					// Clear JTable values
					tableModel.setRowCount(0);
					
					ItemList il = new ItemList();
					DefaultTableModel tableModel = il.createItemsList(searchResults);

					JTable searchResultsList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
					
					searchResultsList.addMouseListener(new MouseAdapter() {
			            @Override
			            public void mouseClicked(MouseEvent e) {
			                // If a row is double-clicked
			            	int itemId = 0;
			                if (e.getClickCount() == 2) {
			                    int selectedRowIndex = searchResultsList.getSelectedRow();
			                    itemId = (int) searchResultsList.getModel().getValueAt(selectedRowIndex, 0);
			                    try {
			    					EditItemDialog dialog = new EditItemDialog(itemId);
			    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			    					dialog.setVisible(true);
			    				} catch (Exception e1) {
			    					e1.printStackTrace();
			    				}
			                    System.out.println(itemId); 
			                }
			            }
			        });
				itemsListPanel.setViewportView(searchResultsList);		
				}else {
					ItemList il = new ItemList();
					DefaultTableModel tableModel = il.createItemsList();
					
					itemsList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
					
					itemsList.addMouseListener(new MouseAdapter() {
			            @Override
			            public void mouseClicked(MouseEvent e) {
			                // If a row is double-clicked
			            	int itemId = 0;
			                if (e.getClickCount() == 2) {
			                    int selectedRowIndex = itemsList.getSelectedRow();
			                    itemId = (int) itemsList.getModel().getValueAt(selectedRowIndex, 0);
			                    try {
			    					EditItemDialog dialog = new EditItemDialog(itemId);
			    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			    					dialog.setVisible(true);
			    				} catch (Exception e1) {
			    					e1.printStackTrace();
			    				}
			                    System.out.println(itemId); 
			                }
			            }
			        });
				itemsListPanel.setViewportView(itemsList);
				}
			}
		});
		stockSearchButton.setBounds(234, 77, 89, 21);
		stock.add(stockSearchButton);
		
		
		
		
		
		
		
		
		
		
		
		//***********************************
		//History tab
		//***********************************
		history = new JPanel();
		layeredPane.add(history, "name_1120340773498000");
		
		JLabel lblNewLabel_1 = new JLabel("History");
		lblNewLabel_1.setBounds(10, 11, 98, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		history.add(lblNewLabel_1);
		
		salesHistoryPanel = new JScrollPane();
		salesHistoryPanel.setBounds(10, 119, 890, 330);
		history.add(salesHistoryPanel);
		
		//**********************************
		//Create Sales History List
		//**********************************
		
		SalesHistory sh = new SalesHistory();
		tableModelHistory = sh.createSalesList();
		
		salesHistory = new JTable(tableModelHistory){
			public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		salesHistoryPanel.setViewportView(salesHistory);
		
		
		JLabel lblNewLabel_12 = new JLabel("Search Sales History");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(10, 55, 205, 21);
		history.add(lblNewLabel_12);
		
		historySearchQueryTextField = new JTextField();
		historySearchQueryTextField.setBounds(10, 87, 267, 21);
		history.add(historySearchQueryTextField);
		historySearchQueryTextField.setColumns(10);
		
		JButton historySearchButton = new JButton("Search");
		historySearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				String searchQuery = historySearchQueryTextField.getText();
				ArrayList<Sale> searchResults = SalesHistory.searchSale(searchQuery);
				
				System.out.println(searchResults);
				
				if (!searchQuery.equals("")) {
					// Clear JTable values
					tableModelHistory.setRowCount(0);
					
					SalesHistory sh = new SalesHistory();
					DefaultTableModel tableModel = sh.createSalesList(searchResults);

					JTable searchResultsList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
				salesHistoryPanel.setViewportView(searchResultsList);		
				}else {
					SalesHistory sh = new SalesHistory();
					DefaultTableModel tableModel = sh.createSalesList();
					
					salesHistory = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
				salesHistoryPanel.setViewportView(salesHistory);
				}
			}
		});
		historySearchButton.setBounds(287, 87, 98, 21);
		history.setLayout(null);
		history.add(historySearchButton);
		
		
		
		
		
		//**************************
		//New Sale
		//**************************
		
		newSale = new JPanel();
		layeredPane.add(newSale, "name_1120342745378900");
		
		JLabel lblNewLabel_2 = new JLabel("NewSale");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		customerNameField = new JTextField();
		customerNameField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Name");
		
		JLabel lblNewLabel_5 = new JLabel("Sale Details");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		dateOfSaleField = new JTextField();
		dateOfSaleField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date of Sale");
		
		itemNameField = new JTextField();
		itemNameField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Item Name");
		
		salespersonNameField = new JTextField();
		salespersonNameField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Salesperson");
		
		itemPriceField = new JTextField();
		itemPriceField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Price");
		
		paymentPlanField = new JTextField();
		paymentPlanField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Payment plan");
		
		JButton submitSaleButton = new JButton("Submit");
		GroupLayout gl_newSale = new GroupLayout(newSale);
		gl_newSale.setHorizontalGroup(
			gl_newSale.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_newSale.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_newSale.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4))
						.addComponent(lblNewLabel_5)
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(dateOfSaleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6))
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(itemNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(salespersonNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_8))
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(itemPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_9))
						.addGroup(gl_newSale.createSequentialGroup()
							.addComponent(paymentPlanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_10)))
					.addContainerGap(734, Short.MAX_VALUE))
				.addGroup(gl_newSale.createSequentialGroup()
					.addContainerGap(810, Short.MAX_VALUE)
					.addComponent(submitSaleButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_newSale.setVerticalGroup(
			gl_newSale.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_newSale.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(9)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateOfSaleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(salespersonNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addGap(18)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_newSale.createParallelGroup(Alignment.BASELINE)
						.addComponent(paymentPlanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10))
					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
					.addComponent(submitSaleButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		newSale.setLayout(gl_newSale);
		
		customerSupport = new JPanel();
		layeredPane.add(customerSupport, "name_1120344336413000");
		
		JLabel lblNewLabel_3 = new JLabel("testCustomerSupport");
		GroupLayout gl_customerSupport = new GroupLayout(customerSupport);
		gl_customerSupport.setHorizontalGroup(
			gl_customerSupport.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customerSupport.createSequentialGroup()
					.addGap(200)
					.addComponent(lblNewLabel_3)
					.addContainerGap(248, Short.MAX_VALUE))
		);
		gl_customerSupport.setVerticalGroup(
			gl_customerSupport.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customerSupport.createSequentialGroup()
					.addGap(137)
					.addComponent(lblNewLabel_3)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		customerSupport.setLayout(gl_customerSupport);
		contentPane.setLayout(gl_contentPane);
		
		/*
		 * Button handlers for switching between panels
		 */
		stockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTabs(stock);
			}
		});
		
		historyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTabs(history);
			}
		});
		
		newSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTabs(newSale);
			}	
		});
		
		customerSupportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTabs(customerSupport);
			}
		});
	}
}
