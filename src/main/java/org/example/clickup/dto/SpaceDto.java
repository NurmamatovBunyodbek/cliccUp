package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {
    private String name;
    private String color;
    private String initial_letter;
    private String avatar_id;
    private String acces_type;
}
