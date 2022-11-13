package com.sryzzz.hospital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 医院管理web端-后端启动类
 *
 * @author sryzzz
 */
@EnableAsync
@ServletComponentScan
@MapperScan("com.example.hospital.api.db.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HospitalAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAdminApiApplication.class, args);
    }

}
