package my.rest;

import com.alibaba.fastjson.JSON;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import my.liuxiang.mysql.mapper.CountryMapper;
import my.liuxiang.mysql.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
@Path("rs")
public class RestMapperController {

    @Autowired
    CountryMapper countryMapper;

    @Autowired
    protected HttpServletResponse autoResponse;

    /**
     * http://localhost:8080/rest/rs/mapper1
     *
     * @return
     */
    @Path("mapper1")
    public Object mapper() {
        System.out.println("mapper begin");
        List<Country> countryList = countryMapper.selectAll();
        return countryList;
    }

    @Path("mapper2")
    public String mapper2() {
        System.out.println("mapper2 begin");
        List<Country> countryList = countryMapper.selectAll();
        return JSON.toJSON(countryList).toString();
    }

    @Path("mapper3")
    @Produces(MediaType.APPLICATION_JSON)
    public String mapper3() {
        System.out.println("mapper3 begin");
        List<Country> countryList = countryMapper.selectAll();
        return JSON.toJSON(countryList).toString();
    }
}
