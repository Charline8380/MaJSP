package service.user;

import java.util.ArrayList;
import java.util.List;

import application.bean.User;
import persistance.user.beanDo.UserDo;

/**
 * Mapper Dto/Do bidirectionnel pour un User
 * 
 * @author Administrateur
 *
 */
public class UserMapper {

    /**
     * Permet de mapper un user en userDo
     * 
     * @param user
     * @return userDo
     */
    public static UserDo mapToDto(final User user) {
        final UserDo userDo = new UserDo();
        userDo.setId(user.getId());
        userDo.setNom(user.getNom());
        userDo.setPrenom(user.getPrenom());
        userDo.setAdresse(user.getAdresse());
        userDo.setEmail(user.getEmail());
        userDo.setMotDePasse(user.getMotDePasse());
        return userDo;
    }

    /**
     * Permet de mapper un userDo en user
     * 
     * @param userDo
     * @return un user
     */
    public static User mapToDto(final UserDo userDo) {
        if (userDo == null) {
            return null;
        }
        final User user = new User();
        user.setId(userDo.getId());
        user.setNom(userDo.getNom());
        user.setPrenom(userDo.getPrenom());
        user.setAdresse(userDo.getAdresse());
        user.setEmail(userDo.getEmail());
        user.setMotDePasse(userDo.getMotDePasse());
        return user;
    }

    /**
     * Permet de mapper une liste de userDo en liste de user
     * 
     * @param listeUserDo
     * @return listeUser
     */
    public static List<User> mapToListDto(final List<UserDo> listeUserDo) {
        final List<User> listeUser = new ArrayList<>();
        for (final UserDo userDo : listeUserDo) {
            listeUser.add(mapToDto(userDo));
        }
        return listeUser;
    }

}
