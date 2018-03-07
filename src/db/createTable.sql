create database car_rental_system;
use car_rental_system;
CREATE TABLE IF NOT EXISTS `User` (
	`code` BIGINT NOT NULL AUTO_INCREMENT = 1000,
	`id` VARCHAR(100) UNIQUE,
	`email` VARCHAR(100) UNIQUE,
	`first_name` VARCHAR(100),
	`last_name` VARCHAR(100),
	`middle_name` VARCHAR(100),
	`password` VARCHAR(20),
	`phone` VARCHAR(20),
	`street` VARCHAR(100),
	`zip` VARCHAR(10),
	PRIMARY KEY (`code`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
--------------------------------------------------------------------------------------
-- (Mena) Tables
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `CarType` varchar(100) DEFAULT NULL,
  `ProviderComp` varchar(100) DEFAULT NULL,
  `Passenger` varchar(100) DEFAULT NULL,
  `Price` varchar(100) DEFAULT NULL,
  `Color` varchar(100) DEFAULT NULL,
  `IsAvailable` varchar(100) DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--------------------------------------------------------------------------------------


