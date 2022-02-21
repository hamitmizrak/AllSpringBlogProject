package com.hamitmizrak;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
//)

@SpringBootApplication

//Audit aktif etmek icin auditorAware ==> Bean adı
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Log4j2
public class AllSpringBlogProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllSpringBlogProjectApplication.class, args);
    }




}
