/**
 * 
 */
package persistance.achat.beanDo;

import java.util.Date;
import java.util.Set;

/**
 * @author Charline
 *
 */
public class Achat {

    private static int          compteurNumAchat;
    private Integer             idAchat;
    private String              numeroAchat;
    private int                 idUser;
    private String              nom;
    private Date                date_achat;
    private double              montant;
    private String              adresseClient;
    private Set<AchatProduitDo> panierDoSet;

    /**
     * Constructeur par defaut
     */
    public Achat() {
        Achat.compteurNumAchat++;
    }

    public Integer getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(final Integer idAchat) {
        this.idAchat = idAchat;
    }

    public String getNumeroAchat() {
        return numeroAchat;
    }

    public void setNumeroAchat(final String numeroAchat) {
        this.numeroAchat = numeroAchat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(final int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(final Date date_achat) {
        this.date_achat = date_achat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(final double montant) {
        this.montant = montant;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Set<AchatProduitDo> getPanierDoSet() {
        return panierDoSet;
    }

    public void setPanierDoSet(Set<AchatProduitDo> panierDoSet) {
        this.panierDoSet = panierDoSet;
    }

    public static int getCompteurNumAchat() {
        return compteurNumAchat;
    }

    public static void setCompteurNumAchat(final int compteurNumAchat) {
        Achat.compteurNumAchat = compteurNumAchat;
    }
    
    

}
