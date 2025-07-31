USE food_ordering_db;

-- Xóa dữ liệu cũ để tránh trùng lặp khi restart
DELETE FROM khach_hang;
DELETE FROM nhan_vien;

-- Thêm tài khoản Khách Hàng (user1 / 123456)
INSERT INTO khach_hang (ho_ten, ngay_sinh, dia_chi, username, password, email, sdt)
VALUES 
('Nguyen Van A', '1998-05-12', 'Hà Nội', 'user1',
'$2a$10$Hnfs1L8wrhL3RHF1FPL7LOr1T1uKXJZ9T3z9HJjhJPMWFeuXJDR9m',
'user1@example.com', '0912345678');

-- Thêm tài khoản Nhân Viên (admin / 123456)
INSERT INTO nhan_vien (ho_ten, ngay_sinh, dia_chi, username, password, email, sdt, chuc_vu)
VALUES 
('Tran Van B', '1990-01-01', 'TP HCM', 'admin',
'$2a$10$Hnfs1L8wrhL3RHF1FPL7LOr1T1uKXJZ9T3z9HJjhJPMWFeuXJDR9m',
'admin@example.com', '0987654321', 'Quản lý');

-- Thêm món ăn mẫu
INSERT INTO monan (ten_mon_an, mo_ta, gia, hinh_anh) VALUES
('Phở bò', 'Phở bò truyền thống Việt Nam', 45000, 'pho_bo.jpg'),
('Bánh mì thịt', 'Bánh mì Việt Nam nhân thịt heo và rau', 20000, 'banh_mi.jpg'),
('Trà sữa trân châu', 'Thức uống yêu thích của giới trẻ', 30000, 'tra_sua.jpg');

-- Thêm đơn hàng mẫu
INSERT INTO orders (user_id, tong_tien, trang_thai) VALUES
(2, 75000, 'Hoàn thành');

-- Thêm chi tiết đơn hàng mẫu
INSERT INTO order_items (order_id, monan_id, so_luong, gia) VALUES
(1, 1, 1, 45000),
(1, 3, 1, 30000);