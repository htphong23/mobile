package com.foodorder.controller;

import com.foodorder.entity.MonAn;
import com.foodorder.service.MonAnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monan")
@CrossOrigin(origins = "*")
public class MonAnController {

    private final MonAnService service;

    public MonAnController(MonAnService service) {
        this.service = service;
    }

    @GetMapping
    public List<MonAn> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MonAn> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public MonAn create(@RequestBody MonAn monAn) {
        return service.save(monAn);
    }

    @PutMapping("/{id}")
    public MonAn update(@PathVariable Long id, @RequestBody MonAn monAn) {
        monAn.setMaMA(id);
        return service.save(monAn);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
