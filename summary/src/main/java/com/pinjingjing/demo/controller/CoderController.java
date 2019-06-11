
package com.pinjingjing.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinjingjing.demo.entity.Coder;
import com.pinjingjing.demo.repository.CoderRepository;
import com.pinjingjing.demo.result.ResponseResult;
import com.pinjingjing.demo.service.CoderService;

@RestController
@RequestMapping("/coder")
public class CoderController {

	@Autowired
	CoderRepository coderRepositiory;
	
	@Autowired
	CoderService coderService;

	@RequestMapping("/get")
	public Coder GetCoderByName(@RequestParam(value = "name") String name) {
		return coderService.findByName(name);
	}
	
	@RequestMapping("/getAll")
	public Iterable<Coder> GetAll() {
		return coderRepositiory.findAll();
	}

	@PostMapping("/save")
	@Transactional
	public ResponseResult Create(@RequestBody Coder coder) throws Exception {

		Coder result = coderRepositiory.save(coder);
		if (result != null) {
			return new ResponseResult(200, result.getName() + "节点创建成功");
		}
		return new ResponseResult(500, coder.getName() + "节点创建失败！");
	}

	@PostMapping("/delete")
	@Transactional
	public void delete(@RequestParam(value = "id") Long id) throws Exception {

		coderRepositiory.deleteById(id);
	}
	
	@PostMapping("/update")
	@Transactional
	public void update(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name) throws Exception {
		
		coderService.updateCoder(id, name);
	}

}
