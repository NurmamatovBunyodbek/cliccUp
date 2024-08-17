package org.example.clickup.repository;

import org.example.clickup.model.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectUserRepository extends JpaRepository<ProjectUser, Integer> {
}
