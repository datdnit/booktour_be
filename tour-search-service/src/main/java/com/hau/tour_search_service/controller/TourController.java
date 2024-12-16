package com.hau.tour_search_service.controller;

import com.hau.tour_search_service.model.Tour;
import com.hau.tour_search_service.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        Tour tour = tourService.getTourById(id);
        return tour != null ? ResponseEntity.ok(tour) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tour addTour(@RequestBody Tour tour) {
        return tourService.addTour(tour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour updatedTour) {
        Tour tour = tourService.updateTour(id, updatedTour);
        return tour != null ? ResponseEntity.ok(tour) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.noContent().build();
    }
}
