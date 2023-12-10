-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for siswa_2020130036
DROP DATABASE IF EXISTS `siswa_2020130036`;
CREATE DATABASE IF NOT EXISTS `siswa_2020130036` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `siswa_2020130036`;

-- Dumping structure for table siswa_2020130036.matakuliah
DROP TABLE IF EXISTS `matakuliah`;
CREATE TABLE IF NOT EXISTS `matakuliah` (
  `KodeMK` char(6) COLLATE utf8mb4_general_ci NOT NULL,
  `NamaMK` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SKS` int DEFAULT NULL,
  `Praktek` int DEFAULT NULL,
  PRIMARY KEY (`KodeMK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table siswa_2020130036.matakuliah: ~2 rows (approximately)
DELETE FROM `matakuliah`;
INSERT INTO `matakuliah` (`KodeMK`, `NamaMK`, `SKS`, `Praktek`) VALUES
	('DK0001', 'Algoritma', 4, 1),
	('DU0001', 'Pancasila', 2, 0),
	('DU0002', 'Bahasa Inggris', 3, 0);

-- Dumping structure for table siswa_2020130036.siswa
DROP TABLE IF EXISTS `siswa`;
CREATE TABLE IF NOT EXISTS `siswa` (
  `NPM` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `Nama` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Alamat` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`NPM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table siswa_2020130036.siswa: ~2 rows (approximately)
DELETE FROM `siswa`;
INSERT INTO `siswa` (`NPM`, `Nama`, `Alamat`) VALUES
	('2000110001', 'Budi', 'Dago 31'),
	('2000120002', 'Andre', 'Sudirman 57'),
	('2001110003', 'Antonius', 'Paskal 29');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
