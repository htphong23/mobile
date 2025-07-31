package com.foodorder.controller;

import com.foodorder.entity.NhanVien;
import com.foodorder.service.NhanVienService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhanvien")
@CrossOrigin(origins = "*")
public class NhanVienController {

    private final NhanVienService service;

    public NhanVienController(NhanVienService service) {
        this.service = service;
    }

    @GetMapping
    public List<NhanVien> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<NhanVien> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public NhanVien create(@RequestBody NhanVien nv) {
        return service.save(nv);
    }

    @PutMapping("/{id}")
    public NhanVien update(@PathVariable Long id, @RequestBody NhanVien nv) {
        nv.setMaNV(id);
        return service.save(nv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
    