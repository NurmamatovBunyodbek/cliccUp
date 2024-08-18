package org.example.clickup.repository;

import org.example.clickup.model.TimeTracked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTrackedRepository extends JpaRepository<TimeTracked, Integer> {
}
