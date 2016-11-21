package ys.springmvc.test.controllers;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ys.springmvc.test.constants.DataSourceConstant;
import ys.springmvc.test.model.User;
import ys.springmvc.test.service.UserService;
import ys.springmvc.test.utils.DataSourceHolder;
import ys.springmvc.test.utils.JsonResponse;

import javax.servlet.http.HttpServletRequest;
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
                        OutputStream outputStream,
                        HttpServletRequest request){
        String result = request.getRequestURI() + " -> ";
        try {
            User user = userService.getById(id);
            if (user == null){
                result += "empty";
            }else {
                result += user.toString();
            }
            outputStream.write(result.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    @RequestMapping(value = "getById2", method = RequestMethod.GET)
    public String getById2(@RequestParam(value = "id", required = true) int id,
                           Model model){
        User user = userService.getById(id);
//        model.addAttribute("id", user.getId());
//        model.addAttribute("uname", user.getUname());
        model.addAttribute("user", user);
        return "hello";
    }

    @RequestMapping(value = "testRedirect", method = RequestMethod.GET)
    public String testRedirect(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addAttribute("id", 1);
        redirectAttributes.addFlashAttribute("id", 1);
        return "redirect:/user/getById";
    }

    @RequestMapping(value = "testDynamicDB", method = RequestMethod.GET)
    public void testDynamicDB(@RequestParam(value = "id", required = true) int id,
                              OutputStream outputStream,
                              HttpServletRequest request){
        try {
            User user ;
            StringBuilder sb = new StringBuilder();
            sb.append(request.getRequestURI()).append(" -> ");

            DataSourceHolder.set(DataSourceConstant.SLAVER_DB);
            user = userService.getById(id);

            if (user == null){
                sb.append("empty");
            }else {
                sb.append(user.toString());
            }

            outputStream.write(sb.toString().getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    @RequestMapping(value = "testObject", method = RequestMethod.GET)
    public void testObject(User user,
                           OutputStream outputStream,
                           HttpServletRequest request) {
        try {
            String result = request.getRequestURI() + " -> ";
            DataSourceHolder.set(DataSourceConstant.SLAVER_DB);
            userService.save(user);
            if (user == null){
                result += "empty";
            }else {
                result += user.toString();
            }
            outputStream.write(result.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

}
