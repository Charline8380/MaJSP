/**
 * 
 */
package persistance.achat.dao.imp;

import java.util.List;

import persistance.achat.beanDo.Achat;
import persistance.achat.dao.IAchatDao;

/**
 * @author Charline
 *
 */
public class AchatDao implements IAchatDao {

    private static AchatDao achatDao = null;

    /**
     * 
     */
    public AchatDao() {
        // TODO Auto-generated constructor stub
    }

    public static AchatDao getInstance() {
        if (achatDao == null) {
            achatDao = new AchatDao();
        }
        return achatDao;

    }

    @Override
    public List<Achat> findAllAchat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Achat findAchatById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateAchat(Achat newAchat) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Achat createAchat(Achat achat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

}
