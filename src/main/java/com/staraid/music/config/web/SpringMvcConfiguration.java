package com.staraid.music.config.web;

import cn.stylefeng.roses.kernel.security.cors.CorsFilterConfiguration;
import cn.stylefeng.roses.kernel.wrapper.field.jackson.CustomJacksonIntrospector;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.staraid.music.core.error.CustomErrorAttributes;
import com.staraid.music.core.security.AuthJwtTokenSecurityInterceptor;
import com.staraid.music.core.security.PermissionSecurityInterceptor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * spring mvc的配置
 *
 * @author mine
 * @since 2023-06-02 22:58:38
 */
@Configuration
@Import({cn.hutool.extra.spring.SpringUtil.class, CorsFilterConfiguration.class})
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Resource
    private AuthJwtTokenSecurityInterceptor authJwtTokenSecurityInterceptor;

    @Resource
    private PermissionSecurityInterceptor permissionSecurityInterceptor;

    /**
     * 重写系统的默认错误提示
     *
     * @author mine
     * @since 2023-06-02 22:58:38
     */
    @Bean
    public CustomErrorAttributes gunsErrorAttributes() {
        return new CustomErrorAttributes();
    }

    /**
     * json自定义序列化工具,long转string
     *
     * @author mine
     * @since 2023-06-02 22:58:38
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance).serializerByType(Long.TYPE, ToStringSerializer.instance);
            jacksonObjectMapperBuilder.annotationIntrospector(new CustomJacksonIntrospector());
        };
    }

    /**
     * 配置项目拦截器
     *
     * @author mine
     * @since 2023-06-02 22:58:38
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authJwtTokenSecurityInterceptor);
        registry.addInterceptor(permissionSecurityInterceptor);
    }

    /**
     * 静态资源映射
     *
     * @author mine
     * @since 2023-06-02 22:58:38
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//        registry.addResourceHandler("/guns-devops/**").addResourceLocations("classpath:/guns-devops/");

        // 流程设计器
        registry.addResourceHandler("/designer/**").addResourceLocations("classpath:/designer/");
    }

}
