package org.example.clickup.repository;

import org.example.clickup.model.CheckListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListItemRepository extends JpaRepository<CheckListItem,Integer> {
}
