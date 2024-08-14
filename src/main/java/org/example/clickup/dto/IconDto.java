package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.Attachment;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {
    private Integer attachmentId;
    private String color;
    private String initialLetter;
    private String icon;
}
