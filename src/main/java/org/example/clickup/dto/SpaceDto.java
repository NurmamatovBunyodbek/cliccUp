package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.Icon;
import org.example.clickup.model.User;
import org.example.clickup.model.Workspace;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {
    private String name;
    private String color;
    private Integer workspaceid;
    private String initial_letter;
    private Integer iconId;
    private String avatar_id;
    private Integer userid;
    private String acces_type;
}
