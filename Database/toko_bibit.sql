-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2020 at 10:53 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_bibit`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(10) NOT NULL,
  `nama_admin` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `nama_admin`, `password`, `jenis_kelamin`) VALUES
('adm001', 'saya admin', '012', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(10) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga` int(15) NOT NULL,
  `id_kategori` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga`, `id_kategori`) VALUES
(10, 'tabebuya', 45000, 101),
(20, 'pupuk kompos', 15000, 102),
(30, 'pot tanaman', 25000, 103),
(50, 'bonsai', 85000, 101),
(60, 'anggrek', 80000, 101),
(70, 'kamboja', 50000, 101),
(80, 'garpu mini', 27500, 105),
(90, 'Kamboja', 40000, 101);

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelamin`
--

CREATE TABLE `jenis_kelamin` (
  `jenis_kelamin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis_kelamin`
--

INSERT INTO `jenis_kelamin` (`jenis_kelamin`) VALUES
('Laki-Laki'),
('Perempuan');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(10) NOT NULL,
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(101, 'tanaman'),
(102, 'perawatan'),
(103, 'media tanaman'),
(104, 'Referensi'),
(105, 'Peralatan');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_user` varchar(10) NOT NULL,
  `nama_user` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Telepon` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_user`, `nama_user`, `alamat`, `email`, `jenis_kelamin`, `username`, `password`, `Telepon`) VALUES
('TB001', 'fadila', 'Probolinggo', 'fadilayoga@gmail.com', 'Laki-Laki', 'fadilayoga', '012', '081325567801'),
('TB002', 'Bimo', 'Jakarta', 'BimoPd@gmail.com', 'Laki-Laki', 'Bim57', '013', '085123456792');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_user` varchar(10) NOT NULL,
  `id_barang` int(10) NOT NULL,
  `jumlah` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_user`, `id_barang`, `jumlah`) VALUES
('TB001', 80, 1),
('TB002', 20, 2),
('TB001', 100, 2),
('TB001', 100, 1),
('TB001', 60, 2),
('TB001', 30, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`),
  ADD KEY `jenis_foreignkey1` (`jenis_kelamin`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `kategori_ibfk_1` (`id_kategori`);

--
-- Indexes for table `jenis_kelamin`
--
ALTER TABLE `jenis_kelamin`
  ADD PRIMARY KEY (`jenis_kelamin`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `jenis_foreignkey` (`jenis_kelamin`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD KEY `barang_ibfk1` (`id_barang`),
  ADD KEY `member_ibfk1` (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `jenis_foreignkey1` FOREIGN KEY (`jenis_kelamin`) REFERENCES `jenis_kelamin` (`jenis_kelamin`);

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `kategori_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `jenis_foreignkey` FOREIGN KEY (`jenis_kelamin`) REFERENCES `jenis_kelamin` (`jenis_kelamin`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `barang_ibfk1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `member_ibfk1` FOREIGN KEY (`id_user`) REFERENCES `member` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
