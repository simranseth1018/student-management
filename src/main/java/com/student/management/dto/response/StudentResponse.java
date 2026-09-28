package com.student.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String studentId;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String className;
    private String phone;
}
