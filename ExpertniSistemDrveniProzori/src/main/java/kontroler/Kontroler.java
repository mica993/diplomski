package kontroler;

import java.sql.ResultSet;
//import java.util.ArrayList;

import baza.DBBroker;
import klasa.DrveniProzor;


public class Kontroler {

    DBBroker dbb;
    private static Kontroler instanca;
    ResultSet rs = null;
   

    private Kontroler() {
        dbb = new DBBroker();
      
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ResultSet vratiResenje( DrveniProzor dp) {     
        dbb.ucitajDrajver();
        dbb.otvoriKonenkciju();
        rs= dbb.vrateResenja(dp);
        
        
        return rs ;
    }
    
    public  void zatvoriKonekciju(){
        dbb.zatvoriKonekciju();

    	
    }

	
}
