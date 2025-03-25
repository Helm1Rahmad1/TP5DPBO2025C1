-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 25, 2025 at 04:45 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `tempat_tinggal` varchar(255) DEFAULT 'Anak Kost'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `tempat_tinggal`) VALUES
(1, '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 'Anak Kost'),
(2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 'PP (Pulang Pergi)'),
(3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 'Asrama'),
(4, '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 'Anak Kost'),
(5, '2202046', 'Nurainun', 'Perempuan', 'PP (Pulang Pergi)'),
(6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 'Asrama'),
(7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 'Anak Kost'),
(8, '2202869', 'Revana Faliha Salma', 'Perempuan', 'PP (Pulang Pergi)'),
(9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 'Asrama'),
(10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 'Anak Kost'),
(11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 'PP (Pulang Pergi)'),
(12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 'Asrama'),
(13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 'Anak Kost'),
(14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 'PP (Pulang Pergi)'),
(15, '2203484', 'Arya Aydin Margono', 'Laki-laki', 'Asrama'),
(16, '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 'Anak Kost'),
(17, '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 'PP (Pulang Pergi)'),
(18, '2206697', 'Rifa Sania', 'Perempuan', 'Asrama'),
(19, '2207260', 'Imam Chalish Rafidhul Haque', 'Laki-laki', 'Anak Kost'),
(20, '2204343', 'Meiva Labibah Putri', 'Perempuan', 'PP (Pulang Pergi)'),
(28, '2311574', 'Muhammad Helmi Rahmadi', 'Laki-laki', 'Anak Kost');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
