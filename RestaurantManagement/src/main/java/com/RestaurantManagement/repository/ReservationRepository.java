package com.RestaurantManagement.repository;

import com.RestaurantManagement.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
