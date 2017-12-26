package mapper;

import basic.SpringJUnitTest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.liuxiang.mysql.mapper.CountryMapper;
import me.liuxiang.mysql.model.Country;
import org.apache.ibatis.type.StringTypeHandler;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class MapperTest extends SpringJUnitTest {

    @Autowired
    CountryMapper countryMapper;

    @Test
    public void mapperTest() {
        List<Country> countrys = countryMapper.selectAll();
        for (Country conuntry : countrys) {
            System.out.println("name:" + conuntry.getCountryname());
        }
    }

    @Test
    public void selectTest() {
        // 测试mapper (详见:http://git.oschina.net/free/Mapper)
        List<Country> countrys = countryMapper.select(new Country() {{
            setId(1);
        }});
        System.out.println(countrys.size());

        if (false) {
            countryMapper.insert(new Country() {{
                setCountryname("ContractNo_test");
            }});// 新增

            countryMapper.updateByPrimaryKey(new Country() {{
                setId(1);
                setCountryname("ContractNo_test");
            }});// 更新
        }

        // Exapmle查询示例
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("billingNo", "Demo");
        criteria.andLike("contractNo", "Dem" + "%");
        // criteria.andIsNull("expireTime"); // 失效时间
        // criteria.andBetween("createTime", DateUtils.getDateStart(new Date()), DateUtils.getDateEnd(new Date()));// 时间范围
        example.setOrderByClause("id");// 排序
        System.out.println(countryMapper.selectByExample(example).size());

        // Exapml灵活用法 详见:http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/3.2.Use330.md
        if (false) {
            example.createCriteria()
                    .andCondition("countryname like 'C%' and id < 100")
                    .andCondition("length(countryname) = ", 5)
                    .andCondition("countrycode =", "CN", StringTypeHandler.class);
            List<Country> csBillingItems1 = countryMapper.selectByExample(example);
        }

        // 测试自定义SQL
        // System.out.println(countryMapper.queryAllByCondition(new Country()).size());//
    }

    @Test
    public void pageTest() {

        System.out.println(countryMapper.selectAll().size());// 6
        System.out.println(countryMapper.select(new Country()).size());// 6

        PageHelper.startPage(2, 2);
        System.out.println(countryMapper.select(new Country()).size());// 2

        System.out.println(countryMapper.select(new Country()).size());// 6

        PageHelper.startPage(1, 2);
        List<Country> countrys = countryMapper.selectAll();
        System.out.println(countrys.size());// 2

        PageInfo pageInfo = new PageInfo(countrys);
        System.out.println(pageInfo.getPageNum());// 1
        System.out.println(pageInfo.getPageSize());// 2
        System.out.println(pageInfo.getStartRow());// 1
        System.out.println(pageInfo.getEndRow());// 2
        System.out.println(pageInfo.getNextPage());// 2
        System.out.println(pageInfo.getPages());// 3
        System.out.println(pageInfo.getTotal());// 6
    }

    // @Test
    public void insertList(){

        // 注意必填字段
        countryMapper.insertList(new ArrayList<Country>(){{
            add(new Country());
            add(new Country());
            add(new Country());
            add(new Country());
        }});
    }
}

/**
 * 更多参考
 * `github`
 *  https://github.com/abel533/Mapper
 *
 * `Spring Boot 集成 MyBatis, 分页插件 PageHelper, 通用 Mapper`
 *  https://github.com/abel533/MyBatis-Spring-Boot
 *﻿  https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
 *
 * `使用通用 MAPPER`
 *  https://mapperhelper.github.io/docs/2.use/
 */