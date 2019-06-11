package com.pinjingjing.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.pinjingjing.demo.entity.Cat;

public interface CatReponsitory extends Neo4jRepository<Cat,Long> { 

}
