package me.liuxiang.mysql.mapper;

import me.liuxiang.mysql.model.Country;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CountryMapper extends Mapper<Country>,MySqlMapper<Country> {
}