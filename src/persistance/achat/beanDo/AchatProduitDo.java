package persistance.achat.beanDo;

import persistance.produitDo.beanDo.ProduitDo;

/**
 * Representation d'un panier en BDD
 * 
 * @author Charline
 *
 */
public class AchatProduitDo {

    private Integer   idAchatProduit;
    private Achat     achat;
    private ProduitDo produitDo;
    private Integer   quantite;

    /**
     * Constructeur par defaut
     */
    public AchatProduitDo() {
        super();
    }

    public Integer getIdAchatProduit() {
        return idAchatProduit;
    }

    public void setIdAchatProduit(final Integer idAchatProduit) {
        this.idAchatProduit = idAchatProduit;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(final Achat achat) {
        this.achat = achat;
    }

    public ProduitDo getProduitDo() {
        return produitDo;
    }

    public void setProduitDo(final ProduitDo produitDo) {
        this.produitDo = produitDo;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(final Integer quantite) {
        this.quantite = quantite;
    }

}
