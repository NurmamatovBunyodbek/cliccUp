package org.example.clickup.repository;

import org.example.clickup.model.TaskAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAttachmentRepository extends JpaRepository<TaskAttachment,Integer> {
}
