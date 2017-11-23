-- MySQL Workbench Synchronization
-- Generated: 2017-11-21 17:05
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: GIOVANI HENRIQUE BERTUZZO

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER SCHEMA `frota_controle`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `frota_controle`.`Motoristas` (
  `idMotorista` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(45) NOT NULL,
  `RFIDMotorista` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMotorista`),
  UNIQUE INDEX `idMotorista_UNIQUE` (`idMotorista` ASC),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC),
  UNIQUE INDEX `RFID_UNIQUE` (`RFIDMotorista` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `frota_controle`.`Veiculos` (
  `idVeiculo` INT(11) NOT NULL AUTO_INCREMENT,
  `Placa` VARCHAR(45) NOT NULL,
  `Marca` VARCHAR(45) NOT NULL,
  `Modelo` VARCHAR(45) NOT NULL,
  `RFIDVeiculo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  UNIQUE INDEX `idVeiculo_UNIQUE` (`idVeiculo` ASC),
  UNIQUE INDEX `Placa_UNIQUE` (`Placa` ASC),
  UNIQUE INDEX `RFIDVeiculo_UNIQUE` (`RFIDVeiculo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `frota_controle`.`Logs` (
  `idLog` INT(11) NOT NULL AUTO_INCREMENT,
  `Data` DATE NOT NULL,
  `Motoristas_idMotorista` INT(11) NOT NULL,
  `Veiculos_idVeiculo` INT(11) NOT NULL,
  `Destinos_idDestino` INT(11) NOT NULL,
  PRIMARY KEY (`idLog`),
  UNIQUE INDEX `idLog_UNIQUE` (`idLog` ASC),
  INDEX `fk_Logs_Motoristas_idx` (`Motoristas_idMotorista` ASC),
  INDEX `fk_Logs_Veiculos1_idx` (`Veiculos_idVeiculo` ASC),
  INDEX `fk_Logs_Destinos1_idx` (`Destinos_idDestino` ASC),
  CONSTRAINT `fk_Logs_Motoristas`
    FOREIGN KEY (`Motoristas_idMotorista`)
    REFERENCES `frota_controle`.`Motoristas` (`idMotorista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Veiculos1`
    FOREIGN KEY (`Veiculos_idVeiculo`)
    REFERENCES `frota_controle`.`Veiculos` (`idVeiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Destinos1`
    FOREIGN KEY (`Destinos_idDestino`)
    REFERENCES `frota_controle`.`Destinos` (`idDestino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `frota_controle`.`Destinos` (
  `idDestino` INT(11) NOT NULL AUTO_INCREMENT,
  `CEP` VARCHAR(45) NULL DEFAULT NULL,
  `Endereco` VARCHAR(45) NULL DEFAULT NULL,
  `Numero` VARCHAR(45) NULL DEFAULT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDestino`),
  UNIQUE INDEX `idDestino_UNIQUE` (`idDestino` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
