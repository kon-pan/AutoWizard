package ui.mechanic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MechanicMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MechanicMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnCreateAReport = new JMenu("Create a Report");
		mnCreateAReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MechanicCreateAReport frame = new MechanicCreateAReport();
				frame.setVisible(true);
			}
		});
		menuBar.add(mnCreateAReport);
		
		JMenu mnAssessment = new JMenu("Assessment");
		mnAssessment.setBackground(SystemColor.menu);
		menuBar.add(mnAssessment);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("123456-Ioanna Sotiropoulou");
		mnAssessment.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("789456-Konstantinos Panos LAM7894");
		mnAssessment.add(mntmNewMenuItem_1);
		
		JMenu mnUnderRepair = new JMenu("Under Repair");
		mnUnderRepair.setBackground(SystemColor.menu);
		menuBar.add(mnUnderRepair);
		
		JMenuItem mntmStelios = new JMenuItem("654789-Stilianos Avlakiotis");
		mnUnderRepair.add(mntmStelios);
		
		JMenuItem mntmPanagiotisDimakopoulosAxh = new JMenuItem("014523-Panagiotis Dimakopoulos");
		mnUnderRepair.add(mntmPanagiotisDimakopoulosAxh);
		
		JMenu mnNewMenu_1 = new JMenu("Review Reports");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MechanicReviewReports frame = new MechanicReviewReports();
				frame.setVisible(true);
				
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu = new JMenu("Log Out");
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.setBackground(SystemColor.menu);
		mnNewMenu.setAlignmentX(5.0f);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Log Out");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Change Password");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u0399\u03C9\u03AC\u03BD\u03BD\u03B1\\Desktop\\\u03A3\u03C7\u03BF\u03BB\u03AE\\4o \u0388\u03C4\u03BF\u03C2\\8\u03BF \u0395\u03BE\u03AC\u03BC\u03B7\u03BD\u03BF\\\u03A4\u03B5\u03C7\u03BD\u03BF\u03BB\u03BF\u03B3\u03AF\u03B1 \u039B\u03BF\u03B3\u03B9\u03C3\u03BC\u03B9\u03BA\u03BF\u03CD\\istockphoto-1190679635-612x612.jpg"));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
