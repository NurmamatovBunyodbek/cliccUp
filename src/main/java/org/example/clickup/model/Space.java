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
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @ManyToMany
    private List<Workspace> workspaceid;
    @Column(nullable = false)
    private String initial_letter;
    @ManyToMany
    private List<Icon> iconId;
    @Column(nullable = false)
    private String avatar_id;
    @OneToOne
    private User userid;
    @Column(nullable = false)
    private String acces_type;
}
