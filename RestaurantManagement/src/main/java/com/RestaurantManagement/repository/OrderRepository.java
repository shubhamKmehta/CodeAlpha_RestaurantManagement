package com.RestaurantManagement.repository;

import com.RestaurantManagement.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByTableId(Long tableId);
}
