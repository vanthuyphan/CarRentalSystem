create database car_rental_system;
use car_rental_system;
CREATE TABLE IF NOT EXISTS `User` (
	`user_id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
    `email` VARCHAR(100) UNIQUE,
	`password` VARCHAR(20),
	`phone` VARCHAR(20),
	`address` VARCHAR(100),
    `type` INT,
    `status` INT,
    `created` DATETIME,
    `last_login` DATETIME,
    `insurance_company` VARCHAR(100),
	PRIMARY KEY (`user_id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `UserType` (
	`type_id` BIGINT NOT NULL AUTO_INCREMENT,
	`type` VARCHAR(100),
	PRIMARY KEY (`type_id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
--------------------------------------------------------------------------------------
-- (Mena) car table
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


