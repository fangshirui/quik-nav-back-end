package cn.fangshirui.navweb.config;

import cn.fangshirui.navweb.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author kk
 * @date 2020/09/03
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
            registry.addInterceptor(authenticationInterceptor())
                    .addPathPatterns("/**");
        }

        @Bean
        public AuthenticationInterceptor authenticationInterceptor() {
            return new AuthenticationInterceptor();
        }
}
