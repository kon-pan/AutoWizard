package ui.mechanic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

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
		setBounds(100, 100, 650, 500);
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
		
		JLabel lbl1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/mec1.jpg")).getImage().getScaledInstance(650,500, Image.SCALE_DEFAULT)	;
		lbl1.setIcon(new ImageIcon(img));
		contentPane.add(lbl1, BorderLayout.CENTER);
	}

}
