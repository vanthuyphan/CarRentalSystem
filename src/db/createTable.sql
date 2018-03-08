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

DROP TABLE Car;
CREATE TABLE IF NOT EXISTS `Car` (
	 `id` BIGINT NOT NULL AUTO_INCREMENT,
  `carType` varchar(100) DEFAULT NULL,
  `provider` varchar(100) DEFAULT NULL,
  `passengers` INTEGER DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `available` TINYINT DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


INSERT INTO Car(carType,provider , passengers ,  price ,color , available , status ) VALUES ('Van','BWM', 4, 100, 'black', 1, 'waiting');
INSERT INTO Car(carType,provider , passengers ,  price ,color , available , status ) VALUES ('Van2','BWM', 4, 100, 'black', 1, 'waiting');
INSERT INTO Car(carType,provider , passengers ,  price ,color , available , status ) VALUES ('Van2','BWM', 4, 100, 'black', 1, 'waiting');
INSERT INTO Car(carType,provider , passengers ,  price ,color , available , status ) VALUES ('Van2','BWM', 4, 100, 'black', 1, 'waiting');


CREATE TABLE IF NOT EXISTS `Order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car` BIGINT ,
  `user` BIGINT,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`car`) REFERENCES car(id),
  FOREIGN KEY (`user`) REFERENCES User(user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;





