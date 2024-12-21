package com.hau.event_service.controller;

import com.hau.event_service.entity.Endow;
import com.hau.event_service.service.EndowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endow")
public class EndowController {

    @Autowired
    private EndowService service;

    @GetMapping
    public List<Endow> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Endow getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Endow create(@RequestBody Endow endow) {
        return service.save(endow);
    }

    @PutMapping("/{id}")
    public Endow update(@PathVariable Long id, @RequestBody Endow endow) {
        endow.setId(id);
        return service.save(endow);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
