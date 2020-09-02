package cn.fangshirui.navweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 跳转控制器
 *
 * @author kk
 * @date 2020/08/29
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello World ~";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "欢迎来到主页 ~";
    }
}
