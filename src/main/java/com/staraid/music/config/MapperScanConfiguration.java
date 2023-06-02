package com.staraid.music.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mapper包扫描
 *
 * @author mine
 * @since 2023-06-02 22:58:38
 */
@Configuration
@MapperScan(basePackages = {"cn.stylefeng.**.mapper", "com.staraid.music.**.mapper"})
public class MapperScanConfiguration {

}
