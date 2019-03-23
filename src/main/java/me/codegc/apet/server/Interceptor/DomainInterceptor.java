package me.codegc.apet.server.Interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.codegc.apet.server.model.JsonResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ding / 2019-03-23 16:45
 * @version: V1.0
 * @TODO: 没有许可域名全部拦截
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Slf4j
public class DomainInterceptor implements HandlerInterceptor {

    // 允许跨域请求 这里可以放入你的域名
    private static String[] allowDomain = {"http://localhost:8080","*",null};

    private static Set<String> allowedOrigins = new HashSet<String>(Arrays.asList(allowDomain));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String originHeader = request.getHeader("Origin");
        if (allowedOrigins.contains(originHeader)) {
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Cookie");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            return  true;
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(JSONObject.toJSON(new JsonResult().init(JsonResult.ERROR).builder("message ","你的域名没有在白名单里!请求被拒绝!")));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
