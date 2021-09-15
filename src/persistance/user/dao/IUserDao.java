/**
 * 
 */
package persistance.user.dao;

import java.util.List;

import persistance.user.beanDo.UserDo;

/**
 * @author Charline
 *
 */
public interface IUserDao {
    /**
     * Permet de rechercher un UserDo à partir de son mail et de son password
     * 
     * @param mail
     * @param password
     * @return user rechérché, null si non trouvé
     */
    UserDo findUserDoForConnexion(final String mail, final String password);

    /**
     * permet de rechercher tous les UserDo stockés en BDD
     * 
     * @return la liste des users par ordre alphabétique
     */
    List<UserDo> findAllUserDo();

    /**
     * Permet de rechercher un UserDo en BDD à partir de son id
     * 
     * @param id
     * @return un UserDo s'il existe sinon null
     */
    UserDo findUserDoById(final Integer id);


    /**
     * Permet de faire appel à la couche persistance afin de créer un UserDo en BDD
     * 
     * @param userDo
     * @return le UserDo crée
     */
    UserDo createUserDo(final UserDo userDo);

    /**
     * Permet de supprimer un UserDo
     * 
     * @param UserDo
     * @return
     */
    boolean updateUserDo(final Integer idUser,final UserDo userDo);

    /**
     * @param id
     * @return
     */
    boolean deleteUserDo(final Integer id);
}
