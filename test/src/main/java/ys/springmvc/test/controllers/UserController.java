package ys.springmvc.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ys.springmvc.test.model.User;
import ys.springmvc.test.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created with by shuangyao on 2016/8/17.
 */
@Controller
@RequestMapping(value = "user")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public void getById(@RequestParam(value = "id", required = true) int id,
                          OutputStream outputStream){
        try {
            User user = userService.getById(id);
            if (user == null){
                outputStream.write("Empty".getBytes());
            }else {
                outputStream.write(user.toString().getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
