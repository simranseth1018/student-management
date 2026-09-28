package com.student.management.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentRequest {
    @NotNull
    private Long studentId;
    @NotNull
    private Long courseId;
}
