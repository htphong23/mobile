package com.foodorder.controller;

import com.foodorder.entity.ChiTietHoaDon;
import com.foodorder.service.ChiTietHoaDonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chitiethoadon")
@CrossOrigin(origins = "*")
public class ChiTietHoaDonController {

    private final ChiTietHoaDonService service;

    public ChiTietHoaDonController(ChiTietHoaDonService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChiTietHoaDon> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ChiTietHoaDon> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ChiTietHoaDon create(@RequestBody ChiTietHoaDon cthd) {
        return service.save(cthd);
    }

    @PutMapping("/{id}")
    public ChiTietHoaDon update(@PathVariable Long id, @RequestBody ChiTietHoaDon cthd) {
        cthd.setMaCTHD(id);
        return service.save(cthd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
