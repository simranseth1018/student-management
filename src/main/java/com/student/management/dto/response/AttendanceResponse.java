package com.student.management.dto.response;

import com.student.management.enums.AttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class AttendanceResponse {
    private Long id;
    private String studentName;
    private String courseName;
    private LocalDate date;
    private AttendanceStatus status;
}
