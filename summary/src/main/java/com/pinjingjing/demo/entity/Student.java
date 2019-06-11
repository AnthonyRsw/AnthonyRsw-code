package com.pinjingjing.demo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author cooze
 * @version 1.0.0
 * @desc
 * @date 2017/7/27
 */
@NodeEntity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String sex;

	private int age;

	public Student() {
	}

	public Student(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
