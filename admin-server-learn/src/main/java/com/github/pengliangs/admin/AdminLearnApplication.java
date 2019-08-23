package com.github.pengliangs.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-admin 服务
 * @author pengliang
 * @date 2019/8/23  15:08
 */
@EnableAdminServer
@SpringBootApplication
public class AdminLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminLearnApplication.class, args);
    }

}
