import java.util.List;

import model.Auteur;
import model.AuteurEjbRemote;
import model.Genre;
import model.GenreEjbRemote;
import model.Livre;
import model.LivreEjbRemote;

public class AppLivre {

	
	public AppLivre() {
		
	}
	public void trouvernumgenre(GenreEjbRemote lesgenrebean) {
		Genre gr = new Genre("BD");

		List<Genre> listeG = lesgenrebean.rechercherUnGenre(gr);
		for (Genre ungenre : listeG) {
			int param = ungenre.getNum();
			String param2 = ungenre.getLibelle();
			
		    System.out.println("-"+param +":-"+param2+" existe");
		}
	}

	public void ajouterLivre(LivreEjbRemote leslivrebean, GenreEjbRemote lesgenrebean, AuteurEjbRemote lesauteurbean) {

		
		Auteur au = new Auteur("française", "bill", "lemachin");
		Genre gr = new Genre("BD");
		Livre l = new Livre(2010,"lamaisonedit","ab45","anglaise",43,"eclipse", au,
				gr);
		
		// ystem.out.println(gr.getNum());

		List<Genre> listeG = lesgenrebean.rechercherUnGenre(gr);
		List<Auteur>listeAu = lesauteurbean.rechercherUnAuteur(au);
		if(listeG.size()==1&&listeAu.size()==1) {
			System.out.println("trouvé");
		for (Genre ungenre : listeG) {
			int param = ungenre.getNum();
			System.out.println(param);
			l.setGenre(ungenre);
		}
		
		for (Auteur unauteur : listeAu) {
			int parama = unauteur.getNum();
			System.out.println(parama);
			l.setAuteur(unauteur);
			
		}
		leslivrebean.persistLivre(l);
		
		
		}

	}
	
	public void supprimerUnLivre(LivreEjbRemote leslivrebean, Livre l) {
		
		List<Livre>listl = leslivrebean.rechercherUnlivrepartitre(l);
		if(listl.size()>=0) {
			System.out.println("trouvé");
			for(Livre li : listl) {
				String param = li.getTitre();
				leslivrebean.removeLivre(li);
			}
		}
	}
}
