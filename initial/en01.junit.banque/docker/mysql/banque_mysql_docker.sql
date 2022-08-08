-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS `banque`;
USE `banque`;

-- -----------------------------------------------------
-- Table `utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur` ;

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(120) NOT NULL,
  `nom` VARCHAR(120) NULL DEFAULT NULL,
  `prenom` VARCHAR(120) NULL DEFAULT NULL,
  `sex` TINYINT(1) NULL DEFAULT NULL,
  `derniereConnectionDate` DATE NULL DEFAULT NULL,
  `derniereConnectionHeure` TIME NULL DEFAULT NULL,
  `dateDeNaissance` DATE NULL DEFAULT NULL,
  `adresse` VARCHAR(500) NULL DEFAULT NULL,
  `codePostal` INT NULL DEFAULT NULL,
  `telephone` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
INSERT INTO `utilisateur` VALUES (1,'df@aol.com','df','Fargis','Denis',0,NULL,NULL,'1975-09-19',NULL,78140,NULL),(2,'dj@aol.com','dj','Fanael','Julie',1,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ip@aol.com','ip','Iaris','Paul',0,NULL,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `compte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `compte` ;

CREATE TABLE IF NOT EXISTS `compte` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(250) NULL DEFAULT NULL,
  `solde` DECIMAL(10,2) NULL DEFAULT NULL,
  `decouvert` DECIMAL(10,2) NULL DEFAULT NULL,
  `taux` DECIMAL(5,2) NULL DEFAULT NULL,
  `utilisateurId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compte_utilisateur_idx` (`utilisateurId` ASC) VISIBLE,
  CONSTRAINT `fk_compte_utilisateur`
    FOREIGN KEY (`utilisateurId`)
    REFERENCES `utilisateur` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


LOCK TABLES `compte` WRITE;
INSERT INTO `compte` VALUES (12,'Compte Courant',25000.00,NULL,NULL,1),(13,'Compte Courant',150000.00,100.00,NULL,2),(14,'Compte Courant',35000.00,50.00,NULL,3),(15,'Livret A',99500.00,NULL,0.10,1),(16,'Compte Remunéré',50000.00,NULL,0.30,2);
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `operation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `operation` ;

CREATE TABLE IF NOT EXISTS `operation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(250) NULL DEFAULT NULL,
  `montant` DECIMAL(10,2) NULL DEFAULT NULL,
  `dateOp` DATE NULL DEFAULT NULL,
  `heureOp` TIME NULL DEFAULT NULL,
  `compteId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_operation_compte1_idx` (`compteId` ASC) VISIBLE,
  CONSTRAINT `fk_operation_compte1`
    FOREIGN KEY (`compteId`)
    REFERENCES `compte` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

LOCK TABLES `operation` WRITE;
INSERT INTO `operation` VALUES (1,'Virement',500,'2014-12-31', '23:00:00',15),(2,'Retrait',-500,'2014-12-31', '23:00:00',12),(3,'Transaction avec le comte 12',-50,'2015-02-13', '13:10:52',15),(4,'Transaction avec le comte 15',50,'2015-02-13', '13:10:52',12);
UNLOCK TABLES;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
