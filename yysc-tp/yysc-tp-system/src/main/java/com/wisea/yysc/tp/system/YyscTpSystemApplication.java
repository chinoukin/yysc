package com.wisea.yysc.tp.system;

import com.wisea.cloud.common.annotation.CORS;
import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wisea.yysc" })
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.yysc" })
@MapperScan(basePackages = { "com.wisea.yysc" })
@OauthJwtResourceServer
@EnableWbfcMonitor // 开启健康监控
//@CORS
public class YyscTpSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(YyscTpSystemApplication.class, args);
    }
}
