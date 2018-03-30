package me.liuxiang.chick.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * 服务消费方配置
 */
//@Configuration
@DubboComponentScan
@Deprecated
public class DubboConsumerConfiguration {

    /**
     * 当前应用配置
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-forseti-gateway");
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();

//         registryConfig.setAddress("N/A");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("dubbo");
        registryConfig.setAddress("192.168.6.55:2181,192.168.6.56:2181,192.168.6.57:2181");
        registryConfig.setPort(-1);

        return registryConfig;
    }

    /**
     * (依据实际client类完成注入)
     * 注册 AnnotationDemoServiceConsumer，@DubboComponentScan 将处理其中 @Reference 字段。
     * 如果 AnnotationDemoServiceConsumer 非 Spring Bean 的话，
     * 即使 @DubboComponentScan 指定 package 也不会进行处理，与 Spring @Autowired 同理
     */
//    @Bean
//    public AccessForsetiConsumer accessForsetiConsumer() {
//        return new AccessForsetiConsumer();
//    }

    /**
     * 当前连接注册中心配置
     */
    @Bean("dubbo")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(12345);
        return protocolConfig;
    }
}