package com.hau.event_service.repo;

import com.hau.event_service.entity.EventPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPromotionRepository extends JpaRepository<EventPromotion, Long> {
}
