package cn.fangshirui.navweb.controller;

import cn.fangshirui.navweb.annotation.UserLoginToken;
import cn.fangshirui.navweb.pojo.User;
import cn.fangshirui.navweb.result.ResultVO;
import cn.fangshirui.navweb.result.ResultVOUtils;
import cn.fangshirui.navweb.service.TokenService;
import cn.fangshirui.navweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录控制器
 *
 * @author kk
 * @date 2020/09/03
 */
@RestController
@RequestMapping("/api")
public class UserLoginController {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResultVO<Object> login(@RequestParam("name") String name
    , @RequestParam("pwd") String pwd){

        // userInDataBase 是数据库中对应的实体用户
        User userInDataBase = userService.findByUsername(name);

        if(userInDataBase == null){
            return ResultVOUtils.error("登陆失败，用户不存在",401);
        }

        if(!userInDataBase.getPassword().equals(pwd)){
            return ResultVOUtils.error("登陆失败，密码错误!",402);
        }else {

            // 生成token 并返回
            String token = tokenService.getToken(userInDataBase);
            return ResultVOUtils.success(token);
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "已经通过验证了";
    }
}
