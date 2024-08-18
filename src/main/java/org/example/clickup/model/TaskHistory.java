package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Task taskid;
    @Column(nullable = false)
    private String changeFieldName;
    @Column(nullable = false)
    private String before;
    @Column(nullable = false)
    private String after;
    @Column(nullable = false)
    private String data;
}
