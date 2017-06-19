package ooad.DAO.interfaces;

import ooad.entity.User;

/**
 * Created by admin on 2017/6/14.
 */
public interface IUserDAO extends IBaseDAO<User> {
    public User queryByUsername(String username);
}
