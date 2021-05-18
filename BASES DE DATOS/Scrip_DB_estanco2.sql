CREATE SCHEMA IF NOT EXISTS `estanco2` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `estanco2`.`Tabaco` (
  `idTabaco` INT(11) NOT NULL AUTO_INCREMENT,
  `gramos` INT(11) NOT NULL,
  `precio` INT(11) NOT NULL,
  `unidades` INT(11) NOT NULL,
  `idMarca` INT(11) NOT NULL,
  `idSabor` INT(11) NOT NULL,
  PRIMARY KEY (`idTabaco`),
  INDEX `fk_Tabaco_Marca_idx` (`idMarca` ASC) VISIBLE,
  INDEX `fk_Tabaco_Sabor1_idx` (`idSabor` ASC) VISIBLE,
  CONSTRAINT `fk_Tabaco_Marca`
    FOREIGN KEY (`idMarca`)
    REFERENCES `estanco2`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tabaco_Sabor1`
    FOREIGN KEY (`idSabor`)
    REFERENCES `estanco2`.`Sabor` (`idSabor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estanco2`.`Marca` (
  `idMarca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estanco2`.`Sabor` (
  `idSabor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `Marca_idMarca` INT(11) NOT NULL,
  PRIMARY KEY (`idSabor`),
  INDEX `fk_Sabor_Marca1_idx` (`Marca_idMarca` ASC) VISIBLE,
  CONSTRAINT `fk_Sabor_Marca1`
    FOREIGN KEY (`Marca_idMarca`)
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


