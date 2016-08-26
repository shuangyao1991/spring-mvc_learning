package ys.springmvc.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
