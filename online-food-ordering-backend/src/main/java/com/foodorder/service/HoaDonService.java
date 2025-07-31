package com.foodorder.service;

import com.foodorder.entity.HoaDon;
import com.foodorder.repository.HoaDonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {

    private final HoaDonRepository repo;

    public HoaDonService(HoaDonRepository repo) {
        this.repo = repo;
    }

    public List<HoaDon> getAll() {
        return repo.findAll();
    }

    public Optional<HoaDon> getById(Long id) {
        return repo.findById(id);
    }

    public HoaDon save(HoaDon hoaDon) {
        return repo.save(hoaDon);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
