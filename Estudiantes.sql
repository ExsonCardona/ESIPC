-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ESICURSO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ESICURSO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ESICURSO` DEFAULT CHARACTER SET utf8 ;
USE `ESICURSO` ;

-- -----------------------------------------------------
-- Table `ESICURSO`.`Departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Departamento` (
  `id` INT NOT NULL,
  `Nombre` VARCHAR(250) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Municipio` (
  `id` INT NOT NULL,
  `Nombre` VARCHAR(250) NULL,
  `Departamento_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Estudiante` (
  `Carne` VARCHAR(100) NOT NULL,
  `Nombre` VARCHAR(250) NULL,
  `Fecha_nac` DATE NULL,
  `Telefono` VARCHAR(45) NULL,
  `Direccion` VARCHAR(250) NULL,
  `DPI` INT NULL,
  `email` VARCHAR(120) NULL,
  `NIT` INT NULL,
  `Municipio_id` INT NOT NULL,
  PRIMARY KEY (`Carne`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Colegiatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Colegiatura` (
  `id` INT NOT NULL,
  `Colegiatura` DOUBLE NULL,
  `Mes` DATE NULL,
  `Inscripcion` DOUBLE NULL,
  `Mora` DOUBLE NULL,
  `Total` DOUBLE NULL,
  `Feha_pago` VARCHAR(45) NULL,
  `Descuento` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Instructor` (
  `id` INT NOT NULL,
  `Nombre` VARCHAR(250) NULL,
  `Apellido` VARCHAR(250) NULL,
  `Fecha_Nac` DATE NULL,
  `Telefono` VARCHAR(45) NULL,
  `Direccion` VARCHAR(250) NULL,
  `DPI` INT NULL,
  `Sueldo` DOUBLE NULL,
  `user` VARCHAR(70) NULL,
  `password` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Curso` (
  `id` INT NOT NULL,
  `Codigo` VARCHAR(105) NULL,
  `Nombre` VARCHAR(250) NULL,
  `Costo_mensual` DOUBLE NULL,
  `observacion` VARCHAR(250) NULL,
  `Costo_anual` DOUBLE NULL,
  `Horario` VARCHAR(50) NULL,
  `Instructor_id` INT NOT NULL,
  `Estudiante_Carne` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Nota` (
  `id` INT NOT NULL,
  `Fecha_Parcial` DATE NULL,
  `Parcial` VARCHAR(105) NULL,
  `Nota` DOUBLE NULL,
  `Nota_final` DOUBLE NULL,
  `Curso_id` INT NOT NULL,
  `Estudiante_Carne` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Login` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NULL,
  `fecha/hora` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ESICURSO`.`Detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ESICURSO`.`Detalle` (
  `id` INT NOT NULL,
  `Estudiante_Carne` VARCHAR(100) NOT NULL,
  `Colegiatura_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
