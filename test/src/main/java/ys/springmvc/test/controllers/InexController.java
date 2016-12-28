package ys.springmvc.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
//        modelMap.addAttribute("time", System.currentTimeMillis());
        modelMap.put("token", "tokenValue");
        modelMap.put("test", "hello");
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

    @RequestMapping("/test/{id}")
    public String test(@PathVariable("id") int id,
                       @RequestParam("name") String name) {
        return "index";
    }

}
