package com.pinjingjing.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinjingjing.demo.entity.Coder;
import com.pinjingjing.demo.repository.CoderRepository;
import com.pinjingjing.demo.service.CoderService;
@Service
@Transactional
public class CoderServiceImpl implements CoderService{
	
	@Autowired
	private CoderRepository mapper;

	@Override
	public Coder findByName(String name) {
		return mapper.findByName(name);
	}

	@Override
	public void updateCoder(Long id, String name) {
		mapper.updateCoder(id, name);
	}
	

}
