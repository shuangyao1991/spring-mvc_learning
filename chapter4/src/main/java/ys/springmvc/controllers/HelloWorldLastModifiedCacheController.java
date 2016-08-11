package ys.springmvc.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with by shuangyao on 2016/8/11.
 */
public class HelloWorldLastModifiedCacheController extends AbstractController {

    private long lastModified;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }

    public long getLastModified(HttpServletRequest request){
        if (lastModified == 0L){
            lastModified = System.currentTimeMillis();
        }
        return lastModified;
    }
}
