package cn.fangshirui.navweb;

import cn.fangshirui.navweb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class NavWebApplicationTests {
    static String test_pwd = UUID.randomUUID().toString().toLowerCase();

    @Autowired
    UserService userService;

    @Test
    public void testUUID(){
        System.out.println(test_pwd);
    }

    @Test
    public void testAddUser() {
        userService.addUser("fangshirui", "dddd");
    }
}
