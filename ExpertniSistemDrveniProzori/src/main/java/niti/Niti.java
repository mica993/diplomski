package niti;

import klasa.DrveniProzor;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;




import forme.FormaIzborProzora;
import forme.FormaResenje;

//import forme.FormaIzborProzora;

public class Niti extends Thread {

	boolean pocni= false;

	public void run() {
		if(pocni){
			try { pocni= false;
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			DrveniProzor dp = new DrveniProzor();
			FormaIzborProzora  formaIP= new FormaIzborProzora(dp);
			formaIP.setVisible(true);
			while(formaIP.isVisible()){
				System.out.print("");
			}
			if(!formaIP.isVisible()){
				//System.out.println("nnn" + dp.toString());
				kSession.insert(dp);
				kSession.fireAllRules();
				
				FormaResenje resenje = new FormaResenje(dp);
				resenje.setVisible(true);
			}
				
			} catch (Throwable t) {
			t.printStackTrace();
			}
			
			
			
		}
	

	}
	public void pocetak (){
		pocni=true;
		
	}
}
