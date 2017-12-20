package my.liuxiang.chick.client.dubbo.country;

import my.liuxiang.chick.client.dubbo.country.object.CountryDO;

import java.util.List;

public interface CountryService {

    /**
     * 获取数据
     *
     * @return
     */
    String queryConnrtyJson();

    List<CountryDO> queryConnrty();

    List<CountryDO> queryConnrty(CountryDO countryDO);
}
