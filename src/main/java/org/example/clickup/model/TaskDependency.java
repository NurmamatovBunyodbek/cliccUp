package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.entity.DependencyType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Task taskid;

    private Integer dependencyTaskId;


    private DependencyType dependencyType;

}
