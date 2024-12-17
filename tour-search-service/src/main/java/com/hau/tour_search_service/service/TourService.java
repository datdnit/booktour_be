package com.hau.tour_search_service.service;

import com.hau.tour_search_service.model.Tour;
import com.hau.tour_search_service.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    // Phương thức lấy tất cả các tour
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    // Phương thức tìm kiếm tour theo tên
    public List<Tour> searchTours(String name) {
        return tourRepository.findByNameContainingIgnoreCase(name);
    }

    // Phương thức lấy tour theo id
    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    // Phương thức thêm mới tour
    public Tour addTour(Tour tour) {
        return tourRepository.save(tour);
    }

    // Phương thức cập nhật tour
    public Tour updateTour(Long id, Tour updatedTour) {
        if (tourRepository.existsById(id)) {
            updatedTour.setId(id);
            return tourRepository.save(updatedTour);
        }
        return null;
    }

    // Phương thức xóa tour
    public void deleteTour(Long id) {
        if (tourRepository.existsById(id)) {
            tourRepository.deleteById(id);
        }
    }
}
