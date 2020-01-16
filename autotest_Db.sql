-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.18 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for test_my_db
CREATE DATABASE IF NOT EXISTS `test_my_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test_my_db`;

-- Dumping structure for table test_my_db.add_user_case
CREATE TABLE IF NOT EXISTS `add_user_case` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `permission` int(11) DEFAULT '0',
  `isDelete` int(11) DEFAULT '0',
  `expected` varchar(10) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table test_my_db.add_user_case: ~1 rows (approximately)
/*!40000 ALTER TABLE `add_user_case` DISABLE KEYS */;
INSERT INTO `add_user_case` (`id`, `name`, `password`, `age`, `sex`, `permission`, `isDelete`, `expected`) VALUES
	(1, 'testadd', '123456', 12, 'M', 0, 0, 'true');
/*!40000 ALTER TABLE `add_user_case` ENABLE KEYS */;

-- Dumping structure for table test_my_db.get_user_info_case
CREATE TABLE IF NOT EXISTS `get_user_info_case` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(100) DEFAULT 'getUserInfo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test_my_db.get_user_info_case: ~0 rows (approximately)
/*!40000 ALTER TABLE `get_user_info_case` DISABLE KEYS */;
/*!40000 ALTER TABLE `get_user_info_case` ENABLE KEYS */;

-- Dumping structure for table test_my_db.get_user_list_case
CREATE TABLE IF NOT EXISTS `get_user_list_case` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `expected` varchar(100) DEFAULT 'getUserList',
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test_my_db.get_user_list_case: ~0 rows (approximately)
/*!40000 ALTER TABLE `get_user_list_case` DISABLE KEYS */;
/*!40000 ALTER TABLE `get_user_list_case` ENABLE KEYS */;

-- Dumping structure for table test_my_db.login_case
CREATE TABLE IF NOT EXISTS `login_case` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `expected` varchar(100) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table test_my_db.login_case: ~2 rows (approximately)
/*!40000 ALTER TABLE `login_case` DISABLE KEYS */;
INSERT INTO `login_case` (`id`, `name`, `password`, `expected`) VALUES
	(1, 'yywang', '123456', 'true'),
	(2, 'yywang', '1234', 'false');
/*!40000 ALTER TABLE `login_case` ENABLE KEYS */;

-- Dumping structure for table test_my_db.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `isDelete` int(11) DEFAULT '0',
  `permission` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table test_my_db.user: ~12 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `age`, `sex`, `isDelete`, `permission`) VALUES
	(1, 'yywang', '123456', 30, 'W', NULL, 0),
	(2, 'ZhangSan', '123456', 28, 'M', NULL, 0),
	(3, 'LiSi', '123456', 32, 'W', NULL, 0),
	(4, 'WangWu', '123456', 33, 'W', NULL, 0),
	(5, 'test1', '123456', 20, 'M', NULL, 0),
	(6, 'test1', '123456', 20, 'M', NULL, 0),
	(7, 'test3', '123', 20, 'M', NULL, 0),
	(8, 'test4', '123', 20, 'M', NULL, 0),
	(9, '1125yywang', '123456', 20, 'W', NULL, 0),
	(10, '1125yywang', '123456', 30, 'W', NULL, 0),
	(13, 'qqqqq', '1234555', 10, 'M', 0, 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
