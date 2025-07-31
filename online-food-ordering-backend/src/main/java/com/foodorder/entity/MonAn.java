package com.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MonAn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maMA;

    @Column(nullable = false)
    private String tenMonAn;

    @ManyToOne
    @JoinColumn(name = "maLMA", nullable = false)
    private LoaiMonAn loaiMonAn;

    @Column(nullable = false)
    private Double gia;
}
