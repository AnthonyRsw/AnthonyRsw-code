package com.pinjingjing.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinjingjing.demo.entity.Student;
import com.pinjingjing.demo.repository.StudentRepositry;
import com.pinjingjing.demo.service.StudentService;

/**
 * @author cooze
 * @version 1.0.0
 * @desc
 * @date 2017/7/28
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositry studentRepositry;

    @Override
    public Student getStudent(String name) {
        return studentRepositry.findByName(name);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepositry.save(student);
    }
}
