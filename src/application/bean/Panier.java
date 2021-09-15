/**
 * 
 */
package application.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Charline
 *
 */
public class Panier {

    private Integer                    quantiteTotale    = 0;
    private String                     totalAvantRemise  = "0,00";
    private String                     remise            = "0,00";
    private String                     totalApresRemise  = "0,00";

    //map de produit par rapport à leur qté et leur prix
    private Map<Produit, QuantitePrix> mapDesProduitsQte = new HashMap<>();

    /**
     * Constructeur par defaut
     */
    public Panier() {
        // TODO Auto-generated constructor stub
    }

    public Integer getQuantiteTotale() {
        return quantiteTotale;
    }

    public void setQuantiteTotale(Integer quantiteTotale) {
        this.quantiteTotale = quantiteTotale;
    }

    public String getTotalAvantRemise() {
        return totalAvantRemise;
    }

    public void setTotalAvantRemise(String totalAvantRemise) {
        this.totalAvantRemise = totalAvantRemise;
    }

    public String getRemise() {
        return remise;
    }

    public void setRemise(String remise) {
        this.remise = remise;
    }

    public String getTotalApresRemise() {
        return totalApresRemise;
    }

    public void setTotalApresRemise(String totalApresRemise) {
        this.totalApresRemise = totalApresRemise;
    }

    public Map<Produit, QuantitePrix> getMapDesProduitsQte() {
        return mapDesProduitsQte;
    }

    public void setMapDesProduitsQte(Map<Produit, QuantitePrix> mapDesProduitsQte) {
        this.mapDesProduitsQte = mapDesProduitsQte;
    }

    /**
     * Classe interne pour la quantite et le prix d'un produit
     * 
     * @author Administrateur
     *
     */
    public static class QuantitePrix {

        private Integer quantite       = 0;
        private String  prixParProduit = "";

        /**
         * Permet de mettre à jour la quantite
         * 
         * @param quantite
         * @return
         */
        public QuantitePrix ajouterQuantite(final int quantite) {
            this.quantite += quantite;
            return this;
        }

        /**
         * Permet de mettre à jour le prix
         * 
         * @param prix
         * @return
         */
        public QuantitePrix updatePrix(final String prix) {
            this.prixParProduit = prix;
            return this;
        }

        /**
         * @return the quantite
         */
        public Integer getQuantite() {
            return quantite;
        }

        /**
         * @param quantite the quantite to set
         */
        public void setQuantite(final Integer quantite) {
            this.quantite = quantite;
        }

        /**
         * @return the prixParProduit
         */
        public String getPrixParProduit() {
            return prixParProduit;
        }

        /**
         * @param prixParProduit the prixParProduit to set
         */
        public void setPrixParProduit(final String prixParProduit) {
            this.prixParProduit = prixParProduit;
        }

    }

}
