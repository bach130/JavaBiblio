import java.util.List;

import model.Auteur;
import model.AuteurEjbRemote;

public class AppAuteur {

	public AppAuteur() {
		
	}
	
	public void ajouterAuteur(AuteurEjbRemote lesauteurbean) {
   	 
   	 Auteur a = new Auteur("française", "bill", "lemachin");
   	 a  = lesauteurbean.persistAuteur(a);
    }
	
	public void supprimerUnAuteur(AuteurEjbRemote lesauteur,Auteur Au) {
		
		List<Auteur>listau = lesauteur.rechercherUnAuteur(Au);
		if(listau.size()>=0) {
		 System.out.println("trouvé");
		 for(Auteur unAut:listau) {
			 String param= unAut.getNom()+" "+unAut.getPrenom();
			 System.out.println(param);
			 
			 lesauteur.removeAuteur(unAut);
		 }
		}
		System.out.println("il n'y a pas un auteur de ce nom et prenom");
	}
}
