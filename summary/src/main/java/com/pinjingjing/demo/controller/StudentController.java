package com.pinjingjing.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinjingjing.demo.entity.Student;
import com.pinjingjing.demo.repository.StudentRepositry;
import com.pinjingjing.demo.service.StudentService;

/**
 * @author cooze
 * @version 1.0.0
 * @desc
 * @date 2017/7/27
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/student")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){

        return  studentService.addStudent(student);
    }

    @GetMapping(value = "/student/{name}")
    public Student getStudent(@PathVariable(name = "name") String name){
        return studentService.getStudent(name);
    }

}
