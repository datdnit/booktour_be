package com.hau.tour_search_service.repository;

import com.hau.tour_search_service.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByNameContainingIgnoreCase(String name);
}
