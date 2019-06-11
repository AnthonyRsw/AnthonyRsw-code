package com.pinjingjing.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;

public interface BaseDataMapper {
	

	List<Map<String, Object>> findAll(Map<String, Object> param);

	Integer findAllCount(Map<String, Object> param);

}
