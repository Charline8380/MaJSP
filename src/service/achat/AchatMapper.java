/**
 * 
 */
package service.achat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import application.bean.AchatDto;
import application.bean.Produit;
import application.bean.User;
import application.bean.Panier.QuantitePrix;
import persistance.achat.beanDo.Achat;
import persistance.user.beanDo.UserDo;

/**
 * @author Charline
 *
 */
public class AchatMapper {
    

    /**
     * Constructeur
     */
    public AchatMapper() {
        super();
    }
    
    private Integer                    idAchat;
    private String                     numeroAchat;
    private int                        idUser;
    private String                     nom;
    private Date                       date_achat;
    private double                     montant;
    private String                     adresseClient;
    private Map<Produit, QuantitePrix> mesAchats;

    /**
     * Permet de mapper un AchatDto en achat
     * 
     * @param achatDto
     * @return achat
     */
    public static Achat mapToDto(final AchatDto achatDto) {
        final Achat achatDo = new Achat();
        achatDo.setIdAchat(achatDto.getIdAchat());
        //...
        return achatDo;
    }

    /**
     * Permet de mapper un userDo en user
     * 
     * @param userDo
     * @return un user
     */
    public static AchatDto mapToDto(final Achat achatDo) {
        final AchatDto achatDto = new AchatDto();
        achatDto.setIdAchat(achatDo.getIdAchat());
       //...
        return achatDto;
    }

    /**
     * Permet de mapper une liste de userDo en liste de user
     * 
     * @param listeUserDo
     * @return listeUser
     */
    public static List<AchatDto> mapToListDto(final List<Achat> listeAchatDo) {
        final List<AchatDto> listeAchatDto = new ArrayList<>();
        for (final Achat achatDo : listeAchatDo) {
            listeAchatDto.add(mapToDto(achatDo));
        }
        return listeAchatDto;
    }

}
