/**
 * 
 */
package application.bean;

/**
 * @author Charline
 *
 */
public class Produit {

    private Integer idProduit;
    private String  designation;
    private String  categorie;
    private String  prix;
    private String  description;
    private String  lienImage;

    /**
     * Constructeur par defaut
     */
    public Produit() {
        super();
    }
    
    

    /**
     * @param designation
     * @param categorie
     * @param prix
     * @param description
     * @param lienImage
     */
    public Produit(final String designation,final String categorie, final String prix, final String description,final String lienImage) {
        super();
        this.designation = designation;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.lienImage = lienImage;
    }



    /**
     * builder de produit
     * 
     * @param idProduit
     * @param designation
     * @param categorie
     * @param prix
     * @param description
     * @param lienImage
     */
    public static Produit buildProduit(final Integer idProduit, final String designation, final String categorie, final String prix, final String description, final String lienImage) {
        final Produit produit = new Produit();
        produit.setIdProduit(idProduit);
        produit.setDesignation(designation);
        produit.setCategorie(categorie);
        produit.setPrix(prix);
        produit.setDescription(description);
        produit.setLienImage(lienImage);
        return produit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(final Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(final String categorie) {
        this.categorie = categorie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(final String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(final String lienImage) {
        this.lienImage = lienImage;
    }

}
