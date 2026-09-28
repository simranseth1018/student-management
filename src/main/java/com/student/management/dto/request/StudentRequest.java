package com.student.management.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {
    @NotBlank
    private String studentId;
    private LocalDate dateOfBirth;
    private String className;
    private String phone;
}
