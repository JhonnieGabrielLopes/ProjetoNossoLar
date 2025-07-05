/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.iftm.sistemanossolar.view;

import br.edu.iftm.sistemanossolar.controller.PedidoController;
import br.edu.iftm.sistemanossolar.controller.RelatorioController;
import br.edu.iftm.sistemanossolar.controller.doacao.DoacaoController;
import br.edu.iftm.sistemanossolar.controller.doacao.ProdutoController;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PacienteController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AFSOUZA
 */
public class Telas extends javax.swing.JFrame {

    private CardLayout cl;
    private static CidadeController cidadeController;
    private static CadastroCidade cadastroCidade;
    private static CadastroProduto cadastroProduto;
    private static BuscarPessoa buscarPessoa;
    private static BuscarDoacao buscarDoacao;
    private static BuscarProduto buscarProduto;
    private static DoacaoController doacaoController;
    private static ProdutoController produtoController;
    private static PessoaController pessoaController;
    private static EnderecoController enderecoController;
    private static RelatorioController relatorioController;
    private DefaultTableModel modeloTabela;
    private int indiceTabelaProduto;
    private Pessoa pessoaAntiga;
    private PacienteController pacienteController;
    private DefaultTableModel modeloTabelaRelatorioPedido;
    private DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private List<Produto> produtosDoacao = new ArrayList<>();
    private BuscarPedido buscarPedido;
    private PedidoController pedidoController;

    /**
     * Creates new form Telas lb - Label tf - TextField ta - TextArea ff -
     * FormatedField
     */
    public Telas(Connection conexao) {
        cidadeController = new CidadeController(conexao);
        pessoaController = new PessoaController(conexao);
        enderecoController = new EnderecoController(conexao);
        doacaoController = new DoacaoController(conexao);
        relatorioController = new RelatorioController(conexao);
        produtoController = new ProdutoController(conexao);
        cadastroCidade = new CadastroCidade(this, true, conexao, this);
        cadastroProduto = new CadastroProduto(this, true, conexao, this);
        buscarPessoa = new BuscarPessoa(this, true, conexao, this);
        buscarDoacao = new BuscarDoacao(this, true, conexao, this);
        buscarProduto = new BuscarProduto(this, true, conexao, this);
        initComponents();
        cl = (CardLayout) pnCard.getLayout();
        modeloTabela = (DefaultTableModel) tableDoacaoProdutos.getModel();
        modeloTabelaRelatorioPedido = (DefaultTableModel) tableRelatorioPedido.getModel();
        pacienteController = new PacienteController(conexao);
        buscarPedido = new BuscarPedido(this, true, conexao, this);
        pedidoController = new PedidoController(conexao);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPessoaTipo = new javax.swing.ButtonGroup();
        jSpinner1 = new javax.swing.JSpinner();
        pnDadosPrincipal = new javax.swing.JPanel();
        pnCard = new javax.swing.JPanel();
        pnCadastrarDoacao = new javax.swing.JPanel();
        pnDoacao = new javax.swing.JPanel();
        lbDoacaoIdDoacao = new javax.swing.JLabel();
        tfDoacaoIdDoacao = new javax.swing.JTextField();
        lbDoacaoDoador = new javax.swing.JLabel();
        tfDoacaoIdDoador = new javax.swing.JTextField();
        tfDoacaoDoador = new javax.swing.JTextField();
        lbDoacaoTipo = new javax.swing.JLabel();
        cbDoacaoTipo = new javax.swing.JComboBox<>();
        lbDoacaoData = new javax.swing.JLabel();
        ftDoacaoData = new javax.swing.JFormattedTextField();
        lbDoacaoValor = new javax.swing.JLabel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        tfDoacaoValor = new javax.swing.JFormattedTextField(nf);
        lbDoacaoObservacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDoacaoObservacao = new javax.swing.JTextArea();
        btDoacaoRecibo = new javax.swing.JButton();
        btDoacaoDeletar = new javax.swing.JButton();
        btDoacaoBuscarDoacao = new javax.swing.JButton();
        btDoacaoBuscarDoador = new javax.swing.JButton();
        pnDoacaoProduto = new javax.swing.JPanel();
        lbDoacaoSelecionarProd = new javax.swing.JLabel();
        lbDoacaoQuantidade = new javax.swing.JLabel();
        tfDoacaoSelecionarProd = new javax.swing.JTextField();
        btDoacaoBuscarProd = new javax.swing.JButton();
        jsDoacaoQuantidadeProduto = new javax.swing.JSpinner();
        btDoacaoAddProd = new javax.swing.JButton();
        pnListBoxProd = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoacaoProdutos = new javax.swing.JTable();
        btDoacaoAltProd = new javax.swing.JButton();
        btDoacaoDelProd = new javax.swing.JButton();
        btDoacaoRegistrarDoacao = new javax.swing.JButton();
        btDoacaoLimpar = new javax.swing.JButton();
        btDoacaoRelatorio = new javax.swing.JButton();
        btDoacaoSair = new javax.swing.JButton();
        pnCadastrarPedido = new javax.swing.JPanel();
        pnPedido = new javax.swing.JPanel();
        tfPedidoCliente = new javax.swing.JTextField();
        lbPedidoCliente = new javax.swing.JLabel();
        lbPedidoQtdMarmitas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taPedidoObservacao = new javax.swing.JTextArea();
        lbPedidoObservacao = new javax.swing.JLabel();
        cbPedidoStatus = new javax.swing.JComboBox<>();
        lbPedidoStatus = new javax.swing.JLabel();
        tfPedidoIdPedido = new javax.swing.JTextField();
        lbPedidoIdPedido = new javax.swing.JLabel();
        tfPedidoIdCliente = new javax.swing.JTextField();
        btPedidoBuscarCliente = new javax.swing.JButton();
        btPedidoBuscarPedido = new javax.swing.JButton();
        jsQtdMarmitas = new javax.swing.JSpinner();
        lbPedidoDtPedido = new javax.swing.JLabel();
        lbPedidoDtEntrega = new javax.swing.JLabel();
        ffPedidoDtPedido = new javax.swing.JFormattedTextField();
        ffPedidoDtEntrega = new javax.swing.JFormattedTextField();
        btPedidoDeletar = new javax.swing.JButton();
        btPedidoRecibo = new javax.swing.JButton();
        btPedidoRegistrar = new javax.swing.JButton();
        btPedidoLimpar = new javax.swing.JButton();
        btPedidoSair = new javax.swing.JButton();
        btPedidoRelatorio = new javax.swing.JButton();
        pnRelatorioDoacao = new javax.swing.JPanel();
        pnRelDoa = new javax.swing.JPanel();
        pnRelFiltros = new javax.swing.JPanel();
        lbRelDoaDtInicial = new javax.swing.JLabel();
        ffRelDoaDtInicial = new javax.swing.JFormattedTextField();
        lbRelDoaDtFinal = new javax.swing.JLabel();
        ffRelDoaDtFinal = new javax.swing.JFormattedTextField();
        lbRelDoaDoador = new javax.swing.JLabel();
        tfRelDoaDoador = new javax.swing.JTextField();
        lbRelDoaTpDoacao = new javax.swing.JLabel();
        cbRelDoaTpDoacao = new javax.swing.JComboBox<>();
        lbRelDoaOrdenacao = new javax.swing.JLabel();
        cbRelDoaOrdenacao = new javax.swing.JComboBox<>();
        cbRelDoaSentido = new javax.swing.JComboBox<>();
        lbRelDoaProd = new javax.swing.JLabel();
        tfRelDoaProd = new javax.swing.JTextField();
        lbRelDoaTpProduto = new javax.swing.JLabel();
        cbRelDoaTpProduto = new javax.swing.JComboBox<>();
        btRelDoaFiltrar = new javax.swing.JButton();
        btRelBuscarDoador = new javax.swing.JButton();
        btRelBuscarProduto = new javax.swing.JButton();
        pnRelResultado = new javax.swing.JPanel();
        spRelResultado = new javax.swing.JScrollPane();
        tableRelatorioDoacao = new javax.swing.JTable();
        jbRelDoaTotDin = new javax.swing.JLabel();
        tfRelTotDin = new javax.swing.JTextField();
        jbRelDoaTotProd = new javax.swing.JLabel();
        tfRelTotProd = new javax.swing.JTextField();
        jbRelDoaTorIte = new javax.swing.JLabel();
        tfRelTotIte = new javax.swing.JTextField();
        btRelDoacaoSalvar = new javax.swing.JButton();
        btRelDoacaoLimpar = new javax.swing.JButton();
        btRelDoaSair = new javax.swing.JButton();
        pnRelatorioPedido = new javax.swing.JPanel();
        pnRelPed = new javax.swing.JPanel();
        pnRelPedFiltros = new javax.swing.JPanel();
        lbRelPedDtPedidoInicio = new javax.swing.JLabel();
        tfRelPedDtPedidoInicio = new javax.swing.JFormattedTextField();
        lbRelPedDtPedidoFim = new javax.swing.JLabel();
        tfRelPedDtPedidoFim = new javax.swing.JFormattedTextField();
        lbRelPedStatus = new javax.swing.JLabel();
        cbRelPedStatus = new javax.swing.JComboBox<>();
        lbRelPedCidade = new javax.swing.JLabel();
        cbRelPedCidade = new javax.swing.JComboBox<>();
        lbRelPedCliente = new javax.swing.JLabel();
        tfRelPedCliente = new javax.swing.JTextField();
        btRelPedidoBuscarCliente = new javax.swing.JButton();
        lbRelPedDtEntregaInicio = new javax.swing.JLabel();
        tfRelPedDtEntregaInicio = new javax.swing.JFormattedTextField();
        lbRelPedDtEntregaFim = new javax.swing.JLabel();
        tfRelPedDtEntregaFim = new javax.swing.JFormattedTextField();
        lbRelPedOrdenacao = new javax.swing.JLabel();
        cbRelPedOrdenacao = new javax.swing.JComboBox<>();
        cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao = new javax.swing.JComboBox<>();
        lbRelPedLocal = new javax.swing.JLabel();
        cbRelPedLocal = new javax.swing.JComboBox<>();
        btRelPedFiltrar = new javax.swing.JButton();
        pnRelPedResultado = new javax.swing.JPanel();
        spRelPedResultado = new javax.swing.JScrollPane();
        tableRelatorioPedido = new javax.swing.JTable();
        jpRelPedTotStatus = new javax.swing.JPanel();
        jbRelPedTotPendente = new javax.swing.JLabel();
        tfRelPedTotPendente = new javax.swing.JTextField();
        jbRelPedTotFechado = new javax.swing.JLabel();
        tfRelPedTotFechado = new javax.swing.JTextField();
        jbRelPedTotCancelado = new javax.swing.JLabel();
        tfRelPedTotCancelado = new javax.swing.JTextField();
        jpRelPedTotMarmitas = new javax.swing.JPanel();
        jbRelPedTotMarmitas = new javax.swing.JLabel();
        tfRelPedTotMarmitas = new javax.swing.JTextField();
        btRelPedidoSalvar = new javax.swing.JButton();
        btRelPedidoLimpar = new javax.swing.JButton();
        btRelPedidoSair = new javax.swing.JButton();
        pnHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnCadastroPessoa = new javax.swing.JPanel();
        pnEnderecoCliente = new javax.swing.JPanel();
        tfEnderecoLogradouro = new javax.swing.JTextField();
        lbLogradouro = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        tfEnderecoNumero = new javax.swing.JTextField();
        tfEnderecoBairro = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        lbLogradouro3 = new javax.swing.JLabel();
        tfEnderecoComplemento = new javax.swing.JTextField();
        lbComplemento = new javax.swing.JLabel();
        cbEnderecoCidade = new javax.swing.JComboBox<>();
        tfEnderecoCep = new javax.swing.JTextField();
        lbLogradouro5 = new javax.swing.JLabel();
        lbLogradouro6 = new javax.swing.JLabel();
        cbEnderecoUf = new javax.swing.JComboBox<>();
        btAdicionarCidade = new javax.swing.JButton();
        pnPessoaCliente = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        ffTelefone = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        lbNomePaciente = new javax.swing.JLabel();
        tfNomePaciente = new javax.swing.JTextField();
        lbTempo = new javax.swing.JLabel();
        lbLocalInternacao = new javax.swing.JLabel();
        cbLocalInternacao = new javax.swing.JComboBox<>();
        jsQtdDias = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        tfCodigoPessoa = new javax.swing.JTextField();
        lbCodigoPessoa = new javax.swing.JLabel();
        btBuscarPessoa = new javax.swing.JButton();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbPessoaTipo = new javax.swing.JLabel();
        rbPessoaFisica = new javax.swing.JRadioButton();
        rbPessoaJuridica = new javax.swing.JRadioButton();
        lbDocumento = new javax.swing.JLabel();
        ffDocumento = new javax.swing.JFormattedTextField();
        lbDias = new javax.swing.JLabel();
        btCadastroPessoaLimpar = new javax.swing.JButton();
        btCadastroPessoaSalvar = new javax.swing.JButton();
        btCadastroPessoaSair = new javax.swing.JButton();
        lbObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        menuBarra = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuPessoa = new javax.swing.JMenu();
        menuDoacao = new javax.swing.JMenu();
        menuPedido = new javax.swing.JMenu();
        menuRelatorio = new javax.swing.JMenu();
        jmRelDoacao = new javax.swing.JMenuItem();
        jmRelPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(29, 29, 29));
        setExtendedState(6);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnCard.setLayout(new java.awt.CardLayout());

        pnDoacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbDoacaoIdDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoIdDoacao.setText("Código:");

        tfDoacaoIdDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoIdDoacao.setEnabled(false);

        lbDoacaoDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoDoador.setText("Doador:");

        tfDoacaoIdDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoIdDoador.setEnabled(false);
        tfDoacaoIdDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoIdDoadorActionPerformed(evt);
            }
        });

        tfDoacaoDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoDoador.setEnabled(false);
        tfDoacaoDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoDoadorActionPerformed(evt);
            }
        });

        lbDoacaoTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoTipo.setText("Tipo:");

        cbDoacaoTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbDoacaoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO", "PRODUTO" }));

        lbDoacaoData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoData.setText("Data:");

        try {
            ftDoacaoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftDoacaoData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ftDoacaoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftDoacaoDataActionPerformed(evt);
            }
        });

        lbDoacaoValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoValor.setText("Valor:");

        tfDoacaoValor.setColumns(10);
        tfDoacaoValor.setValue(0.00);
        tfDoacaoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        tfDoacaoValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoValorActionPerformed(evt);
            }
        });

        lbDoacaoObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoObservacao.setText("Observação:");

        taDoacaoObservacao.setColumns(20);
        taDoacaoObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taDoacaoObservacao.setRows(5);
        taDoacaoObservacao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDoacaoObservacao);

        btDoacaoRecibo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRecibo.setText("Gerar Recibo");
        btDoacaoRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoReciboActionPerformed(evt);
            }
        });

        btDoacaoDeletar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoDeletar.setText("Deletar");
        btDoacaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoDeletarActionPerformed(evt);
            }
        });

        btDoacaoBuscarDoacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarDoacao.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btDoacaoBuscarDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoBuscarDoacaoActionPerformed(evt);
            }
        });

        btDoacaoBuscarDoador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarDoador.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btDoacaoBuscarDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoBuscarDoadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDoacaoLayout = new javax.swing.GroupLayout(pnDoacao);
        pnDoacao.setLayout(pnDoacaoLayout);
        pnDoacaoLayout.setHorizontalGroup(
            pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoacaoDoador)
                            .addGroup(pnDoacaoLayout.createSequentialGroup()
                                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDoacaoIdDoacao)
                                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                                        .addComponent(tfDoacaoIdDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btDoacaoBuscarDoacao)))
                                .addGap(18, 18, 18)
                                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDoacaoTipo)
                                    .addComponent(cbDoacaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnDoacaoLayout.createSequentialGroup()
                                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDoacaoData)
                                    .addComponent(ftDoacaoData, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfDoacaoValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDoacaoValor, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btDoacaoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbDoacaoObservacao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDoacaoLayout.createSequentialGroup()
                                    .addComponent(tfDoacaoIdDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfDoacaoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btDoacaoBuscarDoador))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnDoacaoLayout.setVerticalGroup(
            pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnDoacaoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoIdDoacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDoacaoIdDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btDoacaoBuscarDoacao)))
                            .addGroup(pnDoacaoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbDoacaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbDoacaoDoador)
                        .addGap(2, 2, 2)
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDoacaoIdDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfDoacaoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btDoacaoBuscarDoador))
                        .addGap(18, 18, 18)
                        .addComponent(lbDoacaoData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftDoacaoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addComponent(lbDoacaoValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDoacaoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbDoacaoObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoDeletar)
                    .addComponent(btDoacaoRecibo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnDoacaoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbDoacaoSelecionarProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoSelecionarProd.setText("Descrição");

        lbDoacaoQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoQuantidade.setText("Quantidade:");

        tfDoacaoSelecionarProd.setEnabled(false);

        btDoacaoBuscarProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoBuscarProdActionPerformed1(evt);
            }
        });

        jsDoacaoQuantidadeProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsDoacaoQuantidadeProduto.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jsDoacaoQuantidadeProduto.setToolTipText("");

        btDoacaoAddProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoAddProd.setText("Adicionar");
        btDoacaoAddProd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btDoacaoAddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoAddProdActionPerformed(evt);
            }
        });

        pnListBoxProd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos doados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tableDoacaoProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableDoacaoProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Descrição", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDoacaoProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDoacaoProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableDoacaoProdutos);

        javax.swing.GroupLayout pnListBoxProdLayout = new javax.swing.GroupLayout(pnListBoxProd);
        pnListBoxProd.setLayout(pnListBoxProdLayout);
        pnListBoxProdLayout.setHorizontalGroup(
            pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListBoxProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        pnListBoxProdLayout.setVerticalGroup(
            pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListBoxProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btDoacaoAltProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoAltProd.setText("Alterar");
        btDoacaoAltProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoAltProdActionPerformed(evt);
            }
        });

        btDoacaoDelProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoDelProd.setText("Deletar");
        btDoacaoDelProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoDelProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDoacaoProdutoLayout = new javax.swing.GroupLayout(pnDoacaoProduto);
        pnDoacaoProduto.setLayout(pnDoacaoProdutoLayout);
        pnDoacaoProdutoLayout.setHorizontalGroup(
            pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addComponent(btDoacaoAltProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoDelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnListBoxProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoacaoSelecionarProd)
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(tfDoacaoSelecionarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDoacaoBuscarProd)))
                        .addGap(12, 12, 12)
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoacaoQuantidade)
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(jsDoacaoQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDoacaoAddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnDoacaoProdutoLayout.setVerticalGroup(
            pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDoacaoQuantidade)
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsDoacaoQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoProdutoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btDoacaoAddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbDoacaoSelecionarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDoacaoSelecionarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDoacaoBuscarProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pnListBoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoAltProd)
                    .addComponent(btDoacaoDelProd))
                .addGap(43, 43, 43))
        );

        btDoacaoRegistrarDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRegistrarDoacao.setText("Salvar");
        btDoacaoRegistrarDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoRegistrarDoacaoActionPerformed(evt);
            }
        });

        btDoacaoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoLimpar.setText("Limpar");
        btDoacaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoLimparActionPerformed(evt);
            }
        });

        btDoacaoRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRelatorio.setText("Relatório");
        btDoacaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoRelatorioActionPerformed(evt);
            }
        });

        btDoacaoSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoSair.setText("Sair");
        btDoacaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrarDoacaoLayout = new javax.swing.GroupLayout(pnCadastrarDoacao);
        pnCadastrarDoacao.setLayout(pnCadastrarDoacaoLayout);
        pnCadastrarDoacaoLayout.setHorizontalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(pnDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(btDoacaoRegistrarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
        );
        pnCadastrarDoacaoLayout.setVerticalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDoacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoRegistrarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastrarDoacao, "cdCadastrarDoacao");

        pnPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tfPedidoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPedidoClienteActionPerformed(evt);
            }
        });

        lbPedidoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoCliente.setText("Assistente/Beneficiário:");

        lbPedidoQtdMarmitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoQtdMarmitas.setText("Marmitas:");

        taPedidoObservacao.setColumns(20);
        taPedidoObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taPedidoObservacao.setRows(5);
        taPedidoObservacao.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taPedidoObservacao);

        lbPedidoObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoObservacao.setText("Observação:");

        cbPedidoStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPedidoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Entregue", "Cancelado" }));

        lbPedidoStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoStatus.setText("Status:");

        tfPedidoIdPedido.setEditable(false);
        tfPedidoIdPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbPedidoIdPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoIdPedido.setText("Código:");

        tfPedidoIdCliente.setEditable(false);
        tfPedidoIdCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btPedidoBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btPedidoBuscarCliente.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btPedidoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoBuscarClienteActionPerformed(evt);
            }
        });

        btPedidoBuscarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btPedidoBuscarPedido.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btPedidoBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoBuscarPedidoActionPerformed(evt);
            }
        });

        jsQtdMarmitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsQtdMarmitas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jsQtdMarmitas.setToolTipText("");

        lbPedidoDtPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoDtPedido.setText("Data do Pedido:");

        lbPedidoDtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoDtEntrega.setText("Data da Entrega:");

        try {
            ffPedidoDtPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ffPedidoDtPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            ffPedidoDtEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ffPedidoDtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btPedidoDeletar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoDeletar.setText("Deletar");
        btPedidoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoDeletarActionPerformed(evt);
            }
        });

        btPedidoRecibo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoRecibo.setText("Gerar Recibo");
        btPedidoRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoReciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addComponent(btPedidoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPedidoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoCliente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPedidoLayout.createSequentialGroup()
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPedidoLayout.createSequentialGroup()
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbPedidoIdPedido)
                                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                                .addComponent(tfPedidoIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btPedidoBuscarPedido)))
                                        .addGap(12, 12, 12)
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbPedidoStatus)
                                            .addComponent(cbPedidoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPedidoLayout.createSequentialGroup()
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbPedidoQtdMarmitas)
                                            .addComponent(jsQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbPedidoDtPedido)
                                            .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbPedidoDtEntrega)
                                            .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnPedidoLayout.createSequentialGroup()
                                        .addComponent(tfPedidoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPedidoCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPedidoBuscarCliente))
                                    .addGroup(pnPedidoLayout.createSequentialGroup()
                                        .addComponent(lbPedidoObservacao)
                                        .addGap(498, 498, 498)))))
                        .addGap(25, 25, 25))))
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPedidoIdPedido)
                    .addComponent(lbPedidoStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPedidoIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoBuscarPedido)
                    .addComponent(cbPedidoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbPedidoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPedidoBuscarCliente)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPedidoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPedidoDtEntrega)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                            .addComponent(lbPedidoDtPedido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoQtdMarmitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbPedidoObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPedidoDeletar)
                    .addComponent(btPedidoRecibo))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btPedidoRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoRegistrar.setText("Salvar");
        btPedidoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoRegistrarActionPerformed(evt);
            }
        });

        btPedidoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoLimpar.setText("Limpar");
        btPedidoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoLimparActionPerformed(evt);
            }
        });

        btPedidoSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoSair.setText("Sair");
        btPedidoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoSairActionPerformed(evt);
            }
        });

        btPedidoRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPedidoRelatorio.setText("Relatório");
        btPedidoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrarPedidoLayout = new javax.swing.GroupLayout(pnCadastrarPedido);
        pnCadastrarPedido.setLayout(pnCadastrarPedidoLayout);
        pnCadastrarPedidoLayout.setHorizontalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                        .addComponent(btPedidoRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPedidoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPedidoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(683, Short.MAX_VALUE))
        );
        pnCadastrarPedidoLayout.setVerticalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPedidoRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastrarPedido, "cdCadastrarPedido");

        pnRelDoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório Doação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        pnRelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbRelDoaDtInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaDtInicial.setText("Data Inicial:");

        try {
            ffRelDoaDtInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ffRelDoaDtInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaDtFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaDtFinal.setText("Data Final:");

        try {
            ffRelDoaDtFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ffRelDoaDtFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaDoador.setText("Doador:");

        tfRelDoaDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaTpDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaTpDoacao.setText("Tipo Doação:");

        cbRelDoaTpDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaTpDoacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Produto", "Dinheiro" }));

        lbRelDoaOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaOrdenacao.setText("Ordenação:");

        cbRelDoaOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Código", "Nome do Doador", "Valor", "Quantidade de Produtos" }));

        cbRelDoaSentido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaSentido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crescente", "Decrescente" }));

        lbRelDoaProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaProd.setText("Produto:");

        tfRelDoaProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaTpProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaTpProduto.setText("Tipo Produto:");

        cbRelDoaTpProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaTpProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento", "Limpeza", "Outros" }));

        btRelDoaFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoaFiltrar.setText("Filtrar");
        btRelDoaFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelDoaFiltrarActionPerformed(evt);
            }
        });

        btRelBuscarDoador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btRelBuscarDoador.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btRelBuscarDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelBuscarDoadorActionPerformed(evt);
            }
        });

        btRelBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btRelBuscarProduto.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btRelBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelBuscarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRelFiltrosLayout = new javax.swing.GroupLayout(pnRelFiltros);
        pnRelFiltros.setLayout(pnRelFiltrosLayout);
        pnRelFiltrosLayout.setHorizontalGroup(
            pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffRelDoaDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelDoaDtInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRelDoaDtFinal)
                            .addComponent(ffRelDoaDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaOrdenacao)
                            .addComponent(cbRelDoaOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRelDoaSentido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaProd)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                                .addComponent(tfRelDoaProd, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRelBuscarProduto))
                            .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                                        .addComponent(lbRelDoaDoador)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfRelDoaDoador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRelBuscarDoador)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpProduto)
                            .addComponent(cbRelDoaTpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbRelDoaTpDoacao)
                    .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        pnRelFiltrosLayout.setVerticalGroup(
            pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDtInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDtFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaTpDoacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDoador)
                        .addGap(32, 32, 32))
                    .addComponent(tfRelDoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelBuscarDoador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaOrdenacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelDoaOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbRelDoaSentido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelDoaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaTpProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRelDoaTpProduto)))
                    .addComponent(btRelBuscarProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15))
        );

        pnRelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tableRelatorioDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableRelatorioDoacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód.", "Doador", "Tipo", "Valor", "Produtos", "Observação", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spRelResultado.setViewportView(tableRelatorioDoacao);

        jbRelDoaTotDin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelDoaTotDin.setText("Valor Total:");

        tfRelTotDin.setEditable(false);
        tfRelTotDin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelTotDin.setText("R$ 0,00");

        jbRelDoaTotProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelDoaTotProd.setText("Total Produtos:");

        tfRelTotProd.setEditable(false);
        tfRelTotProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelTotProd.setText("0");

        jbRelDoaTorIte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelDoaTorIte.setText("Total Itens:");

        tfRelTotIte.setEditable(false);
        tfRelTotIte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelTotIte.setText("0");

        javax.swing.GroupLayout pnRelResultadoLayout = new javax.swing.GroupLayout(pnRelResultado);
        pnRelResultado.setLayout(pnRelResultadoLayout);
        pnRelResultadoLayout.setHorizontalGroup(
            pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                    .addGroup(pnRelResultadoLayout.createSequentialGroup()
                        .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotDin)
                            .addComponent(tfRelTotDin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotProd)
                            .addComponent(tfRelTotProd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTorIte)
                            .addComponent(tfRelTotIte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnRelResultadoLayout.setVerticalGroup(
            pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spRelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnRelResultadoLayout.createSequentialGroup()
                            .addComponent(jbRelDoaTotProd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfRelTotProd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelResultadoLayout.createSequentialGroup()
                            .addComponent(jbRelDoaTotDin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfRelTotDin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelResultadoLayout.createSequentialGroup()
                        .addComponent(jbRelDoaTorIte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelTotIte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRelDoaLayout = new javax.swing.GroupLayout(pnRelDoa);
        pnRelDoa.setLayout(pnRelDoaLayout);
        pnRelDoaLayout.setHorizontalGroup(
            pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelDoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnRelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnRelDoaLayout.setVerticalGroup(
            pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelDoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        btRelDoacaoSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoacaoSalvar.setText("Salvar");
        btRelDoacaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelDoacaoSalvarActionPerformed(evt);
            }
        });

        btRelDoacaoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoacaoLimpar.setText("Limpar");
        btRelDoacaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelDoacaoLimparActionPerformed(evt);
            }
        });

        btRelDoaSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoaSair.setText("Sair");
        btRelDoaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelDoaSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRelatorioDoacaoLayout = new javax.swing.GroupLayout(pnRelatorioDoacao);
        pnRelatorioDoacao.setLayout(pnRelatorioDoacaoLayout);
        pnRelatorioDoacaoLayout.setHorizontalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                        .addComponent(btRelDoacaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        pnRelatorioDoacaoLayout.setVerticalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelDoacaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioDoacao, "relatorioDoacao");
        pnRelatorioDoacao.getAccessibleContext().setAccessibleName("");

        pnRelPed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        pnRelPedFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbRelPedDtPedidoInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedDtPedidoInicio.setText("Data do Pedido (Início):");

        try {
            tfRelPedDtPedidoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfRelPedDtPedidoInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedDtPedidoFim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedDtPedidoFim.setText("Data do Pedido (Fim):");

        try {
            tfRelPedDtPedidoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfRelPedDtPedidoFim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedStatus.setText("Status:");

        cbRelPedStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendente", "Finalizado", "Cancelado" }));
        cbRelPedStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelPedStatusActionPerformed(evt);
            }
        });

        lbRelPedCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedCidade.setText("Cidade Cliente:");

        cbRelPedCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Ituiutaba", "Paracatu" }));

        lbRelPedCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedCliente.setText("Assistente/Beneficiário:");

        tfRelPedCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btRelPedidoBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btRelPedidoBuscarCliente.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btRelPedidoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedidoBuscarClienteActionPerformed(evt);
            }
        });

        lbRelPedDtEntregaInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedDtEntregaInicio.setText("Data da Entrega (Início):");

        try {
            tfRelPedDtEntregaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfRelPedDtEntregaInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedDtEntregaFim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedDtEntregaFim.setText("Data da Entrega (Fim):");

        try {
            tfRelPedDtEntregaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfRelPedDtEntregaFim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedOrdenacao.setText("Ordenação:");

        cbRelPedOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cliente", "Data do Pedido", "Data da Entrega", "Status", "Marmitas" }));

        cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crescente", "Decrescente" }));

        lbRelPedLocal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelPedLocal.setText("Local:");

        cbRelPedLocal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hospital São José", "Pronto Socorro" }));

        btRelPedFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelPedFiltrar.setText("Filtrar");
        btRelPedFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRelPedFiltrosLayout = new javax.swing.GroupLayout(pnRelPedFiltros);
        pnRelPedFiltros.setLayout(pnRelPedFiltrosLayout);
        pnRelPedFiltrosLayout.setHorizontalGroup(
            pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfRelPedDtPedidoInicio)
                    .addComponent(lbRelPedDtPedidoInicio)
                    .addComponent(lbRelPedDtEntregaInicio)
                    .addComponent(tfRelPedDtEntregaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRelPedDtEntregaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelPedDtEntregaFim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedOrdenacao)
                            .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelPedLocal))
                        .addGap(75, 75, 75)
                        .addComponent(btRelPedFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedDtPedidoFim)
                                .addGap(50, 50, 50))
                            .addComponent(tfRelPedDtPedidoFim, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedStatus)
                            .addComponent(cbRelPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedCidade)
                            .addComponent(cbRelPedCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRelPedCliente)
                            .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRelPedidoBuscarCliente)))
                .addContainerGap())
        );
        pnRelPedFiltrosLayout.setVerticalGroup(
            pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedDtPedidoInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelPedDtPedidoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfRelPedDtPedidoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedDtPedidoFim)
                        .addGap(32, 32, 32))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRelPedidoBuscarCliente)
                            .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRelPedDtEntregaInicio)
                            .addComponent(lbRelPedDtEntregaFim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelPedDtEntregaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btRelPedFiltrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRelPedDtEntregaFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedOrdenacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        pnRelPedResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tableRelatorioPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableRelatorioPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Status", "Cliente", "Local", "Marmitas", "Observação", "Data do Pedido", "Data da Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spRelPedResultado.setViewportView(tableRelatorioPedido);

        jpRelPedTotStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jbRelPedTotPendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelPedTotPendente.setText("Pendente:");

        tfRelPedTotPendente.setEditable(false);
        tfRelPedTotPendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelPedTotPendente.setText("0");

        jbRelPedTotFechado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelPedTotFechado.setText("Fechado:");

        tfRelPedTotFechado.setEditable(false);
        tfRelPedTotFechado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelPedTotFechado.setText("0");

        jbRelPedTotCancelado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelPedTotCancelado.setText("Cancelado:");

        tfRelPedTotCancelado.setEditable(false);
        tfRelPedTotCancelado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelPedTotCancelado.setText("0");

        javax.swing.GroupLayout jpRelPedTotStatusLayout = new javax.swing.GroupLayout(jpRelPedTotStatus);
        jpRelPedTotStatus.setLayout(jpRelPedTotStatusLayout);
        jpRelPedTotStatusLayout.setHorizontalGroup(
            jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRelPedTotStatusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotPendente)
                    .addComponent(tfRelPedTotPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotFechado)
                    .addComponent(tfRelPedTotFechado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotCancelado)
                    .addComponent(tfRelPedTotCancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpRelPedTotStatusLayout.setVerticalGroup(
            jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRelPedTotStatusLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpRelPedTotStatusLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRelPedTotStatusLayout.createSequentialGroup()
                            .addComponent(jbRelPedTotPendente)
                            .addGap(46, 46, 46)))
                    .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpRelPedTotStatusLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotFechado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRelPedTotStatusLayout.createSequentialGroup()
                            .addComponent(jbRelPedTotFechado)
                            .addGap(46, 46, 46)))
                    .addGroup(jpRelPedTotStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpRelPedTotStatusLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotCancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRelPedTotStatusLayout.createSequentialGroup()
                            .addComponent(jbRelPedTotCancelado)
                            .addGap(46, 46, 46))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbRelPedTotMarmitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbRelPedTotMarmitas.setText("Total de Marmitas:");

        tfRelPedTotMarmitas.setEditable(false);
        tfRelPedTotMarmitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfRelPedTotMarmitas.setText("0");

        javax.swing.GroupLayout jpRelPedTotMarmitasLayout = new javax.swing.GroupLayout(jpRelPedTotMarmitas);
        jpRelPedTotMarmitas.setLayout(jpRelPedTotMarmitasLayout);
        jpRelPedTotMarmitasLayout.setHorizontalGroup(
            jpRelPedTotMarmitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbRelPedTotMarmitas)
            .addComponent(tfRelPedTotMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpRelPedTotMarmitasLayout.setVerticalGroup(
            jpRelPedTotMarmitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRelPedTotMarmitasLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jbRelPedTotMarmitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRelPedTotMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRelPedResultadoLayout = new javax.swing.GroupLayout(pnRelPedResultado);
        pnRelPedResultado.setLayout(pnRelPedResultadoLayout);
        pnRelPedResultadoLayout.setHorizontalGroup(
            pnRelPedResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spRelPedResultado)
                    .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                        .addComponent(jpRelPedTotMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpRelPedTotStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnRelPedResultadoLayout.setVerticalGroup(
            pnRelPedResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spRelPedResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnRelPedResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jpRelPedTotMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpRelPedTotStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pnRelPedLayout = new javax.swing.GroupLayout(pnRelPed);
        pnRelPed.setLayout(pnRelPedLayout);
        pnRelPedLayout.setHorizontalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnRelPedFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnRelPedResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRelPedLayout.setVerticalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRelPedFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRelPedResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btRelPedidoSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelPedidoSalvar.setText("Salvar");
        btRelPedidoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedidoSalvarActionPerformed(evt);
            }
        });

        btRelPedidoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelPedidoLimpar.setText("Limpar");
        btRelPedidoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedidoLimparActionPerformed(evt);
            }
        });

        btRelPedidoSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelPedidoSair.setText("Sair");
        btRelPedidoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedidoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRelatorioPedidoLayout = new javax.swing.GroupLayout(pnRelatorioPedido);
        pnRelatorioPedido.setLayout(pnRelatorioPedidoLayout);
        pnRelatorioPedidoLayout.setHorizontalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                        .addComponent(btRelPedidoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelPedidoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        pnRelatorioPedidoLayout.setVerticalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelPedidoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelPedidoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioPedido, "relatorioPedido");

        pnHome.setBackground(new java.awt.Color(245, 245, 246));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NossoLarMenor.png"))); // NOI18N

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                .addContainerGap(436, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(391, Short.MAX_VALUE))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel3)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pnCard.add(pnHome, "cdHome");

        pnEnderecoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tfEnderecoLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro.setText("Logradouro:");

        lbNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNumero.setText("Número:");

        tfEnderecoNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfEnderecoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoNumeroKeyTyped(evt);
            }
        });

        tfEnderecoBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        lbLogradouro3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro3.setText("Cidade:");

        tfEnderecoComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbComplemento.setText("Complemento:");

        cbEnderecoCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbEnderecoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEnderecoCidadeActionPerformed(evt);
            }
        });

        tfEnderecoCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfEnderecoCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoCepKeyTyped(evt);
            }
        });

        lbLogradouro5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro5.setText("CEP:");

        lbLogradouro6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro6.setText("UF:");

        cbEnderecoUf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbEnderecoUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbEnderecoUf.setEnabled(false);

        btAdicionarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        btAdicionarCidade.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btAdicionarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnEnderecoClienteLayout = new javax.swing.GroupLayout(pnEnderecoCliente);
        pnEnderecoCliente.setLayout(pnEnderecoClienteLayout);
        pnEnderecoClienteLayout.setHorizontalGroup(
            pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                        .addComponent(lbLogradouro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNumero)
                                    .addComponent(tfEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBairro)
                                    .addComponent(tfEnderecoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbComplemento)
                                    .addComponent(tfEnderecoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbLogradouro5)
                                    .addComponent(tfEnderecoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbLogradouro3)
                                    .addComponent(cbEnderecoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbLogradouro6)
                                    .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                                        .addComponent(cbEnderecoUf, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btAdicionarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tfEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        pnEnderecoClienteLayout.setVerticalGroup(
            pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLogradouro3)
                            .addComponent(lbLogradouro6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEnderecoCidade)
                            .addComponent(cbEnderecoUf)
                            .addComponent(btAdicionarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                        .addComponent(lbLogradouro5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEnderecoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLogradouro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero)
                    .addComponent(lbBairro)
                    .addComponent(lbComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pnPessoaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tfNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeKeyTyped(evt);
            }
        });

        lbNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNome.setText("Nome:");

        try {
            ffTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ffTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTelefone.setText("Telefone:");

        lbNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNomePaciente.setText("Nome do Paciente:");

        tfNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomePacienteKeyTyped(evt);
            }
        });

        lbTempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTempo.setText("Tempo:");

        lbLocalInternacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLocalInternacao.setText("Local de Internação:");

        cbLocalInternacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLocalInternacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hospital", "Pronto Socorro", "" }));
        cbLocalInternacao.setEnabled(false);

        jsQtdDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsQtdDias.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jsQtdDias.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo Cliente:");

        cbTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beneficiario", "Doador", "Assistente" }));
        cbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUsuarioActionPerformed(evt);
            }
        });

        tfCodigoPessoa.setEditable(false);
        tfCodigoPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbCodigoPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCodigoPessoa.setText("Código:");

        btBuscarPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btBuscarPessoa.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btBuscarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPessoaActionPerformed(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmail.setText("E-mail:");

        tfEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbPessoaTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPessoaTipo.setText("Tipo Pessoa:");

        buttonGroupPessoaTipo.add(rbPessoaFisica);
        rbPessoaFisica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbPessoaFisica.setText("Física (CPF)");
        rbPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaFisicaActionPerformed(evt);
            }
        });

        buttonGroupPessoaTipo.add(rbPessoaJuridica);
        rbPessoaJuridica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbPessoaJuridica.setText("Jurídica (CNPJ)");
        rbPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaJuridicaActionPerformed(evt);
            }
        });

        lbDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDocumento.setText("Nº do Documento:");

        ffDocumento.setEnabled(false);
        ffDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDias.setText("Dias");

        javax.swing.GroupLayout pnPessoaClienteLayout = new javax.swing.GroupLayout(pnPessoaCliente);
        pnPessoaCliente.setLayout(pnPessoaClienteLayout);
        pnPessoaClienteLayout.setHorizontalGroup(
            pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDocumento)
                    .addComponent(ffDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                        .addComponent(lbPessoaTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbPessoaFisica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbPessoaJuridica))
                    .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                        .addComponent(tfEmail)
                        .addComponent(tfNomePaciente)
                        .addComponent(lbEmail)
                        .addComponent(lbNomePaciente)
                        .addComponent(lbTelefone)
                        .addComponent(lbNome)
                        .addComponent(ffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                            .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbLocalInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbLocalInternacao))
                            .addGap(18, 18, 18)
                            .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                                    .addComponent(jsQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbDias))
                                .addComponent(lbTempo)))
                        .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                            .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                                    .addComponent(tfCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btBuscarPessoa))
                                .addComponent(lbCodigoPessoa))
                            .addGap(18, 18, 18)
                            .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnPessoaClienteLayout.setVerticalGroup(
            pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPessoaClienteLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPessoaClienteLayout.createSequentialGroup()
                        .addComponent(lbCodigoPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscarPessoa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPessoaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                        .addComponent(lbLocalInternacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLocalInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                        .addComponent(lbTempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDias))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNomePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPessoaTipo)
                    .addComponent(rbPessoaFisica)
                    .addComponent(rbPessoaJuridica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ffDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btCadastroPessoaLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastroPessoaLimpar.setText("Limpar");
        btCadastroPessoaLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPessoaLimparActionPerformed(evt);
            }
        });

        btCadastroPessoaSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastroPessoaSalvar.setText("Salvar");
        btCadastroPessoaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPessoaSalvarActionPerformed(evt);
            }
        });

        btCadastroPessoaSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastroPessoaSair.setText("Sair");
        btCadastroPessoaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPessoaSairActionPerformed(evt);
            }
        });

        lbObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbObservacao.setText("Observação:");

        taObservacao.setColumns(20);
        taObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taObservacao.setLineWrap(true);
        taObservacao.setRows(5);
        jScrollPane1.setViewportView(taObservacao);

        javax.swing.GroupLayout pnCadastroPessoaLayout = new javax.swing.GroupLayout(pnCadastroPessoa);
        pnCadastroPessoa.setLayout(pnCadastroPessoaLayout);
        pnCadastroPessoaLayout.setHorizontalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(btCadastroPessoaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastroPessoaLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastroPessoaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbObservacao)
                            .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        pnCadastroPessoaLayout.setVerticalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastroPessoaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCadastroPessoaLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCadastroPessoaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCadastroPessoaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastroPessoa, "beneficiario");

        javax.swing.GroupLayout pnDadosPrincipalLayout = new javax.swing.GroupLayout(pnDadosPrincipal);
        pnDadosPrincipal.setLayout(pnDadosPrincipalLayout);
        pnDadosPrincipalLayout.setHorizontalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnDadosPrincipalLayout.setVerticalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnDadosPrincipal, java.awt.BorderLayout.CENTER);

        menuBarra.setBackground(new java.awt.Color(52, 52, 52));
        menuBarra.setForeground(new java.awt.Color(255, 255, 255));
        menuBarra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuBarra.setPreferredSize(new java.awt.Dimension(458, 50));

        menuInicio.setBackground(new java.awt.Color(52, 52, 52));
        menuInicio.setForeground(new java.awt.Color(255, 255, 255));
        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInicioMouseClicked(evt);
            }
        });
        menuBarra.add(menuInicio);

        menuPessoa.setBackground(new java.awt.Color(52, 52, 52));
        menuPessoa.setForeground(new java.awt.Color(255, 255, 255));
        menuPessoa.setText("Pessoa");
        menuPessoa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPessoaMouseClicked(evt);
            }
        });
        menuBarra.add(menuPessoa);

        menuDoacao.setBackground(new java.awt.Color(52, 52, 52));
        menuDoacao.setForeground(new java.awt.Color(255, 255, 255));
        menuDoacao.setText("Doação");
        menuDoacao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuDoacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDoacaoMouseClicked(evt);
            }
        });
        menuBarra.add(menuDoacao);

        menuPedido.setBackground(new java.awt.Color(52, 52, 52));
        menuPedido.setForeground(new java.awt.Color(255, 255, 255));
        menuPedido.setText("Pedido");
        menuPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPedidoMouseClicked(evt);
            }
        });
        menuBarra.add(menuPedido);

        menuRelatorio.setBackground(new java.awt.Color(52, 52, 52));
        menuRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        menuRelatorio.setText("Relatórios");
        menuRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jmRelDoacao.setBackground(new java.awt.Color(52, 52, 52));
        jmRelDoacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmRelDoacao.setForeground(new java.awt.Color(255, 255, 255));
        jmRelDoacao.setText("Doações");
        jmRelDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelDoacaoActionPerformed(evt);
            }
        });
        menuRelatorio.add(jmRelDoacao);

        jmRelPedido.setBackground(new java.awt.Color(52, 52, 52));
        jmRelPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmRelPedido.setForeground(new java.awt.Color(255, 255, 255));
        jmRelPedido.setText("Pedidos");
        jmRelPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelPedidoActionPerformed(evt);
            }
        });
        menuRelatorio.add(jmRelPedido);

        menuBarra.add(menuRelatorio);

        setJMenuBar(menuBarra);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarClienteActionPerformed
        // Botão para cadastrar CLIENTE:
        cl.show(pnCard, "beneficiario");
    }//GEN-LAST:event_btCadastrarClienteActionPerformed

    private void btCadastrarDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarDoadorActionPerformed
        // Botão para cadastrar PESSOA
        cl.show(pnCard, "doador");
    }//GEN-LAST:event_btCadastrarDoadorActionPerformed

    private void btCadastrarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarCidadeActionPerformed
        // Botão para cadastrar CIDADE:
        cl.show(pnCard, "cidade");
    }//GEN-LAST:event_btCadastrarCidadeActionPerformed

    private void tfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyTyped
        char verificador = evt.getKeyChar();
        if (!Character.isLetter(verificador) && verificador != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_tfNomeKeyTyped

    private void rbPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPessoaFisicaActionPerformed
        aplicarMascara(ffDocumento, "###.###.###-##");
    }//GEN-LAST:event_rbPessoaFisicaActionPerformed

    private void rbPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPessoaJuridicaActionPerformed
        aplicarMascara(ffDocumento, "##.###.###/####-##");
    }//GEN-LAST:event_rbPessoaJuridicaActionPerformed

    private void tfNomePacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomePacienteKeyTyped
        char verificador = evt.getKeyChar();
        if (!Character.isLetter(verificador) && verificador != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_tfNomePacienteKeyTyped

    private void tfEnderecoCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoCepKeyTyped
        char verificador = evt.getKeyChar();
        if (!Character.isDigit(verificador)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfEnderecoCepKeyTyped

    private void tfEnderecoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoNumeroKeyTyped
        char verificador = evt.getKeyChar();
        if (!Character.isDigit(verificador)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfEnderecoNumeroKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cl.show(pnCard, "cdHome");
        try {
            carregarCidade();
            buscarPessoa.carregarCidade();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void cbEnderecoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEnderecoCidadeActionPerformed
        Cidade cidadeSelecionada = (Cidade) cbEnderecoCidade.getSelectedItem();
        if (cidadeSelecionada != null) {
            cbEnderecoUf.setSelectedItem(cidadeSelecionada.getEstado()); // define a UF automaticamente
        }
    }//GEN-LAST:event_cbEnderecoCidadeActionPerformed

    private void btCadastroPessoaLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPessoaLimparActionPerformed
        limparcamposCadastroUsuario();
    }//GEN-LAST:event_btCadastroPessoaLimparActionPerformed

    private void btCadastroPessoaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPessoaSalvarActionPerformed
        Endereco endereco = null;
        Pessoa novaPessoa = null;
        Paciente paciente = null;
        String telefone = ffTelefone.getText().replaceAll("[^\\d]", "");

        Cidade cidadeEscolhida = (Cidade) cbEnderecoCidade.getSelectedItem();
        if (tfNome.getText().isEmpty() || tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Necessário preencher o nome da Pessoa!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ffTelefone.getText().replaceAll("[^\\d]", "").isEmpty() || ffTelefone.getText().replaceAll("[^\\d]", "").equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Necessário preencher o telefone da Pessoa!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (cidadeEscolhida.getNome().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma cidade válida!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tfEnderecoLogradouro.getText().trim().isEmpty() || tfEnderecoLogradouro.getText().equals("")) {
            endereco = new Endereco(cidadeEscolhida);
        } else {
            endereco = new Endereco(
                    tfEnderecoLogradouro.getText(),
                    Integer.parseInt(tfEnderecoNumero.getText()),
                    tfEnderecoBairro.getText(),
                    tfEnderecoCep.getText(),
                    tfEnderecoComplemento.getText(),
                    cidadeEscolhida);
        }

        novaPessoa = new Pessoa(tfNome.getText(), telefone, endereco);

        if (tfNomePaciente.getText() != null && jsQtdDias.getValue() != null) {
            paciente = new Paciente(tfNomePaciente.getText(), (Integer) jsQtdDias.getValue());
        }

        Object selected = cbTipoUsuario.getSelectedItem();
        if (selected != null) {
            String tipo = selected.toString();
            switch (tipo) {
                case "Assistente":
                    novaPessoa.setTipoUsuario(TipoCad.ASSISTENTE);
                    break;
                case "Beneficiario":
                    novaPessoa.setTipoUsuario(TipoCad.BENEFICIARIO);
                    break;
                case "Doador":
                    novaPessoa.setTipoUsuario(TipoCad.DOADOR);
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Tipo de usuário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return; // evita continuar com tipoUsuario nulo
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de usuário.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (cbLocalInternacao.getSelectedIndex()) {
            case 0:
                novaPessoa.setLocal(Pessoa.Local.HOSPITAL);
                break;

            case 1:
                novaPessoa.setLocal(Pessoa.Local.PRONTOSOCORRO);
                break;
            default:
                novaPessoa.setLocal(null);
        }

        novaPessoa.setEmail(tfEmail.getText());
        if (rbPessoaFisica.isSelected()) {
            novaPessoa.setTipoPessoa(Pessoa.TipoPessoa.FISICA);
        }
        if (rbPessoaJuridica.isSelected()) {
            novaPessoa.setTipoPessoa(Pessoa.TipoPessoa.JURIDICA);
        }
        novaPessoa.setIdentificacao(ffDocumento.getText().replaceAll("[^\\d]", ""));
        novaPessoa.setObservacao(taObservacao.getText());
        novaPessoa.setPaciente(paciente);

        try {
            if (tfCodigoPessoa.getText().equals("")) {
                enderecoController.cadastrarEndereco(endereco, cidadeEscolhida);
                if (!pessoaController.cadastrarPessoa(novaPessoa, paciente)) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Cadastrar o Usuário", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sucesso ao Cadastrar o Usuário", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparcamposCadastroUsuario();
                }
            } else {
                novaPessoa.setId(Integer.valueOf(tfCodigoPessoa.getText()));
                if (!enderecoController.alterarEndereco(endereco, pessoaAntiga.getEnderecoId())) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Alterar o Endereço do usuário", "Alteração no Cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!tfNomePaciente.getText().isEmpty() || !tfNomePaciente.getText().equals("")) {
                    if (!pacienteController.alterarPaciente(novaPessoa.getPaciente(), pessoaAntiga.getPaciente(), novaPessoa.getId())) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao Alterar o paciente", "Alteração no Cadastro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                novaPessoa.setEnderecoId(enderecoController.buscarIdEndereco(endereco, cidadeController.buscarIdCidade(new Cidade(endereco.getCidade().getNome(), endereco.getCidade().getEstado()))));
                if (novaPessoa.camposIguais(pessoaAntiga)) {
                    JOptionPane.showMessageDialog(this, "Nenhum campo alterado", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!pessoaController.alterarPessoa(novaPessoa)) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Alterar o Usuário", "Alteração no Cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(rootPane, "Sucesso ao Alterar o Usuário", "Sucesso ao Alterar", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btCadastroPessoaSalvarActionPerformed

    private void cbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoUsuarioActionPerformed
        switch (cbTipoUsuario.getSelectedIndex()) {
            //0 Bene 1 Doador 2 Assis
            case 0:
                tfNomePaciente.setEnabled(true);
                //tfQtdDias.setEnabled(true);
                cbLocalInternacao.setSelectedIndex(0);
                // hospital
                break;
            case 1:
                tfNomePaciente.setEnabled(false);
                //tfQtdDias.setEnabled(false);
                cbLocalInternacao.setSelectedIndex(2);
                // nulo
                break;
            case 2:
                tfNomePaciente.setEnabled(false);
                //tfQtdDias.setEnabled(false);
                cbLocalInternacao.setSelectedIndex(1);
                // Pronto socorro
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cbTipoUsuarioActionPerformed

    private void tfDoacaoDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoDoadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoDoadorActionPerformed

    private void tfDoacaoIdDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoIdDoadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoIdDoadorActionPerformed

    private void ftDoacaoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftDoacaoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftDoacaoDataActionPerformed

    private void tfDoacaoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoValorActionPerformed

    private void btDoacaoAddProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoAddProdActionPerformed
        int quantidade = (int) jsDoacaoQuantidadeProduto.getValue();
        if (tfDoacaoIdDoacao.getText().equals("")) {
            Produto produto = buscarProduto.getProduto();
            produto.setQuantidade(quantidade);
            produtosDoacao.add(produto);
            Object[] linha = {produto.getTipo(), produto.getNome(), produto.getQuantidade()};
            modeloTabela.addRow(linha);
        } else {
            modeloTabela.setValueAt(quantidade, indiceTabelaProduto, 2);
        }
        jsDoacaoQuantidadeProduto.setEnabled(false);

    }//GEN-LAST:event_btDoacaoAddProdActionPerformed

    private void tfPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPedidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPedidoClienteActionPerformed

    private void menuRelatorioDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioDoacaoActionPerformed
        cl.show(pnCard, "relatorioDoacao");
    }//GEN-LAST:event_menuRelatorioDoacaoActionPerformed

    private void menuRelatorioPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioPedidoActionPerformed
        cl.show(pnCard, "relatorioPedido");
    }//GEN-LAST:event_menuRelatorioPedidoActionPerformed

    private void menuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseClicked
        cl.show(pnCard, "cdHome");
    }//GEN-LAST:event_menuInicioMouseClicked

    private void btDoacaoBuscarDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarDoacaoActionPerformed
        buscarDoacao.setLocationRelativeTo(this);
        buscarDoacao.setVisible(true);
    }//GEN-LAST:event_btDoacaoBuscarDoacaoActionPerformed

    private void tableDoacaoProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoacaoProdutosMouseClicked
        int linhaSelecionada = tableDoacaoProdutos.getSelectedRow();
        if (linhaSelecionada != -1) {
            indiceTabelaProduto = linhaSelecionada;
            Object descricao = tableDoacaoProdutos.getValueAt(linhaSelecionada, 1);
            Object quantidade = tableDoacaoProdutos.getValueAt(linhaSelecionada, 2);
            tfDoacaoSelecionarProd.setText(descricao.toString());
            jsDoacaoQuantidadeProduto.setValue(quantidade);
        }
    }//GEN-LAST:event_tableDoacaoProdutosMouseClicked

    private void btDoacaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoDeletarActionPerformed
        if (!tfDoacaoIdDoacao.getText().equals("")) {
            int idDoacao = Integer.parseInt(tfDoacaoIdDoacao.getText());
            if (doacaoController.removeDoacao(idDoacao)) {
                JOptionPane.showMessageDialog(rootPane, "Doação deletada com sucesso.", "Sucesso ao Deletar", JOptionPane.INFORMATION_MESSAGE);
                limparCamposCadastroDoacao();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel deletar a Doação!", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Doação!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btDoacaoDeletarActionPerformed

    private void btDoacaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoLimparActionPerformed
        limparCamposCadastroDoacao();
        destravaCamposDoacao();
    }//GEN-LAST:event_btDoacaoLimparActionPerformed

    private void cbRelPedStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelPedStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelPedStatusActionPerformed

    private void btDoacaoReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoReciboActionPerformed
        if (!tfDoacaoIdDoacao.getText().equals("")) {
            try {
                relatorioController.gerarReciboDoacao(buscarDoacao.getDoacao());
                JOptionPane.showMessageDialog(rootPane, "Recibo gerado.", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma Doação!", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btDoacaoReciboActionPerformed

    private void btDoacaoAltProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoAltProdActionPerformed
        if (!tfDoacaoSelecionarProd.equals("")) {
            jsDoacaoQuantidadeProduto.setEnabled(true);
        }
    }//GEN-LAST:event_btDoacaoAltProdActionPerformed

    private void btDoacaoDelProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoDelProdActionPerformed
        if (!tfDoacaoSelecionarProd.getText().equals("")) {
            modeloTabela.removeRow(indiceTabelaProduto);
            produtosDoacao.remove(indiceTabelaProduto);
        }
    }//GEN-LAST:event_btDoacaoDelProdActionPerformed

    private void btDoacaoRegistrarDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoRegistrarDoacaoActionPerformed
        Doacao doacao = new Doacao();
        doacao.setDoador(buscarPessoa.getPessoa());
        doacao.setDataDoacao(LocalDate.parse(ftDoacaoData.getText(), dataFormat));
        if (cbDoacaoTipo.getSelectedIndex() == 0) {
            doacao.setTipo(Doacao.TipoDoa.DINHEIRO);
        } else {
            doacao.setTipo(Doacao.TipoDoa.PRODUTO);
        }
        Number temp = (Number) tfDoacaoValor.getValue();
        doacao.setValor(temp.doubleValue());
        doacao.setObservacao(taDoacaoObservacao.getText());
        doacao.setProduto(produtosDoacao);
        try {
            if (doacaoController.cadastrarDoacao(doacao)) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso ao Cadastrar Doação", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
                limparCamposCadastroDoacao();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro ao Cadastrar Doação", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btDoacaoRegistrarDoacaoActionPerformed

    private void btDoacaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoSairActionPerformed
        cl.show(pnCard, "cdHome");
        limparCamposCadastroDoacao();
    }//GEN-LAST:event_btDoacaoSairActionPerformed

    private void btDoacaoBuscarDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarDoadorActionPerformed
        buscarPessoa.identificaTelas(2);
        buscarPessoa.setLocationRelativeTo(this);
        buscarPessoa.setVisible(true);
    }//GEN-LAST:event_btDoacaoBuscarDoadorActionPerformed

    private void btDoacaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoRelatorioActionPerformed

    }//GEN-LAST:event_btDoacaoRelatorioActionPerformed

    private void btCadastroPessoaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPessoaSairActionPerformed
        limparcamposCadastroUsuario();
        cl.show(pnCard, "cdHome");
    }//GEN-LAST:event_btCadastroPessoaSairActionPerformed

    private void btBuscarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPessoaActionPerformed
        buscarPessoa.identificaTelas(1);
        buscarPessoa.setLocationRelativeTo(this);
        buscarPessoa.setVisible(true);
    }//GEN-LAST:event_btBuscarPessoaActionPerformed

    private void btDoacaoBuscarProdActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarProdActionPerformed1
        buscarProduto.setLocationRelativeTo(this);
        buscarProduto.setVisible(true);
    }//GEN-LAST:event_btDoacaoBuscarProdActionPerformed1

    private void btPedidoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarClienteActionPerformed
        // TODO add your handling code here:
        buscarPessoa.identificaTelas(3);
        buscarPessoa.setVisible(true);
        limparCamposCadastroPedido();
    }//GEN-LAST:event_btPedidoBuscarClienteActionPerformed

    private void btPedidoBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarPedidoActionPerformed
        // TODO add your handling code here:
        limparCamposCadastroPedido();
        buscarPedido.setVisible(true);
    }//GEN-LAST:event_btPedidoBuscarPedidoActionPerformed

    private void btPedidoReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoReciboActionPerformed

    private void btPedidoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoDeletarActionPerformed

    private void btPedidoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoRelatorioActionPerformed
        cl.show(pnCard, "relatorioPedido");
    }//GEN-LAST:event_btPedidoRelatorioActionPerformed

    private void btPedidoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoSairActionPerformed
        limparTela();
        cl.show(pnCard, "cdHome");
    }//GEN-LAST:event_btPedidoSairActionPerformed

    private void btPedidoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoRegistrarActionPerformed
        Pedido novoPedido = new Pedido();
        if (tfPedidoIdCliente.getText() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um Usuário antes de salvar.");
        }
        novoPedido.setQuantMarmita((Integer) jsQtdMarmitas.getValue());
        novoPedido.setObservacao(taPedidoObservacao.getText());
        novoPedido.setCliente(new Pessoa(Integer.valueOf(tfPedidoIdCliente.getText()), null, null));
        novoPedido.setStatus(Pedido.StatusPedido.fromString(String.valueOf(cbPedidoStatus.getSelectedItem())));
        novoPedido.setDataPedido(LocalDate.now());
        if (tfPedidoIdPedido.getText() != null) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            novoPedido.setId(Integer.valueOf(tfPedidoIdPedido.getText()));
            novoPedido.setDataPedido(LocalDate.parse(ffPedidoDtPedido.getText(), formato));
            if (novoPedido.getStatus() == Pedido.StatusPedido.ENTREGUE) {
                novoPedido.setDataEntrega(LocalDate.now());
            }
            try {
                pedidoController.alterarPedido(novoPedido);
                JOptionPane.showMessageDialog(this, "Sucesso ao alterar pedido");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            limparCamposCadastroPedido();
            return;
        }
        pedidoController.cadastrarPedido(novoPedido);
        limparCamposCadastroPedido();
    }//GEN-LAST:event_btPedidoRegistrarActionPerformed

    private void btPedidoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btPedidoLimparActionPerformed

    public void limparTela() {
        tfPedidoIdPedido.setText("");
        cbPedidoStatus.setSelectedIndex(0);
        tfPedidoIdCliente.setText("");
        tfPedidoCliente.setText("");
        jsQtdMarmitas.setValue(0);
        ffPedidoDtPedido.setText("");
        ffPedidoDtEntrega.setText("");
        taPedidoObservacao.setText("");
    }

    private void btRelBuscarDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelBuscarDoadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelBuscarDoadorActionPerformed

    private void btRelBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelBuscarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelBuscarProdutoActionPerformed

    private void btRelDoaFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelDoaFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelDoaFiltrarActionPerformed

    private void btRelDoacaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelDoacaoSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelDoacaoSalvarActionPerformed

    private void btRelDoacaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelDoacaoLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelDoacaoLimparActionPerformed

    private void btRelDoaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelDoaSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelDoaSairActionPerformed

    private void btRelPedidoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedidoBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelPedidoBuscarClienteActionPerformed

    private void btRelPedFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedFiltrarActionPerformed
        // TODO add your handling code here:
        LocalDate dataPedidoInicio = LocalDate.parse(tfRelPedDtPedidoInicio.getText(), dataFormat);
        LocalDate dataPedidoFim = LocalDate.parse(tfRelPedDtPedidoFim.getText(), dataFormat);
        LocalDate dataEntregaInicio = LocalDate.parse(tfRelPedDtEntregaInicio.getText(), dataFormat);
        LocalDate dataEntregaFim = LocalDate.parse(tfRelPedDtEntregaFim.getText(), dataFormat);
        String status = cbRelPedStatus.getSelectedItem().toString();
        Integer idCliente
        String local = String.valueOf(cbRelPedLocal.getSelectedObjects());
        String cidade = String.valueOf(cbRelPedCidade.getSelectedItem());
        String ordem = String.valueOf(cbRelPedOrdenacao.getSelectedItem());
        String sentido = String.valueOf(cbRelPedOrdenacao.getSelectedItem());

    }//GEN-LAST:event_btRelPedFiltrarActionPerformed

    private void btRelPedidoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedidoSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelPedidoSalvarActionPerformed

    private void btRelPedidoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedidoLimparActionPerformed
        limparTelaRelPed();
    }//GEN-LAST:event_btRelPedidoLimparActionPerformed

    public void limparTelaRelPed() {
        tfRelPedDtPedidoInicio.setText("");
        tfRelPedDtPedidoFim.setText("");
        tfRelPedDtEntregaInicio.setText("");
        tfRelPedDtEntregaFim.setText("");
        tfRelPedCliente.setText("");
        tfRelPedTotMarmitas.setText("0");
        tfRelPedTotPendente.setText("0");
        tfRelPedTotFechado.setText("0");
        tfRelPedTotCancelado.setText("0");
        cbPedidoStatus.setSelectedIndex(0);
        cbRelPedCidade.setSelectedIndex(0);
        cbRelPedLocal.setSelectedIndex(0);
        cbRelPedOrdenacao.setSelectedIndex(0);
        cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao.setSelectedIndex(0);
        modeloTabelaRelatorioPedido.setRowCount(0);
    }

    private void btRelPedidoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedidoSairActionPerformed
        cl.show(pnCard, "cdCadastrarPedido");
    }//GEN-LAST:event_btRelPedidoSairActionPerformed

    private void btAdicionarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarCidadeActionPerformed
        cadastroCidade.setLocationRelativeTo(this);
        cadastroCidade.setVisible(true);
    }//GEN-LAST:event_btAdicionarCidadeActionPerformed

    private void jmRelDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelDoacaoActionPerformed
        cl.show(pnCard, "relatorioDoacao");
    }//GEN-LAST:event_jmRelDoacaoActionPerformed

    private void jmRelPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelPedidoActionPerformed
        cl.show(pnCard, "relatorioPedido");
    }//GEN-LAST:event_jmRelPedidoActionPerformed

    private void menuDoacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDoacaoMouseClicked
        cl.show(pnCard, "cdCadastrarDoacao");
    }//GEN-LAST:event_menuDoacaoMouseClicked

    private void menuPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPessoaMouseClicked
        cl.show(pnCard, "beneficiario");
    }//GEN-LAST:event_menuPessoaMouseClicked

    private void menuPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPedidoMouseClicked
        cl.show(pnCard, "cdCadastrarPedido");
    }//GEN-LAST:event_menuPedidoMouseClicked

    public void preenchePessoa(Pessoa pessoa) {
        this.pessoaAntiga = pessoa;
        tfCodigoPessoa.setText(String.valueOf(pessoa.getId()));
        cbTipoUsuario.setEnabled(false);
        cbTipoUsuario.setSelectedItem(pessoa.getTipoUsuario().toString());
        String nomeTipoUsuario = pessoa.getTipoUsuario().toString();
        for (int i = 0; i < cbTipoUsuario.getItemCount(); i++) {
            String item = cbTipoUsuario.getItemAt(i);
            if (item.equalsIgnoreCase(nomeTipoUsuario)) {
                cbTipoUsuario.setSelectedIndex(i);
                switch (cbTipoUsuario.getSelectedItem().toString()) {
                    case "Beneficiario":
                        cbLocalInternacao.setEnabled(false);
                        jsQtdDias.setEnabled(true);
                        tfNomePaciente.setEditable(true);

                        tfNomePaciente.setText(pessoa.getPaciente().getNome());
                        if (pessoa.getPaciente().getPrevisaoDias() != null) {
                            jsQtdDias.setValue(pessoa.getPaciente().getPrevisaoDias());
                        }
                        break;
                    case "Doador":
                        cbLocalInternacao.setEnabled(false);
                        jsQtdDias.setEnabled(false);
                        break;
                    case "Assistente":
                        cbLocalInternacao.setEnabled(false);
                        jsQtdDias.setEnabled(false);
                        break;
                    default:
                        break;
                }
            }
        }
        tfNome.setText(pessoa.getNome());
        ffTelefone.setText(pessoa.getTelefone());
        if (pessoa.getLocal() != null) {
            String nomeLocalInternacao = pessoa.getLocal().toString();
            for (int i = 0; i < cbLocalInternacao.getItemCount(); i++) {
                String item = cbLocalInternacao.getItemAt(i);
                if (item.equalsIgnoreCase(nomeLocalInternacao)) {
                    cbLocalInternacao.setSelectedIndex(i);
                }
                break;
            }
        }
        tfEmail.setText(pessoa.getEmail());
        if (pessoa.getTipoPessoa() != null) {
            String campoTipoPessoa = pessoa.getTipoPessoa().toString();
            switch (campoTipoPessoa) {
                case "FISICA":
                    rbPessoaFisica.setSelected(true);
                    aplicarMascara(ffDocumento, "###.###.###-##");
                    break;
                case "JURIDICA":
                    rbPessoaJuridica.setSelected(true);
                    aplicarMascara(ffDocumento, "##.###.###/####-##");
                    break;
                default:
                    break;
            }
            if (pessoa.getIdentificacao() != null) {
                ffDocumento.setText(pessoa.getIdentificacao());
            }
            try {
                if (pessoa.getEndereco().getCep() != null) {
                    tfEnderecoCep.setText(pessoa.getEndereco().getCep());
                }
                if (pessoa.getEndereco().getCidade() != null) {
                    Cidade cidadePessoa = pessoa.getEndereco().getCidade();

                    for (int i = 0; i < cbEnderecoCidade.getItemCount(); i++) {
                        Cidade cidadeCombo = cbEnderecoCidade.getItemAt(i);
                        if (cidadeCombo.getNome().equalsIgnoreCase(cidadePessoa.getNome())) {
                            cbEnderecoCidade.setSelectedIndex(i);
                            break;
                        }
                    }
                    cbEnderecoUf.setSelectedItem(pessoa.getEndereco().getCidade().getEstado());
                }
                if (pessoa.getEndereco().getLogradouro() != null) {
                    tfEnderecoLogradouro.setText(pessoa.getEndereco().getLogradouro());
                }
                tfEnderecoNumero.setText(String.valueOf(pessoa.getEndereco().getNumero()));
                if (pessoa.getEndereco().getBairro() != null) {
                    tfEnderecoBairro.setText(pessoa.getEndereco().getBairro());
                }
                if (pessoa.getEndereco().getComplemento() != null) {
                    tfEnderecoComplemento.setText(pessoa.getEndereco().getComplemento());
                }
                if (pessoa.getObservacao() != null) {
                    taObservacao.setText(pessoa.getObservacao());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void preencheDoacao(Doacao doacao) {
        tfDoacaoIdDoacao.setText(String.valueOf(doacao.getId()));
        tfDoacaoIdDoador.setText(String.valueOf(doacao.getDoador().getId()));
        tfDoacaoDoador.setText(doacao.getDoador().getNome());
        ftDoacaoData.setText(String.valueOf(doacao.getDataDoacao().format(dataFormat)));
        switch (String.valueOf(doacao.getTipo())) {
            case "DINHEIRO":
                cbDoacaoTipo.setSelectedIndex(0);
                break;
            case "PRODUTO":
                cbDoacaoTipo.setSelectedIndex(1);
                break;
        }
        tfDoacaoValor.setValue(doacao.getValor());
        taDoacaoObservacao.setText(doacao.getObservacao());
        modeloTabela.setRowCount(0);
        for (Produto prod : doacao.getProduto()) {
            Object[] linha = {prod.getTipo(), prod.getNome(), prod.getQuantidade()};
            modeloTabela.addRow(linha);
        }
        travaCamposDoacao();
    }

    public void preencheDoador(Pessoa doador) {
        btDoacaoBuscarDoacao.setEnabled(false);
        jsDoacaoQuantidadeProduto.setEnabled(false);
        tfDoacaoIdDoador.setText(String.valueOf(doador.getId()));
        tfDoacaoDoador.setText(doador.getNome());
    }

    public void direcionaCadastroPessoa() {
        cl.show(pnCard, "beneficiario");
    }

    public void preenchePedido(Pedido pedido) {
        if (pedido != null) {
            if (pedido.getId() != null) {
                tfPedidoIdPedido.setText(String.valueOf(pedido.getId()));
            }

            if (pedido.getStatus() != null) {
                for (int i = 0; i < cbPedidoStatus.getItemCount(); i++) {
                    if (pedido.getStatus().toString().equalsIgnoreCase(cbPedidoStatus.getItemAt(i))) {
                        cbPedidoStatus.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (pedido.getCliente() != null) {
                System.out.println("aqui");
                System.out.println(pedido.getCliente().getId());
                if (pedido.getCliente().getId() != null) {
                    System.out.println("dwivud");
                    tfPedidoIdCliente.setText(String.valueOf(pedido.getCliente().getId()));
                }

                if (pedido.getCliente().getNome() != null) {
                    tfPedidoCliente.setText(pedido.getCliente().getNome());
                }
            }

            if (pedido.getQuantMarmita() != null) {
                jsQtdMarmitas.setValue(pedido.getQuantMarmita());
            }

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            if (pedido.getDataPedido() != null) {
                ffPedidoDtPedido.setText(pedido.getDataPedido().format(formato));
            }

            if (pedido.getDataEntrega() != null) {
                ffPedidoDtEntrega.setText(pedido.getDataEntrega().format(formato));
            }

            if (pedido.getObservacao() != null) {
                taPedidoObservacao.setText(pedido.getObservacao());
            }
        }
    }

    public void aplicarMascara(JFormattedTextField campo, String mascara) {
        campo.setEnabled(true);
        try {
            MaskFormatter formatter = new MaskFormatter(mascara);
            formatter.setPlaceholderCharacter('_');
            campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatter));
            campo.setValue(null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void preencheProdutoDoacao(Produto produto) {
        tfDoacaoSelecionarProd.setText(produto.getNome());
        jsDoacaoQuantidadeProduto.setEnabled(true);
    }

    public void carregarCidade() throws SQLException {
        cbEnderecoCidade.removeAllItems();
        Cidade cidadePadrao = new Cidade("Selecione...", null);
        cbEnderecoCidade.addItem(cidadePadrao);
        List<Cidade> puxarCidade = cidadeController.listarCidade();
        for (Cidade cidade : puxarCidade) {
            cbEnderecoCidade.addItem(cidade);
        }
    }

    public void travaCamposDoacao() {
        jsDoacaoQuantidadeProduto.setEnabled(false);
        tfDoacaoIdDoacao.setEnabled(false);
        tfDoacaoIdDoador.setEnabled(false);
        tfDoacaoDoador.setEnabled(false);
        ftDoacaoData.setEnabled(false);
        cbDoacaoTipo.setEnabled(false);
        tfDoacaoValor.setEnabled(false);
        taDoacaoObservacao.setEnabled(false);
        btDoacaoAddProd.setEnabled(false);
        btDoacaoAltProd.setEnabled(false);
        btDoacaoBuscarProd.setEnabled(false);
        btDoacaoDelProd.setEnabled(false);
        btDoacaoRegistrarDoacao.setEnabled(false);
        btDoacaoBuscarDoador.setEnabled(false);
    }

    public void destravaCamposDoacao() {
        tfDoacaoDoador.setEnabled(true);
        ftDoacaoData.setEnabled(true);
        cbDoacaoTipo.setEnabled(true);
        tfDoacaoValor.setEnabled(true);
        taDoacaoObservacao.setEnabled(true);
        btDoacaoAddProd.setEnabled(true);
        btDoacaoAltProd.setEnabled(true);
        btDoacaoBuscarProd.setEnabled(true);
        btDoacaoDelProd.setEnabled(true);
        btDoacaoRegistrarDoacao.setEnabled(true);
        btDoacaoBuscarDoador.setEnabled(true);
    }

    public void limparcamposCadastroUsuario() {
        tfNome.setText("");
        ffTelefone.setText("");
        tfEmail.setText("");
        ffDocumento.setText("");
        taObservacao.setText("");
        tfNomePaciente.setText("");
        jsQtdDias.setValue(0);
        tfEnderecoCep.setText("");
        tfEnderecoLogradouro.setText("");
        tfEnderecoComplemento.setText("");
        tfEnderecoBairro.setText("");
        tfEnderecoNumero.setText("");
        cbEnderecoCidade.setSelectedIndex(0);
        cbEnderecoUf.setSelectedIndex(0);
        buttonGroupPessoaTipo.clearSelection();
        tfCodigoPessoa.setText("");
        cbTipoUsuario.setEnabled(true);
        cbTipoUsuario.setSelectedIndex(0);
        cbLocalInternacao.setSelectedIndex(0);
    }

    public void limparCamposCadastroDoacao() {
        tfDoacaoIdDoacao.setText("");
        tfDoacaoIdDoador.setText("");
        tfDoacaoDoador.setText("");
        ftDoacaoData.setText("");
        tfDoacaoValor.setValue(0.00);
        taDoacaoObservacao.setText("");
        tfDoacaoSelecionarProd.setText("");
        jsDoacaoQuantidadeProduto.setValue(0);
        cbDoacaoTipo.setSelectedIndex(0);
        modeloTabela.setRowCount(0);
    }

    public void limparCamposCadastroPedido() {
        tfPedidoIdPedido.setText("");
        tfPedidoIdCliente.setText("");
        tfPedidoCliente.setText("");
        jsQtdMarmitas.setValue(0);
        ffPedidoDtPedido.setText("");
        ffPedidoDtEntrega.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCidade;
    private javax.swing.JButton btBuscarPessoa;
    private javax.swing.JButton btCadastroPessoaLimpar;
    private javax.swing.JButton btCadastroPessoaSair;
    private javax.swing.JButton btCadastroPessoaSalvar;
    private javax.swing.JButton btDoacaoAddProd;
    private javax.swing.JButton btDoacaoAltProd;
    private javax.swing.JButton btDoacaoBuscarDoacao;
    private javax.swing.JButton btDoacaoBuscarDoador;
    private javax.swing.JButton btDoacaoBuscarProd;
    private javax.swing.JButton btDoacaoDelProd;
    private javax.swing.JButton btDoacaoDeletar;
    private javax.swing.JButton btDoacaoLimpar;
    private javax.swing.JButton btDoacaoRecibo;
    private javax.swing.JButton btDoacaoRegistrarDoacao;
    private javax.swing.JButton btDoacaoRelatorio;
    private javax.swing.JButton btDoacaoSair;
    private javax.swing.JButton btPedidoBuscarCliente;
    private javax.swing.JButton btPedidoBuscarPedido;
    private javax.swing.JButton btPedidoDeletar;
    private javax.swing.JButton btPedidoLimpar;
    private javax.swing.JButton btPedidoRecibo;
    private javax.swing.JButton btPedidoRegistrar;
    private javax.swing.JButton btPedidoRelatorio;
    private javax.swing.JButton btPedidoSair;
    private javax.swing.JButton btRelBuscarDoador;
    private javax.swing.JButton btRelBuscarProduto;
    private javax.swing.JButton btRelDoaFiltrar;
    private javax.swing.JButton btRelDoaSair;
    private javax.swing.JButton btRelDoacaoLimpar;
    private javax.swing.JButton btRelDoacaoSalvar;
    private javax.swing.JButton btRelPedFiltrar;
    private javax.swing.JButton btRelPedidoBuscarCliente;
    private javax.swing.JButton btRelPedidoLimpar;
    private javax.swing.JButton btRelPedidoSair;
    private javax.swing.JButton btRelPedidoSalvar;
    private javax.swing.ButtonGroup buttonGroupPessoaTipo;
    private javax.swing.JComboBox<String> cbDoacaoTipo;
    private javax.swing.JComboBox<Cidade> cbEnderecoCidade;
    private javax.swing.JComboBox<String> cbEnderecoUf;
    private javax.swing.JComboBox<String> cbLocalInternacao;
    private javax.swing.JComboBox<String> cbPedidoStatus;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao;
    private javax.swing.JComboBox<String> cbRelDoaSentido;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto;
    private javax.swing.JComboBox<String> cbRelPedCidade;
    private javax.swing.JComboBox<String> cbRelPedLocal;
    private javax.swing.JComboBox<String> cbRelPedOrdenacao;
    private javax.swing.JComboBox<String> cbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacaocbRelPedOrdenacao;
    private javax.swing.JComboBox<String> cbRelPedStatus;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JFormattedTextField ffDocumento;
    private javax.swing.JFormattedTextField ffPedidoDtEntrega;
    private javax.swing.JFormattedTextField ffPedidoDtPedido;
    private javax.swing.JFormattedTextField ffRelDoaDtFinal;
    private javax.swing.JFormattedTextField ffRelDoaDtInicial;
    private javax.swing.JFormattedTextField ffTelefone;
    private javax.swing.JFormattedTextField ftDoacaoData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel jbRelDoaTorIte;
    private javax.swing.JLabel jbRelDoaTotDin;
    private javax.swing.JLabel jbRelDoaTotProd;
    private javax.swing.JLabel jbRelPedTotCancelado;
    private javax.swing.JLabel jbRelPedTotFechado;
    private javax.swing.JLabel jbRelPedTotMarmitas;
    private javax.swing.JLabel jbRelPedTotPendente;
    private javax.swing.JMenuItem jmRelDoacao;
    private javax.swing.JMenuItem jmRelPedido;
    private javax.swing.JPanel jpRelPedTotMarmitas;
    private javax.swing.JPanel jpRelPedTotStatus;
    private javax.swing.JSpinner jsDoacaoQuantidadeProduto;
    private javax.swing.JSpinner jsQtdDias;
    private javax.swing.JSpinner jsQtdMarmitas;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCodigoPessoa;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbDias;
    private javax.swing.JLabel lbDoacaoData;
    private javax.swing.JLabel lbDoacaoDoador;
    private javax.swing.JLabel lbDoacaoIdDoacao;
    private javax.swing.JLabel lbDoacaoObservacao;
    private javax.swing.JLabel lbDoacaoQuantidade;
    private javax.swing.JLabel lbDoacaoSelecionarProd;
    private javax.swing.JLabel lbDoacaoTipo;
    private javax.swing.JLabel lbDoacaoValor;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLocalInternacao;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbLogradouro3;
    private javax.swing.JLabel lbLogradouro5;
    private javax.swing.JLabel lbLogradouro6;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomePaciente;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbObservacao;
    private javax.swing.JLabel lbPedidoCliente;
    private javax.swing.JLabel lbPedidoDtEntrega;
    private javax.swing.JLabel lbPedidoDtPedido;
    private javax.swing.JLabel lbPedidoIdPedido;
    private javax.swing.JLabel lbPedidoObservacao;
    private javax.swing.JLabel lbPedidoQtdMarmitas;
    private javax.swing.JLabel lbPedidoStatus;
    private javax.swing.JLabel lbPessoaTipo;
    private javax.swing.JLabel lbRelDoaDoador;
    private javax.swing.JLabel lbRelDoaDtFinal;
    private javax.swing.JLabel lbRelDoaDtInicial;
    private javax.swing.JLabel lbRelDoaOrdenacao;
    private javax.swing.JLabel lbRelDoaProd;
    private javax.swing.JLabel lbRelDoaTpDoacao;
    private javax.swing.JLabel lbRelDoaTpProduto;
    private javax.swing.JLabel lbRelPedCidade;
    private javax.swing.JLabel lbRelPedCliente;
    private javax.swing.JLabel lbRelPedDtEntregaFim;
    private javax.swing.JLabel lbRelPedDtEntregaInicio;
    private javax.swing.JLabel lbRelPedDtPedidoFim;
    private javax.swing.JLabel lbRelPedDtPedidoInicio;
    private javax.swing.JLabel lbRelPedLocal;
    private javax.swing.JLabel lbRelPedOrdenacao;
    private javax.swing.JLabel lbRelPedStatus;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTempo;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuDoacao;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuPedido;
    private javax.swing.JMenu menuPessoa;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JPanel pnCadastrarDoacao;
    private javax.swing.JPanel pnCadastrarPedido;
    private javax.swing.JPanel pnCadastroPessoa;
    private javax.swing.JPanel pnCard;
    private javax.swing.JPanel pnDadosPrincipal;
    private javax.swing.JPanel pnDoacao;
    private javax.swing.JPanel pnDoacaoProduto;
    private javax.swing.JPanel pnEnderecoCliente;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnListBoxProd;
    private javax.swing.JPanel pnPedido;
    private javax.swing.JPanel pnPessoaCliente;
    private javax.swing.JPanel pnRelDoa;
    private javax.swing.JPanel pnRelFiltros;
    private javax.swing.JPanel pnRelPed;
    private javax.swing.JPanel pnRelPedFiltros;
    private javax.swing.JPanel pnRelPedResultado;
    private javax.swing.JPanel pnRelResultado;
    private javax.swing.JPanel pnRelatorioDoacao;
    private javax.swing.JPanel pnRelatorioPedido;
    private javax.swing.JRadioButton rbPessoaFisica;
    private javax.swing.JRadioButton rbPessoaJuridica;
    private javax.swing.JScrollPane spRelPedResultado;
    private javax.swing.JScrollPane spRelResultado;
    private javax.swing.JTextArea taDoacaoObservacao;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextArea taPedidoObservacao;
    private javax.swing.JTable tableDoacaoProdutos;
    private javax.swing.JTable tableRelatorioDoacao;
    private javax.swing.JTable tableRelatorioPedido;
    private javax.swing.JTextField tfCodigoPessoa;
    private javax.swing.JTextField tfDoacaoDoador;
    private javax.swing.JTextField tfDoacaoIdDoacao;
    private javax.swing.JTextField tfDoacaoIdDoador;
    private javax.swing.JTextField tfDoacaoSelecionarProd;
    private javax.swing.JFormattedTextField tfDoacaoValor;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEnderecoBairro;
    private javax.swing.JTextField tfEnderecoCep;
    private javax.swing.JTextField tfEnderecoComplemento;
    private javax.swing.JTextField tfEnderecoLogradouro;
    private javax.swing.JTextField tfEnderecoNumero;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomePaciente;
    private javax.swing.JTextField tfPedidoCliente;
    private javax.swing.JTextField tfPedidoIdCliente;
    private javax.swing.JTextField tfPedidoIdPedido;
    private javax.swing.JTextField tfRelDoaDoador;
    private javax.swing.JTextField tfRelDoaProd;
    private javax.swing.JTextField tfRelPedCliente;
    private javax.swing.JFormattedTextField tfRelPedDtEntregaFim;
    private javax.swing.JFormattedTextField tfRelPedDtEntregaInicio;
    private javax.swing.JFormattedTextField tfRelPedDtPedidoFim;
    private javax.swing.JFormattedTextField tfRelPedDtPedidoInicio;
    private javax.swing.JTextField tfRelPedTotCancelado;
    private javax.swing.JTextField tfRelPedTotFechado;
    private javax.swing.JTextField tfRelPedTotMarmitas;
    private javax.swing.JTextField tfRelPedTotPendente;
    private javax.swing.JTextField tfRelTotDin;
    private javax.swing.JTextField tfRelTotIte;
    private javax.swing.JTextField tfRelTotProd;
    // End of variables declaration//GEN-END:variables
}
