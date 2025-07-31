package com.foodorder.controller;

import com.foodorder.entity.HoaDon;
import com.foodorder.service.HoaDonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoadon")
@CrossOrigin(origins = "*")
public class HoaDonController {

    private final HoaDonService service;

    public HoaDonController(HoaDonService service) {
        this.service = service;
    }

    @GetMapping
    public List<HoaDon> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<HoaDon> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HoaDon create(@RequestBody HoaDon hd) {
        return service.save(hd);
    }

    @PutMapping("/{id}")
    public HoaDon update(@PathVariable Long id, @RequestBody HoaDon hd) {
        hd.setMaHD(id);
        return service.save(hd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
