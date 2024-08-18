package org.example.clickup.dto;

import lombok.Data;

@Data
public class CheckListItemDto {
    private String name;
    private Integer checkListid;
    private boolean resolved;
    private Integer assignedUserid;
}
