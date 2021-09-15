package persistance.factoryBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author
 *
 */
public class ConnexionFactory {

    private static Connection       connection;

    /**
     * Constructeur par defaut
     */
    public ConnexionFactory() {
        super();
    }

    /**
     * Connexion à la base de données
     * 
     * @return Connection
     */
    public static Connection getConnection() {

        if (ConnexionFactory.connection == null) {
            String url = "jdbc:postgresql://localhost:5432/majsp";
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Pilote chargé");

                Properties props = new Properties();
                props.setProperty("user", "abuwe");
                props.setProperty("password", "8380");
                ConnexionFactory.connection = DriverManager.getConnection(url, props);
                return connection;
            } catch (ClassNotFoundException e) {
                System.out.println("Impossible de se charger le driver");
                System.exit(-1);
            } catch (SQLException e) {
                System.out.println("Impossible de se connecter à l’url : " + url);
                System.exit(-1);
            }

        }

        return connection;
    }

}
