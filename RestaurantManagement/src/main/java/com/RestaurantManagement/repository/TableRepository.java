package com.RestaurantManagement.repository;

import com.RestaurantManagement.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTable, Long> {
}
