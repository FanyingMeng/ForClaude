CREATE DATABASE IF NOT EXISTS `petadoption`;
USE `petadoption`;

DROP TABLE IF EXISTS `adoption`;

CREATE TABLE `adoption`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `petId`       bigint       NOT NULL,
    `adopterName` varchar(255) NOT NULL,
    `phone`       varchar(50)  NOT NULL,
    PRIMARY KEY (`id`)
);