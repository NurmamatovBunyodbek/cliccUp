package org.example.clickup.repository;

import org.example.clickup.model.WorkSpaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSpaceUserRepository extends JpaRepository<WorkSpaceUser, Integer> {
}
