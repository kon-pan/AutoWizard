package ui.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class ManagerAddNewItem extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the dialog.
	 */
	public ManagerAddNewItem() {
		setAlwaysOnTop(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("AutoWizard (Manager) - Add new item");
		setBounds(100, 100, 657, 475);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new item");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 131, 14);
		getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 621, 354);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add vehicle", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add vehicle");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(500, 292, 106, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 58, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(78, 9, 222, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Brand");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 38, 58, 14);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 36, 222, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Model");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 65, 58, 14);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 63, 222, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Year");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 119, 58, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(78, 117, 222, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Type");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(10, 92, 58, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sedan", "Hatchback", "Coupe"}));
		comboBox.setBounds(78, 89, 222, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 146, 58, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(78, 144, 222, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 173, 58, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(78, 171, 222, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2 = new JLabel("<html><b>Description</b> (optional)</html>");
		lblNewLabel_2.setBounds(310, 12, 134, 14);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 29, 296, 249);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Condition");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 198, 68, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New");
		rdbtnNewRadioButton.setBounds(78, 195, 58, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnUsed = new JRadioButton("Used");
		rdbtnUsed.setBounds(138, 195, 58, 23);
		panel.add(rdbtnUsed);
		
		// Create radio button group
		ButtonGroup condition = new ButtonGroup();
		condition.add(rdbtnNewRadioButton);
		condition.add(rdbtnUsed);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add vehicle part", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Add vehicle part");
		btnNewButton_2.setBounds(468, 292, 138, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Title");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 11, 58, 14);
		panel_1.add(lblNewLabel_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(78, 11, 222, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(78, 36, 222, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Price");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(10, 36, 58, 14);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(78, 61, 222, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Quantity");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1_1.setBounds(10, 61, 58, 14);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("<html><b>Description</b> (optional)</html>");
		lblNewLabel_2_1.setBounds(310, 11, 134, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(310, 28, 296, 249);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Category");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1_1_1.setBounds(10, 114, 58, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select category...", "Engine", "Tire", "Brake", "Battery"}));
		comboBox_1.setBounds(78, 111, 222, 23);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1_1_2.setBounds(10, 86, 58, 14);
		panel_1.add(lblNewLabel_1_2_1_1_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New");
		rdbtnNewRadioButton_1.setBounds(78, 83, 58, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Used");
		rdbtnNewRadioButton_1_1.setBounds(138, 83, 58, 23);
		panel_1.add(rdbtnNewRadioButton_1_1);
		
		
		JPanel vehiclePartDetailsPanel = new JPanel();
		vehiclePartDetailsPanel.setBounds(10, 145, 290, 170);
		panel_1.add(vehiclePartDetailsPanel);
		CardLayout cardLayout = new CardLayout(0, 0);
		vehiclePartDetailsPanel.setLayout(cardLayout);
		vehiclePartDetailsPanel.setVisible(false); // default = invisible
		
		// Panel border styling
		TitledBorder border = new TitledBorder(null, "Engine details", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel engineFormPanel = new JPanel();
		engineFormPanel.setBorder(border);
		vehiclePartDetailsPanel.add(engineFormPanel, "Engine");
		
		// Panel border styling
		border = new TitledBorder(null, "Tire details", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel tireFormPanel = new JPanel();
		tireFormPanel.setBorder(border);
		vehiclePartDetailsPanel.add(tireFormPanel, "Tire");
		
		// Panel border styling
		border = new TitledBorder(null, "Brake details", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel brakeFormPanel = new JPanel();
		brakeFormPanel.setBorder(border);
		vehiclePartDetailsPanel.add(brakeFormPanel, "Brake");
		
		// Panel border styling
		border = new TitledBorder(null, "Battery details", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel batteryFormPanel = new JPanel();
		batteryFormPanel.setBorder(border);
		vehiclePartDetailsPanel.add(batteryFormPanel, "Battery");
		
		// Vehicle part category dropdown action listener
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vehiclePartCategory = ((JComboBox) e.getSource()).getSelectedItem().toString();
				System.out.println(vehiclePartCategory);
				
				switch (vehiclePartCategory) {
				case "Engine": {
					vehiclePartDetailsPanel.setVisible(true);
					cardLayout.show(vehiclePartDetailsPanel, "Engine");
					break;
				}
				case "Tire": {
					vehiclePartDetailsPanel.setVisible(true);
					cardLayout.show(vehiclePartDetailsPanel, "Tire");
					break;

				}
				case "Brake": {
					vehiclePartDetailsPanel.setVisible(true);
					cardLayout.show(vehiclePartDetailsPanel, "Brake");
					break;

				}
				case "Battery": {
					vehiclePartDetailsPanel.setVisible(true);
					cardLayout.show(vehiclePartDetailsPanel, "Battery");
					break;

				}
				default:
					vehiclePartDetailsPanel.setVisible(false);
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add accessory", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Add accessory");
		btnNewButton_3.setBounds(461, 292, 145, 23);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Main menu");
		btnNewButton.setBounds(10, 402, 131, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(532, 9, 99, 23);
		getContentPane().add(btnLogOut);
	}
}
