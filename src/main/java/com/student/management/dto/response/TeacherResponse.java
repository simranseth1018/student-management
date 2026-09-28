package com.student.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeacherResponse {
    private Long id;
    private String employeeId;
    private String email;
    private String firstName;
    private String lastName;
    private String department;
    private String specialization;
    private String phone;
}
