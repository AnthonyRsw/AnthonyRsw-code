package com.pinjingjing.demo.service;

import java.util.List;
import java.util.Map;

public interface BaseDataService {

	public List<Map<String, Object>> findAll(Map<String, Object> param);

	public Integer findAllCount(Map<String, Object> param);

}
