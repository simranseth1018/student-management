package com.student.management.service;

import com.student.management.dto.request.AttendanceRequest;
import com.student.management.dto.response.AttendanceResponse;
import com.student.management.entity.Attendance;
import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.exception.ResourceNotFoundException;
import com.student.management.repository.AttendanceRepository;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public AttendanceResponse markAttendance(AttendanceRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Attendance attendance = Attendance.builder()
                .student(student)
                .course(course)
                .date(request.getDate())
                .status(request.getStatus())
                .build();

        return toResponse(attendanceRepository.save(attendance));
    }

    public List<AttendanceResponse> getAttendanceByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId).stream()
                .map(this::toResponse)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<AttendanceResponse> getAttendanceByCourseAndDate(Long courseId, LocalDate date) {
        return attendanceRepository.findByCourseIdAndDate(courseId, date).stream()
                .map(this::toResponse)
                .collect(java.util.stream.Collectors.toList());
    }

    private AttendanceResponse toResponse(Attendance attendance) {
        return AttendanceResponse.builder()
                .id(attendance.getId())
                .studentName(attendance.getStudent().getUser().getFirstName() + " " + attendance.getStudent().getUser().getLastName())
                .courseName(attendance.getCourse().getName())
                .date(attendance.getDate())
                .status(attendance.getStatus())
                .build();
    }
}
