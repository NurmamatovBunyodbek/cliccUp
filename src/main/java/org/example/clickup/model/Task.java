package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Status statusid;
    @ManyToOne
    private Category categoryid;
    @ManyToOne
    private Priority priorityid;
    @Column(nullable = false)
    private Integer parentTaskId;
    @Column(nullable = false)
    private Timestamp startedDate;
    private boolean startDateHas;
    @Column(nullable = false)
    private Timestamp dueDate;
    private boolean dueDateHas;
    @Column(nullable = false)
    private Long estimateDate;
    private Timestamp activedDate;
}
