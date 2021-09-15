/**
 * 
 */
package application.bean;

import java.util.Date;
import java.util.Map;

import application.bean.Panier.QuantitePrix;

/**
 * @author Charline
 *
 */
public class AchatDto {

    private Integer                    idAchat;
    private String                     numeroAchat;
    private int                        idUser;
    private String                     nom;
    private Date                       date_achat;
    private double                     montant;
    private String                     adresseClient;
    private Map<Produit, QuantitePrix> mesAchats;

    /**
     * Constructeur par defaut
     */
    public AchatDto() {
        super();
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

    public void setAdresseClient(final String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Map<Produit, QuantitePrix> getMesAchats() {
        return mesAchats;
    }

    public void setMesAchats(final Map<Produit, QuantitePrix> mesAchats) {
        this.mesAchats = mesAchats;
    }

}
