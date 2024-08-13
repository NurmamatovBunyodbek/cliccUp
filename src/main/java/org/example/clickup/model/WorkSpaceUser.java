package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Workspace workspaceid;
    @ManyToOne
    private User userid;
    @OneToOne
    private WorkSpaceRole workspaceroleId;
    @Column(nullable = false)
    private Timestamp date_invited;
    @Column(nullable = false)
    private Timestamp date_joined;
}
