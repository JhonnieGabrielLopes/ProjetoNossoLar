-- ==================================================== POPULAÇÃO PARA TESTES:
USE nossolar;
-- CIDADES
INSERT INTO cidade (nome, uf) VALUES
('São Paulo', 'SP'),
('Campinas', 'SP'),
('Ribeirão Preto', 'SP'),
('Santos', 'SP');

-- USUÁRIOS (DOADORES - SEM LOCAL)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email) VALUES
('João Silva', NULL, 'FISICA', '12345678900', '11999999999', 1, 'joao@email.com'),
('Maria Santos', NULL, 'FISICA', '98765432100', '11988888888', 2, 'maria@email.com'),
('Empresa DoaBem LTDA', NULL, 'JURIDICA', '12345678000100', '1133334444', 3, 'doabem@empresa.com');

-- USUÁRIOS (BENEFICIÁRIOS - SEMPRE HOSPITAL)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email) VALUES
('Carlos Oliveira', 'HOSPITAL', 'FISICA', '32165498700', '11988776655', 4, 'carlos@email.com'),
('Luciana Martins', 'HOSPITAL', 'FISICA', '32165498711', '11988112233', 1, 'luciana@email.com');

-- USUÁRIOS (ASSISTENTE - SEMPRE PRONTOSOCORRO)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email) VALUES
('Fernanda Almeida', 'PRONTOSOCORRO', 'FISICA', '11122233344', '11987543210', 2, 'fernanda@email.com');

-- VÍNCULOS USUÁRIO x TIPO
INSERT INTO usuarioTipo (usuario, tipoUsuario) VALUES
(6, 1),                  -- Assistente
(4, 2), (5, 2),          -- Beneficiários
(1, 3), (2, 3), (3, 3);  -- Doadores

-- ENDEREÇOS COMPLETOS
INSERT INTO endereco (cidade, cep, logradouro, numero, bairro, complemento) VALUES
(1, '01001000', 'Rua das Flores', '123', 'Centro', 'Apto 101'),
(2, '13050000', 'Av. Brasil', '456', 'Jardim América', NULL),
(3, '14020000', 'Rua Santos Dumont', '789', 'Vila Industrial', 'Casa'),
(4, '11010000', 'Rua do Porto', '321', 'Boqueirão', 'Fundos');

-- USUÁRIOS (DOADORES com endereço completo)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email, observacao) VALUES
('Paulo Menezes', NULL, 'FISICA', '45678912300', '11991234567', 1, 'paulo.menezes@email.com', 'Doa alimentos periodicamente'),
('Ana Beatriz Costa', NULL, 'FISICA', '78912345600', '11999887766', 2, 'ana.costa@email.com', 'Participa de eventos de doação'),
('TechDonate LTDA', NULL, 'JURIDICA', '98765432000199', '1145678900', 3, 'contato@techdonate.com', 'Doações corporativas regulares');

-- USUÁRIOS (BENEFICIÁRIOS com endereço completo)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email, observacao) VALUES
('Marcos Ribeiro', 'HOSPITAL', 'FISICA', '65498732100', '11995544332', 4, 'marcos.ribeiro@email.com', 'Acompanhado por assistente social'),
('Patrícia Souza', 'HOSPITAL', 'FISICA', '65498732211', '11994433221', 1, 'patricia.souza@email.com', 'Recebe suporte mensal');

-- USUÁRIO (ASSISTENTE com endereço completo)
INSERT INTO usuario (nome, local, tipoPessoa, identificacao, telefone, endereco, email, observacao) VALUES
('Renata Gomes', 'PRONTOSOCORRO', 'FISICA', '22233344455', '11990011223', 2, 'renata.gomes@email.com', 'Responsável pela triagem no pronto socorro');

-- PRODUTOS
INSERT INTO produto (tipoProduto, descricao) VALUES
('ALIMENTO', 'Arroz 5kg'),
('ALIMENTO', 'Feijão 1kg'),
('LIMPEZA', 'Sabão em pó'),
('LIMPEZA', 'Desinfetante 2L'),
('OUTRO', 'Kit escolar'),
('OUTRO', 'Cobertor térmico');

-- DOAÇÕES (somente por doadores: usuários 1, 2, 3)
INSERT INTO doacao (tipoDoacao, pessoa, valor, observacao, data) VALUES
('DINHEIRO', 1, 500.00, 'Doação mensal recorrente', '2023-01-15'),
('DINHEIRO', 2, 200.00, 'Em memória de Ana Silva', '2023-02-20'),
('DINHEIRO', 3, 1000.00, 'Doação empresarial', '2023-03-10'),
('PRODUTO', 1, NULL, 'Campanha de Páscoa', '2023-04-05'),
('PRODUTO', 2, NULL, NULL, '2023-05-12'),
('PRODUTO', 3, NULL, 'Parceria com escola local', '2023-06-18'),
('PRODUTO', 1, NULL, 'Doação especial de inverno', '2023-07-01');

-- PRODUTO DOAÇÃO (relacionado às doações tipo PRODUTO)
INSERT INTO produtoDoacao (doacao, produto, quantidade) VALUES
(4, 1, 10),  -- Arroz
(4, 2, 5),   -- Feijão
(5, 3, 8),   -- Sabão
(6, 5, 15),  -- Kit escolar
(7, 6, 10),  -- Cobertor
(7, 4, 4);   -- Desinfetante

-- PACIENTES (somente beneficiários: usuários 4 e 5)
INSERT INTO paciente (usuario, nome, previsaoDias) VALUES
(4, 'José Oliveira', 15),
(5, 'Marina Martins', 10);

-- PEDIDOS (feitos por beneficiários e assistentes: usuários 4, 5, 6)
-- Carlos Oliveira (beneficiário)
INSERT INTO pedido (status, pessoa, quantidade, observacao, dataPedido, dataEntrega) VALUES
('PENDENTE', 4, 2, 'Solicitação urgente para o filho', '2023-06-01', NULL),
('CANCELADO', 4, 1, 'Paciente teve alta', '2023-06-15', NULL);

-- Luciana Martins (beneficiária)
INSERT INTO pedido (status, pessoa, quantidade, observacao, dataPedido, dataEntrega) VALUES
('ENTREGUE', 5, 1, 'Recebido na unidade', '2023-05-25', '2023-05-28');

-- Fernanda Almeida (assistente)
INSERT INTO pedido (status, pessoa, quantidade, observacao, dataPedido, dataEntrega) VALUES
('PENDENTE', 6, 3, 'Pedido emergencial de marmitas para plantão', '2023-06-10', NULL),
('ENTREGUE', 6, 1, 'Atendimento concluído no dia', '2023-06-05', '2023-06-06');

select * from nossolar.usuario;
select * from nossolar.tipousuario;
select * from nossolar.usuariotipo;
select * from nossolar.cidade;
select * from nossolar.endereco;
select * from nossolar.pedido;
select * from nossolar.doacao;
select * from nossolar.produto;
select * from nossolar.produtodoacao;