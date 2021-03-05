package com.wisea.yysc.tp.trade;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import com.wisea.wechat.annotation.EnablePayWechat;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 交易信息
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.wisea.yysc.common", "com.wisea.yysc.tp.trade"})
@ComponentScan(basePackages = {"com.wisea.cloud.common", "com.wisea.yysc"})
@MapperScan(basePackages = {"com.wisea.yysc"})
@OauthJwtResourceServer
@EnableWbfcMonitor // 开启健康监控
@EnablePayWechat
@EnableWbfcQuartzScheduler
public class YyscTpTradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(YyscTpTradeApplication.class, args);
    }
}
