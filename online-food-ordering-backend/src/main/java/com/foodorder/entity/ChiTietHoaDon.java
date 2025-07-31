package com.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ChiTietHoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maCTHD;

    @ManyToOne
    @JoinColumn(name = "maHD")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "maPhieu")
    private GioHang gioHang;

    @Column(nullable = false)
    private Double thanhTien;
}
