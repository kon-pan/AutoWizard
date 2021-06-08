package ui.manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerConfirmRemove extends JDialog {
	
	private boolean confirm;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ManagerConfirmRemove dialog = new ManagerConfirmRemove();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param employeeId 
	 */
	public ManagerConfirmRemove(String employeeId) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 129);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to remove employee with ID " + employeeId + "?");
		lblNewLabel.setBounds(10, 11, 414, 35);
		getContentPane().add(lblNewLabel);
		
		JButton confirmButton = new JButton("Yes, remove.");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setRemoveConfirmation(true);
				Component component = (Component) e.getSource();
		        JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
		        dialog.dispose();
			}
		});
		confirmButton.setBounds(291, 57, 133, 23);
		getContentPane().add(confirmButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(192, 57, 89, 23);
		getContentPane().add(btnNewButton_1);
	}
	
	public void setRemoveConfirmation(boolean value) {
		this.confirm = value;
	}

	public boolean getRemoveConfirmation() {
		return this.confirm;
	}
}
