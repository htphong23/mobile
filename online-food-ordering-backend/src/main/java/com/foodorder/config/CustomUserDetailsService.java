package com.foodorder.config;

import com.foodorder.entity.KhachHang;
import com.foodorder.entity.NhanVien;
import com.foodorder.repository.KhachHangRepository;
import com.foodorder.repository.NhanVienRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final KhachHangRepository khachHangRepository;
    private final NhanVienRepository nhanVienRepository;

    public CustomUserDetailsService(KhachHangRepository khachHangRepository,
                                    NhanVienRepository nhanVienRepository) {
        this.khachHangRepository = khachHangRepository;
        this.nhanVienRepository = nhanVienRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Tìm trong bảng Khách Hàng
        KhachHang kh = khachHangRepository.findByUsername(username).orElse(null);
        if (kh != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(kh.getUsername())
                    .password(kh.getPassword())
                    .roles("USER")
                    .build();
        }

        // Tìm trong bảng Nhân Viên
        NhanVien nv = nhanVienRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(nv.getUsername())
                .password(nv.getPassword())
                .roles("ADMIN")
                .build();
    }
}