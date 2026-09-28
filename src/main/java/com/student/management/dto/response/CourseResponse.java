package com.student.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private String code;
    private String description;
    private Integer credits;
    private String teacherName;
}
