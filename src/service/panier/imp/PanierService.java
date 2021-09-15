/**
 * 
 */
package service.panier.imp;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import application.bean.AchatInfo;
import application.bean.Panier;
import application.bean.Panier.QuantitePrix;
import application.bean.Produit;
import persistance.achat.beanDo.Achat;
import persistance.achat.beanDo.AchatProduitDo;
import persistance.achat.dao.imp.AchatDao;
import persistance.produitDo.beanDo.ProduitDo;
import service.panier.IPanierService;
import service.produit.imp.ProduitService;
import service.user.imp.UserService;
import util.tools.FormatUtil;

/**
 * @author Charline
 *
 */
public class PanierService implements IPanierService {
    final ProduitService         produitService        = ProduitService.getInstance();
    private static final double  REMISE                = 0.5;
    private static final Integer QUANTITE_AVANT_REMISE = 3;
    private static final double  SEUIL_REMISE          = 50.0;

    private static PanierService panierService         = null;

    public static PanierService getInstance() {
        if (panierService == null) {
            panierService = new PanierService();
        }
        return panierService;
    }

    /**
     * Constructeur par defaut
     */
    public PanierService() {
        super();
    }

    /**
     * Construction de l'objet Achat
     * 
     * @param panier : les infos du panier
     * @param achatInfo
     * @param mapProduitQuantite : les produits vendus correspondants et leur quantité
     * @return achat
     */
    private Achat buildAchat(final Panier panier, final AchatInfo achatInfo, final Map<ProduitDo, Integer> mapProduitQuantite) {
        final Achat achat = new Achat();
        achat.setAdresseClient(achatInfo.getAdresseUser());

        // récupération de l'idUser
        final int idUser = Integer.valueOf(achatInfo.getUserId());
        achat.setIdUser(idUser);

        //défini N°Achat (pour l'instant en dur)
        achat.setNumeroAchat(FormatUtil.convertirEntierToString(Achat.getCompteurNumAchat()));

        //renseignement du nom
        final UserService userService = UserService.getInstance();
        //on recupère le nom de l'utilisateur
        final String nomUtilisateur = userService.findUserById(idUser).getNom();
        achat.setNom(nomUtilisateur);

        //date Achat
        achat.setDate_achat(new Date());
        //montant achat
        achat.setMontant(FormatUtil.convertirStringToDouble(panier.getTotalApresRemise()));

        // construction du Set AchatProduitDo
        final Set<AchatProduitDo> setAchatProduitDo = new HashSet<>();
        for (final Map.Entry<ProduitDo, Integer> entry : mapProduitQuantite.entrySet()) {
            final AchatProduitDo achatProduitDo = new AchatProduitDo();
            achatProduitDo.setAchat(achat);
            achatProduitDo.setProduitDo(entry.getKey());
            achatProduitDo.setQuantite(entry.getValue());
            setAchatProduitDo.add(achatProduitDo);
        }
        achat.setPanierDoSet(setAchatProduitDo);
        return achat;
    }

