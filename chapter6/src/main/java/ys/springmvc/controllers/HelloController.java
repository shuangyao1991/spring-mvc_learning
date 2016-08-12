package ys.springmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuangyao on 2016/5/26.
 */
@Controller
public class HelloController{

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "hello2",
                    method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView hello2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "组合方法：GET，POST");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(params = "param", method = RequestMethod.GET)
    public ModelAndView param(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "请求中包含指定参数的映射：param");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(params = {"test", "param=value"})
    public ModelAndView paramValue(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",
                "请求中包含指定多个参数，且参数有指定值： test, param=value");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "testHeader", headers = "testAccept")
    public ModelAndView testHeader(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",
                "请求头中必须包含指定参数： headers=testAccept");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "testParam")
    public void testParam(@RequestParam(value = "userName",
            required = true, defaultValue = "test") String userName,
            @RequestParam(value = "list1") String[] list1,
            @RequestParam(value = "list2") List<String> list2,
            OutputStream outputStream){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(userName).append("\r\n");
            if (list1 != null && list1.length > 0){
                sb.append(Arrays.toString(list1)).append("\r\n");
            }
            if (list2 != null && list2.size() > 0){
                sb.append(list2.toString());
            }
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
