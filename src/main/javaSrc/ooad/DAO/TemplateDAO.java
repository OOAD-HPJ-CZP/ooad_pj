package ooad.DAO;

import ooad.DAO.interfaces.ITemplateDAO;
import ooad.entity.Template;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/6/19.
 */
@Repository
public class TemplateDAO extends BaseDAO<Template> implements ITemplateDAO{
}
