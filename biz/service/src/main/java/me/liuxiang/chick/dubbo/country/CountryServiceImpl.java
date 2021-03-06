package me.liuxiang.chick.dubbo.country;

import com.alibaba.fastjson.JSON;
import me.liuxiang.chick.client.dubbo.country.object.CountryDO;
import me.liuxiang.chick.client.dubbo.country.CountryService;
import me.liuxiang.mysql.mapper.CountryMapper;
import me.liuxiang.mysql.model.Country;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@com.alibaba.dubbo.config.annotation.Service // 注解方式服务提供:@Configuration
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryMapper countryMapper;

    @Override
    public String queryConnrtyJson() {
        return JSON.toJSON(queryConnrty()).toString();
    }

    @Override
    public List<CountryDO> queryConnrty() {
        return queryConnrty(null);
    }

    @Override
    public List<CountryDO> queryConnrty(CountryDO countryDO) {
        Country country = new Country();
        if (countryDO != null) {
            BeanUtils.copyProperties(countryDO, country);
        }

        List<CountryDO> countryDOS = new ArrayList<CountryDO>();
        for (Country country1 : countryMapper.select(country)) {
            CountryDO countryDO1 = new CountryDO();
            BeanUtils.copyProperties(country1, countryDO1);
            countryDOS.add(countryDO1);
        }

        return countryDOS;
    }

}
