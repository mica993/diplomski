package klasa;

//import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.SwingUtilities;
import javax.swing.SwingUtilities;

public class testMain extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//	private static final long serialVersionUID = 1L;
//	private JLabel L1;
//	private JButton pokrenii;
//	private JButton kraj;
//
	public testMain() {
//
//		super("Softver za pomo\u0107 pri izboru drvenih prozora");
//
//		setLayout(new GridBagLayout());
//		setSize(500, 500);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		this.setResizable(false);
//		setVisible(true);
//
//		// slika
//		/*setLayout(new BorderLayout());
//		setContentPane(new JLabel(
//				new ImageIcon(
//						"C:\\Users\\MILICA\\Documents\\ExpertniSistemDrveniProzori\\Slike\\pocetnaa.jpg")));
//		setLayout(new FlowLayout());
//		L1 = new JLabel();
//		add(L1);
//		setSize(550, 550);*/
//
//		// JPanel p = new JPanel(new GridBagLayout());
//		pokrenii = new JButton("Pokreni");
//		
//		GridBagConstraints gbc = new GridBagConstraints();
//		//gbc.insets = new Insets(30, 30, 30, 30);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		/*
//		 * gbc.gridwidth=1; gbc.gridheight=1; gbc.anchor =
//		 * GridBagConstraints.CENTER; gbc.fill=GridBagConstraints.NONE;
//		 */
//
//		add(pokrenii, gbc);
//		// add(p);
//
//		// Button b1= new Button("Pokreni");
//		// Button b2 = new Button("Kraj");
//		// p.add(b1,gbc);
//		// p.add(b2,gbc);
//		//
//		// add(p,BorderLayout.SOUTH);
//
////		kraj = new JButton("Kraj");
////		gbc.gridx = 2;
////		gbc.gridy = 1;
////		gbc.fill = GridBagConstraints.HORIZONTAL;
//		// gbc.anchor = GridBagConstraints.CENTER;
//		// gbc.gridwidth=0;
//		// gbc.gridy=2;
//		// gbc.gridwidth=1;
//		// gbc.gridheight=1;
//		// gbc.fill=GridBagConstraints.BOTH;
//
//		//add(kraj, gbc);
//		
//		
//		//setLayout(new BorderLayout());
//		//setContentPane( L1 = new JLabel(
//				//new ImageIcon(
//						//"C:\\Users\\MILICA\\Documents\\ExpertniSistemDrveniProzori\\Slike\\pocetnaa.jpg")));
//		//setLayout(new FlowLayout());
//		//L1 = new JLabel();
//		JLabel L1 = new JLabel(
//				new ImageIcon(
//						"C:\\Users\\MILICA\\Documents\\ExpertniSistemDrveniProzori\\Slike\\pocetnaa.jpg"));
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		//gbc.gridwidth = 3;
//		add(L1, gbc);

	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				testMain dpForma = new testMain();
				dpForma.setVisible(true);

			}
		});
	}

}
