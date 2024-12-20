package com.hau.tour_service.service;

import com.hau.tour_service.dto.TourCreateRequest;
import com.hau.tour_service.dto.TourUpdateRequest;
import com.hau.tour_service.entity.TourEntity;
import com.hau.tour_service.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.stream.Collectors;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    // Tạo mới tour
    public TourEntity createTour(TourCreateRequest request) {
        if (tourRepository.existsByName(request.getName())) {
            throw new RuntimeException("Tour name already exists");
        }

        TourEntity tour = new TourEntity();

        tour.setName(request.getName());
        tour.setThumbnail(request.getThumbnail());
        tour.setDescription(request.getDescription());
        tour.setPrice(request.getPrice());
        tour.setDuration(request.getDuration());
        tour.setAirline(request.getAirline());
        tour.setStartingGate(request.getStartingGate());
        tour.setStatus(request.getStatus());

        return tourRepository.save(tour);
    }

    // Lấy tất cả các tour
    public List<TourEntity> getAllTours(Integer priceMin, Integer priceMax, String departurePlace) {
        if (priceMin == null || priceMax == null) {
            return tourRepository.findAll();
        }
        
        if (priceMin >= priceMax) {
            return tourRepository.findAll();
        }

        return tourRepository.findAll();
    }

    // Lấy 1 tour dựa theo id
    public TourEntity getTourById(String tourId) {
        return tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Not found tour"));
    }

    // Cập nhật dữ liệu 1 tour dựa theo id
    public TourEntity updateTour(String tourId, TourUpdateRequest request) {
        if (!tourRepository.existsById(tourId)) {
            throw new RuntimeException("Not found tour");
        }

        TourEntity tour = getTourById(tourId);

        tour.setName(request.getName());
        tour.setThumbnail(request.getThumbnail());
        tour.setDescription(request.getDescription());
        tour.setPrice(request.getPrice());
        tour.setDuration(request.getDuration());
        tour.setAirline(request.getAirline());
        tour.setStartingGate(request.getStartingGate());
        tour.setStatus(request.getStatus());

        return tourRepository.save(tour);
    }

    // Thay đổi trạng thái 1 tour dựa theo id
    public TourEntity changeStatusTour(String tourId, String status) {
        if(!tourRepository.existsById(tourId)) {
            throw new RuntimeException("Not found tour");
        }

        TourEntity tour = getTourById(tourId);
        tour.setStatus(status);
        return tourRepository.save(tour);
    }

    // Xóa 1 tour dựa theo id
    public void deleteTour(String tourId) {
        if (!tourRepository.existsById(tourId)) {
            throw new RuntimeException("Not found tour");
        }

        tourRepository.deleteById(tourId);
    }
}
