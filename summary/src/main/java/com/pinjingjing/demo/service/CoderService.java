package com.pinjingjing.demo.service;

import org.springframework.data.repository.query.Param;

import com.pinjingjing.demo.entity.Coder;

public interface CoderService {

	Coder findByName(@Param("name") String name);

	void updateCoder(@Param("id") Long id,@Param("name") String name);

}
