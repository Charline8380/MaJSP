/**
 * 
 */
package persistance.user.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistance.factoryBdd.ConnexionFactory;
import persistance.user.beanDo.UserDo;
import persistance.user.dao.IUserDao;

/**
 * @author Charline
 *
 */
public class UserDao implements IUserDao {
    private static Connection connection;
    private static UserDao    userDao = null;

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    /**
     * 
     */
    public UserDao() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Permet de mapper un resulSet en userDo
     * 
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private UserDo mapToUserDo(final ResultSet resultSet) throws SQLException {
        if (resultSet==null) {
            return null;
        }
        final UserDo userDo = new UserDo();
        userDo.setId(resultSet.getInt(1));
        userDo.setNom(resultSet.getString(2));
        userDo.setPrenom(resultSet.getString(3));
        userDo.setAdresse(resultSet.getString(4));
        userDo.setEmail(resultSet.getString(5));
        userDo.setMotDePasse(resultSet.getString(6));

        System.out.println(userDo);
        return userDo;
    }

    @Override
    public UserDo findUserDoForConnexion(final String mail, final String password) {
        connection = ConnexionFactory.getConnection();
        final String requete = "select id_utilisateur, nom, prenom, adresse, email, mot_de_passe  from utilisateur where email = ? and mot_de_passe = ?  ";
        final PreparedStatement preparedStatement;
        final ResultSet resultSet;
        UserDo userDo = null;

        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userDo = mapToUserDo(resultSet);
                return userDo;
            }
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public List<UserDo> findAllUserDo() {
        final Connection connection = ConnexionFactory.getConnection();
        final String requete = "select id_utilisateur, nom, prenom, adresse, email, mot_de_passe  from utilisateur";
        final List<UserDo> listeUser = new ArrayList<>();

        try (final PreparedStatement preparedStatement = connection.prepareStatement(requete);
             final ResultSet resultSet = preparedStatement.executeQuery()) {

            // on mappe les resultats
            while (resultSet.next()) {
                final UserDo userDo = mapToUserDo(resultSet);
                listeUser.add(userDo);
            }
            return listeUser;

        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDo findUserDoById(final Integer id) {
        connection = ConnexionFactory.getConnection();
        final String requete = "select id_utilisateur, nom, prenom, adresse, email, mot_de_passe  from utilisateur where id_utilisateur = ? ";
        final PreparedStatement preparedStatement;
        final ResultSet resultSet;
        UserDo userDo = null;

        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                userDo = mapToUserDo(resultSet);
                return userDo;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UserDo createUserDo(final UserDo userDo) {
        connection = ConnexionFactory.getConnection();
        final String query = "insert into utilisateur ( nom, prenom, adresse, email, mot_de_passe) VALUES(?,?,?,?,?); select currval('utilisateur_id_utilisateur_seq');";
        final PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userDo.getNom());
            preparedStatement.setString(2, userDo.getPrenom());
            preparedStatement.setString(3, userDo.getAdresse());
            preparedStatement.setString(4, userDo.getEmail());
            preparedStatement.setString(5, userDo.getMotDePasse());

            System.out.println(preparedStatement.execute());

            int nInserted = preparedStatement.getUpdateCount();
            if (nInserted == 1 && preparedStatement.getMoreResults()) {
                ResultSet rs = preparedStatement.getResultSet();
                final UserDo newUser = new UserDo();
                if (rs.next()) {
                    newUser.setId(rs.getInt(1));
                    newUser.setNom(userDo.getNom());
                    newUser.setPrenom(userDo.getPrenom());
                    newUser.setAdresse(userDo.getAdresse());
                    newUser.setEmail(userDo.getEmail());
                    newUser.setMotDePasse(userDo.getMotDePasse());
                }
                return newUser;
            }

        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUserDo(final Integer idUser, final UserDo userDo) {
        connection = ConnexionFactory.getConnection();
        final String query = "update utilisateur set nom=?, prenom=?, adresse=?, email=?, mot_de_passe? where id_utilisateur = ?";

        try (final PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userDo.getNom());
            preparedStatement.setString(2, userDo.getPrenom());
            preparedStatement.setString(3, userDo.getAdresse());
            preparedStatement.setString(4, userDo.getEmail());
            preparedStatement.setString(5, userDo.getMotDePasse());

            final int result = preparedStatement.executeUpdate();

            userDo.setId(idUser);

            // on n'attend qu'un seul résultat
            return result == 1;
        } catch (final SQLException sqlExcpetion) {
            sqlExcpetion.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserDo(final Integer id) {
        connection = ConnexionFactory.getConnection();
        final String sqlQuery = "delete utilisateur produit where id_utilisateur = ?";

        try (final PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            final int result = preparedStatement.executeUpdate();

            // on n'attend qu'un seul résultat
            return result == 1;
        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

}