    @Override
    public Panier addProduitPanier(final Panier panier, final int idProduit) {

        final Produit produit = produitService.findProduitById(idProduit);

        // on met à jour la map
        // on récupère la quantité et le prix pour 1 produit dans le panier
        Panier.QuantitePrix quantitePrix = panier.getMapDesProduitsQte().get(produit);
        if (quantitePrix == null) {
            // le produit n'est pas dans le panier
            quantitePrix = new Panier.QuantitePrix().ajouterQuantite(1).updatePrix(produit.getPrix());
            panier.getMapDesProduitsQte().put(produit, quantitePrix);
        } else {
            // on convertit en double pour faire les calculs
            final double prixProduit = FormatUtil.convertirStringToDouble(produit.getPrix());
            final double prixCourant = FormatUtil.convertirStringToDouble(quantitePrix.getPrixParProduit());
            // on calcule le nouveau prix
            final double prixTotal = prixCourant + prixProduit;
            // on met à jour la map en ajoutant 1 à la quantité et le nouveau prix en String
            panier.getMapDesProduitsQte().put(produit, quantitePrix.ajouterQuantite(1).updatePrix(FormatUtil.convertirDoubleToString(prixTotal)));
        }

        // on met à jour les autres attributs du panier
        panier.setQuantiteTotale(panier.getMapDesProduitsQte().size());
        // on convertit pour les calculs
        final double total = FormatUtil.convertirStringToDouble(produit.getPrix());
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panier.getTotalAvantRemise());
        // on met à jour
        panier.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise + total));
        // on calcule la remise
        remisePanier(panier);

        return panier;
    }

    @Override
    public Panier diminuerProduitPanier(final Panier panier, final int idProduit) {
        final Produit produit = produitService.findProduitById(idProduit);

        // on récupère la quantité du produit dans le panier
        final QuantitePrix quantitePrix = panier.getMapDesProduitsQte().get(produit);
        final Integer quantite = quantitePrix.getQuantite();
        if (quantite == 1) {
            // s'il n'y a qu'un produit dans le panier, on enleve le produit de la map
            panier.getMapDesProduitsQte().remove(produit);
        } else {
            // on convertit en double pour faire les calculs
            final double prixProduit = FormatUtil.convertirStringToDouble(produit.getPrix());
            final double prixCourant = FormatUtil.convertirStringToDouble(quantitePrix.getPrixParProduit());
            // on calcule le nouveau prix
            final double prixTotal = prixCourant - prixProduit;
            // on met à jour la map en ajoutant 1 à la quantité et le nouveau prix en String
            panier.getMapDesProduitsQte().put(produit, quantitePrix.ajouterQuantite(-1).updatePrix(FormatUtil.convertirDoubleToString(prixTotal)));
        }

        // on met à jour les autres attributs du panier
        panier.setQuantiteTotale(panier.getMapDesProduitsQte().size());
        // on convertit pour les calculs
        final double total = FormatUtil.convertirStringToDouble(produit.getPrix());
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panier.getTotalAvantRemise());
        // on met à jour
        panier.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - total));
        // on calcule la remise
        remisePanier(panier);

        return panier;
    }

    @Override
    public Panier remisePanier(final Panier panier) {
        // on convertit
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panier.getTotalAvantRemise());
        double totalApresRemise = 0;
        if (panier.getQuantiteTotale() > QUANTITE_AVANT_REMISE && totalAvtRemise >= SEUIL_REMISE) {
            // on calcule le total après la remise
            panier.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise * REMISE));
            // on calcule la remise
            totalApresRemise = FormatUtil.convertirStringToDouble(panier.getTotalApresRemise());
            panier.setRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - totalApresRemise));
            return panier;
        } else {
            panier.setRemise(FormatUtil.convertirDoubleToString(0.00));
            // on calcule le total après la remise
            panier.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise));
        }

        return panier;
    }

    @Override
    public Achat validerPanier(final Panier panier, final AchatInfo achatInfo, final String nom) {

        //construction de la mapProduitQuantite
        final Map<ProduitDo, Integer> mapProduitQuantite = produitService.buildMapProduitQuantite(panier);

        // construction de la Achat
        final Achat achat = buildAchat(panier, achatInfo, mapProduitQuantite);

        achat.setNom(nom);
        achat.setNumeroAchat("2020");
        // persistance
        final AchatDao achatDao = AchatDao.getInstance();
        return achatDao.createAchat(achat);

    }

    @Override
    public Panier deleteProduitPanier(final Panier panier, final int idProduit) {
        final ProduitService produitService = ProduitService.getInstance();

        // Récupération de du produit grâce à son Id
        final Produit produit = produitService.findProduitById(idProduit);

        //Récupération "QuantitéPrix" dans la map 
        final QuantitePrix quantitePrix = panier.getMapDesProduitsQte().get(produit);

        //Récupération de la quantité de produit dans "QuantitéPrix (classe)" 
        final int quantite = quantitePrix.getQuantite();

        //Suppression du produit de la map
        panier.getMapDesProduitsQte().remove(produit, quantitePrix);

        // Je màj la quantiteTotale 
        panier.setQuantiteTotale(panier.getMapDesProduitsQte().size());

        // Déduction du produit (quantité*prix) du TotalAVantRemise
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panier.getTotalAvantRemise());
        final double total = FormatUtil.convertirStringToDouble(produit.getPrix()) * quantite;

        panier.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - total));

        // on calcule la remise
        remisePanier(panier);
        return panier;
    }

    @Override
    public Panier viderPanierDto(final Panier panier) {
        panier.setQuantiteTotale(0);
        panier.setTotalAvantRemise("0,00");
        panier.setRemise("0,00");
        panier.setTotalApresRemise("0,00");
        panier.getMapDesProduitsQte().clear();
        return panier;
    }

}
