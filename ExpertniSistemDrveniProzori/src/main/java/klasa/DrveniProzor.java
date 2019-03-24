package klasa;

//import java.util.ArrayList;

public class DrveniProzor {
	public enum MestoZivljenja {
		kuca, stan
	}

	public enum Pozicija {

		istok, zapad, sever, jug
	}

	public enum Grejanje {

		centralno, necentralizovano

	}

	public enum Materijal {
		Jela,
		Bor,
		//Aris,
		Hrast
	}
	public enum Podrucje {
	Planinskom , Brdskom , Primorskom , Ravnicarskom 
		
	}

    private Podrucje podrucje;
	private MestoZivljenja mestoZivljenja;
	private Pozicija pozicija;
	private int spratnost;
	private boolean fasada;
	private double debljinaIzolacije;
	private Grejanje grejanje;
	private String osetljivostNaBuku;
	private String osetljivostNaHladnocu;
	private boolean blizinaUlice;
	
	// baza
	private String tip;
	//private ArrayList<Materijal> m;
	private Materijal materijal;
	private int debljina;
	private int cena;
	private String dimenzije;
    private int brojStakala;

	public DrveniProzor(MestoZivljenja mestoZivljenja, Pozicija pozicija,
			int spratnost, boolean fasada, double debljinaIzolacije,
			Grejanje grejanje, String osetljivostNaBuku,
			String osetljivostNaHladnocu, boolean blizinaUlice, int cena, Materijal materijal,
			int debljina, String tip, String dimenzije,int brojStakala, Podrucje podrucje) {
		super();
		this.podrucje= podrucje;
		this.mestoZivljenja = mestoZivljenja;
		this.pozicija = pozicija;
		this.spratnost = spratnost;
		this.fasada = fasada;
		this.debljinaIzolacije = debljinaIzolacije;
		this.grejanje = grejanje;
		this.osetljivostNaBuku = osetljivostNaBuku;
		this.osetljivostNaHladnocu = osetljivostNaHladnocu;
		this.dimenzije = dimenzije;
		this.cena = cena;
		this.materijal=materijal;
		this.tip=tip;
		this.brojStakala= brojStakala;
		this.debljina=debljina;
		this.blizinaUlice= blizinaUlice;
	}
	
	public DrveniProzor(String tip, int dRama, int brStalaka, String materijal, String dim, int cena) {
		this.tip = tip;
		this.dimenzije = dim;
		this.cena = cena;
		this.materijal=Materijal.valueOf(materijal);
		this.brojStakala= brStalaka;
		this.debljina=dRama;
	}

	public DrveniProzor() {
	
		super();
	}

	public MestoZivljenja getMestoZivljenja() {
		return mestoZivljenja;
	}

	public void setMestoZivljenja(MestoZivljenja mestoZivljenja) {
		this.mestoZivljenja = mestoZivljenja;
	}

	public Pozicija getPozicija() {
		return pozicija;
	}

	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}

	public int getSpratnost() {
		return spratnost;
	}

	public void setSprarnost(int spratnost) {
		this.spratnost = spratnost;
	}

	public boolean isFasada() {
		return fasada;
	}

	public void setFasada(boolean fasada) {
		this.fasada = fasada;
	}

	public double getDebljinaIzolacije() {
		return debljinaIzolacije;
	}

	public void setDebljinaIzolacije(double debljinaIzolacije) {
		this.debljinaIzolacije = debljinaIzolacije;
	}

	public Grejanje getGrejanje() {
		return grejanje;
	}

	public void setGrejanje(Grejanje grejanje) {
		this.grejanje = grejanje;
	}

	public String getOsetljivostNaBuku() {
		return osetljivostNaBuku;
	}

	public void setOsetljivostNaBuku(String osetljivostNaBuku) {
		this.osetljivostNaBuku = osetljivostNaBuku;
	}

	public String getOsetljivostNaHladnocu() {
		return osetljivostNaHladnocu;
	}

	public void setOsetljivostNaHladnocu(String osetljivostNaHladnocu) {
		this.osetljivostNaHladnocu = osetljivostNaHladnocu;
	}

	public boolean getBlizinaUlice() {
		return blizinaUlice;
	}

	public void setBlizinaUlice(boolean blizinaUlice) {
		this.blizinaUlice = blizinaUlice;
	}

	public void setSpratnost(int spratnost) {
		this.spratnost = spratnost;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getDimenzije() {
		return dimenzije;
	}

	public void setDimenzije(String dimenzije) {
		this.dimenzije = dimenzije;
	}


	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip= tip;
	}

	public Materijal getMaterijal() {
		return materijal;
	}

	public void setMaterijal(Materijal materijal) {
		this.materijal = materijal;
	}

	public int getDebljina() {
		return debljina;
	}

	public void setDebljina(int debljina) {
		this.debljina = debljina;
	}

	public int getBrojStakala() {
		return brojStakala;
	}

	public void setBrojStakala(int brojStakala) {
		this.brojStakala = brojStakala;
	}

	public Podrucje getPodrucje() {
		return podrucje;
	}

	public void setPodrucje(Podrucje podrucje) {
		this.podrucje = podrucje;
	}

	public String toString() {

		return " Mesto zivljenja= " + mestoZivljenja 
				+ ", \n pozicija= "+ pozicija 
				+ ", \n Spratnost=" + spratnost 
				+ ", \n fasada= " + fasada
				+ " , \n debljina izolacije= " + debljinaIzolacije
				+ ", \n grejanje= " + grejanje 
				+ ",\n osetljivost na buku= "+ osetljivostNaBuku 
				+ ", \n osetljivost na hladnocu= "+ osetljivostNaHladnocu 
				+ ", \n blizina ulice= "+ blizinaUlice 
				+ " , \n tip= " + tip
				+ ", \n materijal= " + materijal 
				+ ", \n debljina= " + debljina
				+ " , \n dimenzije= " + dimenzije 
				+ " , \n cena= " + cena
			    + ", \n brojStakala= " + brojStakala 
			    + ", \n podrucije = " + podrucje;
	}
	public String ispisNaFormiIzBaze() {

		return " Tip = " + tip
				+ ",\n Materijal= " + materijal + ",\n Debljina= " + debljina
				+ " ,\n Dimenzije= " + dimenzije + " , \n Cena= " + cena
				+ ", \n BrojStakala= " + brojStakala ;
	}
}
