package my;

import com.alibaba.fastjson.JSON;
import my.liuxiang.mysql.mapper.CountryMapper;
import my.liuxiang.mysql.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class MapperController {


    @Autowired
    CountryMapper countryMapper;

    /**
     * http://localhost:8080/mapper
     *
     * @return
     */
    @RequestMapping(value = "/mapper",produces = "application/json; charset=UTF-8")
    public String mapper() {
        List<Country> countryList = countryMapper.selectAll();
        System.out.println(countryList.size());

        return JSON.toJSON(countryList).toString();
    }

    /**
     * http://localhost:8080/mapper2
     *
     * @return
     */
    @RequestMapping("/mapper2")
    public Object mapper2(){
        return countryMapper.selectAll();
    }
}
