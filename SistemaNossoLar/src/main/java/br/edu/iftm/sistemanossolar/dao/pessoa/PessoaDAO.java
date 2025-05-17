package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoPessoa;;

public class PessoaDAO {

    public boolean cadastrarCliente(Cliente cliente, Tipo tipo) {
        Integer idCidade = buscarIdCidade(cliente.getEndereco().getCidade().getNome());
        Integer idEndereco = buscarIdEndereco(idCidade);
        Integer idTipo = buscarIdTipo(tipo.getDescricao());
        String sqlCadastro = "INSERT INTO usuario (nome, telefone, endereco, assistido, previsaoQtdDias, tipoPessoa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sqlCadastro, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, idEndereco);
            stmt.setString(4, cliente.getPaciente());
            stmt.setInt(5, cliente.getPrevisaoQtdDias());
            stmt.setString(6, TipoPessoa.FISICA.name());
            stmt.executeUpdate();
            Integer idUser = null;
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idUser = rs.getInt(1);
                }
            }
            if (idUser!=null) {
                String sqlUserTipo = "INSERT INTO usuariotipo (usuario, tipoUsuario) VALUES (?, ?)";
                try (PreparedStatement stmtUserTipo = conn.prepareStatement(sqlUserTipo)) {
                    stmtUserTipo.setInt(1, idUser);
                    stmtUserTipo.setInt(2, idTipo);
                    stmtUserTipo.executeUpdate();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdCidade(String nomeCidade) {
        String sqlBuscarIdCidade = "SELECT id FROM cidade WHERE nome = ?";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sqlBuscarIdCidade);
            stmt.setString(1, nomeCidade);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }else {
                System.out.println("Cidade não encontrada.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ID da cidade");
            return null;
        }
    }

    public Integer buscarIdEndereco(int idCidade) {
        String sqlBuscarIdEndereco = "SELECT id FROM endereco WHERE cidade = ?";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sqlBuscarIdEndereco);
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }else {
                System.out.println("ID do endereço não encontrado.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ID do endereço");
            return null;
        }
    }

    public Integer buscarIdTipo(String tipo){
        String sqlBuscarIdTipo = "SELECT id FROM tipousuario WHERE tipo = ?";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sqlBuscarIdTipo);
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }else {
                System.out.println("ID do tipo não encontrado.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ID do tipo");
            return null;
        }
    }
}
