package com.student.management.dto.request;

import com.student.management.enums.AttendanceStatus;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceRequest {
    @NotNull
    private Long studentId;
    @NotNull
    private Long courseId;
    @NotNull
    private LocalDate date;
    @NotNull
    private AttendanceStatus status;
}
