package com.student.management.repository;

import com.student.management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);
    List<Course> findByTeacherId(Long teacherId);
    boolean existsByCode(String code);
}
