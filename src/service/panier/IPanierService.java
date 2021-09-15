/**
 * 
 */
package service.panier;

import application.bean.AchatInfo;
import application.bean.Panier;
import persistance.achat.beanDo.Achat;

/**
 * @author Charline
 *
 */
public interface IPanierService {
    
    /**
     * Méthode permettant de faire appel à un produit de la couche persistance pour l'ajouter au panier 
     * 
     * @param panier qui contient les infos des produits à ajouter au panier
     * @param idProduit l'id du produit à rajouter
     * @return un panier si ajout OK, sinon null
     */
    Panier addProduitPanier(final Panier panier, final int idProduit);

    /**
     * Méthode permettant de diminuer la quantité d'un produit dans le panier
     * 
     * @param panier qui contient le produit à diminuer
     * @param idProduit du produit à diminuer
     * @return panier mise à jour
     */
    Panier diminuerProduitPanier(final Panier panier, final int idProduit);
    
     /**
     * Permet de calculer la remise sur le panier quand le seuil de 6 articles à 100 euros est atteint
     * 
     * @param panier
     * @return le panier
     */
    Panier remisePanier(final Panier panier);

    /**
     * Permet de valider le panier et de créer la commande associée
     * 
     * @param panier à valider
     * @param achatInfo les infos (userId, adresses)
     * @return la achat, null sinon
     */
    Achat validerPanier(final Panier panier, final AchatInfo achatInfo, final String nom);

    /**
     * Méthode permettant de faire appel à un produit de la couche persistance pour le supprimer du panier
     * 
     * @param panier qui contient les infos des produits à supprimer du panier
     * @param idProduit l'id du produit à supprimer
     * @return un panier si supp OK, sinon null
     */
    Panier deleteProduitPanier(final Panier panier, final int idProduit);

    /**
     * Permet de vider le panier
     * 
     * @param panier à vider
     * @return panier vide
     */
    Panier viderPanierDto(final Panier panier);

}
