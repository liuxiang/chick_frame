package my.liuxiang.chick.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

//@Component // error:The resource configuration is not modifiable in this context.
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        System.out.println("JerseyConfig begin");

        register(RequestContextFilter.class);

        // 配置restful package.
        packages("my.liuxiang");
    }

}