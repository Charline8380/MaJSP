/**
 * 
 */
package service.produit;

import java.util.List;

import application.bean.Produit;

/**
 * @author Charline
 *
 */
public interface IProduitService {
    
    /**
     * Permet de recuperer la liste de tous les produits
     * 
     * @return listeDesProduits
     */
    List<Produit> findAllProduit() ;

    /**
     * Permet de chercher un produit à partir de son id
     * 
     * @param id du produit à chercher
     * @return produit trouvé
     */
    Produit findProduitById(final Integer id) ;
    /**
     * Permet de mettre à jour un produit
     * 
     * @param produit
     * @return
     */
    boolean updateProduit(final Produit newProduit);

    /**
     * Permet d'ajouter un nouveau produit dans la liste des produits
     * 
     * @param produit
     * @return 
     */
    Produit createProduit(final Produit produit) ;

    /**
     * Permet de supprimer un produit
     * 
     * @param id
     * @return
     */
    boolean delete(final Integer id) ;

}
