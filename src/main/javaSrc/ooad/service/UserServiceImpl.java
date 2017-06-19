package ooad.service;

import ooad.DAO.interfaces.IUserDAO;
import ooad.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/6/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private IUserDAO userDao;

    public void saveUsers(List<User> us) {
        for (User u : us) {
            userDao.insert(u);
        }
    }
    public List<User> getAllUsernames() {
        return userDao.queryAll();
    }

}
