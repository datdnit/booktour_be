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

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public Tour addTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, Tour updatedTour) {
        return tourRepository.findById(id).map(tour -> {
            tour.setName(updatedTour.getName());
            tour.setDescription(updatedTour.getDescription());
            tour.setPrice(updatedTour.getPrice());
            return tourRepository.save(tour);
        }).orElse(null);
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }
}
