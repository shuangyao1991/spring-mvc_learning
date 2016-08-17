package ys.springmvc.test.service;

import ys.springmvc.test.model.User;

/**
 * Created with by shuangyao on 2016/8/17.
 */
public interface UserService {

    public void save(User user);

    public User getById(int id);
}
