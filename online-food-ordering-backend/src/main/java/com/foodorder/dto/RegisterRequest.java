package com.foodorder.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String taiKhoan;
    private String matKhau;
    private String email;
    private String sdt;
}
