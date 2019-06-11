package com.pinjingjing.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.pinjingjing.demo.entity.Player;

public interface PlayerRepository extends Neo4jRepository<Player,Long> { 

}
