package com.wisea.yysc.operation;

import com.wisea.cloud.backup.annotation.EnableWbfcBackup;
import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.files.annotation.EnableWbfcFiles;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import com.wisea.cloud.security.annotation.EnableWbfcSecurity;
import com.wisea.cloud.system.annotation.EnableWbfcSystem;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 新盟风控果品产业互联网综合服务平台-交易服务-运营平台-基础框架服务集成
 *
 * @author XuDL(Wisea)
 * <p>
 * 2020年4月1日 下午2:14:51
 */
@EnableFeignClients(basePackages = {"com.wisea.yysc"})
@EnableEurekaClient
@ComponentScan(basePackages = {"com.wisea.cloud.common", "com.wisea.yysc"})
@MapperScan(basePackages = {"com.wisea.yysc"})
@SpringBootApplication
@EnableWbfcSecurity // 用户服务
@EnableWbfcFiles // 文件服务
@EnableWbfcSystem // 系统服务
@OauthJwtResourceServer // 接口需要认证
@EnableWbfcMonitor // 开启健康监控
public class YyscOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyscOperationApplication.class, args);
    }
}
