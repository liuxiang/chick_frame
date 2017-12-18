package basic;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)//SpringJUnit支持，由此引入Spring-Test框架支持
@WebAppConfiguration //由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
@ContextConfiguration(locations={"/app.xml"})
@Rollback
public class BaseSpringBootTest {

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        // 获知﻿自动注入的是 PlatformTransactionManager 接口的哪个实现类
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    // 其中 dataSource 框架会自动为我们注入
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}