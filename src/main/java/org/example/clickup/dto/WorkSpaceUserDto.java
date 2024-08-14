package org.example.clickup.dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.User;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.model.Workspace;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaceUserDto {

    private Integer workspaceid;

    private Integer userid;
    private Integer workspaceroleId;

}
