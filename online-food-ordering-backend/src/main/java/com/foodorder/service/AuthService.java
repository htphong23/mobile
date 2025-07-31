package com.foodorder.service;

import com.foodorder.dto.AuthRequest;
import com.foodorder.dto.RegisterRequest;
import com.foodorder.entity.KhachHang;
import com.foodorder.repository.KhachHangRepository;
import com.foodorder.config.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final KhachHangRepository khRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(KhachHangRepository khRepo, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.khRepo = khRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest req) {
        KhachHang kh = new KhachHang();
        kh.setHoTen(req.getHoTen());
        kh.setNgaySinh(req.getNgaySinh());
        kh.setDiaChi(req.getDiaChi());
        kh.setUsername(req.getTaiKhoan());
        kh.setPassword(passwordEncoder.encode(req.getMatKhau()));
        kh.setEmail(req.getEmail());
        kh.setSdt(req.getSdt());
        khRepo.save(kh);
        return jwtService.generateToken(kh.getUsername(), "ROLE_USER");
    }

    public String login(AuthRequest req) {
        KhachHang kh = khRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));
        if (!passwordEncoder.matches(req.getPassword(), kh.getPassword())) {
            throw new RuntimeException("Mật khẩu không đúng");
        }
        return jwtService.generateToken(kh.getUsername(), "ROLE_USER");
    }
}
