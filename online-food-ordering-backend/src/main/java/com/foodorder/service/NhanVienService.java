package com.foodorder.service;

import com.foodorder.entity.NhanVien;
import com.foodorder.repository.NhanVienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    private final NhanVienRepository repo;

    public NhanVienService(NhanVienRepository repo) {
        this.repo = repo;
    }

    public List<NhanVien> getAll() {
        return repo.findAll();
    }

    public Optional<NhanVien> getById(Long id) {
        return repo.findById(id);
    }

    public NhanVien save(NhanVien nv) {
        return repo.save(nv);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Optional<NhanVien> getByTaiKhoan(String taiKhoan) {
        return repo.findByUsername(taiKhoan);
    }
}
