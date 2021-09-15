/**
 * 
 */
package service.user;

import java.util.List;

import application.bean.User;

/**
 * @author Charline
 *
 */
public interface IUserService {

    /**
     * Permet de recupérer la liste des users
     * 
     * @return la liste de user
     */
    List<User> findAllUser();

    /**
     * Permet de chercher un user à partir de son Id
     * 
     * @param id
     * @return user trouvé
     */
    User findUserById(final Integer id);

    /**
     * Permet de creer un nouveau user
     * 
     * @param user à créer
     */
    User createUser(final User user);

    /**
     * Permet de mettre à jour un user
     * 
     * @param user
     * @return true si ok sinon false
     */
    boolean updateUser(final User user);

    /**
     * Permet de supprimer un user
     * 
     * @param id
     * @return true si ok sinon false
     */
    boolean deleteUSer(final Integer id);
    
    /**
     * Permet de chercher un User à partir de son mail et son mot de passe
     * @param email
     * @param motDePasse
     * @return
     */
    User findUserDoForConnexion(final String email, final String motDePasse);
}
