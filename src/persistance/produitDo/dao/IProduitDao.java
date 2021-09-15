/**
 * 
 */
package persistance.produitDo.dao;

import java.util.List;

import persistance.produitDo.beanDo.ProduitDo;

/**
 * @author Charline
 *
 */
public interface IProduitDao {
    /**
     * Permet de recuperer la liste de tous les achats
     * 
     * @return listeDesProduitDo
     */
    List<ProduitDo> findAllProduitDo();

    /**
     * Permet de chercher un ProduitDo à partir de son id
     * 
     * @param id de ProduitDo à chercher
     * @return ProduitDo trouvé
     */
    ProduitDo findProduitDoById(final Integer id);

    /**
     * Permet de mettre à jour un ProduitDo
     * 
     * @param produitDo
     * @return
     */
    boolean updateProduitDo(final Integer idProduit,final ProduitDo produitDo);

    /**
     * Permet d'ajouter un nouveau ProduitDo dans la liste des ProduitDo
     * 
     * @param produitDo
     * @return
     */
    ProduitDo createProduitDo(final ProduitDo produitDo);

    /**
     * Permet de supprimer un ProduitDo
     * 
     * @param id
     * @return
     */
    boolean delete(final Integer id);

}
