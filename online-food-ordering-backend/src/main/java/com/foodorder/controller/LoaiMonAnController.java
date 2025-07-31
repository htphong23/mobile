package com.foodorder.controller;

import com.foodorder.entity.LoaiMonAn;
import com.foodorder.service.LoaiMonAnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loaimonan")
@CrossOrigin(origins = "*")
public class LoaiMonAnController {

    private final LoaiMonAnService service;

    public LoaiMonAnController(LoaiMonAnService service) {
        this.service = service;
    }

    @GetMapping
    public List<LoaiMonAn> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<LoaiMonAn> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public LoaiMonAn create(@RequestBody LoaiMonAn loai) {
        return service.save(loai);
    }

    @PutMapping("/{id}")
    public LoaiMonAn update(@PathVariable Long id, @RequestBody LoaiMonAn loai) {
        loai.setMaLMA(id);
        return service.save(loai);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
