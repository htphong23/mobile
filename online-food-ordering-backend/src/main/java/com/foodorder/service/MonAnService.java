package com.foodorder.service;

import com.foodorder.entity.MonAn;
import com.foodorder.repository.MonAnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonAnService {

    private final MonAnRepository repo;

    public MonAnService(MonAnRepository repo) {
        this.repo = repo;
    }

    public List<MonAn> getAll() {
        return repo.findAll();
    }

    public Optional<MonAn> getById(Long id) {
        return repo.findById(id);
    }

    public MonAn save(MonAn monAn) {
        return repo.save(monAn);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
