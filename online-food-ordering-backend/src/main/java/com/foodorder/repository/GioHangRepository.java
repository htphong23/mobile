package com.foodorder.repository;

import com.foodorder.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    List<GioHang> findByKhachHang_MaKH(Long maKH);
}
