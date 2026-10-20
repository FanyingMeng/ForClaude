CREATE DATABASE IF NOT EXISTS `courseassignment`;
USE `courseassignment`;

DROP TABLE IF EXISTS `courseregistration`;

CREATE TABLE `courseregistration`
(
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `courseId`  bigint NOT NULL,
    `firstName` varchar(255) DEFAULT NULL,
    `lastName`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);