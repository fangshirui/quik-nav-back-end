package cn.fangshirui.navweb.service;


import cn.fangshirui.navweb.mapper.UserMapper;
import cn.fangshirui.navweb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author kk
 * @date 2020/09/03
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    public User findUserById(int id){
        return userMapper.findUserById(id);
    }
}
