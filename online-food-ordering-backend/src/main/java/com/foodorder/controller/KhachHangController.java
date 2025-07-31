package com.foodorder.controller;

import com.foodorder.entity.KhachHang;
import com.foodorder.service.KhachHangService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
@CrossOrigin(origins = "*")
public class KhachHangController {

    private final KhachHangService service;

    public KhachHangController(KhachHangService service) {
        this.service = service;
    }

    @GetMapping
    public List<KhachHang> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<KhachHang> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public KhachHang create(@RequestBody KhachHang kh) {
        return service.save(kh);
    }

    @PutMapping("/{id}")
    public KhachHang update(@PathVariable Long id, @RequestBody KhachHang kh) {
        kh.setMaKH(id);
        return service.save(kh);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
