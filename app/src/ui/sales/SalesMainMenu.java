package ui.sales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class SalesMainMenu extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public SalesMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Stock");
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("History");
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Sale");
		menuBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Customer Support");
		menuBar.add(btnNewButton_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 517, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 351, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
