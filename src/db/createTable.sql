create database car_rental_system;
use car_rental_system;

CREATE TABLE IF NOT EXISTS `UserType` (
	`type_id` BIGINT NOT NULL AUTO_INCREMENT,
	`type` VARCHAR(100),
	PRIMARY KEY (`type_id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

Insert into UserType (type) values('Customer');
Insert into UserType (type) values('Admin');

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
	PRIMARY KEY (`user_id`),
    FOREIGN KEY (type) REFERENCES UserType(type_id)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into User (name, email, password, type, status, created) values ('Enkhee', 'test1@test.com', '123', 1, 0, sysdate());
insert into User (name, email, password, type, status, created) values ('Van', 'test2@test.com', '123', 1, 0, sysdate());
insert into User (name, email, password, type, status, created) values ('Mena', 'test3@test.com', '123', 2, 0, sysdate());
insert into User (name, email, password, type, status, created) values ('Hazem', 'test4@test.com', '123', 1, 0, sysdate());

--------------------------------------------------------------------------------------
-- (Mena) car table
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CarType` varchar(100) DEFAULT NULL,
  `ProviderComp` varchar(100) DEFAULT NULL,
  `Passenger` varchar(100) DEFAULT NULL,
  `Price` varchar(100) DEFAULT NULL,
  `Color` varchar(100) DEFAULT NULL,
  `IsAvailable` varchar(100) DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
-- car table temp data for testing
INSERT INTO `car_rental_system`.`car`
(
`CarType`,
`ProviderComp`,
`Passenger`,
`Price`,
`Color`,
`IsAvailable`,
`Status`) VALUES ('adf','sddf','sdf','sdf','sdf','sdf','s');
--------------------------------------------------------------------------------------

