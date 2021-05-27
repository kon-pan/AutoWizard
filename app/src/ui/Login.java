/**
 * This class creates the login screen screen user interface.
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import models.EmployeeList;
import ui.manager.ManagerMainMenu;
import ui.sales.SalesMainMenu;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.NORTH);
		
		JLabel lbl1 = new JLabel("Enter your login credentials");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel1.add(lbl1);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.CENTER);
		
		JLabel lbl2 = new JLabel("E-mail");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel lbl3 = new JLabel("Password");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailTextField.getText();
				// Get employee record using email provided by the user
				EmployeeList el = new EmployeeList();
				List<Object> employee = el.getEmployeeByEmail(email);
				
				if (employee.size() > 0) { // Employee record found
					// Compare password input with registered password
					String inputPassword = new String(passwordTextField.getPassword());
					String registeredPassword = (String) employee.get(4);
					
					System.out.println(inputPassword);
					System.out.println(registeredPassword);
					
					if (inputPassword.equals(registeredPassword)) {
						System.out.println("Passwords match!");
						// Check employee position
						String position = (String) employee.get(5);
						
						Component component = (Component) e.getSource();
						JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
						switch (position) {
						case "Manager":
							// Render Manager main window
							System.out.println(position);
							
							// Close current window
					        currentFrame.setVisible(false);
					        
					        ManagerMainMenu managerFrame = new ManagerMainMenu();
					        managerFrame.setVisible(true);
					        
							break;
						case "Sales":
							// Render Sales main window
							System.out.println(position);
							
							// Close current window
					        currentFrame.setVisible(false);
					       
					        SalesMainMenu salesFrame = new SalesMainMenu();
					        salesFrame.setVisible(true);
					        
							break;
						case "Mechanic":
							// Render Repairs main window
							System.out.println(position);
							break;
						default:
							// code block
						}
					}
				} else {
					System.out.println("Employee with the following email address does not exist:\n" + email);
				}
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addContainerGap()
							.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl2, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl2))
					.addGap(18)
					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
	}
}
