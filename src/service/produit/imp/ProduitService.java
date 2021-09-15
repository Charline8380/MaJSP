/**
 * 
 */
package service.produit.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import application.bean.Panier;
import application.bean.Panier.QuantitePrix;
import application.bean.Produit;
import persistance.produitDo.beanDo.ProduitDo;
import persistance.produitDo.dao.imp.ProduitDao;
import service.produit.IProduitService;
import service.produit.ProduitMapper;

/**
 * @author Charline
 *
 */
public class ProduitService implements IProduitService {

    final ProduitDao              produitDao     = ProduitDao.getInstance();
    private static ProduitService produitService = null;

    /**
     * Constructeur par defaut
     */
    public ProduitService() {
        super();
    }

    /**
     * Gestion du Singleton
     * 
     * @return produitService l'instance singleton
     */
    public static ProduitService getInstance() {
        if (produitService == null) {
            produitService = new ProduitService();
        }
        return produitService;
    }

    @Override
    public List<Produit> findAllProduit() {
        //acces à la couche persistance
        final List<Produit> listeProduit = ProduitMapper.mapToListDto(produitDao.findAllProduitDo());
        if (!listeProduit.isEmpty()) {
            return listeProduit;
        }
        return null;
    }

    @Override
    public Produit findProduitById(final Integer id) {
        final Produit produit = ProduitMapper.mapProduitDoToDto(produitDao.findProduitDoById(id));
        if (produit != null) {
            return produit;
        }
        return null;
    }

    @Override
    public boolean updateProduit(final Produit newProduit) {
        final ProduitDo produitDo = ProduitMapper.mapProduitToProduitDo(newProduit);
        boolean resultat = produitDao.updateProduitDo(newProduit.getIdProduit(), produitDo);
        return resultat;
    }

    @Override
    public Produit createProduit(final Produit produit) {
        final ProduitDo produitDo = ProduitMapper.mapProduitToProduitDo(produit);
        final Produit newProduit = ProduitMapper.mapProduitDoToDto(produitDao.createProduitDo(produitDo));
        return newProduit;

    }

    @Override
    public boolean delete(final Integer id) {
        boolean resultat = produitDao.delete(id);
        return resultat;
    }

    /**
     * Permet de construire la map mapProduitQuantite
     * 
     * @param panier
     * @return
     */
    public Map<ProduitDo, Integer> buildMapProduitQuantite(final Panier panier) {
        //declaration mapProduitVenduQuantite
        final Map<ProduitDo, Integer> mapProduitQuantite = new HashMap<>();

        //acces à la couche persistance
        final ProduitDao produitDao = (ProduitDao) ProduitDao.getInstance();

        for (final Entry<Produit, QuantitePrix> entry : panier.getMapDesProduitsQte().entrySet()) {

            System.out.println("key : " + entry.getKey().getDesignation() + " Value : " + entry.getValue().toString());
            //instancier la clé 
            final Produit produit = entry.getKey();

            // recherche d'un produit correspondant à notre produit courant
            ProduitDo produitDo = produitDao.findProduitDoById(produit.getIdProduit());
            if (produitDo == null) {
                //Si produitVenduDo n'existe pas on le crée
                // Mapping du produit en produitDo
                produitDo = ProduitMapper.mapProduitToProduitDo(produit);
            }

            final QuantitePrix quantitePrix = entry.getValue();
            //j'ajoute le produitVenduDo à la mapProduitVenduQuantite
            mapProduitQuantite.put(produitDo, quantitePrix.getQuantite());
        }
        for (final Entry<ProduitDo, Integer> couple : mapProduitQuantite.entrySet()) {
            System.out.println("key : " + couple.getKey().getDesignation() + " Value : " + couple.getValue().toString());
        }
        return mapProduitQuantite;
    }

}
