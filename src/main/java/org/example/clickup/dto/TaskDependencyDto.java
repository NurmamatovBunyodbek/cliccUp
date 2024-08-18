package org.example.clickup.dto;

import lombok.Data;
import org.example.clickup.model.entity.DependencyType;

@Data
public class TaskDependencyDto {
    private Integer taskid;
    private Integer dependencyTaskId;
    private DependencyType dependencyType;
}
