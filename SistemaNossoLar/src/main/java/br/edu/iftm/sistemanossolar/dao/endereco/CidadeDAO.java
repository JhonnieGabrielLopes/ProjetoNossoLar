package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class CidadeDAO {
    
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public CidadeDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarCidade(Cidade cidade) throws SQLException {
        String sql = "INSERT INTO cidade (nome, uf) VALUES (?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            stmt.executeUpdate();
            log.registrarLog(2, "CidadeDAO", "cadastrarCidade", "cidade", "Cidade cadastrada");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "CidadeDAO", "cadastrarCidade", "cidade", "Cidade não cadastrada");
            return false;
        }
    }
    
    public Integer buscarIdCidade(Cidade cidade) throws SQLException {
        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                log.registrarLog(2, "CidadeDAO", "buscarIdCidade", "cidade", "ID da cidade encontrado");
                return rs.getInt("id");
            } else {
                log.registrarLog(3, "CidadeDAO", "buscarIdCidade", "cidade", "ID da cidade não encontrado");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "CidadeDAO", "buscarIdCidade", "cidade", "Erro ao buscar ID da cidade");
            return null;
        }
    }

    public boolean existeCidade(Cidade cidade) throws SQLException {
        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                log.registrarLog(2, "CidadeDAO", "existeCidade", "cidade", "Cidade existe");
                return true;
            } else {
                log.registrarLog(3, "CidadeDAO", "existeCidade", "cidade", "Cidade não existe");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "CidadeDAO", "existeCidade", "cidade", "Erro ao verificar se a cidade existe");
            return false;
        }
    }

    public List<Cidade> listarCidade() throws SQLException {
        String sql = "SELECT * FROM cidade";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            List<Cidade> cidades = new ArrayList<>();
            while (rs.next()) {
                Cidade cidade = new Cidade(
                    rs.getString("nome"),
                    rs.getString("uf")
                );
                cidades.add(cidade);
            }
            log.registrarLog(2, "CidadeDAO", "listarCidade", "cidade", "Cidades listadas");
            return cidades;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "CidadeDAO", "listarCidade", "cidade", "Erro ao buscar as cidades");
            return null;
        }
    }
}