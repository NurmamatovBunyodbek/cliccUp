package org.example.clickup.dto;

import lombok.Data;

@Data
public class TaskAttachmentDto {
    private Integer taskid;
    private Integer attachmentid;
    private boolean pinCoverImage;
}
