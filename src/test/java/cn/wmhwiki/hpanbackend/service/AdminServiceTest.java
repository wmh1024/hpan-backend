package cn.wmhwiki.hpanbackend.service;

import cn.wmhwiki.hpanbackend.domain.Admin;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminServiceTest {
    @Resource
    private AdminService adminService;

    @Test
    void registerTest() {
        Admin admin = new Admin();
        admin.setUsername("wmh");
        admin.setUserPassword("123.com");
        // 注册
//        String id = adminService.register(admin.getUsername(), admin.getUserPassword());
//        // 断言
//        Assertions.assertNotNull(id);
    }

    @Test
    void loginTest() {
        String username = "wmh";
        String userPassword = "123.com";
        // 登录
//        String id = adminService.login(username, userPassword, null);
        // 断言
//        Assertions.assertNotNull(id);
    }
}