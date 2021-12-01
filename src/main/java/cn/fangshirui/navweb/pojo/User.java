package cn.fangshirui.navweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author kk
 * @date 2020/09/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int id;

    String userName;

    String password;
}