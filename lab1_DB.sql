-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tsar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tsar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tsar` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tsar` ;

-- -----------------------------------------------------
-- Table `tsar`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`country` (
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`region` (
  `name` VARCHAR(30) NOT NULL,
  `country_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `region_country` (`country_name` ASC) VISIBLE,
  CONSTRAINT `region_country`
    FOREIGN KEY (`country_name`)
    REFERENCES `tsar`.`country` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`city` (
  `name` VARCHAR(30) NOT NULL,
  `region_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `city_region` (`region_name` ASC) VISIBLE,
  CONSTRAINT `city_region`
    FOREIGN KEY (`region_name`)
    REFERENCES `tsar`.`region` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`street` (
  `name` VARCHAR(30) NOT NULL,
  `city_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `street_city` (`city_name` ASC) VISIBLE,
  CONSTRAINT `street_city`
    FOREIGN KEY (`city_name`)
    REFERENCES `tsar`.`city` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`watch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`watch` (
  `serial_number` VARCHAR(40) NOT NULL,
  `street_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`serial_number`),
  INDEX `watch_street` (`street_name` ASC) VISIBLE,
  CONSTRAINT `watch_street`
    FOREIGN KEY (`street_name`)
    REFERENCES `tsar`.`street` (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`emergency_phone_number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`emergency_phone_number` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(12) NOT NULL,
  `watch_serial_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `emergency_phone_number_watch` (`watch_serial_number` ASC) VISIBLE,
  CONSTRAINT `emergency_phone_number_watch`
    FOREIGN KEY (`watch_serial_number`)
    REFERENCES `tsar`.`watch` (`serial_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`health_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`health_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `heartbeat_rate` INT NOT NULL,
  `watch_serial_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `health_info_watch` (`watch_serial_number` ASC) VISIBLE,
  CONSTRAINT `health_info_watch`
    FOREIGN KEY (`watch_serial_number`)
    REFERENCES `tsar`.`watch` (`serial_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`property_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`property_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `owner_id` INT NOT NULL,
  `watch_serial_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Table_5_owner` (`owner_id` ASC) VISIBLE,
  INDEX `Table_5_watch` (`watch_serial_number` ASC) VISIBLE,
  CONSTRAINT `Table_5_owner`
    FOREIGN KEY (`owner_id`)
    REFERENCES `tsar`.`owner` (`id`),
  CONSTRAINT `Table_5_watch`
    FOREIGN KEY (`watch_serial_number`)
    REFERENCES `tsar`.`watch` (`serial_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  `gender` VARCHAR(7) NULL DEFAULT NULL,
  `property_info_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_property_info` (`property_info_id` ASC) VISIBLE,
  CONSTRAINT `user_property_info`
    FOREIGN KEY (`property_info_id`)
    REFERENCES `tsar`.`property_info` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`watch_battery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`watch_battery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `charge_level` DECIMAL(3,0) NOT NULL,
  `watch_serial_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `watch_battery_watch` (`watch_serial_number` ASC) VISIBLE,
  CONSTRAINT `watch_battery_watch`
    FOREIGN KEY (`watch_serial_number`)
    REFERENCES `tsar`.`watch` (`serial_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tsar`.`watch_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsar`.`watch_location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` DECIMAL(8,6) NOT NULL,
  `longitude` DECIMAL(8,6) NOT NULL,
  `watch_serial_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_watch_location_watch1_idx` (`watch_serial_number` ASC) VISIBLE,
  CONSTRAINT `fk_watch_location_watch1`
    FOREIGN KEY (`watch_serial_number`)
    REFERENCES `tsar`.`watch` (`serial_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
