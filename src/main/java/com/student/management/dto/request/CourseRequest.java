package com.student.management.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String code;
    private String description;
    @NotNull
    private Integer credits;
    private Long teacherId;
}
