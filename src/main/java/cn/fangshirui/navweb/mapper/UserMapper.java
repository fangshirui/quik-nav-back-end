package cn.fangshirui.navweb.mapper;

import cn.fangshirui.navweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户映射器
 *
 * @author kk
 * @date 2020/09/03
 */
@Mapper
public interface UserMapper {
    User findByUsername(@Param("name") String username);
    User findUserById(@Param("id") int id);

    void addUser(@Param("name") String name, @Param("pwd") String pwd);
}
