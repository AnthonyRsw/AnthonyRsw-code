package com.pinjingjing.demo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class BaseEntity {
	/**
	 * Neo4j会分配的ID（节点唯一标识 当前类中有效）
	 */
	 @Id
	 @GeneratedValue
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
