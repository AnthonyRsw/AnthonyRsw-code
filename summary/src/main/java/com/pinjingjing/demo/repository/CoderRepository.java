package com.pinjingjing.demo.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.pinjingjing.demo.entity.Coder;

public interface CoderRepository extends Neo4jRepository<Coder,Long> { 

	/*
	 CoderRepositiory 继承 GraphRepository类，实现增删查改
	   实现自己的接口:通过名字查询Coder(可以是单个Coder，也可以是一个List集合)，
	 spring-data-neo4j 支持方法命名约定查询 findBy{Coder的属性名}，
	 findBy后面的属性名一定要Coder类里存在，否则会报错 
	 */
	
	Coder findByName(@Param("name") String name);
	
	@Query("Match(c:Coder) where id(c)={id}  set c.name={name}")
	void updateCoder(@Param("id") Long id,@Param("name") String name);
	
}

