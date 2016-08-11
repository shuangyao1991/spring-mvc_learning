package ys.springmvc.controllers;

import org.springframework.web.servlet.mvc.SimpleFormController;
import ys.springmvc.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with by shuangyao on 2016/8/11.
 */
public class RegisterSimpleFormController extends SimpleFormController {

    public RegisterSimpleFormController() {
        setCommandClass(User.class);
        setCommandName("user");
    }

    //提供展示表单时的表单数据
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        User user = new User();
        user.setUserName("请输入用户名");
        return user;
    }

    //提供展示表单时需要的一些其他数据
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("cityList", Arrays.asList("北京", "上海"));
        return map;
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        User user = (User) command;
        System.out.println(user);
    }
}
