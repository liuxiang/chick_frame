package mapper;

import basic.BaseSpringBootTest;
import my.liuxiang.mysql.mapper.CountryMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperSpringBootTest extends BaseSpringBootTest {

    @Test
    public void test() {
        System.out.println("hello world!");
    }

    @Autowired
    CountryMapper countryMapper;

    @Test
    public void mapper() {
        System.out.println("MapperTest mapper:" + countryMapper.selectAll().size());
    }
}
