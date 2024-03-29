package com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pulkit.SpringBootRestAPISpringDataJPAMySQL.Binding.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Serializable>{
    
}
