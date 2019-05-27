import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Adherent;
import model.AdherentEjbRemote;
import model.Auteur;
import model.AuteurEjbRemote;
import model.GenreEjbRemote;
import model.Livre;
import model.LivreEjbRemote;
import model.PretEjbRemote;

public class MainBiblio {

	public static void main(String[] args) {
		InitialContext context;  
		AdherentEjbRemote  lesadherentbean=null ;AuteurEjbRemote  lesauteurbean=null ;GenreEjbRemote lesgenrebean=null;
		LivreEjbRemote leslivrebean = null;PretEjbRemote lespretbean = null;
		
		try {   context = new InitialContext();  
		lesadherentbean = (AdherentEjbRemote)context.lookup("ejb-biblioProjet-AdherentEjb");
		lesauteurbean = (AuteurEjbRemote)context.lookup("ejb-biblioProjet-AuteurEjb");
		lesgenrebean = (GenreEjbRemote)context.lookup("ejb-biblioProjet-GenreEjb");
		leslivrebean = (LivreEjbRemote)context.lookup("ejb-biblioProjet-LivreEjb");
		lespretbean = (PretEjbRemote)context.lookup("ejb-biblioProjet-PretEjb");
		
		
		} catch (NamingException e) {   // TODO Auto-generated catch block
			e.printStackTrace();  
		}
		//Test sur les Adherent
		Adherent ad = new Adherent("ba","ch");
		AppAdherent adapp = new AppAdherent();
		adapp.supprimerUnAuteur(lesadherentbean, ad);
		//ad.ajouterAdherent(lesadherentbean);
		//ad.listAdherent(lesadherentbean);
		//ad.chercherAdheParNometPrenom(lesadherentbean);
		
		
		////////////////////////////////////
		
		
		//Tests sur Les Genre
		AppGenre appG = new AppGenre();
		appG.listDesGenre(lesgenrebean);
		
		
		//////////////////////////////////////
		
		//test sur les Auteur
		Auteur au = new Auteur("bill","lemachin");
		
		AppAuteur appAu = new AppAuteur();
		//appAu.ajouterAuteur(lesauteurbean);
		//appAu.supprimerUnAuteur(lesauteurbean, au);
		System.out.println();
		System.out.println("//////////////////////////");
		
		///////////////////////////////////
		
		//Tests sur Les Livres
		Livre l = new Livre("eclipse");
		AppLivre appL = new AppLivre();
		appL.trouvernumgenre(lesgenrebean);
		//appL.ajouterLivre(leslivrebean, lesgenrebean, lesauteurbean);
		//appL.supprimerUnLivre(leslivrebean, l);
		
		

	}

}
