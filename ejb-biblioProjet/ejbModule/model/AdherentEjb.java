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
@Stateless(name = "AdherentEjb", mappedName = "ejb-biblioProjet-AdherentEjb")
public class AdherentEjb
        implements AdherentEjbLocal, AdherentEjbRemote
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
    public AdherentEjb() {
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
    public Adherent persistAdherent(Adherent adherent) {
        em.persist(adherent);
        return adherent;
    }

    /**
     * @generated DT_ID=none
     */
    public Adherent mergeAdherent(Adherent adherent) {
        return em.merge(adherent);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeAdherent(Adherent adherent) {
        adherent = em.find(Adherent.class, adherent.getNum());
        em.remove(adherent);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Adherent> getAdherentFindAll() {
        return em.createNamedQuery("Adherent.findAll").getResultList();
    }
    public List<Adherent>findparNomEtPrenomAdh(Adherent ad) {
    	
    	/*List<Adherent>liste = em.createQuery("select a from Adherent a where a.nom LIKE :name ")
    			.setParameter("name",ad.getNom()).getResultList();
    	return liste;*/
	List<Adherent>liste = em.createQuery("select a from Adherent a where a.nom LIKE :name  and a.prenom LIKE :tname")
			.setParameter("name", ad.getNom()).setParameter("tname", ad.getPrenom()).getResultList();
	return liste;
    	
    }

        public List<Adherent>findparnum(Adherent ad) {
        	
    	List<Adherent>liste = em.createQuery("select a from Adherent a where a.num LIKE :numA")
    			.setParameter("numA", ad.getNom()).getResultList();
    	return liste;
        	
        }
        public List<Adherent> selectTous() {
            String jpqlStmt = "select x from Adherent x where x.num = ?";
            List<Adherent> lesAdherent = (List<Adherent>) queryByRange(jpqlStmt, 0, 2);
            return lesAdherent;
            }
        
        


}

