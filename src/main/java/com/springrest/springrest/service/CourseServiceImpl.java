package com.springrest.springrest.service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
//    public List<Course> courses;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {
//        this.courses = new ArrayList<>();
//        this.courses.add(new Course(1, "Angular", "Angular Course"));
//        this.courses.add(new Course(2, "Java", "Java Course"));
    }

    @Override
    public List<Course> getCourses() {
//        return courses;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course course = null;
//        for(Course c: this.courses) {
//            if(c.getId() == courseId) {
//                course = c;
//                break;
//            }
//        }
//        return course;
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        this.courses.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
//        for(Course c: this.courses) {
//            if(c.getId() == course.getId()) {
//                c.setTitle(course.getTitle());
//                c.setDescription(course.getDescription());
//                break;
//            }
//        }
        courseDao.save(course);
        return course;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCourse(Course course) {
        try {
//            this.courses = this.courses.stream().filter(e->e.getId()!=course.getId()).collect(Collectors.toList());
            courseDao.delete(courseDao.getOne(course.getId()));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
