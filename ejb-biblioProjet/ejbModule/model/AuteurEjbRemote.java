package model;

import java.util.List;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AuteurEjbRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Auteur persistAuteur(Auteur auteur);

    /**
     * @generated DT_ID=none
     */
    public Auteur mergeAuteur(Auteur auteur);

    /**
     * @generated DT_ID=none
     */
    public void removeAuteur(Auteur auteur);

    /**
     * @generated DT_ID=none
     */
    public List<Auteur> getAuteurFindAll();
    ////////////////////////////////////////////
    public List<Auteur> rechercherUnAuteur(Auteur auteur);

}
