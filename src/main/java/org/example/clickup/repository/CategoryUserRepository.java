package org.example.clickup.repository;

import org.example.clickup.model.CategoryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryUserRepository extends JpaRepository<CategoryUser, Integer> {
}
