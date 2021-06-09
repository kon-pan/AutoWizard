package ui.sales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import models.Customer;
import models.CustomerList;
import models.Employee;
import models.EmployeeList;
import models.Item;
import models.ItemList;
import models.Sale;
import models.SalesHistory;
import ui.Login;
import ui.manager.ManagerRegisterNewEmployee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
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
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JDateChooser;

public class SalesMainMenu extends JFrame {

	private JPanel contentPane;
	private  JLayeredPane layeredPane;
	private JPanel stock;
	private JPanel history;
	private JPanel newSale;
	private  JPanel customerSupport;
	private JTextField historySearchQueryTextField;
	private JTextField customerNameTextField;
	private JTextField soldItemNameTextField;
	private JTextField salespersonNameTextField;
	private JTextField priceOfSaleTextField;
	public static JTable itemsList;
	public static JTable salesHistory;
	public static JTable customerList;
	private JTextField stockSearchQueryTextField;
	
	public String paymentPlan = "Total Sum";
	public static DefaultTableModel tableModel;
	public static DefaultTableModel tableModelHistory;
	public static DefaultTableModel tableModelCustomerSupport;
	public static ItemList il;
	public static JScrollPane itemsListPanel;
	public static JScrollPane salesHistoryPanel;
	public static JScrollPane customerSupportPanel;
	
	private JTextField saleIdTextField;
	private JTextField customerSupportSearchTextField;
	
	
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
		
		JButton salesMenuLogoutButton = new JButton("Log Out");
		salesMenuLogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
				
