package com.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cat.sql.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 14629
 */
@Mapper
@Repository
public interface FoodMapper extends BaseMapperPlus<FoodMapper,Food,Food> {
    List<LinkedHashMap<String,Object>> getFoodMap();
}
