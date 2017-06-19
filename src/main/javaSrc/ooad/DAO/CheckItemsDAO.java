package ooad.DAO;

import ooad.DAO.interfaces.ICheckItemsDAO;
import ooad.entity.Checkitems;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/6/19.
 */
@Repository("checkItemsDAO")
public class CheckItemsDAO extends BaseDAO<Checkitems> implements ICheckItemsDAO {
}
