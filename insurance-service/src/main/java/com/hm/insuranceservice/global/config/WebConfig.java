package com.hm.insuranceservice.global.config;

import com.hm.insuranceservice.global.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludeUrl("/csrf","/"));
    }

    public List<String> excludeUrl(String... strings){
        List<String> excludeUrls =
                new ArrayList<>(Arrays.asList(new String[]{"/css/**", "/*.ico", "/**/*swagger*/**", "/webjars/**", "/error"}));
        excludeUrls.addAll(Arrays.asList(strings));
        return excludeUrls;
    }
}
