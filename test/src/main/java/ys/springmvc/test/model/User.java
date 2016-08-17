package ys.springmvc.test.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with by shuangyao on 2016/8/17.
 */
public class User implements Serializable{

    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public static User getUser(SqlRowSet sqlRowSet) throws Exception{
        if (sqlRowSet == null){
            return null;
        }

        while (sqlRowSet.next()){
            User user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setName(sqlRowSet.getString("name"));
            user.setAge(sqlRowSet.getInt("age"));
            user.setBirthday(sqlRowSet.getDate("birthday"));
            return user;
        }

        return null;
    }
}
