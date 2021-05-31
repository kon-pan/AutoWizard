package ui.sales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import models.Employee;
import models.EmployeeList;
import models.Item;
import models.ItemList;
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
	private JTextField searchBarHistory;
	private JTable table_1;
	private JTextField customerNameField;
	private JTextField dateOfSaleField;
	private JTextField itemNameField;
	private JTextField salespersonNameField;
	private JTextField itemPriceField;
	private JTextField paymentPlanField;
	public static JTable itemsList;
	private JTextField stockSearchQueryTextField;
	
	public static DefaultTableModel tableModel;
	public static ItemList il;
	public static JScrollPane itemsListPanel;
	
	
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
				itemsListPanel.setViewportView(searchResultsList);		
				}else {
					ItemList il = new ItemList();
					DefaultTableModel tableModel = il.createItemsList();
					
					itemsList = new JTable(tableModel) {
						public boolean isCellEditable(int row, int column){
					        return false;
					   }
					};
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		searchBarHistory = new JTextField();
		searchBarHistory.setColumns(10);
		
		JButton searchButtonHistory = new JButton("Search");
		
		table_1 = new JTable();
		
		JTextArea textArea_1 = new JTextArea();
		GroupLayout gl_history = new GroupLayout(history);
		gl_history.setHorizontalGroup(
			gl_history.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_history.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_history.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_history.createSequentialGroup()
							.addGroup(gl_history.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_history.createSequentialGroup()
									.addComponent(searchBarHistory, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchButtonHistory))
								.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_history.setVerticalGroup(
			gl_history.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_history.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_history.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addGroup(gl_history.createSequentialGroup()
							.addGroup(gl_history.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchBarHistory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButtonHistory))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		history.setLayout(gl_history);
		
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
			gl_newSale.createParallelGroup(Alignment.LEADING)
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
					.addContainerGap(318, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_newSale.createSequentialGroup()
					.addContainerGap(395, Short.MAX_VALUE)
					.addComponent(submitSaleButton)
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
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(submitSaleButton)
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
