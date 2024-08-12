package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Attachment attachmentId;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String initialLetter;
    @Column(nullable = false)
    private String icon;

}
