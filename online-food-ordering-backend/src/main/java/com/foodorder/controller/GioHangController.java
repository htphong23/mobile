package com.foodorder.controller;

import com.foodorder.entity.GioHang;
import com.foodorder.service.GioHangService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giohang")
@CrossOrigin(origins = "*")
public class GioHangController {

    private final GioHangService service;

    public GioHangController(GioHangService service) {
        this.service = service;
    }

    @GetMapping("/{maKH}")
    public List<GioHang> getByKhachHang(@PathVariable Long maKH) {
        return service.getAllByKhachHang(maKH);
    }

    @PostMapping
    public GioHang addItem(@RequestBody GioHang gh) {
        return service.save(gh);
    }

    @PutMapping("/{id}")
    public GioHang update(@PathVariable Long id, @RequestBody GioHang gh) {
        gh.setMaPhieu(id);
        return service.save(gh);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
