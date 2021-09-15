/**
 * 
 */
package persistance.user.beanDo;

/**
 * @author Charline
 *
 */
public class UserDo {

    private Integer id;
    private String  nom;
    private String  prenom;
    private String  adresse;
    private String  email;
    private String  motDePasse;

    /**
     * Constructeur par defaut
     */
    public UserDo() {
        super();
    }

    /**
     * Constructeur avec mail et mot de passe
     * 
     * @param email
     * @param motDePasse
     */
    public UserDo(final String email, final String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    /**
     * Builder UserDo
     * 
     * @param id
     * @param nom
     * @param prenom
     * @param adresse
     * @param email
     * @param motDePasse
     */
    public UserDo buildUserDo(final Integer id, final String nom, final String prenom, final String adresse, final String email, final String motDePasse) {
        final UserDo userDo = new UserDo();
        userDo.setId(id);
        userDo.setNom(prenom);
        userDo.setPrenom(prenom);
        userDo.setAdresse(adresse);
        userDo.setEmail(email);
        userDo.setMotDePasse(motDePasse);

        return userDo;

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
