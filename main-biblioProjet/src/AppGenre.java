import java.util.List;

import model.Genre;
import model.GenreEjbRemote;
import model.Livre;

public class AppGenre {
	
	public AppGenre() {
		
	}

	
	public void listDesGenre(GenreEjbRemote lesgenrebean) {
		System.out.println("//////////////////");
		System.out.println("liste des gerne"); 
		List<Genre> listeG = lesgenrebean.getGenreFindAll();  
		for (Genre ungenre: listeG){        
			String param = ungenre.getLibelle()+""+ungenre.getNum();
			System.out.println(param);   
		}
		
	}
	public void rechercherUnGenre(GenreEjbRemote lesgenrebean) {
		System.out.println("//////////////////");
		System.out.println("trouver un gerne");
		Genre g = new Genre("BD");
		List<Genre> listeG  = lesgenrebean.rechercherUnGenre(g);
		for (Genre ungenre: listeG){        
			String param = ungenre.getLibelle();
			System.out.println(param); 
	    }
	}
	public void rechercherUnLivreParGenre(GenreEjbRemote lesgenrebean) {
		
		System.out.println("//////////////////");
		System.out.println("liste des livres par gerne");
		Genre g = new Genre("BD");
		List<Livre> listel  = lesgenrebean.rechercherUnLivreParGenre(g);
		for (Livre unlivre: listel){        
			String param = unlivre.getTitre();
			System.out.println(param); 
	    }
	}
	/**
	 * ajouter un genre
	 * @param lesgenrebean
	 */
	public void ajouterUnGenre(GenreEjbRemote lesgenrebean) {
		Genre g = new Genre("un_Noeveau_Genre ");
		g = lesgenrebean.persistGenre(g);
	}
	
	public void supprimerUnGenre(GenreEjbRemote lesgenrebean) {
		Genre recherche = new Genre("mongashonen"); 
		String jpqlStmt = "select g from Genre g where g.libelle ="; 
		jpqlStmt = jpqlStmt +"'" + recherche.getLibelle()+"'"; 
		 
		List<Genre> listeg = (List<Genre>)lesgenrebean.queryByRange(jpqlStmt, 0,10);
		
		if (listeg.size()>0) { 
			System.out.println("genre trouvé");  
			for (Genre user : listeg){ 
				String oneuser = user.getLibelle(); 
				System.out.println(oneuser);
				lesgenrebean.removeGenre(user); 
			}
		}
	}
}
