package com.hau.event_service.controller;

import com.hau.event_service.entity.EventPromotion;
import com.hau.event_service.service.EventPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events-promotions")
public class EventPromotionController {

    @Autowired
    private EventPromotionService service;

    @GetMapping
    public List<EventPromotion> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EventPromotion getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public EventPromotion create(@RequestBody EventPromotion eventPromotion) {
        return service.save(eventPromotion);
    }

    @PutMapping("/{id}")
    public EventPromotion update(@PathVariable Long id, @RequestBody EventPromotion eventPromotion) {
        eventPromotion.setId(id);
        return service.save(eventPromotion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
