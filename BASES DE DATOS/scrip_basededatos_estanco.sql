-- MySQL Workbench Synchronization
-- Generated: 2021-05-20 20:09
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: david

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `estanco2` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `estanco2`.`Tabacosdecachimba` (
  `idTabacosdecachimba` INT(11) NOT NULL AUTO_INCREMENT,
  `idMarca` INT(11) NOT NULL,
  `idSabor` INT(11) NOT NULL,
  `Gramos` INT(11) NOT NULL,
  `Precio` INT(11) NOT NULL,
  `Unidades` INT(11) NOT NULL,
  PRIMARY KEY (`idTabacosdecachimba`),
  INDEX `fk_Tabacosdecachimba_Marca_idx` (`idMarca` ASC) VISIBLE,
  INDEX `fk_Tabacosdecachimba_Sabor1_idx` (`idSabor` ASC) VISIBLE,
  CONSTRAINT `fk_Tabacosdecachimba_Marca`
    FOREIGN KEY (`idMarca`)
    REFERENCES `estanco2`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tabacosdecachimba_Sabor1`
    FOREIGN KEY (`idSabor`)
    REFERENCES `estanco2`.`Sabor` (`idSabor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estanco2`.`Marca` (
  `idMarca` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estanco2`.`Sabor` (
  `idSabor` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `idMarca` INT(11) NOT NULL,
  PRIMARY KEY (`idSabor`),
  INDEX `fk_Sabor_Marca1_idx` (`idMarca` ASC) VISIBLE,
  CONSTRAINT `fk_Sabor_Marca1`
    FOREIGN KEY (`idMarca`)
    REFERENCES `estanco2`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estanco2`.`usuarios` (
  `idusuarios` INT(11) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;