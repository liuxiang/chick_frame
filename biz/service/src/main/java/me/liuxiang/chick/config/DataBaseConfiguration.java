package me.liuxiang.chick.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SuppressWarnings("ContextJavaBeanUnresolvedMethodsInspection")
//@Configuration
//@EnableTransactionManagement
@Deprecated
public class DataBaseConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource writeDataSource() {
        System.out.println("注入druid！！！");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("url"));
        dataSource.setUsername(propertyResolver.getProperty("username"));//用户名
        dataSource.setPassword(propertyResolver.getProperty("password"));//密码
        dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

}
/**
 * 参考:
 * https://blog.csdn.net/u014695188/article/details/52263951
 */