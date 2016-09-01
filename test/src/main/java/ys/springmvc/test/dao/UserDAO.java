package ys.springmvc.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ys.springmvc.test.model.User;
import ys.springmvc.test.utils.ModelUtil;

/**
 * Created with by shuangyao on 2016/8/17.
 */
@Component
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user){
        String sql = "insert into user(uname, age, birthday) values(" +
                user.getUname() + ", " + user.getAge() + ", " +
                user.getBirthday() + ")";
        jdbcTemplate.update(sql);
    }

    @Transactional(rollbackFor = Exception.class)
    public User getById(int id) throws Exception{
        String sql = "select * from user where id = " + id;
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        return ModelUtil.getUser(sqlRowSet);
    }

}
