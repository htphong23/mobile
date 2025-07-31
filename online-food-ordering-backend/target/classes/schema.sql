CREATE DATABASE IF NOT EXISTS food_ordering_db
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE food_ordering_db;

-- Bảng người dùng
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng món ăn
CREATE TABLE IF NOT EXISTS monan (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ten_mon_an VARCHAR(255) NOT NULL,
    mo_ta TEXT,
    gia DECIMAL(10,2) NOT NULL,
    hinh_anh VARCHAR(255)
);

-- Bảng đơn hàng
CREATE TABLE IF NOT EXISTS orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    ngay_dat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tong_tien DECIMAL(12,2) NOT NULL,
    trang_thai VARCHAR(50) DEFAULT 'Đang xử lý',
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Bảng chi tiết đơn hàng
CREATE TABLE IF NOT EXISTS order_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    monan_id BIGINT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY (monan_id) REFERENCES monan(id)
);