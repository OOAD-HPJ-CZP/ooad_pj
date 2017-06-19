package ooad.service;

import ooad.entity.User;

import java.util.List;

/**
 * Created by admin on 2017/6/14.
 */

public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsernames();
}
