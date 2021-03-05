package com.wisea.yysc.tp.product;

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
@EnableFeignClients(basePackages = { "com.wisea.yysc.common" ,"com.wisea.yysc.tp.product.mss"})
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.yysc.common", "com.wisea.yysc.tp.product" })
@MapperScan(basePackages = { "com.wisea.transac","com.wisea.yysc.common" })
@OauthJwtResourceServer
@EnableWbfcMonitor
public class YyscTpProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyscTpProductApplication.class, args);
    }
}
