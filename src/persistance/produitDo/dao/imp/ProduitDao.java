package persistance.produitDo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistance.factoryBdd.ConnexionFactory;
import persistance.produitDo.beanDo.ProduitDo;
import persistance.produitDo.dao.IProduitDao;

public class ProduitDao implements IProduitDao {

    private static ProduitDao produitDao = null;

    /**
     * Gestion du Singleton
     * 
     * @return
     */
    public static ProduitDao getInstance() {

        if (produitDao == null) {
            produitDao = new ProduitDao();
        }
        return produitDao;
    }

    /**
     * Constructeur par defaut
     */
    public ProduitDao() {
        super();
    }

    /**
     * Permet de mapper un resulSet en produitDo
     * 
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private ProduitDo mapToProduitDo(final ResultSet resultSet) throws SQLException {
        final ProduitDo produitDo = new ProduitDo();
        produitDo.setIdProduit(resultSet.getInt(1));
        produitDo.setDesignation(resultSet.getString(2));
        produitDo.setCategorie(resultSet.getString(3));
        produitDo.setPrix(resultSet.getDouble(4));
        produitDo.setDescription(resultSet.getString(5));
        produitDo.setLienImage(resultSet.getString(6));
        return produitDo;
    }

    @Override
    public List<ProduitDo> findAllProduitDo() {
        Connection connection = ConnexionFactory.getConnection();
        final String requete = "select id_produit, designation, categorie, prix, description, lien_image  from produit";
        final List<ProduitDo> listeProduits = new ArrayList<>();

        try (final PreparedStatement preparedStatement = connection.prepareStatement(requete);
             final ResultSet resultSet = preparedStatement.executeQuery()) {

            // on mappe les resultats
            while (resultSet.next()) {
                final ProduitDo produitDo = mapToProduitDo(resultSet);
                listeProduits.add(produitDo);
            }
            return listeProduits;

        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public ProduitDo findProduitDoById(final Integer id) {
        Connection connection = ConnexionFactory.getConnection();
        final String requete = "select id_produit, designation, categorie, prix, description, lien_image  from produit where id_produit = ? ";
        final PreparedStatement preparedStatement;
        final ResultSet resultSet;
        ProduitDo produitDo = null;

        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produitDo = mapToProduitDo(resultSet);
                return produitDo;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateProduitDo(final Integer idProduit, final ProduitDo produitDo) {
        Connection connection = ConnexionFactory.getConnection();
        final String query = "update produit set designation=?, categorie=?, prix=?, description=?, lien_image=? where id_produit = ?";

        try (final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, produitDo.getDesignation());
            preparedStatement.setString(2, produitDo.getCategorie());
            preparedStatement.setDouble(3, produitDo.getPrix());
            preparedStatement.setString(4, produitDo.getDescription());
            preparedStatement.setString(5, produitDo.getLienImage());
            preparedStatement.setInt(6, idProduit);

            final int result = preparedStatement.executeUpdate();

            produitDo.setIdProduit(idProduit);

            // on n'attend qu'un seul résultat
            return result == 1;
        } catch (final SQLException sqlExcpetion) {
            sqlExcpetion.printStackTrace();
        }
        return false;
    }

    @Override
    public ProduitDo createProduitDo(final ProduitDo produitDo) {
        Connection connection = ConnexionFactory.getConnection();
        final String sqlQuery = "INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES(?,?,?,?,?);select currval('produit_id_produit_seq');";
        final PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, produitDo.getDesignation());
            preparedStatement.setString(2, produitDo.getCategorie());
            preparedStatement.setDouble(3, produitDo.getPrix());
            preparedStatement.setString(4, produitDo.getDescription());
            preparedStatement.setString(5, produitDo.getLienImage());

            preparedStatement.execute();

            int nInserted = preparedStatement.getUpdateCount();
            if (nInserted == 1 && preparedStatement.getMoreResults()) {
                ResultSet rs = preparedStatement.getResultSet();
                final ProduitDo newProduitDo = new ProduitDo();
                if (rs.next()) {
                    newProduitDo.setIdProduit(rs.getInt(1));
                    newProduitDo.buildProduitDo(rs.getInt(1), produitDo.getDesignation(), produitDo.getCategorie(), produitDo.getPrix(), produitDo.getDescription(), produitDo.getLienImage());
                }
                return newProduitDo;
            }

        } catch (final SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Connection connection = ConnexionFactory.getConnection();
        final String sqlQuery = "delete from produit where id_produit = ?";

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
