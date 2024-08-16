package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.entity.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Space spaceid;
    @ManyToOne
    private Project projectid;
    @ManyToOne
    private Category categoryid;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;


}
