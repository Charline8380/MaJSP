/**
 * 
 */
package persistance.achat.dao;

import java.util.List;

import persistance.achat.beanDo.Achat;

/**
 * @author Charline
 *
 */
public interface IAchatDao {

    /**
     * Permet de recuperer la liste de tous les achats
     * 
     * @return listeDesAchats
     */
    List<Achat> findAllAchat();

    /**
     * Permet de chercher un achat à partir de son id
     * 
     * @param id de achat à chercher
     * @return achat trouvé
     */
    Achat findAchatById(final Integer id);

    /**
     * Permet de mettre à jour un achat
     * 
     * @param achat
     * @return
     */
    boolean updateAchat(final Achat newAchat);

    /**
     * Permet d'ajouter un nouveau achat dans la liste des achats
     * 
     * @param achat
     * @return 
     */
    Achat createAchat(final Achat achat);

    /**
     * Permet de supprimer un achat
     * 
     * @param id
     * @return
     */
    boolean delete(final Integer id);

}
