/**
 * This class creates the main menu screen for the manager.
 */
package ui.manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ManagerMainMenu() {
		setTitle("AutoWizard (Manager) - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome back, <Manager Name>");
		lblNewLabel.setBounds(10, 11, 634, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JButton btnManageEmployees = new JButton("Manage Employees");
		btnManageEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Component component = (Component) e.getSource();
					JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
					currentFrame.setVisible(false);
					ManagerManageEmployees frame = new ManagerManageEmployees();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManageEmployees.setBounds(10, 61, 160, 120);
		contentPane.add(btnManageEmployees);
		
		JButton btnManageStock = new JButton("Manage Stock");
		btnManageStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Component component = (Component) e.getSource();
					JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
					currentFrame.setVisible(false);
					ManagerManageStock frame = new ManagerManageStock();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManageStock.setBounds(10, 192, 160, 120);
		contentPane.add(btnManageStock);
		
		JButton btnReviewReports = new JButton("Review Reports");
		btnReviewReports.setBounds(484, 61, 160, 120);
		contentPane.add(btnReviewReports);
		
		JButton btnNewButton_1_1 = new JButton("Review Orders");
		btnNewButton_1_1.setBounds(484, 192, 160, 120);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnManageSuppliers = new JButton("Manage Suppliers");
		btnManageSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Component component = (Component) e.getSource();
					JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
					currentFrame.setVisible(false);
					ManagerManageSuppliers frame = new ManagerManageSuppliers();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManageSuppliers.setBounds(180, 61, 160, 120);
		contentPane.add(btnManageSuppliers);
	}
}
