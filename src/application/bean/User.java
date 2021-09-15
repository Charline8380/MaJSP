/**
 * 
 */
package application.bean;

/**
 * @author Charline
 *
 */
public class User {

    private Integer id;
    private String  nom;
    private String  prenom;
    private String  adresse;
    private String  email;
    private String  motDePasse;

    /**
     * Constructeur par defaut
     */
    public User() {
        super();
    }

    /**
     * Constructeur avec field
     * 
     * @param nom
     * @param prenom
     * @param adresse
     * @param email
     * @param motDePasse
     */
    public User(final String nom, final String prenom, final String adresse, final String email, final String motDePasse) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    /**
     * Constructeur avec mail et mot de passe
     * 
     * @param email
     * @param motDePasse
     */
    public User(final String email, final String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", motDePasse=" + motDePasse + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
