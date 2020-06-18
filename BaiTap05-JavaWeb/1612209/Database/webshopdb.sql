-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 04, 2019 lúc 06:47 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webshopdb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanphams`
--

CREATE TABLE `loaisanphams` (
  `MaLoaiSP` int(11) NOT NULL,
  `TenLoaiSP` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanphams`
--

INSERT INTO `loaisanphams` (`MaLoaiSP`, `TenLoaiSP`) VALUES
(1, 'Áo sơ mi'),
(2, 'Áo dài'),
(3, 'quần kaki'),
(4, 'Áo cánh'),
(5, 'Áo thời trang'),
(6, 'Đồ thời trang'),
(7, 'Áo khoác'),
(8, 'Đồ ngủ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanphams`
--

CREATE TABLE `sanphams` (
  `MaSP` int(11) NOT NULL,
  `GiaBan` double DEFAULT NULL,
  `NgayTiepNhan` datetime DEFAULT NULL,
  `MoTa` varchar(200) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `HinhAnh` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `XuatXu` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `TenSP` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `NhaSanXuat` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `LoaiSP` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `sanphams`
--

INSERT INTO `sanphams` (`MaSP`, `GiaBan`, `NgayTiepNhan`, `MoTa`, `HinhAnh`, `XuatXu`, `TenSP`, `NhaSanXuat`, `SoLuong`, `LoaiSP`) VALUES
(1, 80000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/1.jpg', 'Việt Nam', 'Áo ren hồng L01', 'NTK Văn Nam', 10, 4),
(2, 60000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/2.jpg', 'Âu-Mĩ', 'Áo cánh xẻ 02', 'Chưa có thông tin', 10, 4),
(3, 90000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/3.jpg', 'Việt Nam', 'Áo bo 01', 'VN', 10, 5),
(4, 80000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/4.jpg', 'Việt Nam', 'Áo khoác nữ', 'VN', 10, 7),
(5, 110000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/5.jpg', 'Việt Nam', 'Áo thời trang MS02', 'VN', 10, 5),
(6, 60000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/6.jpg', 'Việt Nam', 'Set đồ thời trang 1', 'VN', 10, 6),
(7, 90000, '2019-05-04 00:00:00', 'Không có mô tả', './img/product/7.jpg', 'Việt Nam', 'Áo thời trang NEW', 'VN', 10, 5),
(8, 100000, '2019-05-04 00:00:00', 'Đồ ngủ liền set', './img/product/8.jpg', 'Châu Âu', 'Đồ ngủ nguyên set', 'VN', 5, 8),
(9, 90000, '2019-05-04 00:00:00', 'Đồ thời trang', './img/product/9.jpg', 'Nhật Bản', 'Đồ thời trang 02', 'VN', 10, 6),
(10, 90000, '2019-05-04 00:00:00', 'Chỉ bán áo', './img/product/10.jpg', 'Việt Nam', 'Áo xẻ cánh LS2', 'USA', 10, 5),
(11, 150000, '2019-05-04 00:00:00', 'Khuyến mãi 5%', './img/product/11.jpg', 'Italia', 'Đồ bộ trắng-xanh', 'John', 25, 6),
(12, 250000, '2019-05-04 00:00:00', 'Số lượng có hạn', './img/product/12.jpg', 'Holywood', 'Áo Taylor Swift', 'Chưa xác định', 1, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoans`
--

CREATE TABLE `taikhoans` (
  `MaTaiKhoan` int(11) NOT NULL,
  `TenTaiKhoan` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `MatKhau` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `TenDangNhap` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoans`
--

INSERT INTO `taikhoans` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `TenDangNhap`) VALUES
(1, 'Nguyễn Hữu Hòa', '123', 'admin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanphams`
--
ALTER TABLE `loaisanphams`
  ADD PRIMARY KEY (`MaLoaiSP`);

--
-- Chỉ mục cho bảng `sanphams`
--
ALTER TABLE `sanphams`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK_dqfp38mmhh03s8qbdvle0kjwu` (`LoaiSP`);

--
-- Chỉ mục cho bảng `taikhoans`
--
ALTER TABLE `taikhoans`
  ADD PRIMARY KEY (`MaTaiKhoan`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaisanphams`
--
ALTER TABLE `loaisanphams`
  MODIFY `MaLoaiSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sanphams`
--
ALTER TABLE `sanphams`
  MODIFY `MaSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `taikhoans`
--
ALTER TABLE `taikhoans`
  MODIFY `MaTaiKhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sanphams`
--
ALTER TABLE `sanphams`
  ADD CONSTRAINT `FK_dqfp38mmhh03s8qbdvle0kjwu` FOREIGN KEY (`LoaiSP`) REFERENCES `loaisanphams` (`MaLoaiSP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
