-- MySQL Workbench Synchronization
-- Generated: 2021-05-20 19:40
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: david

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `estanco2`.`Sabor` 
DROP FOREIGN KEY `fk_Sabor_Marca1`;

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

ALTER TABLE `estanco2`.`Marca` 
CHANGE COLUMN `Nombre` `Nombre` VARCHAR(45) NOT NULL ;

ALTER TABLE `estanco2`.`Sabor` 
DROP COLUMN `Marca_idMarca`,
ADD COLUMN `idMarca` INT(11) NOT NULL AFTER `Nombre`,
CHANGE COLUMN `Nombre` `Nombre` VARCHAR(45) NOT NULL ,
DROP INDEX `fk_Sabor_Marca1_idx` ,
ADD INDEX `fk_Sabor_Marca1_idx` (`idMarca` ASC) VISIBLE;
;

DROP TABLE IF EXISTS `estanco2`.`tabaco` ;

ALTER TABLE `estanco2`.`Sabor` 
ADD CONSTRAINT `fk_Sabor_Marca1`
  FOREIGN KEY (`idMarca`)
  REFERENCES `estanco2`.`Marca` (`idMarca`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;