create database car_rental_system;
use time_table;
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

INSERT INTO User(email, first_name, last_name, subscribe, phone, password, verified, isAdmin) VALUES("van@mail.com", 'Van', "Phan", 0, '122', 'pppppp', 1, 1);

INSERT INTO User(email, first_name, last_name, subscribe, phone, password, verified, isAdmin) VALUES("van2@mail.com", 'Van', "Phan", 0, '122', 'pppppp', 1, 1);
INSERT INTO User(email, first_name, last_name, subscribe, phone, password, verified, isAdmin) VALUES("thuan@loanfactory.com", 'Thuan', "Nguyen", 0, '122', 'Himark101', 1, 1);

INSERT INTO FAQ(question, answer) VALUES("Do I need a license to work for Loan Factory? If so, what type?", "");
