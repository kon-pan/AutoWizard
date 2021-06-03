package ui.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalityType;

public class ManagerAddNewItem extends JDialog {

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ManagerAddNewItem dialog = new ManagerAddNewItem();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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
		btnNewButton_1.setBounds(500, 292, 106, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add vehicle part", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Add vehicle part");
		btnNewButton_2.setBounds(468, 292, 138, 23);
		panel_1.add(btnNewButton_2);
		
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
