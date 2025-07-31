package com.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LoaiMonAn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiMonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLMA;

    @Column(nullable = false, unique = true)
    private String tenLoaiMonAn;
}
