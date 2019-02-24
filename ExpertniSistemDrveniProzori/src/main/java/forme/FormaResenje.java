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
	// JLabel lblNatpis;
	JTextPane lblNatpis;
	JButton btnPredhodno = new JButton("Predhodno");;
	JButton btnSledeci = new JButton("Slede\u0107i");
	JTextPane txtpnPogledajteDaLi;

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

	public FormaResenje() {

		setResizable(false);
		new FormaResenje(dp).setVisible(true);
	}

	public FormaResenje(DrveniProzor dp) {
		
		
		super("Softver za pomo\u0107 pri izboru drvenih prozora");
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(350, 250, 650, 600);
		setBounds(100, 100, 650, 600);
		setLocationRelativeTo(null);
		this.setResizable(false);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final JTextPane lblNatpis = new JTextPane();
		lblNatpis.setBackground(Color.BLACK);
		lblNatpis.setForeground(Color.WHITE);
		lblNatpis.setBounds(295, 241, 304, 196);
		contentPane.add(lblNatpis);

		lblslika = new JLabel(" Slika");
		lblslika.setBackground(Color.BLACK);
		lblslika.setForeground(Color.WHITE);
		lblslika.setBounds(10, 217, 238, 220);
		contentPane.add(lblslika);

		lblNatpis.setText("Resenje");
		System.out.println(dp);

		

		txtpnPogledajteDaLi = new JTextPane();
		txtpnPogledajteDaLi.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtpnPogledajteDaLi.setForeground(Color.WHITE);
		txtpnPogledajteDaLi.setBackground(Color.BLACK);
		txtpnPogledajteDaLi
				.setText("Pogledajte jo\u0161 neke tipove prozora koje Vam je expertni sistem predlo\u017Eio");
		txtpnPogledajteDaLi.setBounds(10, 497, 315, 38);
		contentPane.add(txtpnPogledajteDaLi);
		txtpnPogledajteDaLi.setEditable(false);
	
		// Ispis iz baze

		rs = Kontroler.getInstanca().vratiResenje(dp);
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Greska baza");
		}

		try {
			dp2 = new DrveniProzor(rs.getString("tip"),
					rs.getInt("debljinaRama"), rs.getInt("brojStakala"),
					rs.getString("materijal"), rs.getString("dimenzija"),
					rs.getInt("cena"));
		
			lblNatpis.setText(dp2.ispisNaFormiIzBaze());
			lblNatpis.setEditable(false);
			byte image[];
			image = rs.getBytes("slika");
			ImageIcon icon = new ImageIcon(image);
			Image im = icon.getImage();
			Image imm = im.getScaledInstance(lblslika.getWidth(),
					    lblslika.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon myImg = new ImageIcon(imm);
			lblslika.setIcon(myImg);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Greska prikaz");
			JOptionPane.showMessageDialog(contentPane, "Nema proizvod u bazi ",
					"Greska", JOptionPane.ERROR_MESSAGE);

		}

		System.out.println(rs.toString());
		System.out.println(dp2.ispisNaFormiIzBaze());

		// Dugme sledeci

		btnSledeci.setBackground(Color.BLACK);
		btnSledeci.setForeground(Color.WHITE);
		btnSledeci.setBounds(497, 497, 103, 38);

		try {
			if (rs.next()) {

				btnSledeci.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if (rs.next()) {
								dp2 = new DrveniProzor(rs.getString("tip"), rs
										.getInt("debljinaRama"), rs
										.getInt("brojStakala"), rs
										.getString("materijal"), rs
										.getString("dimenzija"), rs
										.getInt("cena"));
								byte image[];
								image = rs.getBytes("slika");
								ImageIcon icon = new ImageIcon(image);
								Image im = icon.getImage();
								Image imm = im.getScaledInstance(
										lblslika.getWidth(),
										lblslika.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon myImg = new ImageIcon(imm);
								lblslika.setIcon(myImg);
								btnPredhodno.setVisible(true);
							    btnSledeci.setVisible(true);
								txtpnPogledajteDaLi.setVisible(true);
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("Nema dalje");
							e.printStackTrace();

						}

						lblNatpis.setText(dp2.ispisNaFormiIzBaze());
						lblNatpis.setEditable(false);
					}
				});
			}
			 else {
					txtpnPogledajteDaLi.setVisible(false);
					btnSledeci.setVisible(false);
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*btnPredhodno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
*/
		// Dugme predhodno


		btnPredhodno.setBackground(Color.BLACK);
		btnPredhodno.setForeground(Color.WHITE);
		btnPredhodno.setBounds(351, 497, 103, 38);
		btnPredhodno.setVisible(false);
		contentPane.add(btnPredhodno);

		try {
			if (rs.previous()) {
				btnPredhodno.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						try {
							if (rs.previous()) {
								dp2 = new DrveniProzor(rs.getString("tip"), rs
										.getInt("debljinaRama"), rs
										.getInt("brojStakala"), rs
										.getString("materijal"), rs
										.getString("dimenzija"), rs
										.getInt("cena"));
								byte image[];
								image = rs.getBytes("slika");
								ImageIcon icon = new ImageIcon(image);
								Image im = icon.getImage();
								Image imm = im.getScaledInstance(
										lblslika.getWidth(),
										lblslika.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon myImg = new ImageIcon(imm);
								lblslika.setIcon(myImg);
							} /*else {
								btnPredhodno.setEnabled(false);
							}*/

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("Nema predhodni");
							e.printStackTrace();
						}

						lblNatpis.setText(dp2.ispisNaFormiIzBaze());
						lblNatpis.setEnabled(false);
					}

				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contentPane.setLayout(null);
		contentPane.add(btnSledeci);

		JLabel lblLogo = new JLabel("  Logo");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setIcon(new ImageIcon(FormaResenje.class
				.getResource("/slike/logo.png")));
		lblLogo.setBounds(10, 11, 472, 75);

		contentPane.add(lblLogo);
		
		JLabel lblKontakt = new JLabel("KONTAKT");
		lblKontakt.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblKontakt.setForeground(Color.WHITE);
		lblKontakt.setBounds(30, 97, 113, 32);
		contentPane.add(lblKontakt);
		
		JLabel lblTelefon = new JLabel("telefon :");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setBounds(30, 129, 81, 22);
		contentPane.add(lblTelefon);
		
		JLabel lblEmil = new JLabel("email :");
		lblEmil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmil.setForeground(Color.WHITE);
		lblEmil.setBounds(40, 162, 52, 14);
		contentPane.add(lblEmil);
		
		JLabel label = new JLabel("+387 65 / 511-364");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setForeground(Color.WHITE);
		label.setBounds(121, 133, 136, 14);
		contentPane.add(label);
		
		JLabel lblMahagonioutlookcom = new JLabel("mahagoni@outlook.com");
		lblMahagonioutlookcom.setForeground(Color.WHITE);
		lblMahagonioutlookcom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMahagonioutlookcom.setBounds(121, 153, 167, 32);
		contentPane.add(lblMahagonioutlookcom);


	}
}
