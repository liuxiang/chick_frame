package mapper;

import basic.SpringJUnitTest;
import my.liuxiang.mysql.mapper.CountryMapper;
import org.junit.Test;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class MapperTest extends SpringJUnitTest {


    @Test
    public void test() {
        System.out.println("hello world!");
    }

    @Autowired
    CountryMapper countryMapper;

    @Test
    public void mapper(){
        System.out.println("MapperTest mapper:" + countryMapper.selectAll().size());
    }
}
