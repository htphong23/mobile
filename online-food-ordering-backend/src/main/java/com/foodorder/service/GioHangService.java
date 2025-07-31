package com.foodorder.service;

import com.foodorder.entity.GioHang;
import com.foodorder.repository.GioHangRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangService {

    private final GioHangRepository repo;

    public GioHangService(GioHangRepository repo) {
        this.repo = repo;
    }

    public List<GioHang> getAllByKhachHang(Long maKH) {
        return repo.findByKhachHang_MaKH(maKH);
    }

    public GioHang save(GioHang gioHang) {
        return repo.save(gioHang);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Optional<GioHang> getById(Long id) {
        return repo.findById(id);
    }
}
