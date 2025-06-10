
-- TRIGGER PARA INSERIR O ENDEREÇO APENAS DA CIDADE AUTOMATICAMENTE
DELIMITER //
CREATE TRIGGER CriarEnderecoCidade
AFTER INSERT ON cidade
FOR EACH ROW
BEGIN
    INSERT INTO endereco (cidade)
    VALUES (NEW.id);
END//
DELIMITER ;

SELECT * FROM nossolar.cidade;
-- INSERTS PADRÃO DA TABELA CIDADE
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Ituiutaba', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Centralina', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Capinópolis', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Campina Verde', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Santa Vitória', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Canápolis', 'MG');
INSERT INTO `nossolar`.`cidade` (`nome`, `uf`) VALUES ('Gurinhatã', 'MG');

SELECT * FROM nossolar.endereco;
-- INSERTS JÁ INSERIDOS AUTOMATICAMENTE VIA TRIGGER

SELECT * FROM nossolar.tipousuario;
-- INSERTS PADRÃO DA TABELA TIPO USUARIO
INSERT INTO `nossolar`.`tipousuario` (`tipo`) VALUES ('ASSISTENTE');
INSERT INTO `nossolar`.`tipousuario` (`tipo`) VALUES ('BENEFICIARIO');
INSERT INTO `nossolar`.`tipousuario` (`tipo`) VALUES ('DOADOR');
