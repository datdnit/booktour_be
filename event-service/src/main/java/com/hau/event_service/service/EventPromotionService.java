package com.hau.event_service.service;

import com.hau.event_service.entity.EventPromotion;
import com.hau.event_service.repo.EventPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventPromotionService {

    @Autowired
    private EventPromotionRepository repository;

    public List<EventPromotion> findAll() {
        return repository.findAll();
    }

    public Optional<EventPromotion> findById(Long id) {
        return repository.findById(id);
    }

    public EventPromotion save(EventPromotion eventPromotion) {
        return repository.save(eventPromotion);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
