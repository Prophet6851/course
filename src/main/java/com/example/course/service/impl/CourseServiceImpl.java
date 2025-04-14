package com.example.course.service.impl;

import com.example.course.entity.Course;
import com.example.course.mapper.CourseMapper;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> listCourses() {
        return courseMapper.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insertCourse(course);
    }

}
