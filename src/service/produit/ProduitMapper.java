package service.produit;

import java.util.ArrayList;
import java.util.List;

import application.bean.Produit;
import persistance.produitDo.beanDo.ProduitDo;
import util.tools.FormatUtil;

/**
 * Mapper un produitDo en produitDto
 * 
 * @author Nora LIFERKI
 *
 */
public class ProduitMapper {

    /**
     * Permet de mapper un ProduitDo en Produit
     * 
     * @param produitDo
     * @return produitDto
     */
    public static Produit mapToDto(final ProduitDo produitDo) {

        final String prixDto = FormatUtil.convertirDoubleToString(produitDo.getPrix());
        return Produit.buildProduit(produitDo.getIdProduit(), produitDo.getDesignation(), produitDo.getCategorie(), prixDto, produitDo.getDescription(), produitDo.getLienImage());
    }

    /**
     * Permet de mapper un Produit en ProduitDo
     * 
     * @param produitDto
     * @return produitDo
     */
    public static ProduitDo mapToDo(final Produit produit) {
        final ProduitDo produitDo = new ProduitDo();
        final Double prixDo = FormatUtil.convertirStringToDouble(produit.getPrix());
        return produitDo.buildProduitDo(produit.getIdProduit(), produit.getDesignation(), produit.getCategorie(), prixDo, produit.getDescription(), produit.getLienImage());
    }

    /**
     * Permet de mapper une liste de ProduitDo en liste de ProduitDto
     * 
     * @param listeProduitDo
     * @return listeProduitDto
     */
    public static List<Produit> mapToListDto(final List<ProduitDo> listeProduitDo) {
        final List<Produit> listeProduit = new ArrayList<>();
        for (final ProduitDo produitDo : listeProduitDo) {
            listeProduit.add(mapToDto(produitDo));
        }
        return listeProduit;
    }

    /**
     * Permet de mapper un Produit en ProduitDo
     * 
     * @param produit
     * @return le produitDo
     */
    public static ProduitDo mapProduitToProduitDo(final Produit produit) {
        final ProduitDo produitDo = new ProduitDo();
        produitDo.setIdProduit(produit.getIdProduit());
        produitDo.setDesignation(produit.getDesignation());
        produitDo.setCategorie(produit.getCategorie());
        produitDo.setPrix(FormatUtil.convertirStringToDouble(produit.getPrix()));
        produitDo.setDescription(produit.getDescription());;
        produitDo.setLienImage(produit.getLienImage());
        return produitDo;
    }
    

    /**
     * Permet de mapper un produitDo en produit
     * 
     * @param produitDo
     * @return produit
     */
    public static Produit mapProduitDoToDto(final ProduitDo produitDo) {
        final Produit produit = new Produit();
        produit.setIdProduit(produitDo.getIdProduit());
        produit.setDesignation(produitDo.getDesignation());
        produit.setCategorie(produitDo.getCategorie());
        produit.setPrix(FormatUtil.convertirDoubleToString(produitDo.getPrix()));
        produit.setDescription(produitDo.getDescription());
        produit.setLienImage(produitDo.getLienImage());
        return produit;
    }
}
