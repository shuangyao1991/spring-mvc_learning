package ys.springmvc.test.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ys.springmvc.test.dao.UserDAO;
import ys.springmvc.test.model.User;
import ys.springmvc.test.service.UserService;

/**
 * Created with by shuangyao on 2016/8/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(User user) {
        if (user == null || StringUtils.isBlank(user.getUname())){
            return;
        }

        userDAO.save(user);
    }

    @Override
    public User getById(int id) {
        try {
            return userDAO.getById(id);
        } catch (Exception e) {
            logger.error("获取用户信息异常！", e);
            return null;
        }
    }
}
