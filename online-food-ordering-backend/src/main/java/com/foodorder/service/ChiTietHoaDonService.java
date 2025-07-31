package com.foodorder.service;

import com.foodorder.entity.ChiTietHoaDon;
import com.foodorder.repository.ChiTietHoaDonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietHoaDonService {

    private final ChiTietHoaDonRepository repo;

    public ChiTietHoaDonService(ChiTietHoaDonRepository repo) {
        this.repo = repo;
    }

    public List<ChiTietHoaDon> getAll() {
        return repo.findAll();
    }

    public Optional<ChiTietHoaDon> getById(Long id) {
        return repo.findById(id);
    }

    public ChiTietHoaDon save(ChiTietHoaDon cthd) {
        return repo.save(cthd);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
