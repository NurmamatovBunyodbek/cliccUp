package org.example.clickup.repository;

import org.example.clickup.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskUserRepository extends JpaRepository<TaskUser, Integer> {
}