				currentFrame.setVisible(false);
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
			}
		});
		menuBar.add(salesMenuLogoutButton);
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
		lblNewLabel_2.setBounds(10, 11, 121, 29);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		saleIdTextField = new JTextField();
		saleIdTextField.setBounds(10, 93, 215, 20);
		saleIdTextField.setEnabled(false);
		saleIdTextField.setColumns(10);
		ArrayList<Sale> sales = sh.getAllSales();
		saleIdTextField.setText(Integer.toString(sh.generateId(sales)));
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(10, 121, 215, 20);
		customerNameTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sale Details");
		lblNewLabel_5.setBounds(10, 67, 107, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		soldItemNameTextField = new JTextField();
		soldItemNameTextField.setBounds(10, 175, 215, 20);
		soldItemNameTextField.setColumns(10);
		
		salespersonNameTextField = new JTextField();
		salespersonNameTextField.setBounds(10, 239, 215, 20);
		salespersonNameTextField.setColumns(10);
		
		priceOfSaleTextField = new JTextField();
		priceOfSaleTextField.setBounds(10, 277, 215, 20);
		priceOfSaleTextField.setColumns(10);
		
		JDateChooser newSaleDateChooser = new JDateChooser();
		newSaleDateChooser.setBounds(10, 149, 215, 20);
		
		JButton submitSaleButton = new JButton("Submit");
		submitSaleButton.setBounds(810, 412, 90, 37);
		submitSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int saleId = Integer.parseInt(saleIdTextField.getText());
				String customerName = customerNameTextField.getText();
				String dateOfSale = newSaleDateChooser.getDate().toString();
				String soldItemName = soldItemNameTextField.getText();
				String salepersonName = salespersonNameTextField.getText();
				int priceOfSale = Integer.parseInt(priceOfSaleTextField.getText());
				
				SalesHistory sh = new SalesHistory();
				Sale sale = new Sale(saleId, customerName, dateOfSale, soldItemName, salepersonName, priceOfSale, paymentPlan);
				ArrayList<Sale> sales = sh.registerSale(sale);
				
				tableModelHistory.setRowCount(0);
				tableModelHistory = sh.createSalesList(sales);
				
				salesHistory = new JTable(tableModelHistory){
					public boolean isCellEditable(int row, int column){
				        return false;
				   }
				};
				salesHistoryPanel.setViewportView(salesHistory);
				switchTabs(history);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(235, 93, 19, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Customer Name");
		lblNewLabel_6.setBounds(235, 121, 130, 20);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_7 = new JLabel("Date of Sale");
		lblNewLabel_7.setBounds(235, 149, 100, 20);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_8 = new JLabel("Item Id");
		lblNewLabel_8.setBounds(235, 175, 91, 20);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_9 = new JLabel("Salesperson");
		lblNewLabel_9.setBounds(234, 239, 98, 20);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		lblNewLabel_10.setBounds(234, 277, 41, 20);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_13 = new JLabel("Payment Plan");
		lblNewLabel_13.setBounds(234, 303, 113, 20);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 305, 215, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentPlan = ((JComboBox) e.getSource()).getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Total Sum", "Recurring"}));
		newSale.setLayout(null);
		newSale.add(lblNewLabel_2);
		newSale.add(lblNewLabel_5);
		newSale.add(newSaleDateChooser);
		newSale.add(comboBox);
		newSale.add(saleIdTextField);
		newSale.add(customerNameTextField);
		newSale.add(soldItemNameTextField);
		newSale.add(salespersonNameTextField);
		newSale.add(priceOfSaleTextField);
		newSale.add(lblNewLabel_4);
		newSale.add(lblNewLabel_6);
		newSale.add(lblNewLabel_7);
		newSale.add(lblNewLabel_8);
		newSale.add(lblNewLabel_9);
		newSale.add(lblNewLabel_10);
		newSale.add(lblNewLabel_13);
		newSale.add(submitSaleButton);
		
		JButton newSaleItemDetailsButton = new JButton("Fetch Item Details");
		newSaleItemDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemId = Integer.parseInt(soldItemNameTextField.getText());
				Item item = il.getItemById(itemId);
				
				String newItemId = Integer.toString(item.getItemId());
				String itemPrice = Integer.toString(item.getItemPrice());
				String itemName = item.getItemName();
				String itemType = item.getItemType();
				
				String[] row = {newItemId, itemPrice, itemName, itemType};
				
				System.out.println(row);
			}
		});
		newSaleItemDetailsButton.setBounds(10, 205, 147, 23);
		newSale.add(newSaleItemDetailsButton);
		
		
		//***********************************
		//Customer Support
		//***********************************
		customerSupport = new JPanel();
		layeredPane.add(customerSupport, "name_1120344336413000");
		customerSupport.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Support");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_3.setBounds(10, 11, 223, 35);
		customerSupport.add(lblNewLabel_3);
		
		customerSupportSearchTextField = new JTextField();
		customerSupportSearchTextField.setBounds(10, 85, 223, 20);
		customerSupport.add(customerSupportSearchTextField);
		customerSupportSearchTextField.setColumns(10);
		
		
		JLabel lblNewLabel_14 = new JLabel("Search Customers");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(10, 60, 152, 14);
		customerSupport.add(lblNewLabel_14);
		
		customerSupportPanel = new JScrollPane();
		customerSupportPanel.setBounds(10, 116, 890, 333);
		customerSupport.add(customerSupportPanel);
		
		CustomerList cl = new CustomerList();
		tableModelCustomerSupport = cl.createCustomersList();
		
		customerList = new JTable(tableModelCustomerSupport){
			public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		customerSupportPanel.setViewportView(customerList);
		
		customerList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // If a row is double-clicked
            	int customerId = 0;
                if (e.getClickCount() == 2) {
                    int selectedRowIndex = customerList.getSelectedRow();
                    customerId = (int) customerList.getModel().getValueAt(selectedRowIndex, 0);
                    try {
    					EditCustomerInfoDialog dialog = new EditCustomerInfoDialog(customerId);
    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    					dialog.setVisible(true);
    				} catch (Exception e1) {
    					e1.printStackTrace();
    				}
                    System.out.println(customerId); 
                }
            }
        });
		customerSupportPanel.setViewportView(customerList);
		
		JButton customerSupportRegisterNewCustomerButton = new JButton("Register New Customer");
		customerSupportRegisterNewCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                	RegisterNewCustomerDialog dialog = new RegisterNewCustomerDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		customerSupportRegisterNewCustomerButton.setBounds(748, 60, 152, 45);
		customerSupport.add(customerSupportRegisterNewCustomerButton);
		
		JButton customerSupportSearchButton = new JButton("Search");
		customerSupportSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String searchQuery = customerSupportSearchTextField.getText();
					ArrayList<Customer> searchResults = CustomerList.searchCustomer(searchQuery);
					
					System.out.println(searchResults);
					
					if (!searchQuery.equals("")) {
						// Clear JTable values
						tableModelCustomerSupport.setRowCount(0);
						
						CustomerList cl = new CustomerList();
						DefaultTableModel tableModel = cl.createCustomersList(searchResults);

						JTable searchResultsList = new JTable(tableModel) {
							public boolean isCellEditable(int row, int column){
						        return false;
						   }
						};
						searchResultsList.addMouseListener(new MouseAdapter() {
				            @Override
				            public void mouseClicked(MouseEvent e) {
				                // If a row is double-clicked
				            	int customerId = 0;
				                if (e.getClickCount() == 2) {
				                    int selectedRowIndex = searchResultsList.getSelectedRow();
				                    customerId = (int) searchResultsList.getModel().getValueAt(selectedRowIndex, 0);
				                    try {
				                    	EditCustomerInfoDialog dialog = new EditCustomerInfoDialog(customerId);
				    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				    					dialog.setVisible(true);
				    				} catch (Exception e1) {
				    					e1.printStackTrace();
				    				}
				                    System.out.println(customerId); 
				                }
				            }
				        });
						customerSupportPanel.setViewportView(searchResultsList);		
					}else {
						CustomerList cl = new CustomerList();
						DefaultTableModel tableModel = cl.createCustomersList();
						
						customerList = new JTable(tableModel) {
							public boolean isCellEditable(int row, int column){
						        return false;
						   }
						};
						customerList.addMouseListener(new MouseAdapter() {
				            @Override
				            public void mouseClicked(MouseEvent e) {
				                // If a row is double-clicked
				            	int customerId = 0;
				                if (e.getClickCount() == 2) {
				                    int selectedRowIndex = customerList.getSelectedRow();
				                    customerId = (int) customerList.getModel().getValueAt(selectedRowIndex, 0);
				                    try {
				                    	EditCustomerInfoDialog dialog = new EditCustomerInfoDialog(customerId);
				    					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				    					dialog.setVisible(true);
				    				} catch (Exception e1) {
				    					e1.printStackTrace();
				    				}
				                    System.out.println(customerId); 
				                }
				            }
				        });
						customerSupportPanel.setViewportView(customerList);
					}
			}
		});
		customerSupportSearchButton.setBounds(243, 85, 89, 20);
		customerSupport.add(customerSupportSearchButton);
		contentPane.setLayout(gl_contentPane);
		
		/*
		 * Button handlers for switching between tabs
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
