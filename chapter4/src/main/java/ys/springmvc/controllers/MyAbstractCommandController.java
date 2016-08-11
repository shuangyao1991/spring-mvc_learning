package ys.springmvc.controllers;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import ys.springmvc.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with by shuangyao on 2016/8/11.
 */
public class MyAbstractCommandController extends AbstractCommandController {

    public MyAbstractCommandController() {
        setCommandClass(User.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object command, BindException errors) throws Exception {
        User user = (User) command;
        response.getWriter().write(user.toString());
        return null;
    }
}
