package com.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNV;

    @Column(nullable = false)
    private String hoTen;

    @Column(nullable = false)
    private String ngaySinh;

    @Column(nullable = false)
    private String diaChi;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 10)
    private String sdt;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String chucVu; // ADMIN hoặc NHANVIEN
}
