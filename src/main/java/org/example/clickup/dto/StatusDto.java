package org.example.clickup.dto;

import jakarta.persistence.metamodel.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
    private String name;
    private Integer spaceId;
    private Integer projectId;
    private Integer categoryId;
    private String color;
    private Type type;
}
