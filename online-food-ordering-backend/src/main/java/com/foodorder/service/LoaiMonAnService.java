package com.foodorder.service;

import com.foodorder.entity.LoaiMonAn;
import com.foodorder.repository.LoaiMonAnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiMonAnService {

    private final LoaiMonAnRepository repo;

    public LoaiMonAnService(LoaiMonAnRepository repo) {
        this.repo = repo;
    }

    public List<LoaiMonAn> getAll() {
        return repo.findAll();
    }

    public Optional<LoaiMonAn> getById(Long id) {
        return repo.findById(id);
    }

    public LoaiMonAn save(LoaiMonAn loai) {
        return repo.save(loai);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
