package com.student.management.service;

import com.student.management.dto.request.GradeRequest;
import com.student.management.dto.response.GradeResponse;
import com.student.management.entity.Course;
import com.student.management.entity.Grade;
import com.student.management.entity.Student;
import com.student.management.exception.ResourceNotFoundException;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.GradeRepository;
import com.student.management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public GradeResponse assignGrade(GradeRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Grade grade = Grade.builder()
                .student(student)
                .course(course)
                .score(request.getScore())
                .grade(request.getGrade())
                .semester(request.getSemester())
                .build();

        return toResponse(gradeRepository.save(grade));
    }

    public GradeResponse updateGrade(Long id, GradeRequest request) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found with id: " + id));

        grade.setScore(request.getScore());
        grade.setGrade(request.getGrade());
        grade.setSemester(request.getSemester());

        return toResponse(gradeRepository.save(grade));
    }

    public List<GradeResponse> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId).stream()
                .map(this::toResponse)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<GradeResponse> getGradesByCourseId(Long courseId) {
        return gradeRepository.findByCourseId(courseId).stream()
                .map(this::toResponse)
                .collect(java.util.stream.Collectors.toList());
    }

    private GradeResponse toResponse(Grade grade) {
        return GradeResponse.builder()
                .id(grade.getId())
                .studentName(grade.getStudent().getUser().getFirstName() + " " + grade.getStudent().getUser().getLastName())
                .courseName(grade.getCourse().getName())
                .score(grade.getScore())
                .grade(grade.getGrade())
                .semester(grade.getSemester())
                .build();
    }
}
