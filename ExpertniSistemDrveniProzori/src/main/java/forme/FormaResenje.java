package forme;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;


//import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klasa.DrveniProzor;
import kontroler.Kontroler;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Font;
//import java.util.ArrayList;

public class FormaResenje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DrveniProzor dp;
	//JLabel lblNatpis;
	JTextPane lblNatpis;
	JButton btnPredhodno;
	JButton btnSledeci ;
	JTextPane txtpnPogledajteDaLi ;

	ResultSet rs;
	DrveniProzor dp2 = null;
	private JLabel lblslika;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaResenje frame = new FormaResenje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FormaResenje (){
	
		setResizable(false);
        new FormaResenje(dp).setVisible(true);
	}
	public FormaResenje( DrveniProzor dp) {
		super("Softver za pomo\u0107 pri izboru drvenih prozora");
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 650, 600);
		setLocationRelativeTo(null);
		this.setResizable(false);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		final JTextPane lblNatpis = new JTextPane();
		 lblNatpis.setBackground(Color.BLACK);
		 lblNatpis.setForeground(Color.WHITE);
			lblNatpis.setBounds(295, 230, 304, 207);
			contentPane.add(lblNatpis);
			
			lblslika = new JLabel(" Slika");
			lblslika.setBackground(Color.BLACK);
			lblslika.setForeground(Color.WHITE);
			lblslika.setBounds(10, 205, 238, 232);
			contentPane.add(lblslika);
			
		lblNatpis.setText("Resenje");
		System.out.println(dp);
		
		
		//Ispis iz baze
		 
		
		
		 rs = Kontroler.getInstanca().vratiResenje(dp);
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Greska baza");
		}
		
		try {
			dp2 = new DrveniProzor (rs.getString("tip"), rs.getInt("debljinaRama"),rs.getInt("brojStakala"),rs.getString("materijal"), rs.getString("dimenzija"), rs.getInt("cena"));
			//lblNatpis.setText("<html>" + dp2.ispisNaFormiIzBaze().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
			lblNatpis.setText(dp2.ispisNaFormiIzBaze());
			lblNatpis.setEnabled(false);
			byte image[];
			image = rs.getBytes("slika");
			ImageIcon icon = new ImageIcon(image);
			Image im = icon.getImage();
			Image imm = im.getScaledInstance(lblslika.getWidth(), lblslika.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon myImg = new ImageIcon(imm);
			lblslika.setIcon(myImg);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Greska prikaz");
			JOptionPane.showMessageDialog(contentPane,
					"Nema proizvod u bazi ", "Greska",
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		System.out.println(rs.toString());
		System.out.println(dp2.ispisNaFormiIzBaze());

		
		
		
		
		// Dugme sledeci
		
	    btnSledeci = new JButton("Slede\u0107i");
		btnSledeci.setBackground(Color.BLACK);
		btnSledeci.setForeground(Color.WHITE);
		btnSledeci.setBounds(497, 497, 103, 38);
		//btnSledeci.setEnabled(false);
		//btnSledeci.setVisible(false);
		btnSledeci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(rs.next()){
					dp2 = new DrveniProzor (rs.getString("tip"), rs.getInt("debljinaRama"),rs.getInt("brojStakala"),rs.getString("materijal"), rs.getString("dimenzija"), rs.getInt("cena"));
					byte image[];
					image = rs.getBytes("slika");
					ImageIcon icon = new ImageIcon(image);
					Image im = icon.getImage();
					Image imm = im.getScaledInstance(lblslika.getWidth(), lblslika.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon myImg = new ImageIcon(imm);
					lblslika.setIcon(myImg);
					
					} 
			btnPredhodno.setVisible(true);
			//btnSledeci.setEnabled(true);
			//btnSledeci.setVisible(true);
			txtpnPogledajteDaLi.setVisible(true);
				   
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Nema dalje");
					e.printStackTrace();
					
				}
				//lblNatpis.setText("<html>" + dp2.ispisNaFormiIzBaze().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

	            lblNatpis.setText(/*"<html>"+*/ dp2.ispisNaFormiIzBaze());/*.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");*/
			    lblNatpis.setEnabled(false);
			}
		});
		
		
		//Dugme predhodno
	    btnPredhodno = new JButton("Predhodno");
		btnPredhodno.setBackground(Color.BLACK);
		btnPredhodno.setForeground(Color.WHITE);
		btnPredhodno.setBounds(351, 497, 103, 38);
		btnPredhodno.setVisible(false);
		contentPane.add(btnPredhodno);
		
		btnPredhodno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					if(rs.previous()){
					dp2 = new DrveniProzor (rs.getString("tip"), rs.getInt("debljinaRama"),rs.getInt("brojStakala"),rs.getString("materijal"), rs.getString("dimenzija"), rs.getInt("cena"));
					byte image[];
					image = rs.getBytes("slika");
					ImageIcon icon = new ImageIcon(image);
					Image im = icon.getImage();
					Image imm = im.getScaledInstance(lblslika.getWidth(), lblslika.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon myImg = new ImageIcon(imm);
					lblslika.setIcon(myImg);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Nema dalje");
					e.printStackTrace();
				}
		

	            lblNatpis.setText(dp2.ispisNaFormiIzBaze());
	            lblNatpis.setEnabled(false);
			}
			
		});

		
		
		
	
		contentPane.setLayout(null);
		contentPane.add(btnSledeci);
		
		JLabel lblLogo = new JLabel("  Logo");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setIcon(new ImageIcon(FormaResenje.class.getResource("/slike/logo.png")));
		lblLogo.setBounds(10, 11, 472, 75);
		
		contentPane.add(lblLogo);
		
	    txtpnPogledajteDaLi = new JTextPane();
		txtpnPogledajteDaLi.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtpnPogledajteDaLi.setForeground(Color.WHITE);
		txtpnPogledajteDaLi.setBackground(Color.BLACK);
		txtpnPogledajteDaLi.setText("Pogledajte jo\u0161 neke tipove prozora koje Vam je expertni sistem predlo\u017Eio");
		txtpnPogledajteDaLi.setBounds(10, 497, 315, 38);
		contentPane.add(txtpnPogledajteDaLi);
		txtpnPogledajteDaLi.setEditable(false);
		//txtpnPogledajteDaLi.setVisible(false);
		
	}
}
