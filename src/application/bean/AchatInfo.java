/**
 * 
 */
package application.bean;

/**
 * @author Charline
 *
 */
public class AchatInfo {

    private String userId;
    private String adresseUser;

    /**
     * Constructeur par defaut
     */
    public AchatInfo() {
        super();
    }
    
    

    /**
     * @param userId
     * @param adresseUser
     */
    public AchatInfo(String userId, String adresseUser) {
        super();
        this.userId = userId;
        this.adresseUser = adresseUser;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getAdresseUser() {
        return adresseUser;
    }

    public void setAdresseUser(final String adresseUser) {
        this.adresseUser = adresseUser;
    }

}
