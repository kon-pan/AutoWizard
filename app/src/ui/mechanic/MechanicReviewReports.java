package ui.mechanic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MechanicReviewReports extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MechanicReviewReports frame = new MechanicReviewReports();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MechanicReviewReports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,60, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(32, 11, 101, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(32, 57, 52, 14);
		contentPane.add(lblName);
		
		JLabel lblFullName = new JLabel("Last Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFullName.setBounds(32, 82, 78, 14);
		contentPane.add(lblFullName);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		lblRegistrationNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistrationNumber.setBounds(32, 107, 141, 14);
		contentPane.add(lblRegistrationNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 55, 123, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 80, 123, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 105, 123, 20);
		contentPane.add(textField_2);
		
		JButton btnFind = new JButton("Search");
		btnFind.setBounds(192, 169, 89, 23);
		contentPane.add(btnFind);
		
		List list = new List();
		list.setBounds(32, 229, 254, 306);
		contentPane.add(list);
	}

}
