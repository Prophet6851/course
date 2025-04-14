package com.example.course.mapper;

import com.example.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
}
