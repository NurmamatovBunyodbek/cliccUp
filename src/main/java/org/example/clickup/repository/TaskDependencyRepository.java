package org.example.clickup.repository;

import org.example.clickup.model.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDependencyRepository extends JpaRepository<TaskDependency, Integer> {
}
