package model;

import java.util.List;
import javax.ejb.Local;


/**
 * @generated DT_ID=none
 */
@Local
public interface LivreEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Livre persistLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public Livre mergeLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public void removeLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public List<Livre> getLivreFindAll();
////////////////////////////////////////:
    public List<Livre> rechercherUnlivrepartitre(Livre livre);
}
