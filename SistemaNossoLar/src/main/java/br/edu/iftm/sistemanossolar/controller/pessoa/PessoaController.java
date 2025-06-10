package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;
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

    public List<Pessoa> listarPessoas(String tipo) throws SQLException {
        log.registrarLog(1, "PessoaController", "listarPessoas", "usuario/tipoUsuario", "Consultando Usuários do tipo "+ tipo);
        int idTipo = tipoController.buscarIdTipo(tipo, "tipousuario");
        
        return pessoaDAO.listarPessoas(tipo, idTipo);
    }

}