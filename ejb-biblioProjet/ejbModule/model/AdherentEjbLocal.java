package model;

import java.util.List;
import javax.ejb.Local;


/**
 * @generated DT_ID=none
 */
@Local
public interface AdherentEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Adherent persistAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public Adherent mergeAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public void removeAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public List<Adherent> getAdherentFindAll();
    ///////////////////////////////////////////:
    public List<Adherent>findparNomEtPrenomAdh(Adherent ad);
    ///////////////////////////
    public List<Adherent>findparnum(Adherent ad);
    //////////////////////
    public List<Adherent> selectTous();
    
    

}
