package me.liuxiang.chick.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

// @Configuration
@Deprecated
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate riskserverJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /********* 以下为多数据源 ************/

//    @Bean(name = "riskserverDataSource")
//    @Qualifier("riskserverDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource riskserverDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "riskserverJdbcTemplate")
//    public JdbcTemplate riskserverJdbcTemplate(
//            @Qualifier("riskserverDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

//    @Bean(name = "forsetiDataSource")
//    @Qualifier("forsetiDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.forseti")
//    public DataSource forsetiDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "forsetiJdbcTemplate")
//    public JdbcTemplate forsetiJdbcTemplate(
//            @Qualifier("forsetiDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

}

/**
 * Description:
 * <p>
 * Field forsetidbcTemplate in com.lyz.demo.gateway.cache.ChallengerCache required a single bean, but 2 were found:
 * - riskserverJdbcTemplate: defined by method 'riskserverJdbcTemplate' in class path resource [com/lyz/demo/gateway/config/DataSourceConfig.class]
 * - forsetiJdbcTemplate: defined by method 'forsetiJdbcTemplate' in class path resource [com/lyz/demo/gateway/config/DataSourceConfig.class]
 * <p>
 * <p>
 * Action:
 * <p>
 * Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
 */