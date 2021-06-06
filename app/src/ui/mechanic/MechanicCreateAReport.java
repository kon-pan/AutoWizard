package ui.mechanic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.*;
import javax.swing.event.*;

import com.toedter.calendar.JDateChooser;

import javax.swing.JSpinner;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JCheckBoxMenuItem;
import java.awt.*;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;


public class MechanicCreateAReport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Container layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MechanicCreateAReport frame = new MechanicCreateAReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	} 
	
	/**
	 * Create the frame.
	 */
	public MechanicCreateAReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,60, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(25, 11, 52, 14);
		contentPane.add(lblName);
		
		JLabel lblFullName = new JLabel("Last Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFullName.setBounds(25, 33, 80, 14);
		contentPane.add(lblFullName);
		
		textField = new JTextField();
		textField.setBounds(165, 9, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 31, 123, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		lblRegistrationNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistrationNumber.setBounds(25, 56, 141, 14);
		contentPane.add(lblRegistrationNumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 54, 123, 20);
		contentPane.add(textField_2);
		
		JButton btnSumbit = new JButton("Sumbit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnSumbit.setBounds(685, 527, 89, 23);
		contentPane.add(btnSumbit);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(25, 150, 749, 400);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Ready = new JPanel();
		layeredPane.add(Ready, "name_1730188461778841");
		Ready.setLayout(null);
		
		JLabel lblDateOfReceipt = new JLabel("Date of receipt \r\nby the customer");
		lblDateOfReceipt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfReceipt.setBounds(34, 55, 204, 33);
		Ready.add(lblDateOfReceipt);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(261, 55, 142, 33);
		Ready.add(dateChooser_1);
		
		JPanel Under_Repair = new JPanel();
		layeredPane.add(Under_Repair, "name_1730279327655640");
		Under_Repair.setLayout(null);
		
		JLabel lblEstimatedDate = new JLabel("Estimated Date ");
		lblEstimatedDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstimatedDate.setBounds(10, 73, 106, 14);
		Under_Repair.add(lblEstimatedDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(133, 67, 124, 20);
		Under_Repair.add(dateChooser);
		
		JPanel Assessment = new JPanel();
		layeredPane.add(Assessment, "name_1730275578443137");
		Assessment.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 180, 290);
		Assessment.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Air Filter", "Battery", "Brake caliper repair kit", "Brake discs", "Brake fluid", "Brake pads", "Drain plug", "Engine Oil", "Fuel Filter", "Fuse", "Gear oil and Transmission oil", "Glow plugs", "Headlight bulb", "Ignition coil", "Ignition switch", "Indicator bulb", "Inner tie rod", "Oil drain plug gasket", "Oil filter", "Screenwash", "Shock absorber", "Spark plug", "Springs", "Strut mount and bearing", "Tailgate", "Tappet", "Tie rod", "Track rob end", "Wheel bolt and wheel nuts", "Wheel hub", "Wheel nuts", "Windshield washer pump", "Wiper blades"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(318, 63, 192, 284);
		Assessment.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JButton btnAdd = new JButton("Add >");
		btnAdd.setBounds(222, 178, 89, 23);
		Assessment.add(btnAdd);
		
		JButton btnAdd_1 = new JButton("< Remove");
		btnAdd_1.setBounds(222, 212, 89, 23);
		Assessment.add(btnAdd_1);
		
		JLabel lblSparePartsAvailable = new JLabel("Spare Parts Available:\r\n");
		lblSparePartsAvailable.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSparePartsAvailable.setBounds(20, 38, 154, 14);
		Assessment.add(lblSparePartsAvailable);
		
		JButton btnAssessment = new JButton("Assessment");
		btnAssessment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Ready); 
			}
		});
		btnAssessment.setBounds(25, 92, 101, 23);
		contentPane.add(btnAssessment);
		
		JButton btnAssessment_1 = new JButton("Under Repair");
		btnAssessment_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Under_Repair); 
			}
		});
		btnAssessment_1.setMinimumSize(new Dimension(89, 23));
		btnAssessment_1.setMaximumSize(new Dimension(89, 23));
		btnAssessment_1.setBounds(137, 92, 107, 23);
		contentPane.add(btnAssessment_1);
		
		JButton btnAssessment_1_1 = new JButton("Ready");
		btnAssessment_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Assessment); 
			}
		});
		btnAssessment_1_1.setMinimumSize(new Dimension(89, 23));
		btnAssessment_1_1.setMaximumSize(new Dimension(89, 23));
		btnAssessment_1_1.setBounds(254, 92, 107, 23);
		contentPane.add(btnAssessment_1_1);
		
	
	}
		
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
