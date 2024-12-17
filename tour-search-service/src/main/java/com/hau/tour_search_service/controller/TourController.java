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

    // API lấy tất cả tour
    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    // API tìm kiếm tour theo tên
    @GetMapping("/search")
    public List<Tour> searchTours(@RequestParam String name) {
        return tourService.searchTours(name);
    }

    // API lấy tour theo id
    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        Tour tour = tourService.getTourById(id);
        return tour != null ? ResponseEntity.ok(tour) : ResponseEntity.notFound().build();
    }

    // API thêm mới tour
    @PostMapping
    public Tour addTour(@RequestBody Tour tour) {
        return tourService.addTour(tour);
    }

    // API cập nhật tour
    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour updatedTour) {
        Tour tour = tourService.updateTour(id, updatedTour);
        return tour != null ? ResponseEntity.ok(tour) : ResponseEntity.notFound().build();
    }

    // API xóa tour
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.noContent().build();
    }
}
