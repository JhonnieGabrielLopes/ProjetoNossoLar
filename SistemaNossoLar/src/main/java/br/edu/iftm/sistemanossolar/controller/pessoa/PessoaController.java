package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.dao.pessoa.PessoaDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PessoaController {
    private PessoaDAO pessoaDAO;
    private CidadeController cidadeController;
    private EnderecoController enderecoController;
    private TipoController tipoController;
    private PacienteController pacienteController;

    RegistrosLog log = new RegistrosLog();

    public PessoaController(Connection conexao) {
        this.pessoaDAO = new PessoaDAO(conexao);
        this.cidadeController = new CidadeController(conexao);
        this.enderecoController = new EnderecoController(conexao);
        this.tipoController = new TipoController(conexao);
        this.pacienteController = new PacienteController(conexao);
    }

    public boolean cadastrarPessoa(Pessoa pessoa, Paciente paciente) throws SQLException {
        log.registrarLog(1, "PessoaController", "cadastrarPessoa", "", "Cadastrando o "+ pessoa.getTipoUsuario() +" "+ pessoa.getNome());

        Cidade cidade = pessoa.getEndereco().getCidade();
        int pessoaId = pessoaDAO.cadastrarPessoa(pessoa, paciente, cidadeController.buscarIdCidade(cidade), enderecoController.buscarIdEndereco(pessoa.getEndereco(), cidadeController.buscarIdCidade(cidade)), tipoController.buscarIdTipo(pessoa.getTipoUsuario().toString(), "tipousuario"));
        if (pessoaId != 0) {
            if (paciente != null) {
                pacienteController.cadastrarPaciente(paciente, pessoaId);
            }
            return true;
        } else {
            return false;
        }
    }

    public Pessoa buscarPessoaPorId(int id) throws SQLException {
        log.registrarLog(1, "PessoaController", "buscarPessoaPorId", "usuario", "Buscando Dados da Pessoa");
        return pessoaDAO.buscarPessoaPorId(id);
    }

    public List<Pessoa> listarPessoas2(String tipo) throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        log.registrarLog(1, "PessoaController", "listarPessoas", "usuario/tipoUsuario", "Consultando Usuários do tipo "+ tipo);
        int idTipo = tipoController.buscarIdTipo(tipo, "tipousuario");
        return pessoaDAO.listarPessoas2(tipo, idTipo);
    }

    public List<Pessoa> listarPessoas(String nomePessoa, String tipoUsuario, String cidade) throws SQLException {
        log.registrarLog(1, "PessoaController", "buscarPessoas", "usuario, endereco, cidade", "Listando pessoas para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (!nomePessoa.isEmpty() || !nomePessoa.equals("")) {
            sqlFiltro.append("AND u.nome LIKE ? ");
            filtros.add("%"+ nomePessoa +"%");
        }

        if (!tipoUsuario.isEmpty() && !tipoUsuario.equals("Todos")) {
            sqlFiltro.append("AND tu.tipo = ? ");
            filtros.add(tipoUsuario);
        }
        
        if (!cidade.isEmpty()) {
            sqlFiltro.append("AND c.nome LIKE ? ");
            filtros.add("%"+ cidade +"%");
        }

        return pessoaDAO.listarPessoas(sqlFiltro.toString(), filtros);
    }
}