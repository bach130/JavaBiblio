package model;

import java.util.List;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface PretEjbRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Pret persistPret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public Pret mergePret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public void removePret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public List<Pret> getPretFindAll();

}
