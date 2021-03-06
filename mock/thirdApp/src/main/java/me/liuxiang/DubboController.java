package me.liuxiang;

import com.alibaba.dubbo.config.annotation.Reference;
import me.liuxiang.chick.client.dubbo.country.CountryService;
import me.liuxiang.chick.client.dubbo.country.object.CountryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class DubboController {

    // @Autowired// xml服务引用:﻿<dubbo:reference
    @Reference(url = "dubbo://127.0.0.1:12345")// 注解方式服务引用:@Configuration
            CountryService countryService;

    /**
     * http://localhost:8011/queryContryJson
     *
     * @return
     */
    @RequestMapping(value = "/queryContryJson", produces = "application/json; charset=UTF-8")
    public String queryContryJson() {
        return countryService.queryConnrtyJson();
    }

    /**
     * http://localhost:8011/queryContry
     *
     * @return
     */
    @RequestMapping("/queryContry")
    public List<CountryDO> queryContry() {
        return countryService.queryConnrty();
    }

    /**
     * http://localhost:8011/queryContry
     *
     * @return
     */
    @RequestMapping("/queryContry2")
    public List<CountryDO> queryContry2() {
        CountryDO countryDO = new CountryDO();
        countryDO.setCountryname("中国");
        return countryService.queryConnrty(countryDO);
    }
}
