package ui.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.Employee;
import models.EmployeeList;

import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManagerRemoveMultipleEmployees extends JDialog {
	private JTextField textField;
	private ArrayList<Employee> updatedList;

	/**
	 * Create the dialog.
	 */
	public ManagerRemoveMultipleEmployees() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("AutoWizard (Manager) - Remove multiple employees");
		setBounds(100, 100, 450, 201);
		getContentPane().setLayout(null);
		{
			JTextPane lblNewLabel = new JTextPane();
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBackground(SystemColor.menu);
			lblNewLabel.setEditable(false);
			lblNewLabel.setText("Enter the ID values of the employees you wish to remove below, seperated by comma.");
			lblNewLabel.setBounds(10, 11, 414, 36);
			getContentPane().add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(10, 51, 414, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel errorMessageLabel = new JLabel("New label");
		errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessageLabel.setForeground(new Color(255, 0, 0));
		errorMessageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		errorMessageLabel.setBounds(10, 93, 414, 16);
		errorMessageLabel.setVisible(false);
		getContentPane().add(errorMessageLabel);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorMessageLabel.setVisible(false);
				String textFieldInput = textField.getText();
				// Split input string
				List<String> idList = Arrays.asList(textFieldInput.split(",", -1));
				String confirmMessage = ""; // string that will be sent to confirmation dialog window
				// Trim white spaces from list elements
				for(int i = 0; i < idList.size(); i++) {
					idList.set(i, idList.get(i).trim());
					if(i == idList.size() - 1) {
						confirmMessage += idList.get(i);
						break;
					}
					confirmMessage += idList.get(i) + ", ";
				}
				System.out.println(confirmMessage);
				
				
				
				// Confirmation dialog
				boolean confirm = false;
				try {
					ManagerConfirmRemove dialog = new ManagerConfirmRemove(confirmMessage);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					confirm = dialog.getRemoveConfirmation();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println(confirm);
				
				
				if(confirm == true) {
					// Check if IDs to be removed exist
					for(int i = 0; i < idList.size(); i++) {
						String id = idList.get(i);
						EmployeeList el = new EmployeeList();
						Employee employee = el.getEmployeeById(Integer.parseInt(id));
						
						if(employee == null) { // employee does not exist
							System.out.println("Employee with ID of " + id + " could not be found.");
							errorMessageLabel.setVisible(true);
							errorMessageLabel.setText("Employee with ID of " + id + " could not be found.");
							break;
						}
						
						 setUpdatedList(el.removeEmployee(Integer.parseInt(id)));
					}
					
					// Close the dialog window
					Component component = (Component) e.getSource();
			        JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
			        dialog.setVisible(false);
				}				
			}

			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(335, 121, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(234, 121, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
	}
	
	private void setUpdatedList(ArrayList<Employee> updatedList) {
		this.updatedList = updatedList;
	}
	
	public ArrayList<Employee> getUpdatedList() {
		return this.updatedList;
	}

}
