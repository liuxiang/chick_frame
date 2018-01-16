package me.liuxiang;

import com.alibaba.dubbo.config.annotation.Reference;
import me.liuxiang.chick.client.dubbo.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Annotation 驱动 {@link CountryService} 消费方
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class AnnotationDemoServiceConsumer {

    // @Autowired// xml服务引用:﻿<dubbo:reference
    @Reference(url = "dubbo://127.0.0.1:12345")// 注解方式服务引用:@Configuration
            CountryService countryService;


    public String doSayHell(String name) {
        return countryService.queryConnrtyJson();
    }

    /**
     * http://localhost:8011/a/queryContryJson
     *
     * @return
     */
    @RequestMapping(value = "/a/queryContryJson", produces = "application/json; charset=UTF-8")
    public String queryContryJson() {
        return countryService.queryConnrtyJson();
    }
}