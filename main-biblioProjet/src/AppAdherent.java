import java.util.List;

import model.Adherent;
import model.AdherentEjbRemote;
import model.Auteur;
import model.AuteurEjbRemote;

public class AppAdherent {
	
	
	public AppAdherent() {
		
	}

	public void ajouterAdherent(AdherentEjbRemote lesadherentbean,Adherent ad) {
		
		//Adherent ad = new Adherent(34,"3Allee François Babeuf","plaisir","cherif@laposte.net","bachir","chérif","2345678765");
		//(ADRCP, ADRRUE, ADRVILLE, MEL, NOM, PRENOM, TEL) 
		ad =lesadherentbean.persistAdherent(ad);
		
	}
	public void listAdherent(AdherentEjbRemote lesadherentbean) {
		List<Adherent>liste = lesadherentbean.getAdherentFindAll();
		for(Adherent unadhe:liste) {
			String param = unadhe.getNom()+" "+unadhe.getPrenom()+" "+unadhe.getAdrVille()+" "+unadhe.getAdrRue()+" "
		                   +unadhe.getAdrCP()+" "+unadhe.getTel();
			System.out.println(param);
		}
	}
public void chercherAdheParNometPrenom(AdherentEjbRemote lesadherentbean,Adherent ad) {
		
		System.out.println("//////////////////");
		System.out.println("");
		//Adherent ad = new Adherent("Fime","Nadia");
		List<Adherent> listead  = lesadherentbean.findparNomEtPrenomAdh(ad);
		if (listead.size()<=0) {
			System.out.println("cette Personne n'est pas un Adherent");
		}
		else {
		    for (Adherent unadhe: listead){        
			     String param = unadhe.getNom() + " " + unadhe.getPrenom() + " " + unadhe.getAdrCP() + " "
					+ unadhe.getAdrRue() + " " + unadhe.getAdrVille() + " " + unadhe.getTel();
			     System.out.println(param);
		    }
	   }
    	
	}
  public void supprimerUnAuteur(AdherentEjbRemote lesadherentbean,Adherent ad) {
	
	List<Adherent>listau = lesadherentbean.findparNomEtPrenomAdh(ad);
	if(listau.size()>=0) {
	 System.out.println("trouvé");
	 for(Adherent unAd:listau) {
		 String param= unAd.getNom()+" "+unAd.getPrenom();
		 System.out.println(param);
		 
		 lesadherentbean.removeAdherent(unAd);
	 }
	}
	System.out.println("il n'y a pas un adherent de ce nom et prenom");
}
}
