package my.liuxiang.chick.rest;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan(basePackages = "my.liuxiang")
@ImportResource(locations = {"classpath:app.xml"})
public class RestApplication {

//    @Bean
//    public ServletRegistrationBean jerseyServlet() {
//        System.out.println("jerseyServlet init.");
//        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
//
//        // our rest resources will be available in the path /rest/*
//        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//
//        return registration;
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
