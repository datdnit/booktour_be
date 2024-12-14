package com.hau.tour_service.repo;

import com.hau.tour_service.entity.EventPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPromotionRepository extends JpaRepository<EventPromotion, Long> {
}
