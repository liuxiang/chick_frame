package my.liuxiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan(basePackages = "my.liuxiang")
@ImportResource(locations = {"classpath:app.xml"})
public class ThirdAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdAppApplication.class, args);
    }
}
