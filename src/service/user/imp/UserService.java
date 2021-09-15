/**
 * 
 */
package service.user.imp;

import java.util.List;

import application.bean.User;
import persistance.user.beanDo.UserDo;
import persistance.user.dao.imp.UserDao;
import service.user.IUserService;
import service.user.UserMapper;
import util.cryptage.MD5Encryption;

/**
 * @author Charline
 *
 */
public class UserService implements IUserService {

    final UserDao              userDao     = UserDao.getInstance();

    private static UserService userService = null;

    /**
     * Constructeur par defaut
     */
    public UserService() {
        super();
    }

    /**
     * Gestion du singleton
     * 
     * @return
     */
    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    @Override
    public List<User> findAllUser() {
        final List<User> listeUsers = UserMapper.mapToListDto(userDao.findAllUserDo());
        if (!listeUsers.isEmpty()) {
            return listeUsers;
        }
        return null;
    }

    @Override
    public User findUserById(final Integer id) {
        final UserDo userDo = userDao.findUserDoById(id);
        return UserMapper.mapToDto(userDo);
    }

    @Override
    public User createUser(final User user) {
    
        final UserDo userDo = UserMapper.mapToDto(user);
        final User newUser = UserMapper.mapToDto(userDao.createUserDo(userDo));
        return newUser;
    }

    @Override
    public boolean updateUser(final User user) {
        final UserDo userDo = UserMapper.mapToDto(user);
        boolean resultat = userDao.updateUserDo(user.getId(), userDo);
        return resultat;

    }

    @Override
    public boolean deleteUSer(final Integer id) {
        boolean resultal = userDao.deleteUserDo(id);
        return resultal;
    }

    @Override
    public User findUserDoForConnexion(final String email,final  String motDePasse) {
        final User user = UserMapper.mapToDto(userDao.findUserDoForConnexion(email, motDePasse));
        return user;
    }

}
