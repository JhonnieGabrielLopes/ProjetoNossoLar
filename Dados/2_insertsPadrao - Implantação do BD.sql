-- ==================================================== POPULAÇÃO PADRÃO DO BANCO:
USE nossolar;
-- INSERTS PADRÃO DA TABELA CIDADE
INSERT INTO cidade (nome, uf) VALUES
('Ituiutaba', 'MG'),
('Centralina', 'MG'),
('Capinópolis', 'MG'),
('Campina Verde', 'MG'),
('Santa Vitória', 'MG'),
('Canápolis', 'MG'),
('Gurinhatã', 'MG');
SELECT * FROM nossolar.cidade;

-- INSERTS JÁ INSERIDOS AUTOMATICAMENTE VIA TRIGGER
SELECT * FROM nossolar.endereco;

-- INSERTS PADRÃO DA TABELA TIPO USUARIO
INSERT INTO tipoUsuario (tipo) VALUES 
('ASSISTENTE'),
('BENEFICIARIO'),
('DOADOR');
SELECT * FROM nossolar.tipousuario;