package org.example.clickup.dto;

import lombok.Data;

import java.security.Timestamp;

@Data
public class TaskDto {
    private String name;
    private String description;
    private Integer statusId;
    private Integer categoryId;
    private Integer priorityId;
    private Integer parentTaskId;
    private Timestamp startedDate;
    private boolean startDateHas;
    private Timestamp dueDate;
    private boolean dueDateHas;
    private Long estimateDate;
    private Timestamp activedDate;
}
