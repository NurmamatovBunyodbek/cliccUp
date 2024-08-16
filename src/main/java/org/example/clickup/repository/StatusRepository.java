package org.example.clickup.repository;

import org.example.clickup.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {

}
