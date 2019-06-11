package com.pinjingjing.demo.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.pinjingjing.demo.entity.Student;

/**
 * @author cooze
 * @version 1.0.0
 * @desc
 * @date 2017/7/27
 */
public interface StudentRepositry extends Neo4jRepository<Student,Long> { 

    @Query("MATCH (n:Student) WHERE n.name = {name} RETURN n")
    Student getStudentByName(@Param("name") String Name);

    Student findByName( String Name );
}
