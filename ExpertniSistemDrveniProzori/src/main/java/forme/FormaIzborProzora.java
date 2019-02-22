package forme;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import klasa.DrveniProzor;
import klasa.DrveniProzor.Grejanje;
import klasa.DrveniProzor.MestoZivljenja;
import klasa.DrveniProzor.Podrucje;
import klasa.DrveniProzor.Pozicija;

import java.awt.CardLayout;

import javax.swing.JSlider;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
//import java.awt.SystemColor;

//import javax.swing.UIManager;

public class FormaIzborProzora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DrveniProzor dp;
	private JPanel panelSaPitanjima;
	private JLabel labelCena;

	private JButton btnDalje;
	private JButton buttonDalje1;
	private JButton buttonNazad1;
	private JButton buttonDalje3;
	private JButton buttonNazad3;
	private JButton btnNazad4;
	private JButton buttonDalje4;
	private JButton buttonDalje5;
	private JButton buttonNazad5;
	private JButton buttonDalje6;
	private JButton buttonNazad6;
	private JButton buttonDaljee7;
	private JButton buttonNazad7;
	private JButton buttonDalje8;
	private JButton buttonNazad8;
	private JButton buttonDalje9;
	private JButton buttonNazad9;
	
	final static String MESTOZIVLJENJA = "Mesto zivljenja";
	final static String POZICIJASTANA = " Pozicioniranost stana";
	final static String SPRATNOST = "Spratnost";
	final static String IZOLACIJA = " Da li ima izolaciju";
	final static String DEBLJINA = "Debljina izolacije";
	final static String GREJANJE = "Kako se grejete";
	final static String KLIMA = "Kakva  je klima";
	final static String BUKA = "Osetljivost na buku";
	final static String HLADNOCA = "Osjetljivost na hladnocu";
	final static String DIMENZIJE = "Dimenzije";
	final static String CENA = "Cena drvenih prozora";
	final static String UDALJENOSTTV = "Udaljenost od ekrana";
	final static String UREDJAJI = "Dodatni ure\u0111aji";

	private int spratnost = 18;
	private int najvecaCena = 160;
	private String povratakSaPanelaGrejanje;

	private String mestoZivljenjaS;
	private String fasadaS;

	JRadioButton rdbtnStan;
	JRadioButton rdbtnKuca;
	JRadioButton rdbtnIstok;
	JRadioButton rdbtnJug;
	JRadioButton rdbtnZapad;
	JRadioButton rdbtnSever;
	JRadioButton rbtnFasadaDa;
	JRadioButton rbtnIzolacija4;
	JRadioButton rbtnIzolacija8;
	JRadioButton rbtnFasadaNe;
	JRadioButton rbtnIzolacija16;
	JRadioButton rbtnCentralno;
	JRadioButton rbtnNecentralizovano;
	JRadioButton rdbtnPrimorski;
	JRadioButton rdbtnPlaninski;
	JRadioButton rdbtnRavnicarski;
	JRadioButton rdbtnBrdski;
	JRadioButton rdbtnBukaDa;
	JRadioButton rdbtnBukaNe;
	JRadioButton rdbtnBukaSlabije;
	JRadioButton rdbtnHladnocaDa;
	JRadioButton rdbtnHladnocaSlabije;
	JRadioButton rdbtnHladnocaNe;
	JRadioButton rdbtn100x120;
	JRadioButton rdbtn100x140;
	JRadioButton rdbtn140x140;
	JRadioButton rdbtn160x140;
	JRadioButton rdbtnDruge;

	private final ButtonGroup grupaDimenzije = new ButtonGroup();
	private final ButtonGroup grupaHladnoca = new ButtonGroup();
	private final ButtonGroup grupaBuka = new ButtonGroup();
	private final ButtonGroup grupaKlima = new ButtonGroup();
	private final ButtonGroup grupaGrejanje = new ButtonGroup();
	private final ButtonGroup grupaDebljina = new ButtonGroup();
	private final ButtonGroup grupaFasada = new ButtonGroup();
	private final ButtonGroup grupaMestoZivljenja = new ButtonGroup();
	private final ButtonGroup grupaPozicijaStana = new ButtonGroup();
	
	public boolean closed;
	private JLabel lblLogo;
	private JLabel lblLogo1;
	private JLabel lblLogo_1;
	private JLabel lblLogo_2;
	private JLabel lblLogo_3;
	private JLabel lblLogo_4;
	private JLabel lblLogooo;
	private JLabel lblLogo5;
	private JLabel lblLogo6;
	private JLabel lblLogo7;
	private JLabel lblLogo8;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaIzborProzora frame = new FormaIzborProzora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// DrveniProzor dp;
		public FormaIzborProzora() {
			super("Softver za pomo\u0107 pri izboru drvenih prozora");

			new FormaIzborProzora(dp).setVisible(true);
			setLocationRelativeTo(null);
			this.setResizable(false);
			// setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}


	

	public FormaIzborProzora(final DrveniProzor dp) {
		super("Softver za izbor drvenih prozora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 400);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				closed = true;
				dispose();
				FormaPocetnaMain.zaustavi();
			}
		});

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.setBackground(Color.white);

		panelSaPitanjima = new JPanel();
		panelSaPitanjima.setBackground(Color.CYAN);
		contentPane.add(panelSaPitanjima);
		panelSaPitanjima.setLayout(new CardLayout(0, 0));
		final CardLayout cl = (CardLayout) (panelSaPitanjima.getLayout());
		// dp = new DrveniProzor();

		// 1 pitanje
		
		JPanel gdeZivite = new JPanel();
		gdeZivite.setBackground(Color.BLACK);
		panelSaPitanjima.add(gdeZivite, MESTOZIVLJENJA);
		gdeZivite.setLayout(null);

		JLabel lblPrvoPitanje = new JLabel(" Gde \u017Eivite ?");
		lblPrvoPitanje.setForeground(Color.WHITE);
		lblPrvoPitanje.setBounds(34, 33, 369, 14);
		gdeZivite.add(lblPrvoPitanje);

		rdbtnKuca = new JRadioButton("Ku\u0107a");
		rdbtnKuca.setForeground(Color.WHITE);
		rdbtnKuca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnDalje.setVisible(true);

			}
		});

		rdbtnKuca.setBackground(new Color(255,51,51));

		grupaMestoZivljenja.add(rdbtnKuca);
		gdeZivite.add(rdbtnKuca);
		rdbtnKuca.setBounds(34, 75, 114, 23);

		rdbtnStan = new JRadioButton("Stan");
		rdbtnStan.setForeground(Color.WHITE);
		rdbtnStan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnDalje.setVisible(true);

			}
		});
		rdbtnStan.setBackground(new Color(255,51,51));
		grupaMestoZivljenja.add(rdbtnStan);
		gdeZivite.add(rdbtnStan);
		rdbtnStan.setBounds(34, 127, 114, 23);

		btnDalje = new JButton("Dalje");
		btnDalje.setForeground(Color.WHITE);
		btnDalje.setBackground(new Color(255, 51, 51));
		btnDalje.setVisible(false);
		btnDalje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// cl.next(panelSaPitanjima);
				// System.out.println(mestoZivljenjaOznaceno());
				dp.setMestoZivljenja(mestoZivljenjaOznaceno());
				cl.show(panelSaPitanjima, mestoZivljenjaS);
			
			}

			private MestoZivljenja mestoZivljenjaOznaceno() {
				if (rdbtnKuca.isSelected()) {
					mestoZivljenjaS = IZOLACIJA;
					povratakSaPanelaGrejanje = DEBLJINA;
					// System.out.println("test1");

					return MestoZivljenja.kuca;
				}
				if (rdbtnStan.isSelected()) {
					mestoZivljenjaS = POZICIJASTANA;
					povratakSaPanelaGrejanje = SPRATNOST;
					// System.out.println("test2");

					return MestoZivljenja.stan;
				}
				return null;
			}
		});
		btnDalje.setBounds(355, 213, 89, 23);
		gdeZivite.add(btnDalje);
		
		lblLogo = new JLabel("logo");
		lblLogo.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo.setBounds(20, 251, 465, 62);
		gdeZivite.add(lblLogo);

		// 2 pitanje

		JPanel pozicijaStana = new JPanel();
		pozicijaStana.setBackground(Color.BLACK);
		panelSaPitanjima.add(pozicijaStana, POZICIJASTANA);
		pozicijaStana.setLayout(null);

		JLabel lblPozicijaStana = new JLabel("Kako vam je pozicioniran stan ?");
		lblPozicijaStana.setForeground(Color.WHITE);
		lblPozicijaStana.setBounds(34, 28, 369, 14);
		pozicijaStana.add(lblPozicijaStana);

		rdbtnIstok = new JRadioButton("Istok");

		rdbtnIstok.setForeground(Color.WHITE);
		rdbtnIstok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje1.setVisible(true);
				//buttonNazad1.setVisible(true);

			}
		});
		rdbtnIstok.setBackground(new Color(255, 51, 51));
		grupaPozicijaStana.add(rdbtnIstok);
		pozicijaStana.add(rdbtnIstok);
		rdbtnIstok.setBounds(34, 49, 114, 23
				);

		rdbtnZapad = new JRadioButton("Zapad");
		rdbtnZapad.setForeground(Color.WHITE);
		rdbtnZapad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje1.setVisible(true);
				buttonNazad1.setVisible(true);

			}
		});
		rdbtnZapad.setBackground(new Color(255, 51, 51));
		grupaPozicijaStana.add(rdbtnZapad);
		pozicijaStana.add(rdbtnZapad);

		rdbtnZapad.setBounds(34, 81, 114, 23);

		rdbtnSever = new JRadioButton("Sever");
		rdbtnSever.setForeground(Color.WHITE);
		rdbtnSever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje1.setVisible(true);
				buttonNazad1.setVisible(true);

			}
		});
		rdbtnSever.setBackground(new Color(255, 51, 51));
		grupaPozicijaStana.add(rdbtnSever);
		pozicijaStana.add(rdbtnSever);

		rdbtnSever.setBounds(34, 119, 114, 23);

		rdbtnJug = new JRadioButton("Jug");
		rdbtnJug.setForeground(Color.WHITE);
		rdbtnJug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje1.setVisible(true);
				buttonNazad1.setVisible(true);

			}
		});
		rdbtnJug.setBackground(new Color(255, 51, 51));
		grupaPozicijaStana.add(rdbtnJug);
		pozicijaStana.add(rdbtnJug);
		rdbtnJug.setBounds(34, 157, 114, 23);

		buttonDalje1 = new JButton("Dalje");
		buttonDalje1.setBackground(new Color(255, 51, 51));
		buttonDalje1.setForeground(Color.WHITE);
		buttonDalje1.setVisible(false);
		buttonDalje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setPozicija(pozicijaStana());

				cl.show(panelSaPitanjima, SPRATNOST);
				
			}

			private Pozicija pozicijaStana() {
				if (rdbtnIstok.isSelected()) {

					// System.out.println("test1");

					return Pozicija.istok;
				}
				if (rdbtnZapad.isSelected()) {

					// System.out.println("test2");

					return Pozicija.zapad;
				}
				if (rdbtnSever.isSelected()) {

					// System.out.println("test2");

					return Pozicija.sever;
				}
				if (rdbtnJug.isSelected()) {

					// System.out.println("test2");

					return Pozicija.jug;
				}

				return null;

			}
		});
		buttonDalje1.setBounds(355, 213, 89, 23);
		pozicijaStana.add(buttonDalje1);

		buttonNazad1 = new JButton("Nazad");
		buttonNazad1.setBackground(new Color(255, 51, 51));
		buttonNazad1.setForeground(Color.WHITE);
		//buttonNazad1.setVisible(false);
		buttonNazad1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setMestoZivljenja(null);
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad1.setBounds(161, 213, 89, 23);
		pozicijaStana.add(buttonNazad1);
		
		lblLogo1 = new JLabel("logoo");
		lblLogo1.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo1.setBounds(32, 247, 465, 66);
		pozicijaStana.add(lblLogo1);
		// 3 pitanjne

		final JPanel spratnostStana = new JPanel();
		spratnostStana.setBackground(Color.BLACK);
		panelSaPitanjima.add(spratnostStana, SPRATNOST);
		spratnostStana.setLayout(null);

		JLabel lblSpratnost = new JLabel("Koja je spratnost stana ?");
		lblSpratnost.setForeground(Color.WHITE);
		lblSpratnost.setBackground(Color.GRAY);
		lblSpratnost.setBounds(34, 28, 369, 14);
		spratnostStana.add(lblSpratnost);

		final JLabel labelSpratnost = new JLabel("18");
		labelSpratnost.setForeground(Color.WHITE);

		labelSpratnost.setBounds(99, 104, 46, 14);
		spratnostStana.add(labelSpratnost);

		final JSlider sliderStan = new JSlider(-1, 35, 18);
		sliderStan.setBackground(Color.BLACK);
		sliderStan.setForeground(Color.WHITE);
		sliderStan.setBounds(38, 67, 406, 26);
		spratnostStana.add(sliderStan);

		Hashtable<Integer, JLabel> ispisSpratnosti = new Hashtable<Integer, JLabel>();
		ispisSpratnosti.put(new Integer(-1), new JLabel("-1"));

		ispisSpratnosti.put(new Integer(5), new JLabel("5"));
		ispisSpratnosti.put(new Integer(10), new JLabel("10"));
		ispisSpratnosti.put(new Integer(15), new JLabel("15"));
		ispisSpratnosti.put(new Integer(20), new JLabel("20"));
		ispisSpratnosti.put(new Integer(25), new JLabel("25"));
		ispisSpratnosti.put(new Integer(30), new JLabel("30"));
		ispisSpratnosti.put(new Integer(35), new JLabel("35"));
		sliderStan.setLabelTable(ispisSpratnosti);
		sliderStan.setPaintLabels(true);
		sliderStan.setSnapToTicks(false);
		

		sliderStan.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelSpratnost.setText(String.valueOf(sliderStan.getValue()));
				String value = String.valueOf(sliderStan.getValue());
				spratnost = Integer.parseInt(value);
			}
		});

		JButton buttonDalje2 = new JButton("Dalje");
		buttonDalje2.setBackground(new Color(255, 51, 51));
		buttonDalje2.setForeground(Color.WHITE);
		buttonDalje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setSprarnost(spratnost);
				//System.out.println(dp.getSpratnost());
				cl.show(panelSaPitanjima, GREJANJE);
			}

		});
		buttonDalje2.setBounds(355, 213, 89, 23);
		spratnostStana.add(buttonDalje2);

		JButton buttonNazad2 = new JButton("Nazad");
		buttonNazad2.setBackground(new Color(255, 51, 51));
		buttonNazad2.setForeground(Color.WHITE);
		buttonNazad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setSprarnost(spratnost);
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad2.setBounds(161, 213, 89, 23);
		spratnostStana.add(buttonNazad2);
		
		lblLogo_2 = new JLabel("logo3");
		lblLogo_2.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo_2.setBounds(32, 247, 465, 66);
		spratnostStana.add(lblLogo_2);

		// 4.pitanje

		JPanel panelFasadnaIzolacija = new JPanel();
		panelFasadnaIzolacija.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelFasadnaIzolacija, IZOLACIJA);
		panelFasadnaIzolacija.setLayout(null);

		JLabel lblIzolacija = new JLabel("Da li imate fasadnu izolaciju ?");
		lblIzolacija.setForeground(Color.WHITE);
		lblIzolacija.setBounds(34, 28, 369, 14);
		panelFasadnaIzolacija.add(lblIzolacija);

		rbtnFasadaDa = new JRadioButton("Da");
		rbtnFasadaDa.setForeground(Color.WHITE);
		rbtnFasadaDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje3.setVisible(true);
				//buttonNazad3.setVisible(true);

			}
		});
		rbtnFasadaDa.setBackground(new Color(255, 51, 51));
		grupaFasada.add(rbtnFasadaDa);
		rbtnFasadaDa.setBounds(34, 63, 114, 23
				);
		panelFasadnaIzolacija.add(rbtnFasadaDa);

		rbtnFasadaNe = new JRadioButton("Ne");
		rbtnFasadaNe.setForeground(Color.WHITE);
		rbtnFasadaNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje3.setVisible(true);
				//buttonNazad3.setVisible(true);

			}
		});
		rbtnFasadaNe.setBackground(new Color(255, 51, 51));
		grupaFasada.add(rbtnFasadaNe);
		rbtnFasadaNe.setBounds(34, 98, 114, 23);
		panelFasadnaIzolacija.add(rbtnFasadaNe);

		buttonDalje3 = new JButton("Dalje");
		buttonDalje3.setVisible(false);
		buttonDalje3.setBackground(new Color(255, 51, 51));
		buttonDalje3.setForeground(Color.WHITE);
		buttonDalje3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setFasada(postaviFasadu());

				// if (rbtnFasadaDa.isSelected() || rbtnFasadaNe.isSelected()) {
				cl.show(panelSaPitanjima, fasadaS);
				/*
				 * } else { JOptionPane.showMessageDialog(contentPane,
				 * "Nijedna opcija nije izabrana", "Greska",
				 * JOptionPane.ERROR_MESSAGE); }
				 */
			}

			private boolean postaviFasadu() {
				if (rbtnFasadaDa.isSelected()) {
					fasadaS = DEBLJINA;
					povratakSaPanelaGrejanje = DEBLJINA;

					return true;
				}
				if (rbtnFasadaNe.isSelected()) {
					fasadaS = GREJANJE;
					povratakSaPanelaGrejanje = IZOLACIJA;

					return false;
				}
				return false;
			}

		});
		buttonDalje3.setBounds(355, 213, 89, 23);
		panelFasadnaIzolacija.add(buttonDalje3);

		buttonNazad3 = new JButton("Nazad");
		buttonNazad3.setBackground(new Color(255, 51, 51));
		buttonNazad3.setForeground(Color.WHITE);
		//buttonNazad3.setVisible(false);
		buttonNazad3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// dp.setFasada(false);
				cl.show(panelSaPitanjima, MESTOZIVLJENJA);
			}
		});
		buttonNazad3.setBounds(161, 213, 89, 23);
		panelFasadnaIzolacija.add(buttonNazad3);
		
		lblLogo_3 = new JLabel("logo");
		lblLogo_3.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo_3.setBounds(32, 247, 465, 66);
		panelFasadnaIzolacija.add(lblLogo_3);

		// 5 pitanje

		JPanel panelDebljinaIzolacije = new JPanel();
		panelDebljinaIzolacije.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelDebljinaIzolacije, DEBLJINA);
		panelDebljinaIzolacije.setLayout(null);

		JLabel lblDebljina = new JLabel("Koja Vam je debljina izolacije ?");
		lblDebljina.setForeground(Color.WHITE);
		lblDebljina.setBounds(34, 28, 369, 14);
		panelDebljinaIzolacije.add(lblDebljina);

		rbtnIzolacija4 = new JRadioButton("4");
		rbtnIzolacija4.setForeground(Color.WHITE);
		rbtnIzolacija4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje4.setVisible(true);
				//btnNazad4.setVisible(true);

			}
		});
		rbtnIzolacija4.setBackground(new Color(255, 51, 51));
		grupaDebljina.add(rbtnIzolacija4);
		rbtnIzolacija4.setBounds(30, 64, 109, 23);
		panelDebljinaIzolacije.add(rbtnIzolacija4);

		rbtnIzolacija8 = new JRadioButton("8");
		rbtnIzolacija8.setForeground(Color.WHITE);
		rbtnIzolacija8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje4.setVisible(true);
				//btnNazad4.setVisible(true);

			}
		});
		rbtnIzolacija8.setBackground(new Color(255, 51, 51));
		grupaDebljina.add(rbtnIzolacija8);
		rbtnIzolacija8.setBounds(30, 100, 109, 23);
		panelDebljinaIzolacije.add(rbtnIzolacija8);

		rbtnIzolacija16 = new JRadioButton("10");
		rbtnIzolacija16.setBackground(new Color(255, 51, 51));
		rbtnIzolacija16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje4.setVisible(true);
				//btnNazad4.setVisible(true);

			}
		});
		rbtnIzolacija16.setForeground(Color.WHITE);
		grupaDebljina.add(rbtnIzolacija16);
		rbtnIzolacija16.setBounds(30, 133, 109, 23);
		panelDebljinaIzolacije.add(rbtnIzolacija16);

		buttonDalje4 = new JButton("Dalje");
		buttonDalje4.setBackground(new Color(255, 51, 51));
		buttonDalje4.setForeground(Color.WHITE);
		buttonDalje4.setVisible(false);
		buttonDalje4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setDebljinaIzolacije(vratiDebljinuIzolacije());

			
					cl.show(panelSaPitanjima, GREJANJE);
			

			}

			private double vratiDebljinuIzolacije() {
				if (rbtnIzolacija16.isSelected()) {
					return 10;
				}
				if (rbtnIzolacija4.isSelected()) {
					return 4;
				}
				if (rbtnIzolacija8.isSelected()) {
					return 8;
				}
				return 0.0;
			}
		});
		buttonDalje4.setBounds(355, 213, 89, 23);
		panelDebljinaIzolacije.add(buttonDalje4);

		btnNazad4 = new JButton("Nazad");
		btnNazad4.setBackground(new Color(255, 51, 51));
		btnNazad4.setForeground(Color.WHITE);
		//btnNazad4.setVisible(false);
		btnNazad4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		btnNazad4.setBounds(161, 213, 89, 23);
		panelDebljinaIzolacije.add(btnNazad4);
		
		lblLogo_4 = new JLabel("logo");
		lblLogo_4.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo_4.setBounds(32, 247, 465, 66);
		panelDebljinaIzolacije.add(lblLogo_4);

		// pitanje 6
		JPanel panelGrejanje = new JPanel();
		panelGrejanje.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelGrejanje, GREJANJE);
		panelGrejanje.setLayout(null);

		JLabel lblGrejanje = new JLabel("Koje grejanje  imate ?");
		lblGrejanje.setForeground(Color.WHITE);
		lblGrejanje.setBounds(34, 28, 369, 14);
		panelGrejanje.add(lblGrejanje);

		rbtnCentralno = new JRadioButton("Centralno");
		rbtnCentralno.setBackground(new Color(255, 51, 51));
		rbtnCentralno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje5.setVisible(true);
				//buttonNazad5.setVisible(true);

			}
		});
		rbtnCentralno.setForeground(Color.WHITE);
		grupaGrejanje.add(rbtnCentralno);
		rbtnCentralno.setBounds(34, 58, 126, 23);
		panelGrejanje.add(rbtnCentralno);

		rbtnNecentralizovano = new JRadioButton("Necentralizovano");
		rbtnNecentralizovano.setBackground(new Color(255, 51, 51));
		rbtnNecentralizovano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje5.setVisible(true);
				//buttonNazad5.setVisible(true);

			}
		});
		rbtnNecentralizovano.setForeground(Color.WHITE);
		grupaGrejanje.add(rbtnNecentralizovano);
		rbtnNecentralizovano.setBounds(34, 106, 126, 23);
		panelGrejanje.add(rbtnNecentralizovano);

		buttonDalje5 = new JButton("Dalje");
		buttonDalje5.setBackground(new Color(255, 51, 51));
		buttonDalje5.setForeground(Color.WHITE);
		buttonDalje5.setVisible(false);
		buttonDalje5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setGrejanje(oznaciGrejanje());
				//cl.next(panelSaPitanjima );
				cl.show(panelSaPitanjima, KLIMA);
			}

			private Grejanje oznaciGrejanje() {
				if (rbtnCentralno.isSelected()) {

					return Grejanje.centralno;
				}
				if (rbtnNecentralizovano.isSelected()) {

					return Grejanje.necentralizovano;
				}
				return null;
			}
		});
		buttonDalje5.setBounds(355, 213, 89, 23);
		panelGrejanje.add(buttonDalje5);

		buttonNazad5 = new JButton("Nazad");
		buttonNazad5.setForeground(Color.WHITE);
		buttonNazad5.setBackground(new Color(255, 51, 51));
		//buttonNazad5.setVisible(false);
		buttonNazad5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cl.show(panelSaPitanjima, povratakSaPanelaGrejanje);
			}
		});
		buttonNazad5.setBounds(169, 213, 89, 23);
		panelGrejanje.add(buttonNazad5);
		
		lblLogooo = new JLabel("logooo");
		lblLogooo.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogooo.setBounds(32, 247, 465, 66);
		panelGrejanje.add(lblLogooo);

		// pitanje 7

		JPanel panelKlimackoPodrucje = new JPanel();
		panelKlimackoPodrucje.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelKlimackoPodrucje, KLIMA);
		panelKlimackoPodrucje.setLayout(null);

		JLabel lblNaKomKlimatckom = new JLabel(
				"Na kom klimatskom podru\u010Dju \u017Eivite ?");
		lblNaKomKlimatckom.setForeground(Color.WHITE);
		lblNaKomKlimatckom.setBounds(34, 28, 369, 14);
		panelKlimackoPodrucje.add(lblNaKomKlimatckom);

		rdbtnPrimorski = new JRadioButton("Primorskom");
		rdbtnPrimorski.setBackground(new Color(255, 51, 51));
		rdbtnPrimorski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje6.setVisible(true);
			//	buttonNazad6.setVisible(true);

			}
		});
		rdbtnPrimorski.setForeground(Color.WHITE);
		grupaKlima.add(rdbtnPrimorski);
		rdbtnPrimorski.setBounds(34, 54, 109, 23);
		panelKlimackoPodrucje.add(rdbtnPrimorski);

		rdbtnPlaninski = new JRadioButton("Planinskom");
		rdbtnPlaninski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje6.setVisible(true);
			//	buttonNazad6.setVisible(true);

			}
		});
		rdbtnPlaninski.setForeground(Color.WHITE);
		rdbtnPlaninski.setBackground(new Color(255, 51, 51));
		grupaKlima.add(rdbtnPlaninski);
		rdbtnPlaninski.setBounds(34, 93, 109, 23);
		panelKlimackoPodrucje.add(rdbtnPlaninski);

		rdbtnRavnicarski = new JRadioButton("Ravni\u010Darskom");
		rdbtnRavnicarski.setForeground(Color.WHITE);
		rdbtnRavnicarski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje6.setVisible(true);
			//	buttonNazad6.setVisible(true);

			}
		});
		rdbtnRavnicarski.setBackground(new Color(255, 51, 51));
		grupaKlima.add(rdbtnRavnicarski);
		rdbtnRavnicarski.setBounds(34, 131, 109, 23);
		panelKlimackoPodrucje.add(rdbtnRavnicarski);

		rdbtnBrdski = new JRadioButton("Brdskom");
		rdbtnBrdski.setForeground(Color.WHITE);
		rdbtnBrdski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje6.setVisible(true);
				//buttonNazad6.setVisible(true);

			}
		});
		rdbtnBrdski.setBackground(new Color(255, 51, 51));
		grupaKlima.add(rdbtnBrdski);
		rdbtnBrdski.setBounds(34, 171, 109, 23);
		panelKlimackoPodrucje.add(rdbtnBrdski);

		buttonDalje6 = new JButton("Dalje");
		buttonDalje6.setBackground(new Color(255, 51, 51));
		buttonDalje6.setForeground(Color.WHITE);
		buttonDalje6.setVisible(false);
		buttonDalje6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setPodrucje(vratiPodrucje());
				
				cl.show(panelSaPitanjima, BUKA);
	

			}

			private Podrucje vratiPodrucje() {

				if (rdbtnBrdski.isSelected()) {
					return Podrucje.Brdskom;

				}
				if (rdbtnPlaninski.isSelected()) {
					return Podrucje.Planinskom;

				}
				if (rdbtnPrimorski.isSelected()) {
					return Podrucje.Primorskom;

				}
				if (rdbtnRavnicarski.isSelected()) {
					return Podrucje.Ravnicarskom;

				}
				return null;
			}
		});
		buttonDalje6.setBounds(355, 213, 89, 23);
		panelKlimackoPodrucje.add(buttonDalje6);

		buttonNazad6 = new JButton("Nazad");
		buttonNazad6.setBackground(new Color(255, 51, 51));
		buttonNazad6.setForeground(Color.WHITE);
		//buttonNazad6.setVisible(false);
		buttonNazad6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad6.setBounds(161, 213, 89, 23);
		panelKlimackoPodrucje.add(buttonNazad6);
		lblLogo5 = new JLabel("logooo");
		lblLogo5.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo5.setBounds(32, 247, 465, 66);
		panelKlimackoPodrucje.add(lblLogo5);
	

		// 8 pitanje

		JPanel panelBuka = new JPanel();
		panelBuka.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelBuka, BUKA);
		panelBuka.setLayout(null);

		JLabel lblDaLiSte = new JLabel("Da li ste osetljivi na buku ?");
		lblDaLiSte.setForeground(Color.WHITE);
		lblDaLiSte.setBounds(34, 28, 369, 14);
		panelBuka.add(lblDaLiSte);

		rdbtnBukaDa = new JRadioButton("Da");
		rdbtnBukaDa.setForeground(Color.WHITE);
		rdbtnBukaDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDaljee7.setVisible(true);
			//	buttonNazad7.setVisible(true);

			}
		});
		rdbtnBukaDa.setBackground(new Color(255, 51, 51));
		grupaBuka.add(rdbtnBukaDa);
		rdbtnBukaDa.setBounds(34, 62, 109, 23);
		panelBuka.add(rdbtnBukaDa);

		rdbtnBukaNe = new JRadioButton("Ne");
		rdbtnBukaNe.setBackground(new Color(255, 51, 51));
		rdbtnBukaNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDaljee7.setVisible(true);
				//buttonNazad7.setVisible(true);

			}
		});
		rdbtnBukaNe.setForeground(Color.WHITE);
		grupaBuka.add(rdbtnBukaNe);
		rdbtnBukaNe.setBounds(34, 137, 109, 23);
		panelBuka.add(rdbtnBukaNe);

		rdbtnBukaSlabije = new JRadioButton("Slabije");
		rdbtnBukaSlabije.setForeground(Color.WHITE);
		rdbtnBukaSlabije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDaljee7.setVisible(true);
				//buttonNazad7.setVisible(true);

			}
		});
		rdbtnBukaSlabije.setBackground(new Color(255, 51, 51));
		grupaBuka.add(rdbtnBukaSlabije);
		rdbtnBukaSlabije.setBounds(34, 100, 109, 23);
		panelBuka.add(rdbtnBukaSlabije);

		buttonDaljee7 = new JButton("Dalje");
		buttonDaljee7.setVisible(false);
		buttonDaljee7.setBackground(new Color(255, 51, 51));
		buttonDaljee7.setForeground(Color.WHITE);
		buttonDaljee7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setOsetljivostNaBuku(oserljivostNaBuku());

			
				cl.show(panelSaPitanjima, HLADNOCA);
				
			}

			private String oserljivostNaBuku() {
				if (rdbtnBukaDa.isSelected()) {
					return "Da";

				}
				if (rdbtnBukaSlabije.isSelected()) {
					return "Slabije";

				}
				if (rdbtnBukaNe.isSelected()) {
					return "Ne";

				}
				return null;
			}
		});
		buttonDaljee7.setBounds(355, 213, 89, 23);
		panelBuka.add(buttonDaljee7);

		buttonNazad7 = new JButton("Nazad");
		buttonNazad7.setForeground(Color.WHITE);
		buttonNazad7.setBackground(new Color(255, 51, 51));
		//buttonNazad7.setVisible(false);
		buttonNazad7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad7.setBounds(161, 213, 89, 23);
		panelBuka.add(buttonNazad7);
		lblLogo6 = new JLabel("logooo");
		lblLogo6.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo6.setBounds(32, 247, 465, 66);
		panelBuka.add(lblLogo6);

		// 9 pitanje

		JPanel panelHladnoca = new JPanel();
		panelHladnoca.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelHladnoca, HLADNOCA);
		panelHladnoca.setLayout(null);

		JLabel lblDaLiSte_1 = new JLabel(
				"Da li ste osetljivi na hladno\u0107u ?");
		lblDaLiSte_1.setForeground(Color.WHITE);
		lblDaLiSte_1.setBounds(34, 28, 369, 14);
		panelHladnoca.add(lblDaLiSte_1);

		rdbtnHladnocaDa = new JRadioButton("Da");
		rdbtnHladnocaDa.setBackground(new Color(255, 51, 51));
		rdbtnHladnocaDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje8.setVisible(true);
				//buttonNazad8.setVisible(true);

			}
		});
		rdbtnHladnocaDa.setForeground(Color.WHITE);
		grupaHladnoca.add(rdbtnHladnocaDa);
		rdbtnHladnocaDa.setBounds(34, 63, 109, 23);
		panelHladnoca.add(rdbtnHladnocaDa);

		rdbtnHladnocaSlabije = new JRadioButton("Slabije");
		rdbtnHladnocaSlabije.setForeground(Color.WHITE);
		rdbtnHladnocaSlabije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje8.setVisible(true);
			//	buttonNazad8.setVisible(true);

			}
		});
		rdbtnHladnocaSlabije.setBackground(new Color(255, 51, 51));
		grupaHladnoca.add(rdbtnHladnocaSlabije);
		rdbtnHladnocaSlabije.setBounds(34, 100, 109, 23);
		panelHladnoca.add(rdbtnHladnocaSlabije);

		rdbtnHladnocaNe = new JRadioButton("Ne");
		rdbtnHladnocaNe.setBackground(new Color(255, 51, 51));
		rdbtnHladnocaNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje8.setVisible(true);
				//buttonNazad8.setVisible(true);

			}
		});
		rdbtnHladnocaNe.setForeground(Color.WHITE);
		grupaHladnoca.add(rdbtnHladnocaNe);
		rdbtnHladnocaNe.setBounds(34, 138, 109, 23);
		panelHladnoca.add(rdbtnHladnocaNe);

		buttonDalje8 = new JButton("Dalje");
		buttonDalje8.setBackground(new Color(255, 51, 51));
		buttonDalje8.setForeground(Color.WHITE);
		buttonDalje8.setVisible(false);
		buttonDalje8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setOsetljivostNaHladnocu(osetljivostNaHladnocu());

					cl.show(panelSaPitanjima, DIMENZIJE);
		

			}

			private String osetljivostNaHladnocu() {
				if (rdbtnHladnocaDa.isSelected()) {
					return "Da";

				}
				if (rdbtnHladnocaSlabije.isSelected()) {
					return "Slabije";

				}
				if (rdbtnHladnocaNe.isSelected()) {
					return "Ne";

				}

				return null;
			}
		});
		buttonDalje8.setBounds(355, 213, 89, 23);
		panelHladnoca.add(buttonDalje8);

	    buttonNazad8 = new JButton("Nazad");
		buttonNazad8.setForeground(Color.WHITE);
		buttonNazad8.setBackground(new Color(255, 51, 51));
		//buttonNazad8.setVisible(false);
		buttonNazad8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad8.setBounds(161, 213, 89, 23);
		panelHladnoca.add(buttonNazad8);
		lblLogo7 = new JLabel("logooo");
		lblLogo7.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo7.setBounds(32, 247, 465, 66);
		panelHladnoca.add(lblLogo7);

		//10 pitanje
		
		JPanel panelDimenzije = new JPanel();
		panelDimenzije.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelDimenzije, DIMENZIJE);
		panelDimenzije.setLayout(null);

		JLabel lblKojihDimenzijaVam = new JLabel(
				"Kojih dimenzija Vam je potreban prozor ?");
		lblKojihDimenzijaVam.setForeground(Color.WHITE);
		lblKojihDimenzijaVam.setBounds(34, 28, 369, 14);
		panelDimenzije.add(lblKojihDimenzijaVam);

		rdbtn100x120 = new JRadioButton("100x120");
		rdbtn100x120.setBackground(new Color(255, 51, 51));
		rdbtn100x120.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje9.setVisible(true);
				//buttonNazad9.setVisible(true);

			}
		});
		rdbtn100x120.setForeground(Color.WHITE);
		grupaDimenzije.add(rdbtn100x120);
		rdbtn100x120.setBounds(34, 52, 109, 23);
		panelDimenzije.add(rdbtn100x120);

		rdbtn100x140 = new JRadioButton("100x140");
		rdbtn100x140.setForeground(Color.WHITE);
		rdbtn100x140.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje9.setVisible(true);
				//buttonNazad9.setVisible(true);

			}
		});
		rdbtn100x140.setBackground(new Color(255, 51, 51));
		grupaDimenzije.add(rdbtn100x140);
		rdbtn100x140.setBounds(34, 87, 109, 23);
		panelDimenzije.add(rdbtn100x140);

		rdbtn140x140 = new JRadioButton("140x140");
		rdbtn140x140.setForeground(Color.WHITE);
		rdbtn140x140.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje9.setVisible(true);
				//buttonNazad9.setVisible(true);

			}
		});
		rdbtn140x140.setBackground(new Color(255, 51, 51));
		grupaDimenzije.add(rdbtn140x140);
		rdbtn140x140.setBounds(34, 117, 109, 23);
		panelDimenzije.add(rdbtn140x140);

		rdbtn160x140 = new JRadioButton("160x140");
		rdbtn160x140.setForeground(Color.WHITE);
		rdbtn160x140.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje9.setVisible(true);
			//	buttonNazad9.setVisible(true);

			}
		});
		rdbtn160x140.setBackground(new Color(255, 51, 51));
		grupaDimenzije.add(rdbtn160x140);
		rdbtn160x140.setBounds(34, 152, 109, 23);
		panelDimenzije.add(rdbtn160x140);

		rdbtnDruge = new JRadioButton("Druge");
		rdbtnDruge.setForeground(Color.WHITE);
		rdbtnDruge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buttonDalje9.setVisible(true);
				//buttonNazad9.setVisible(true);

			}
		});
		rdbtnDruge.setBackground(new Color(255, 51, 51));
		grupaDimenzije.add(rdbtnDruge);
		rdbtnDruge.setBounds(34, 185, 109, 23);
		panelDimenzije.add(rdbtnDruge);

		buttonDalje9 = new JButton("Dalje");
		buttonDalje9.setForeground(Color.WHITE);
		buttonDalje9.setBackground(new Color(255, 51, 51));
		buttonDalje9.setVisible(false);
		buttonDalje9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setDimenzije(dimenzije());

					cl.show(panelSaPitanjima, CENA);
				

			}

			private String dimenzije() {
				if (rdbtn100x120.isSelected()) {
					return "100x120";

				}
				if (rdbtn100x140.isSelected()) {
					return "100x140";

				}

				if (rdbtn140x140.isSelected()) {
					return "140x140";

				}

				if (rdbtn160x140.isSelected()) {
					return "160x140";

				}
				if (rdbtnDruge.isSelected()) {
					return "Druge";

				}
				return null;
			}
		});
		buttonDalje9.setBounds(355, 213, 89, 23);
		panelDimenzije.add(buttonDalje9);

		buttonNazad9 = new JButton("Nazad");
		buttonNazad9.setBackground(new Color(255, 51, 51));
		buttonNazad9.setForeground(Color.WHITE);
		//buttonNazad9.setVisible(false);
		buttonNazad9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad9.setBounds(161, 213, 89, 23);
		panelDimenzije.add(buttonNazad9);
		
		lblLogo_1 = new JLabel("logo");
		lblLogo_1.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo_1.setBounds(32, 247, 465, 66);
		panelDimenzije.add(lblLogo_1);

		JPanel panelCena = new JPanel();
		panelCena.setBackground(Color.BLACK);
		panelSaPitanjima.add(panelCena, CENA);
		panelCena.setLayout(null);

		JLabel lblKolikoNovcaSte = new JLabel(
				"Koliko novca ste spremni da izdvojite ?");
		lblKolikoNovcaSte.setForeground(Color.WHITE);
		lblKolikoNovcaSte.setBounds(34, 28, 369, 14);
		panelCena.add(lblKolikoNovcaSte);

		final JSlider sliderCena = new JSlider(160, 600, 160);
		sliderCena.setForeground(Color.WHITE);
		sliderCena.setBackground(Color.BLACK);

		sliderCena.setBounds(34, 53, 410, 26);
		panelCena.add(sliderCena);

		Hashtable<Integer, JLabel> ispisCene = new Hashtable<Integer, JLabel>();
		ispisCene.put(new Integer(160), new JLabel("160"));

		ispisCene.put(new Integer(200), new JLabel("200"));
		ispisCene.put(new Integer(250), new JLabel("250"));
		ispisCene.put(new Integer(300), new JLabel("300"));
		ispisCene.put(new Integer(350), new JLabel("350"));
		ispisCene.put(new Integer(400), new JLabel("400"));
		ispisCene.put(new Integer(450), new JLabel("450"));
		ispisCene.put(new Integer(500), new JLabel("500"));
		ispisCene.put(new Integer(550), new JLabel("550"));
		ispisCene.put(new Integer(600), new JLabel("600"));
		sliderCena.setLabelTable(ispisCene);
		sliderCena.setPaintLabels(true);
		sliderCena.setSnapToTicks(false);

		sliderCena.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelCena.setText(String.valueOf(sliderCena.getValue())
						+ " \u20ac");
				String value = String.valueOf(sliderCena.getValue());
				najvecaCena = Integer.parseInt(value);

			}
		});

		JButton btnZavrsi = new JButton("Zavr\u0161i");
		btnZavrsi.setForeground(Color.WHITE);
		btnZavrsi.setBackground(new Color(255, 51, 51));
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setCena(najvecaCena);

				System.out.println(dp.toString());

				dispose();

			}
		});
		btnZavrsi.setBounds(355, 213, 89, 23);
		panelCena.add(btnZavrsi);

		JButton buttonNazad10 = new JButton("Nazad");
		buttonNazad10.setBackground(new Color(255, 51, 51));
		buttonNazad10.setForeground(Color.WHITE);
		buttonNazad10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.previous(panelSaPitanjima);
			}
		});
		buttonNazad10.setBounds(161, 213, 89, 23);
		panelCena.add(buttonNazad10);
		lblLogo8 = new JLabel("logooo");
		lblLogo8.setIcon(new ImageIcon(FormaIzborProzora.class.getResource("/slike/logo.png")));
		lblLogo8.setBounds(32, 247, 465, 66);
		panelCena.add(lblLogo8);
		
		labelCena = new JLabel("160 \u20ac");
		labelCena.setForeground(Color.WHITE);
		labelCena.setBounds(117, 115, 46, 14);
		panelCena.add(labelCena);
	}


}
