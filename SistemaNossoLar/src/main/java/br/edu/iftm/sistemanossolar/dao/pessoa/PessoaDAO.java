package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.dao.endereco.CidadeDAO;
import br.edu.iftm.sistemanossolar.dao.endereco.EnderecoDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoPessoa;;

public class PessoaDAO {
    CidadeDAO cidadeDAO = new CidadeDAO();
    EnderecoDAO enderecoDAO = new EnderecoDAO();

    public boolean cadastrarCliente(Cliente cliente, Tipo tipo) {
        Integer idCidade = cidadeDAO.buscarIdCidade(cliente.getEndereco().getCidade());
        Integer idEndereco = enderecoDAO.buscarIdEndereco(idCidade);
        Integer idTipo = buscarIdTipo(tipo.getDescricao());

        String sql = "INSERT INTO usuario (nome, telefone, endereco, assistido, previsaoQtdDias, tipoPessoa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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

    public Integer buscarIdTipo(String tipo){
        String sql = "SELECT id FROM tipousuario WHERE tipo = ?";
        try (Connection conn = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
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