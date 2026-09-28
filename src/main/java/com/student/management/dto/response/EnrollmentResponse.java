package com.student.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class EnrollmentResponse {
    private Long id;
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
    private String status;
}
