package org.example.clickup.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private String name;
    private Integer projectId;
    private String accessType;
    private Boolean archived;
    private String color;
}
