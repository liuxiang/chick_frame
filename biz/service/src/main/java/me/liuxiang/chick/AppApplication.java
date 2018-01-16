package me.liuxiang.chick;

import me.liuxiang.chick.config.ProviderConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan(basePackages = "me.liuxiang")
@ImportResource(locations = {"classpath:app.xml"})
public class AppApplication extends SpringBootServletInitializer {

    /**
     * 启动服务提供方上下文
     * 此方法:Spring boot可省略.将自动扫描@Configuration完整初始化
     */
    private static void startProviderContext() {
        // 创建 Annotation 配置上下文
        AnnotationConfigApplicationContext providerContext = new AnnotationConfigApplicationContext();
        // 注册配置 Bean
        providerContext.register(ProviderConfiguration.class);
        // 启动服务提供方上下文
        providerContext.refresh();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
