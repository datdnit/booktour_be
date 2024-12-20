package com.hau.news_service.controller;

import com.hau.news_service.entity.News;
import com.hau.news_service.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping
    public List<News> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public News create(@RequestBody News news) {
        return service.save(news);
    }

    @PutMapping("/{id}")
    public News update(@PathVariable Long id, @RequestBody News news) {
        news.setId(id);
        return service.save(news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
