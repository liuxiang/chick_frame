package me.liuxiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan(basePackages = "me.liuxiang")
@ImportResource(locations = {"classpath:app.xml"})
public class ThirdAppApplication {

    /**
     * 启动并且返回服务消费方上下文
     * 此方法:Spring boot可省略.将自动扫描@Configuration完整初始化
     * @return AnnotationConfigApplicationContext
     */
    private static ApplicationContext startConsumerContext() {
        // 创建服务消费方 Annotation 配置上下文
        AnnotationConfigApplicationContext consumerContext = new AnnotationConfigApplicationContext();
        // 注册服务消费方配置 Bean
        consumerContext.register(DubboConsumerConfiguration.class);
        // 启动服务消费方上下文
        consumerContext.refresh();
        // 返回服务消费方 Annotation 配置上下文
        return consumerContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThirdAppApplication.class, args);
    }
}
