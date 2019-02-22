package forme;

//import java.awt.BorderLayout;
//import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.FlowLayout;



//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import niti.Niti;




import java.awt.Color;
//import org.apache.poi.ss.usermodel.Picture;
import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.SystemColor;

public class FormaPocetnaMain extends JFrame {
	private static Niti dpNit;
	private static FormaPocetnaMain frame;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton /*btnKraj,*/ btnPocetak;
	private JLabel lblSlika;
	private JLabel lblLogo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FormaPocetnaMain();
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
	public FormaPocetnaMain() {
		super("Softver za pomo\u0107 pri izboru drvenih prozora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(350, 250, 650, 670);
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*btnKraj = new JButton("Kraj");
		// btnKraj.setBackground((Color.white));
		btnKraj.setEnabled(false);
		btnKraj.setVisible(false);
		btnKraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		btnKraj.setBounds(10, 607, 103, 23);
		contentPane.add(btnKraj);*/

		JButton btnPocetak = new JButton("Po\u010Detak");
		btnPocetak.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPocetak.setBackground(Color.BLACK);
		btnPocetak.setForeground(Color.WHITE);
		// btnPocetak.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		// btnPocetak.setBackground(new Color(255, 0, 0));
		btnPocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pokreni();
				frame.setVisible(false);
			}
		});
		btnPocetak.setBounds(501, 606, 133, 23);
		contentPane.add(btnPocetak);

		JLabel labelSlika = new JLabel("");
		labelSlika.setBackground(Color.WHITE);
		labelSlika.setForeground(Color.WHITE);
		labelSlika.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		labelSlika
				.setIcon(new ImageIcon(FormaPocetnaMain.class.getResource("/slike/prozor.jpg")));
		labelSlika.setBounds(10, 90, 630, 506);
		contentPane.add(labelSlika);
		
		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(FormaPocetnaMain.class.getResource("/slike/logo.png")));
		//lblLogo.setIcon(new ImageIcon("C:\\Users\\MILICA\\Desktop\\Diolomski\\logo.png"));
		lblLogo.setBounds(10, 11, 473, 66);
		contentPane.add(lblLogo);

	}

	public JLabel getLblSlika() {
		return lblSlika;
	}

	public void setLblSlika(JLabel lblSlika) {
		this.lblSlika = lblSlika;
	}

	public JButton getBtnPocetak() {
		return btnPocetak;
	}

	public void setBtnPocetak(JButton btnPocetak) {
		this.btnPocetak = btnPocetak;
	}

	public static void pokreni() {
		dpNit = new Niti();
		dpNit.pocetak();
		dpNit.start();
	}

	public static void zaustavi() {
		dpNit.interrupt();
	}

	public static void showYourself() {
		frame.setVisible(true);
	}

}
