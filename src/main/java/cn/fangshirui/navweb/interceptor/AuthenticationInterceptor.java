package cn.fangshirui.navweb.interceptor;

import cn.fangshirui.navweb.annotation.PassToken;
import cn.fangshirui.navweb.annotation.UserLoginToken;
import cn.fangshirui.navweb.service.TokenService;
import cn.fangshirui.navweb.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 身份验证拦截器
 *
 * @author kk
 * @date 2020/09/03
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;


    /**
     * 前处理
     * 重点是这个方法的重写
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @return boolean* @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        // 从http请求头取出token
        String token = request.getHeader("token");

        // 如果不是映射到方法就直接放行
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 检查是否有passToken注释，有则跳过验证，直接通过
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        // 检查是否有 UserLoginToken 有则需要登录才可以访问
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);

            if(userLoginToken.required()){
                // 执行认证
                if (token == null){
                    throw new RuntimeException("无token，请重新登陆");
                }

                // 如果有这个id ,再使用根密码解码 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TokenService.ROOT_PASSWORD)).build();

                try{
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("token不正确或已过期");
                }

                return true;

            }
        }

        // 什么注解也没有的方法也放行。此语句使得PassToken不加的方法也可以通过拦截器
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
