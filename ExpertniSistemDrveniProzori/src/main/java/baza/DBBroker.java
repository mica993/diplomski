package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import klasa.DrveniProzor;

public class DBBroker {

	Connection konekcija;
	   String upit;
	private ResultSet rs;
    
	   public void ucitajDrajver() {
	    
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    
	    
	    }
	    public void otvoriKonenkciju() {
        
	        try {
	            konekcija= DriverManager.getConnection("jdbc:mysql://localhost:3306/namestaj", "root", "");
	            konekcija.setAutoCommit(false);
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("Nije otvorio konekciju");
	        }
	    }
	    
	     public  void commit () {
	    
	        try {
	            konekcija.commit();
	        } catch (SQLException ex) {
	            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public void rollback() {
	    
	        try {
	            konekcija.rollback();
	        } catch (SQLException ex) {
	            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public void zatvoriKonekciju() {
	    
	        try {
	            konekcija.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    
	    }

	   public ResultSet vrateResenja( DrveniProzor dp) {
		   rs = null;
		   
	 
		  
			   if (dp.getMaterijal() != null )  {
				   upit= "select * from prozori WHERE materijal = '" + dp.getMaterijal() +"' AND brojStakala = " + dp.getBrojStakala() + " AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije()+ "'";/*+ "' AND cena <= " + dp.getCena();*/
				   System.out.println("Materijal nije null" + upit );
			   } else {
				upit= "select * from prozori WHERE brojStakala = " + dp.getBrojStakala() + " AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije()+ "'";/*+ "' AND cena <= " + dp.getCena();*/
				   System.out.println("Materijal je null" + upit);
			}
			   
			   if(dp.getDebljina() == 0) {
				   upit += "";
				   System.out.println(" Debljina 90 nema za datu dimenziju "+upit);
			  } else {
				   upit += " AND debljinaRama = " + dp.getDebljina();
				   System.out.println("1 " + upit);
			   }
			  
			   
			/*   if(dp.getDimenzije()== "140x140" &&  dp.getDimenzije()== "160x140"  ){
					
					// upit = "select * from prozori WHERE brojStakala = '"/*debljinaRama= '"+ dp.getDebljina() */ /*+"' AND materijal = '" + dp.getMaterijal() *//*+"' AND brojStakala = '" *///+ dp.getBrojStakala() + "' AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije()/*+ "' AND cena= '" + dp.getCena() */+ "'";
					   //System.out.println(upit);
					
				//} 
			/*else{
				// upit= "select * from prozori WHERE debljinaRama= '"+ dp.getDebljina()  /*+"' AND materijal = '" + dp.getMaterijal() *///+"' AND brojStakala = '" + dp.getBrojStakala() + "' AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije()/*+ "' AND cena= '" + dp.getCena() */+ "'";
				 //  System.out.println(upit);
	//		}
		
		   
	      //  ArrayList<DrveniProzor> listaP = new ArrayList<DrveniProzor>();
		   //try {
			//if(!rs.next()){
			    //upit= "select * from prozori WHERE debljinaRama= '"+ dp.getDebljina() + "' AND materijal = '" + dp.getMaterijal() + "' AND brojStakala = '" + dp.getBrojStakala() + "' AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije() + "' AND cena= '" + dp.getCena() + "'";
			    //System.out.println(upit);
			    //System.out.println("drugi");
			    //}
			
			   //else {
				   //rs.previous();
				   //upit= "select * from prozori WHERE debljinaRama= '"+ dp.getDebljina() + "' AND materijal = '" + dp.getMaterijal() + "' AND brojStakala = '" + dp.getBrojStakala() + "' AND tip= '" + dp.getTip() + "' AND dimenzija= '" + dp.getDimenzije() + "' AND cena= '" + dp.getCena() + "'";
				  // System.out.println(upit);   
			   //}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			///e.printStackTrace();
		//}
	       try {
	           Statement s = konekcija.createStatement();
	           rs= s.executeQuery(upit);
	          /* rs.next();
	           System.out.println(rs.getString("naziv"));*/
	          /* while (rs.next()) {               
	                dp2 = new DrveniProzor (rs.getString("naziv"), rs.getInt("debljinaRama"),rs.getInt("brojStakala"),rs.getString("materijal"), rs.getString("dimenzija"), rs.getInt("cena"));
	               
	           } */
	           //rs.close();
	           //s.close();
	       } catch (SQLException ex) {
	           Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	       }
	       return rs;
	    }
	    
	  	
}
