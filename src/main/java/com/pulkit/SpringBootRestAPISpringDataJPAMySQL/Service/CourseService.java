package com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Service;

import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Binding.Course;
import java.util.List;

public interface CourseService {
    
    //This method will perform insert and update in the table based on the primary key value
    public String upsert(Course course);

    public Course getById(Integer cid);

    public List<Course> getAllCourses();

    public String deleteById(Integer cid);
}
