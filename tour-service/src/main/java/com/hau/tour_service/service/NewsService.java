package com.hau.tour_service.service;
import com.hau.tour_service.entity.News;
import com.hau.tour_service.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NewsService {

    @Autowired
    private NewsRepository repository;

    public List<News> findAll() {
        return repository.findAll();
    }

    public Optional<News> findById(Long id) {
        return repository.findById(id);
    }

    public News save(News news) {
        return repository.save(news);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
