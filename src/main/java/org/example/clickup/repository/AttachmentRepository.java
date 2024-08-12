package org.example.clickup.repository;

import org.example.clickup.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
