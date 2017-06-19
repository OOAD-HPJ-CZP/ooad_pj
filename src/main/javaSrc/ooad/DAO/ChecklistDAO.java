package ooad.DAO;

import ooad.DAO.interfaces.IChecklistDAO;
import ooad.entity.Checklist;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/6/19.
 */
@Repository
public class ChecklistDAO extends BaseDAO<Checklist> implements IChecklistDAO {
}
