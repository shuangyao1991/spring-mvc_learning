package ys.springmvc.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.springmvc.test.utils.ImageCodeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/8/18.
 */
@Controller
public class InexController {

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("time", System.currentTimeMillis());
        return "index";
    }

    @RequestMapping("/imgcode")
    public void imgcode(HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            byte[] bytes = ImageCodeUtils.generateImageCode();
            response.getOutputStream().write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
