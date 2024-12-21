package com.hau.event_service.service;

import com.hau.event_service.entity.Endow;
import com.hau.event_service.repo.EndowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EndowService {

    @Autowired
    private EndowRepository repository;

    public List<Endow> findAll() {
        return repository.findAll();
    }

    public Optional<Endow> findById(Long id) {
        return repository.findById(id);
    }

    public Endow save(Endow endow) {
        return repository.save(endow);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
