package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Workspace> workspaceId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String extendRole;

}
