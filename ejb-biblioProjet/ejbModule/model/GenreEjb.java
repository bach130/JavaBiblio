package model;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "GenreEjb", mappedName = "ejb-biblioProjet-GenreEjb")
public class GenreEjb
        implements GenreEjbLocal, GenreEjbRemote
{

    /**
     * @generated DT_ID=none
     */
	@Resource
	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="ejb-biblioProjet")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public GenreEjb() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Genre persistGenre(Genre genre) {
        em.persist(genre);
        return genre;
    }

    /**
     * @generated DT_ID=none
     */
    public Genre mergeGenre(Genre genre) {
        return em.merge(genre);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeGenre(Genre genre) {
        genre = em.find(Genre.class, genre.getNum());
        em.remove(genre);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Genre> getGenreFindAll() {
        return em.createNamedQuery("Genre.findAll").getResultList();
    }
    public List<Genre> rechercherUnGenre(Genre genre){
    	List<Genre>liste = em.createQuery("select x from Genre x where x.libelle LIKE :name")
    			.setParameter("name",genre.getLibelle()).getResultList();
    	return liste;
    }
    public List<Livre>rechercherUnLivreParGenre(Genre genre){
        	List<Livre>liste = em.createQuery("select x from Livre x where x.genre.libelle LIKE :genre")
        			.setParameter("genre",genre.getLibelle()).getResultList();
        	return liste;
    }
    
    public List<Genre>NumGenre(Genre genre){
    	List<Genre>liste = em.createQuery("select x from Genre x where x.libelle LIKE :name")
    			.setParameter("name",genre.getNum()).getResultList();
    	return liste;
    }
    
    public String findparvaleur2(Genre genre) {
    	String param="Valeur non existante";
    	String requet = "select x from Genre x where x.libelle = ";    
    	requet = requet +"'" + genre.getLibelle()+"'";
    	List<Genre> lesgenre = (List<Genre>)queryByRange(requet,0,10); 
    	if(lesgenre.size()>0) {
		for (Genre ungenre: lesgenre){        
			param = ungenre.getLibelle();
			
		}
    	return param;
    	}return param;
    }
    

}
