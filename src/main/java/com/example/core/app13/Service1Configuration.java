package com.example.core.app13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service1Configuration {

    @Bean // 이 Spring Bean 의 이름은 메소드 이름으로 결정
    public Service1 service1() {
        return new Service1();
    }

    @Bean
    public Service2 service2() {
        return new Service2();
    }
}
