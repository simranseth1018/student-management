package com.student.management.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GradeRequest {
    @NotNull
    private Long studentId;
    @NotNull
    private Long courseId;
    @NotNull
    private Double score;
    private String grade;
    private String semester;
}
