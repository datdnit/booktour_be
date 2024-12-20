package com.hau.tour_service.repository;

import com.hau.tour_service.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, String> {
    Boolean existsByName(String name);
}
