# application with 'debug' enabled.
Error starting ApplicationContext. To display the auto-configuration report re-run your application with 'debug' enabled.
- 问题原因:在springboot环境中在已经使用`spring-boot-starter`后重复使用了更多的`*-spring-boot-starter`造成Spring依赖冲突
```$xslt
    <!-- === MyBatis-Spring-Boot [https://github.com/abel533/MyBatis-Spring-Boot] ===-->
    <!--mybatis-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>
    <!--mapper-->
    <dependency>
        <groupId>tk.mybatis</groupId>
        <artifactId>mapper-spring-boot-starter</artifactId>
        <version>1.1.5</version>
    </dependency>
    <!--pagehelper-->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper-spring-boot-starter</artifactId>
        <version>1.2.1</version>
    </dependency>
```
- 解决办法:换用常规的maven-jar依赖
```$xslt
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.5</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.1</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <!--<version>8.0.8-dmr</version>-->
        <version>5.1.45</version>
    </dependency>

    <!-- === MyBatis-Spring-Boot [https://github.com/abel533/MyBatis-Spring-Boot] ===-->
    <!--mapper-->
    <dependency>
        <groupId>tk.mybatis</groupId>
        <artifactId>mapper</artifactId>
        <version>3.4.5</version>
    </dependency>
    <!--pagehelper-->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>5.1.2</version>
    </dependency>
    <!-- Mybatis Generator -->
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>1.3.2</version>
        <scope>compile</scope>
        <optional>true</optional>
    </dependency>
```

# Column name pattern can not be NULL or empty
http://blog.csdn.net/u012527870/article/details/71633915

# 引入缺失:@SpringApplicationConfiguration(classes = Application.class)
原因:较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解，用@SpringBootTest就可以了
`Spring Boot @SpringApplicationConfiguration 不能导入的问题`
http://blog.csdn.net/office5845/article/details/77749350

# RestMapperController(Jersey) 成功调用,但返回404
```$xslt
{
    "timestamp": 1513661775619,
    "status": 404,
    "error": "Not Found",
    "message": "Not Found",
    "path": "/rest/rs/mapper1"
}
```
原因:未结

# Error creating bean with name 'persistenceExceptionTranslationPostProcessor'
```$xslt
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'persistenceExceptionTranslationPostProcessor' defined in class path resource [org/springframework/boot/autoconfigure/dao/PersistenceExceptionTranslationAutoConfiguration.class]: Initialization of bean failed; nested exception is java.lang.IllegalStateException: No persistence exception translators found in bean factory. Cannot perform exception translation.
```
原因:`dubbo.version`从`2.5.3`升级到`2.5.8`问题解决

