package org.example.clickup.repository;

import org.example.clickup.model.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, Integer> {
}
