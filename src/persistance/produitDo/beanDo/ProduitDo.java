/**
 * 
 */
package persistance.produitDo.beanDo;

/**
 * @author Charline
 *
 */
public class ProduitDo {

    private Integer idProduit;
    private String  designation;
    private String  categorie;
    private double  prix;
    private String  description;
    private String  lienImage;
  

    /**
     * Constructeur par defaut
     */
    public ProduitDo() {
        super();
    }

    /**
     * Builder pour le ProduitDo
     * 
     * @param idProduit
     * @param designation
     * @param categorie
     * @param prix
     * @param description
     * @param lienImage
     */
    public ProduitDo buildProduitDo(final Integer idProduit, final String designation, final String categorie, final double prix, final String description, final String lienImage) {
        final ProduitDo produitDo = new ProduitDo();
        produitDo.setIdProduit(idProduit);
        produitDo.setDesignation(designation);
        produitDo.setCategorie(categorie);
        produitDo.setPrix(prix);
        produitDo.setDescription(description);
        produitDo.setLienImage(lienImage);

        return produitDo;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }


}
