package com.staraid.music;

import cn.stylefeng.roses.kernel.db.starter.GunsDataSourceAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.flowable.spring.boot.FlowableSecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"cn.stylefeng", "com.staraid.music"}, exclude = {MongoAutoConfiguration.class, FlywayAutoConfiguration.class, GunsDataSourceAutoConfiguration.class, FlowableSecurityAutoConfiguration.class})
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
        log.info(MusicApplication.class.getSimpleName() + " is success!");
    }

}
