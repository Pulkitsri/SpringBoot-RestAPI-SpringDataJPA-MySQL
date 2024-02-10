package com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Binding.Course;
import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Service.CourseService;

@RestController
@RequestMapping
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course courseData){
        String status = courseService.upsert(courseData);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/course/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
        Course coursebyId = courseService.getById(cid);
        return new ResponseEntity<>(coursebyId,HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        java.util.List<Course> allCourses = courseService.getAllCourses();
        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course courseData){
        String status = courseService.upsert(courseData);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    } 

    @DeleteMapping("/course/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
        String status = courseService.deleteById(cid);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
