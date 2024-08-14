package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.Icon;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickAppsDto {
    private String name;
    private Integer iconid;
}
