package com.student.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GradeResponse {
    private Long id;
    private String studentName;
    private String courseName;
    private Double score;
    private String grade;
    private String semester;
}
