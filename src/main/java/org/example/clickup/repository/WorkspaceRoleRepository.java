package org.example.clickup.repository;

import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRoleRepository extends JpaRepository<WorkSpaceRole,Integer> {

}
