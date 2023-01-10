package com.bus.oyhj;

import com.bus.oyhj.service.UserService;
import com.bus.oyhj.service.imp.userServiceimp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
class OyhjApplicationTests {
    @Autowired(required = false)
    DataSource dataSource;
    @Autowired
    @Qualifier("userServiceimp")
    UserService userService;
    @Test
    void contextLoads() throws SQLException {
     System.out.println(userService.queryUserList());
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
