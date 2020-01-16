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


-- Dumping database structure for course
CREATE DATABASE IF NOT EXISTS `course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `course`;

-- Dumping structure for table course.addusercase
CREATE TABLE IF NOT EXISTS `addusercase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL DEFAULT '123456',
  `age` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `permission` varchar(10) DEFAULT '1',
  `isDelete` varchar(10) DEFAULT '1',
  `expected` varchar(100) DEFAULT 'true',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table course.addusercase: ~1 rows (approximately)
/*!40000 ALTER TABLE `addusercase` DISABLE KEYS */;
INSERT INTO `addusercase` (`id`, `userId`, `userName`, `password`, `age`, `sex`, `permission`, `isDelete`, `expected`) VALUES
	(1, 2, 'hello', '123456', '1', '1', '0', '1', 'true');
/*!40000 ALTER TABLE `addusercase` ENABLE KEYS */;

-- Dumping structure for table course.getuserinfocase
CREATE TABLE IF NOT EXISTS `getuserinfocase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(100) DEFAULT 'getUserInfo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table course.getuserinfocase: ~1 rows (approximately)
/*!40000 ALTER TABLE `getuserinfocase` DISABLE KEYS */;
INSERT INTO `getuserinfocase` (`id`, `userId`, `expected`) VALUES
	(1, 1, 'getUserInfoForCaseCheck');
/*!40000 ALTER TABLE `getuserinfocase` ENABLE KEYS */;

-- Dumping structure for table course.getuserlistcase
CREATE TABLE IF NOT EXISTS `getuserlistcase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `age` varchar(10) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `expected` varchar(100) DEFAULT 'getUserListForCaseCheck',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table course.getuserlistcase: ~2 rows (approximately)
/*!40000 ALTER TABLE `getuserlistcase` DISABLE KEYS */;
INSERT INTO `getuserlistcase` (`id`, `userName`, `age`, `sex`, `expected`) VALUES
	(1, 'testadd', '1', '1', 'getUserListForCaseCheck'),
	(2, 'testfailed', '1', '1', 'getUserListForCaseCheck'),
	(3, 'hello', '12', '2', 'getUserListForCaseCheck');
/*!40000 ALTER TABLE `getuserlistcase` ENABLE KEYS */;

-- Dumping structure for table course.logincase
CREATE TABLE IF NOT EXISTS `logincase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `expected` varchar(100) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table course.logincase: ~1 rows (approximately)
/*!40000 ALTER TABLE `logincase` DISABLE KEYS */;
INSERT INTO `logincase` (`id`, `userName`, `password`, `expected`) VALUES
	(1, 'yywang', '123456', 'true'),
	(2, 'yywang', '444444', 'false');
/*!40000 ALTER TABLE `logincase` ENABLE KEYS */;

-- Dumping structure for table course.updateuserinfocase
CREATE TABLE IF NOT EXISTS `updateuserinfocase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `permission` varchar(10) DEFAULT NULL,
  `isDelete` varchar(10) DEFAULT NULL,
  `expected` varchar(100) DEFAULT 'getUpdateUserInfoForCaseCheck',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table course.updateuserinfocase: ~0 rows (approximately)
/*!40000 ALTER TABLE `updateuserinfocase` DISABLE KEYS */;
INSERT INTO `updateuserinfocase` (`id`, `userId`, `userName`, `age`, `sex`, `permission`, `isDelete`, `expected`) VALUES
	(1, 2, 'testupdate', '2', '2', '1', '1', 'getUpdateUserInfoForCaseCheck'),
	(2, 3, 'hello', NULL, NULL, NULL, '2', 'getUpdateUserInfoForCaseCheck'),
	(3, 4, NULL, NULL, NULL, NULL, '2', 'getUpdateUserInfoForCaseCheck');
/*!40000 ALTER TABLE `updateuserinfocase` ENABLE KEYS */;

-- Dumping structure for table course.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `age` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `permission` varchar(10) DEFAULT NULL,
  `isDelete` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- Dumping data for table course.user: ~37 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `age`, `sex`, `permission`, `isDelete`) VALUES
	(1, 'yywang', '123456', '1', '2', '1', '0'),
	(2, 'testupdate', '', '2', '2', '1', '1'),
	(3, 'hello', '123456', '1', '2', NULL, '2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
