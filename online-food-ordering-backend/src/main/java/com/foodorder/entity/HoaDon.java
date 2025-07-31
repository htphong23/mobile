package com.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maHD;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @Column(nullable = false)
    private Double tongTien;

    @Column(nullable = false)
    private String trangThai;
}
