package com.student.management.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeacherRequest {
    @NotBlank
    private String employeeId;
    private String department;
    private String specialization;
    private String phone;
}
