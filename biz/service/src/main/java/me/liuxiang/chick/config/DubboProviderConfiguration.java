package me.liuxiang.chick.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务提供方配置
 */
@Configuration
@DubboComponentScan("me.liuxiang") // 扫描 Dubbo 组件
public class DubboProviderConfiguration {

    /**
     * 当前应用配置
     */
    @Bean("dubbo-annotation-provider")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider-forseti-gateway");
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     * <dubbo:registry id="normal" group="${forseti.dubbo.zookeeper.root}" protocol="zookeeper" address="${forseti.dubbo.zookeeper}" timeout="10000"/>
     * <dubbo:registry group="${dubbo.zookeeper.root}" protocol="zookeeper" address="${dubbo.zookeeper.host}" port="${dubbo.port}" />
     */
    @Bean("my-registry")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();

        registryConfig.setAddress("N/A");

//        registryConfig.setProtocol("zookeeper");
//        registryConfig.setGroup("dubbo");
//        registryConfig.setAddress("192.168.6.55:2181,192.168.6.56:2181,192.168.6.57:2181");
//        registryConfig.setPort(-1);
        return registryConfig;
    }

    /**
     * 当前连接注册中心配置(与zookeeper不冲突,可双开)
     */
    @Bean("dubbo")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(12345);
        return protocolConfig;
    }
}