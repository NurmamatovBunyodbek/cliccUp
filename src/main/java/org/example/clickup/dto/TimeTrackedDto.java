package org.example.clickup.dto;

import lombok.Data;

import java.security.Timestamp;

@Data
public class TimeTrackedDto {
    private Integer taskId;
    private Timestamp startedAt;
    private Timestamp stoppedAt;
}
