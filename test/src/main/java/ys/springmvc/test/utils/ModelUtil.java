package ys.springmvc.test.utils;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import ys.springmvc.test.model.User;

import java.text.SimpleDateFormat;

/**
 * Created with by shuangyao on 2016/9/1.
 */
public class ModelUtil {

    public static User getUser(SqlRowSet sqlRowSet) throws Exception{
        if (sqlRowSet == null){
            return null;
        }

        while (sqlRowSet.next()){
            User user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setUname(sqlRowSet.getString("uname"));
            user.setAge(sqlRowSet.getInt("age"));

            String time = sqlRowSet.getString("birthday");
            if (time != null && time.matches("[0-9]{4}([-][0-9]{2}){2}")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthday(format.parse(time));
            }
            return user;
        }

        return null;
    }
}
