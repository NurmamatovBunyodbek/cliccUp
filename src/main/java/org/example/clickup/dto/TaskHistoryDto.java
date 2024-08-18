package org.example.clickup.dto;

import lombok.Data;

@Data
public class TaskHistoryDto {
    private Integer taskId;
    private String changeFieldName;
    private String before;
    private String after;
    private String data;
}
