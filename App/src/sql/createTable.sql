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

