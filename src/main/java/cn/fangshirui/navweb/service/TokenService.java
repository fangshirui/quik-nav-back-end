package cn.fangshirui.navweb.service;

import cn.fangshirui.navweb.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 令牌服务
 *
 * @author kk
 * @date 2020/09/03
 */
@Service("TokenService")
public class TokenService {

    /**
     * 根密码
     */
    public static final String ROOT_PASSWORD = "b977f4b13f93f549e06140971bded384";

    public String getToken(User user) {
        String token;
        // 将 user id 保存到 token 里面
        // 以 password 作为 token 的密钥
        // expiresAt 设置过期时间 设置为一周
        token= JWT.create().withAudience( ((Integer)user.getId()).toString() )
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000 * 24 * 7))
                .sign(Algorithm.HMAC256(ROOT_PASSWORD));
        return token;
    }
}
