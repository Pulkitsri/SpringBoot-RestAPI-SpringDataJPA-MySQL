package com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Binding.Course;
import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public String upsert(Course course) {
        courseRepo.save(course); //save method internally perform upsert operation
        return "success";
    }

    @Override
    public Course getById(Integer cid) {
        Optional<Course> byId = courseRepo.findById(cid);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteById(Integer cid) {
        if(courseRepo.existsById(cid)){
            courseRepo.deleteById(cid);
            return "Deleted Succesfully";
        }
        else{
            return "No record Found";
        }
        
    }
    

}
