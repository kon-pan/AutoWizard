/**
 * This class creates the login screen screen user interface.
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import models.Employee;
import models.EmployeeList;
import ui.manager.ManagerMainMenu;
import ui.mechanic.MechanicMainMenu;
import ui.sales.SalesMainMenu;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 625, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		contentPane.add(panel1, BorderLayout.NORTH);

		JLabel lbl1 = new JLabel("Enter your login credentials");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel1.add(lbl1);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2, BorderLayout.CENTER);

		JLabel lbl2 = new JLabel("E-mail");
		lbl2.setBounds(148, 222, 36, 15);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 12));

		emailTextField = new JTextField();
		emailTextField.setBounds(206, 220, 237, 20);
		emailTextField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(206, 264, 237, 20);
		passwordTextField.setColumns(10);

		JLabel lbl3 = new JLabel("Password");
		lbl3.setBounds(112, 266, 72, 15);
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel errorMsgLabel = new JLabel("Employee with the following email address does not exist:");
		errorMsgLabel.setBounds(46, 319, 397, 79);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		errorMsgLabel.setVisible(false);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(448, 298, 70, 31);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailTextField.getText();
				// Get employee record using email provided by the user
				EmployeeList el = new EmployeeList();
				Employee employee = el.getEmployeeByEmail(email);

				if (employee != null ) { // Employee record found
					// Compare password input with registered password
					String inputPassword = new String(passwordTextField.getPassword());
					String registeredPassword = employee.getPassword();

					System.out.println(inputPassword);
					System.out.println(registeredPassword);

					if (inputPassword.equals(registeredPassword)) {
						System.out.println("Passwords match!");
						// Check employee position
						String department = employee.getDepartment();
						System.out.println(department);

						Component component = (Component) e.getSource();
						JFrame currentFrame = (JFrame) SwingUtilities.getRoot(component);
						switch (department) {
						case "Manager":
							// Render Manager main window
							System.out.println(department);

							// Close current window
							currentFrame.setVisible(false);

							ManagerMainMenu managerFrame = new ManagerMainMenu();
							managerFrame.setVisible(true);

							break;
						case "Sales":
							// Render Sales main window
							System.out.println(department);

							// Close current window
							currentFrame.setVisible(false);

							SalesMainMenu salesFrame = new SalesMainMenu();
							salesFrame.setVisible(true);

							break;
						case "Mechanic":
							// Render Repairs main window
							System.out.println(department);
							
							// Close current window
							currentFrame.setVisible(false);

							try {
								MechanicMainMenu frame = new MechanicMainMenu();
								frame.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
							break;
						default:
							// code block
						}
					}
				} else { // Email does not exist
					System.out.println("Employee with the following email address does not exist:\n" + email);
					errorMsgLabel.setText("<html>" + errorMsgLabel.getText() + "<br>" + email + "</html>");
					errorMsgLabel.setVisible(true);
				}
			}
		});

		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel2.setLayout(null);
		panel2.add(errorMsgLabel);
		panel2.add(lbl3);
		panel2.add(lbl2);
		panel2.add(passwordTextField);
		panel2.add(emailTextField);
		panel2.add(loginBtn);
		
		lbl1 = new JLabel("");

		Image img = new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
		lbl1.setIcon(new ImageIcon(img));

		lbl1.setBounds(148, 11, 328, 200);
		panel2.add(lbl1);
	}
}
