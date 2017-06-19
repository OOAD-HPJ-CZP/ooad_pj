package ooad.DAO;

import ooad.entity.User;

import java.util.List;

/**
 * Created by admin on 2017/6/14.
 */
public interface UserDAO {
    public int save(User u);
    public List<User> findAll();
}
