-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema nossolar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nossolar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nossolar` DEFAULT CHARACTER SET utf8 ;
USE `nossolar` ;

-- -----------------------------------------------------
-- Table `nossolar`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(32) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `nossolar`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cidade` INT NOT NULL,
  `cep` VARCHAR(8) NULL,
  `logradouro` VARCHAR(100) NULL,
  `numero` VARCHAR(10) NULL,
  `bairro` VARCHAR(45) NULL,
  `complemento` VARCHAR(65) NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_endereco_cidade1_idx` (`cidade` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_cidade1`
    FOREIGN KEY (`cidade`)
    REFERENCES `nossolar`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `local` ENUM('HOSPITAL', 'PRONTOSOCORRO') NULL,
  `tipoPessoa` ENUM('FISICA', 'JURIDICA') NULL,
  `identificacao` VARCHAR(14) NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `endereco` INT NOT NULL,
  `email` VARCHAR(60) NULL,
  `observacao` TEXT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_usuario_endereco1_idx` (`endereco` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_endereco1`
    FOREIGN KEY (`endereco`)
    REFERENCES `nossolar`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`tipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`tipoUsuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` ENUM('ASSISTENTE', 'BENEFICIARIO', 'DOADOR') NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `nossolar`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('PENDENTE', 'ENTREGUE', 'CANCELADO') NULL,
  `pessoa` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `observacao` TEXT NULL,
  `dataPedido` DATE NOT NULL,
  `dataEntrega` DATE NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_pedido_pessoa1_idx` (`pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_pessoa1`
    FOREIGN KEY (`pessoa`)
    REFERENCES `nossolar`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`doacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`doacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoDoacao` ENUM('DINHEIRO', 'PRODUTO') NOT NULL,
  `pessoa` INT NOT NULL,
  `valor` DOUBLE NULL,
  `observacao` VARCHAR(250) NULL,
  `anexo` BLOB NULL,
  `data` DATE NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_doacao_pessoa1_idx` (`pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_doacao_pessoa1`
    FOREIGN KEY (`pessoa`)
    REFERENCES `nossolar`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoProduto` ENUM('ALIMENTO', 'LIMPEZA', 'OUTRO') NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `nossolar`.`usuarioTipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`usuarioTipo` (
  `usuario` INT NOT NULL,
  `tipoUsuario` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario`, `tipoUsuario`),
  INDEX `fk_tipoUsuario_has_usuario_usuario1_idx` (`usuario` ASC) VISIBLE,
  INDEX `fk_tipoUsuario_has_usuario_tipoUsuario1_idx` (`tipoUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_tipoUsuario_has_usuario_tipoUsuario1`
    FOREIGN KEY (`tipoUsuario`)
    REFERENCES `nossolar`.`tipoUsuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoUsuario_has_usuario_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `nossolar`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`produtoDoacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`produtoDoacao` (
  `doacao` INT NOT NULL,
  `produto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_doacao_has_produto_produto1_idx` (`produto` ASC) VISIBLE,
  INDEX `fk_doacao_has_produto_doacao1_idx` (`doacao` ASC) VISIBLE,
  PRIMARY KEY (`doacao`, `produto`),
  CONSTRAINT `fk_doacao_has_produto_doacao1`
    FOREIGN KEY (`doacao`)
    REFERENCES `nossolar`.`doacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doacao_has_produto_produto1`
    FOREIGN KEY (`produto`)
    REFERENCES `nossolar`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `nossolar`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nossolar`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `previsaoDias` INT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`, `usuario`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_paciente_usuario1_idx` (`usuario` ASC) VISIBLE,
  CONSTRAINT `fk_paciente_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `nossolar`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

USE `nossolar`;

DELIMITER $$
USE `nossolar`$$
CREATE DEFINER = CURRENT_USER TRIGGER `nossolar`.`cidade_AFTER_INSERT` AFTER INSERT ON `cidade` FOR EACH ROW
BEGIN
    INSERT INTO endereco (cidade)
    VALUES (NEW.id);
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;