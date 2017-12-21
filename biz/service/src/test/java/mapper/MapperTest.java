package mapper;

import basic.SpringJUnitTest;
import me.liuxiang.mysql.mapper.CountryMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
