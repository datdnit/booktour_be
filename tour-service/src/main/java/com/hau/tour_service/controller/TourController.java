package com.hau.tour_service.controller;

import com.hau.tour_service.dto.TourCreateRequest;
import com.hau.tour_service.dto.TourUpdateRequest;
import com.hau.tour_service.entity.TourEntity;
import com.hau.tour_service.service.TourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private TourService tourService;

    // Tạo tour mới
    @PostMapping("/create")
    TourEntity createTour(@RequestBody @Valid TourCreateRequest request) {
        return  tourService.createTour(request);
    }

    // Lấy tất cả các tour và lọc tour theo trường
    @GetMapping
    List<TourEntity> getAllTours(
        @RequestParam(name = "priceMin", required = false) Integer priceMin,
        @RequestParam(name = "priceMax", required = false) Integer priceMax,
        @RequestParam(name = "departurePlace", required = false) String departurePlace
    ) {
        return tourService.getAllTours(priceMin, priceMax, departurePlace);
    }

    // Lấy 1 tour dựa theo id
    @GetMapping("/{tourId}")
    TourEntity getTourById(@PathVariable String tourId) {
        return tourService.getTourById(tourId);
    }

    // Cập nhật dữ liệu của tour dựa theo id
    @PutMapping("/update/{tourId}")
    TourEntity updateTour(@PathVariable String tourId, @RequestBody TourUpdateRequest request) {
        return tourService.updateTour(tourId, request);
    }

    // Thay đổi trạng thái tour dựa theo id
    @PutMapping("/change-status/{tourId}")
    TourEntity changeStatusTour(
        @PathVariable String tourId,
        @RequestParam(name = "status", required = false) String status)
    {
        return tourService.changeStatusTour(tourId, status);
    }

    // Xóa tour dựa theo id
    @DeleteMapping("/delete/{tourId}")
    String deleteTour(@PathVariable String tourId) {
        tourService.deleteTour(tourId);
        return "Tour deleted successfully";
    }
}
