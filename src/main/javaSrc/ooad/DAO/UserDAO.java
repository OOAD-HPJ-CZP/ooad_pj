package ooad.DAO;

import ooad.DAO.interfaces.IUserDAO;
import ooad.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/6/14.
 */
@Repository
public class UserDAO extends BaseDAO<User> implements IUserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public User queryByUsername(String username) {
        String hql = "from User u where u.username=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setString(0,username);
        return (User) query.uniqueResult();
    }
}
