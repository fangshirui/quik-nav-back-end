package cn.fangshirui.navweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class NavWebApplicationTests {
    static String test_pwd = UUID.randomUUID().toString().toLowerCase();

    @Test
    public void testUUID(){
        System.out.println(test_pwd);
    }

}
