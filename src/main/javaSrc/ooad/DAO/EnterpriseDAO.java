package ooad.DAO;

import ooad.DAO.interfaces.IEnterpriseDAO;
import ooad.entity.Enterprise;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/6/19.
 */
@Repository
public class EnterpriseDAO extends BaseDAO<Enterprise> implements IEnterpriseDAO {
}
