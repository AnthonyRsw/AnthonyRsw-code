package com.pinjingjing.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinjingjing.demo.mapper.BaseDataMapper;
import com.pinjingjing.demo.service.BaseDataService;
@Service
@Transactional
public class BaseDataServiceImpl implements BaseDataService{
	
	@Autowired
	private BaseDataMapper mapper;
	

	@Cacheable(cacheNames="area")
    @Override
	public List<Map<String, Object>> findAll(Map<String, Object> param) {
		return mapper.findAll(param);
	}

    @Override
	public Integer findAllCount(Map<String, Object> param) {
		return mapper.findAllCount(param);
	}

}
