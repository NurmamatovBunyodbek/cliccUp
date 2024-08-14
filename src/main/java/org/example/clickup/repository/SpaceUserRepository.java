package org.example.clickup.repository;

import org.example.clickup.model.SpaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceUserRepository extends JpaRepository<SpaceUser, Integer> {
}
