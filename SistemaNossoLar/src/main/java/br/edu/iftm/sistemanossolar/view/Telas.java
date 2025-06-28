/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.iftm.sistemanossolar.view;

import br.edu.iftm.sistemanossolar.controller.doacao.DoacaoController;
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
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import java.text.NumberFormat;
import java.util.Locale;
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
    private static DoacaoController doacaoController;
    private static PessoaController pessoaController;
    private static EnderecoController enderecoController;
    private static BuscarDoacao buscarDoacao;
    private DefaultTableModel modeloTabela;
    /**
     * Creates new form Telas
     *      lb - Label
     *      tf - TextField
     *      ta - TextArea
     *      ff - FormatedField
     */
    public Telas(Connection conexao) {
        cidadeController = new CidadeController(conexao);
        pessoaController = new PessoaController(conexao);
        enderecoController = new EnderecoController(conexao);
        doacaoController = new DoacaoController(conexao);
        cadastroCidade = new CadastroCidade(this, true, conexao, this);
        cadastroProduto = new CadastroProduto(this, true, conexao, this);
        buscarPessoa = new BuscarPessoa(this, true, conexao, this);
        buscarDoacao = new BuscarDoacao(this, true, conexao, this);
        initComponents();
        cl = (CardLayout) pnCard.getLayout();
        modeloTabela = (DefaultTableModel) tableDoacaoProdutos.getModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPessoaTipo = new javax.swing.ButtonGroup();
        jSpinner1 = new javax.swing.JSpinner();
        pnDadosPrincipal = new javax.swing.JPanel();
        pnCard = new javax.swing.JPanel();
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
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        rbPessoaFisica = new javax.swing.JRadioButton();
        rbPessoaJuridica = new javax.swing.JRadioButton();
        lbPessoaTipo = new javax.swing.JLabel();
        lbDocumento = new javax.swing.JLabel();
        lbNomePaciente = new javax.swing.JLabel();
        tfNomePaciente = new javax.swing.JTextField();
        lbNomePaciente1 = new javax.swing.JLabel();
        tfQtdDias = new javax.swing.JTextField();
        ffDocumento = new javax.swing.JFormattedTextField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbLocalInternacao = new javax.swing.JComboBox<>();
        btCadastroPessoaLimpar = new javax.swing.JButton();
        btCadastroPessoaRegistrar = new javax.swing.JButton();
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
        jsDoacaoQuantidadeProduto = new javax.swing.JSpinner();
        btDoacaoAddProd = new javax.swing.JButton();
        pnListBoxProd = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoacaoProdutos = new javax.swing.JTable();
        tfDoacaoSelecionarProd = new javax.swing.JTextField();
        btDoacaoBuscarProd = new javax.swing.JButton();
        btDoacaoAltProd = new javax.swing.JButton();
        btDoacaoDelProd = new javax.swing.JButton();
        btDoacaoRegistrarDoacao = new javax.swing.JButton();
        btDoacaoLimpar = new javax.swing.JButton();
        btDoacaoRelatorio = new javax.swing.JButton();
        btDoacaoVoltar = new javax.swing.JButton();
        pnCadastrarPedido = new javax.swing.JPanel();
        pnPedido = new javax.swing.JPanel();
        tfPedidoCliente = new javax.swing.JTextField();
        lbPedidoCliente = new javax.swing.JLabel();
        lbPedidoQtdMarmitas = new javax.swing.JLabel();
        ffPedidoDtPedido = new javax.swing.JFormattedTextField();
        lbPedidoDtPedido = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDoacaoObservacao1 = new javax.swing.JTextArea();
        lbPedidoObservacao = new javax.swing.JLabel();
        lbPedidoDtEntrega = new javax.swing.JLabel();
        ffPedidoDtEntrega = new javax.swing.JFormattedTextField();
        cbPedidoStatus = new javax.swing.JComboBox<>();
        lbPedidoStatus = new javax.swing.JLabel();
        tfPedidoIdPedido = new javax.swing.JTextField();
        lbPedidoIdPedido = new javax.swing.JLabel();
        tfPedidoIdPedido1 = new javax.swing.JTextField();
        btPedidoBuscarCliente = new javax.swing.JButton();
        btPedidoBuscarPedido = new javax.swing.JButton();
        jSpinner4 = new javax.swing.JSpinner();
        btPedidoRegistrar = new javax.swing.JButton();
        btPedidoLimpar = new javax.swing.JButton();
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
        cbRelDoaOrdenacao1 = new javax.swing.JComboBox<>();
        cbRelDoaOrdenacao2 = new javax.swing.JComboBox<>();
        lbRelDoaProd = new javax.swing.JLabel();
        tfRelDoaProd = new javax.swing.JTextField();
        lbRelDoaTpProduto = new javax.swing.JLabel();
        cbRelDoaTpProduto = new javax.swing.JComboBox<>();
        btRelDoaFiltrar = new javax.swing.JButton();
        btPedidoBuscarCliente1 = new javax.swing.JButton();
        btPedidoBuscarCliente2 = new javax.swing.JButton();
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
        btRelDoaVoltar = new javax.swing.JButton();
        pnRelatorioPedido = new javax.swing.JPanel();
        pnRelPed = new javax.swing.JPanel();
        pnRelPedFiltros = new javax.swing.JPanel();
        lbRelPedDtPedido = new javax.swing.JLabel();
        tfRelPedDtPedido = new javax.swing.JFormattedTextField();
        lbRelPedDtEntrega = new javax.swing.JLabel();
        tfRelPedDtEntrega = new javax.swing.JFormattedTextField();
        lbRelPedStatus = new javax.swing.JLabel();
        cbRelPedStatus = new javax.swing.JComboBox<>();
        lbRelPedCliente = new javax.swing.JLabel();
        tfRelPedCliente = new javax.swing.JTextField();
        lbRelPedOrdenacao = new javax.swing.JLabel();
        cbRelPedOrdenacao = new javax.swing.JComboBox<>();
        cbRelPedSentido = new javax.swing.JComboBox<>();
        lbRelPedLocal = new javax.swing.JLabel();
        cbRelPedLocal = new javax.swing.JComboBox<>();
        btRelPedFiltrar = new javax.swing.JButton();
        lbRelPedDtPedido1 = new javax.swing.JLabel();
        lbRelPedDtEntrega1 = new javax.swing.JLabel();
        btPedidoBuscarCliente3 = new javax.swing.JButton();
        lbRelPedCidade = new javax.swing.JLabel();
        cbRelPedCidade = new javax.swing.JComboBox<>();
        tfRelPedDtPedido2 = new javax.swing.JFormattedTextField();
        tfRelPedDtPedido3 = new javax.swing.JFormattedTextField();
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
        btRelPedidoLimpar = new javax.swing.JButton();
        btRelPedVoltar = new javax.swing.JButton();
        btRelPedidoSalvar = new javax.swing.JButton();
        pnHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuPessoa = new javax.swing.JMenu();
        menuPessoaCadastrar = new javax.swing.JMenuItem();
        menuDoacao = new javax.swing.JMenu();
        menuDoacaoCadastrar = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenu();
        menuPedidoCadastrar = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuRelatorioDoacao = new javax.swing.JMenuItem();
        menuRelatorioPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(29, 29, 29));
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnCard.setLayout(new java.awt.CardLayout());

        pnEnderecoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));

        lbLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro.setText("Logradouro:");

        lbNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNumero.setText("Número:");

        tfEnderecoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoNumeroKeyTyped(evt);
            }
        });

        lbBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        lbLogradouro3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro3.setText("Cidade:");

        lbComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbComplemento.setText("Complemento:");

        cbEnderecoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEnderecoCidadeActionPerformed(evt);
            }
        });

        tfEnderecoCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoCepKeyTyped(evt);
            }
        });

        lbLogradouro5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro5.setText("CEP:");

        lbLogradouro6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogradouro6.setText("UF");

        cbEnderecoUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbEnderecoUf.setEnabled(false);

        btAdicionarCidade.setText("+");
        btAdicionarCidade.setToolTipText("Cadastrar novo endereço");
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero)
                            .addComponent(tfEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro)
                            .addComponent(tfEnderecoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbComplemento)
                            .addComponent(tfEnderecoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogradouro5)
                            .addComponent(tfEnderecoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogradouro3)
                            .addComponent(cbEnderecoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(lbLogradouro6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbEnderecoUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btAdicionarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(pnEnderecoClienteLayout.createSequentialGroup()
                        .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLogradouro))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnEnderecoClienteLayout.setVerticalGroup(
            pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdicionarCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                        .addComponent(lbLogradouro3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnderecoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                        .addComponent(lbLogradouro6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnderecoUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoClienteLayout.createSequentialGroup()
                        .addComponent(lbLogradouro5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEnderecoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbLogradouro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero)
                    .addComponent(lbBairro)
                    .addComponent(lbComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        pnPessoaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa"));

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

        lbTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTelefone.setText("Telefone:");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmail.setText("E-mail:");

        lbObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbObservacao.setText("Observação:");

        taObservacao.setColumns(20);
        taObservacao.setLineWrap(true);
        taObservacao.setRows(5);
        jScrollPane1.setViewportView(taObservacao);

        buttonGroupPessoaTipo.add(rbPessoaFisica);
        rbPessoaFisica.setText("Pessoa Física (CPF)");
        rbPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaFisicaActionPerformed(evt);
            }
        });

        buttonGroupPessoaTipo.add(rbPessoaJuridica);
        rbPessoaJuridica.setText("Pessoa Jurídica (CNPJ)");
        rbPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaJuridicaActionPerformed(evt);
            }
        });

        lbPessoaTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPessoaTipo.setText("Tipo:");

        lbDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDocumento.setText("Nº do Documento:");

        lbNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNomePaciente.setText("Nome do Paciente:");

        tfNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomePacienteKeyTyped(evt);
            }
        });

        lbNomePaciente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNomePaciente1.setText("Dias de Internação:");

        tfQtdDias.setToolTipText("Estimar a quantidade de dias de internação");
        tfQtdDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtdDiasKeyTyped(evt);
            }
        });

        ffDocumento.setEnabled(false);

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beneficiario", "Doador", "Assistente" }));
        cbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Usuário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Local de Internação:");

        cbLocalInternacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hospital", "Pronto Socorro", " " }));

        javax.swing.GroupLayout pnPessoaClienteLayout = new javax.swing.GroupLayout(pnPessoaCliente);
        pnPessoaCliente.setLayout(pnPessoaClienteLayout);
        pnPessoaClienteLayout.setHorizontalGroup(
            pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                            .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNomePaciente1)
                                .addComponent(tfQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(285, 285, 285))
                        .addComponent(lbNomePaciente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbDocumento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbPessoaTipo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnPessoaClienteLayout.createSequentialGroup()
                            .addComponent(rbPessoaFisica)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbPessoaJuridica))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbObservacao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ffTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfNomePaciente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ffDocumento, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                        .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLocalInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnPessoaClienteLayout.setVerticalGroup(
            pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPessoaClienteLayout.createSequentialGroup()
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPessoaTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPessoaFisica)
                    .addComponent(rbPessoaJuridica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ffDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLocalInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNomePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNomePaciente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btCadastroPessoaLimpar.setText("Limpar");
        btCadastroPessoaLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPessoaLimparActionPerformed(evt);
            }
        });

        btCadastroPessoaRegistrar.setText("Registrar");
        btCadastroPessoaRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPessoaRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroPessoaLayout = new javax.swing.GroupLayout(pnCadastroPessoa);
        pnCadastroPessoa.setLayout(pnCadastroPessoaLayout);
        pnCadastroPessoaLayout.setHorizontalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(btCadastroPessoaLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastroPessoaRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        pnCadastroPessoaLayout.setVerticalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(111, Short.MAX_VALUE))
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastroPessoaRegistrar)
                            .addComponent(btCadastroPessoaLimpar))
                        .addGap(114, 114, 114))))
        );

        pnCard.add(pnCadastroPessoa, "beneficiario");

        pnDoacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbDoacaoIdDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoIdDoacao.setText("Código:");

        tfDoacaoIdDoacao.setEditable(false);
        tfDoacaoIdDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbDoacaoDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoDoador.setText("Doador:");

        tfDoacaoIdDoador.setEditable(false);
        tfDoacaoIdDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoIdDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoIdDoadorActionPerformed(evt);
            }
        });

        tfDoacaoDoador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        ftDoacaoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
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

        javax.swing.GroupLayout pnDoacaoLayout = new javax.swing.GroupLayout(pnDoacao);
        pnDoacao.setLayout(pnDoacaoLayout);
        pnDoacaoLayout.setHorizontalGroup(
            pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addComponent(lbDoacaoDoador)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnDoacaoLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnDoacaoLayout.createSequentialGroup()
                                            .addComponent(btDoacaoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btDoacaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDoacaoLayout.createSequentialGroup()
                                    .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbDoacaoObservacao, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDoacaoLayout.createSequentialGroup()
                                            .addComponent(tfDoacaoIdDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfDoacaoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btDoacaoBuscarDoador)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(23, 23, 23))))
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnDoacaoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbDoacaoSelecionarProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoSelecionarProd.setText("Descrição");

        lbDoacaoQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoacaoQuantidade.setText("Quantidade:");

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

        tfDoacaoSelecionarProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDoacaoSelecionarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoSelecionarProdActionPerformed(evt);
            }
        });

        btDoacaoBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarProd.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btDoacaoBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoBuscarProdActionPerformed(evt);
            }
        });

        btDoacaoAltProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoAltProd.setText("Alterar");

        btDoacaoDelProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoDelProd.setText("Deletar");

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

        btDoacaoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoLimpar.setText("Limpar");
        btDoacaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoLimparActionPerformed(evt);
            }
        });

        btDoacaoRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRelatorio.setText("Relatório");

        btDoacaoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoVoltar.setText("Sair");

        javax.swing.GroupLayout pnCadastrarDoacaoLayout = new javax.swing.GroupLayout(pnCadastrarDoacao);
        pnCadastrarDoacao.setLayout(pnCadastrarDoacaoLayout);
        pnCadastrarDoacaoLayout.setHorizontalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(pnDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(btDoacaoRegistrarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        pnCadastrarDoacaoLayout.setVerticalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnDoacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoRegistrarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
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

        ffPedidoDtPedido.setText("_____ / _____ / _____");
        ffPedidoDtPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbPedidoDtPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoDtPedido.setText("Data do Pedido:");

        taDoacaoObservacao1.setColumns(20);
        taDoacaoObservacao1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taDoacaoObservacao1.setRows(5);
        taDoacaoObservacao1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taDoacaoObservacao1);

        lbPedidoObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoObservacao.setText("Observação:");

        lbPedidoDtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoDtEntrega.setText("Data da Entrega:");

        ffPedidoDtEntrega.setText("_____ / _____ / _____");
        ffPedidoDtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbPedidoStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPedidoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Finalizado", "Cancelado" }));

        lbPedidoStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoStatus.setText("Status:");

        tfPedidoIdPedido.setEditable(false);
        tfPedidoIdPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbPedidoIdPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPedidoIdPedido.setText("Código:");

        tfPedidoIdPedido1.setEditable(false);
        tfPedidoIdPedido1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        jSpinner4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner4.setToolTipText("");

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPedidoDtPedido)
                            .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(lbPedidoDtEntrega)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPedidoIdPedido)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(tfPedidoIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPedidoBuscarPedido)))
                        .addGap(12, 12, 12)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPedidoStatus)
                            .addComponent(cbPedidoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPedidoLayout.createSequentialGroup()
                                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbPedidoObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfPedidoIdPedido1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPedidoBuscarCliente))
                                    .addComponent(lbPedidoCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPedidoQtdMarmitas)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(15, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPedidoDtEntrega)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnPedidoLayout.createSequentialGroup()
                            .addComponent(lbPedidoDtPedido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPedidoCliente)
                    .addComponent(lbPedidoQtdMarmitas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPedidoIdPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btPedidoBuscarCliente)))
                .addGap(18, 18, 18)
                .addComponent(lbPedidoObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                        .addComponent(btPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(560, Short.MAX_VALUE))
        );
        pnCadastrarPedidoLayout.setVerticalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPedidoRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastrarPedido, "cdCadastrarPedido");

        pnRelDoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório Doação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        pnRelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbRelDoaDtInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaDtInicial.setText("Data Inicial:");

        ffRelDoaDtInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaDtFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaDtFinal.setText("Data Final:");

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

        cbRelDoaOrdenacao1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaOrdenacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Código", "Nome do Doador", "Valor", "Quantidade de Produtos" }));

        cbRelDoaOrdenacao2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaOrdenacao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrente", "Crescente" }));

        lbRelDoaProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaProd.setText("Produto:");

        tfRelDoaProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelDoaTpProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRelDoaTpProduto.setText("Tipo Produto:");

        cbRelDoaTpProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelDoaTpProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento", "Limpeza", "Outros" }));

        btRelDoaFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoaFiltrar.setText("Filtrar");

        btPedidoBuscarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btPedidoBuscarCliente1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btPedidoBuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoBuscarCliente1ActionPerformed(evt);
            }
        });

        btPedidoBuscarCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btPedidoBuscarCliente2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btPedidoBuscarCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoBuscarCliente2ActionPerformed(evt);
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
                            .addComponent(cbRelDoaOrdenacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRelDoaOrdenacao2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addComponent(btPedidoBuscarCliente2))
                            .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                                        .addComponent(lbRelDoaDoador)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfRelDoaDoador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPedidoBuscarCliente1)))
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
                    .addComponent(btPedidoBuscarCliente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaOrdenacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelDoaOrdenacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbRelDoaOrdenacao2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btPedidoBuscarCliente2, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addComponent(spRelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(10, Short.MAX_VALUE))
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
                .addGap(20, 20, 20)
                .addComponent(pnRelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        btRelDoacaoSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoacaoSalvar.setText("Salvar");

        btRelDoacaoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoacaoLimpar.setText("Limpar");

        btRelDoaVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelDoaVoltar.setText("Fechar");

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
                        .addComponent(btRelDoaVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
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
                    .addComponent(btRelDoaVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioDoacao, "relatorioDoacao");
        pnRelatorioDoacao.getAccessibleContext().setAccessibleName("");

        pnRelPed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        pnRelPedFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lbRelPedDtPedido.setText("Data do Pedido (Início)");

        tfRelPedDtPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedDtEntrega.setText("Data da Entrega: (Início)");

        tfRelPedDtEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedStatus.setText("Status:");

        cbRelPedStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendente", "Finalizado", "Cancelado" }));
        cbRelPedStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelPedStatusActionPerformed(evt);
            }
        });

        lbRelPedCliente.setText("Assistente/Beneficiário");

        tfRelPedCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbRelPedOrdenacao.setText("Ordenação");

        cbRelPedOrdenacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cliente", "Data do Pedido", "Data da Entrega", "Status", "Marmitas" }));

        cbRelPedSentido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedSentido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crescente", "Decrescente" }));

        lbRelPedLocal.setText("Local:");

        cbRelPedLocal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hospital São José", "Pronto Socorro" }));

        btRelPedFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRelPedFiltrar.setText("Filtrar");

        lbRelPedDtPedido1.setText("Data do Pedido (Fim)");

        lbRelPedDtEntrega1.setText("Data da Entrega: (Fim)");

        btPedidoBuscarCliente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btPedidoBuscarCliente3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btPedidoBuscarCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoBuscarCliente3ActionPerformed(evt);
            }
        });

        lbRelPedCidade.setText("Cidade Cliente:");

        cbRelPedCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRelPedCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Ituiutaba", "Paracatu" }));

        tfRelPedDtPedido2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfRelPedDtPedido3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnRelPedFiltrosLayout = new javax.swing.GroupLayout(pnRelPedFiltros);
        pnRelPedFiltros.setLayout(pnRelPedFiltrosLayout);
        pnRelPedFiltrosLayout.setHorizontalGroup(
            pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfRelPedDtPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(lbRelPedDtPedido)
                    .addComponent(lbRelPedDtEntrega)
                    .addComponent(tfRelPedDtEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedDtPedido1)
                            .addComponent(lbRelPedDtEntrega1))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfRelPedDtPedido3)
                            .addComponent(tfRelPedDtPedido2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedStatus)
                            .addComponent(cbRelPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedCidade)
                            .addComponent(cbRelPedCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedOrdenacao)
                            .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedSentido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRelPedLocal)
                            .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(btRelPedFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                            .addComponent(lbRelPedCliente)
                            .addGap(194, 194, 194))
                        .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                            .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPedidoBuscarCliente3))))
                .addContainerGap())
        );
        pnRelPedFiltrosLayout.setVerticalGroup(
            pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btPedidoBuscarCliente3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRelPedFiltrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedLocal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbRelPedSentido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedDtPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRelPedDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbRelPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRelPedDtPedido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelPedDtPedido1)
                                .addGap(32, 32, 32)))
                        .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbRelPedDtEntrega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRelPedDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbRelPedOrdenacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnRelPedFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRelPedDtPedido3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnRelPedFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelPedCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelPedCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(13, 13, 13))
            .addGroup(pnRelPedFiltrosLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbRelPedDtEntrega1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnRelPedResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tableRelatorioPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableRelatorioPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
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
                .addComponent(spRelPedResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRelPedResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpRelPedTotStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnRelPedResultadoLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jpRelPedTotMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addGap(20, 20, 20)
                .addComponent(pnRelPedFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRelPedResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btRelPedidoLimpar.setText("Limpar");

        btRelPedVoltar.setText("Fechar");

        btRelPedidoSalvar.setText("Salvar");

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
                        .addComponent(btRelPedVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
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
                    .addComponent(btRelPedVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioPedido, "relatorioPedido");

        pnHome.setBackground(new java.awt.Color(245, 245, 246));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NossoLarMenor.png"))); // NOI18N

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(326, 326, 326))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pnCard.add(pnHome, "cdHome");

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

        menuBarra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        menuInicio.setText("Inicio");
        menuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInicioMouseClicked(evt);
            }
        });
        menuBarra.add(menuInicio);

        menuPessoa.setText("Pessoa");

        menuPessoaCadastrar.setText("Cadastrar");
        menuPessoaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoaCadastrarActionPerformed(evt);
            }
        });
        menuPessoa.add(menuPessoaCadastrar);

        menuBarra.add(menuPessoa);

        menuDoacao.setText("Doação");

        menuDoacaoCadastrar.setText("Cadastrar");
        menuDoacaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoacaoCadastrarActionPerformed(evt);
            }
        });
        menuDoacao.add(menuDoacaoCadastrar);

        menuBarra.add(menuDoacao);

        menuPedido.setText("Pedido");

        menuPedidoCadastrar.setText("Cadastrar");
        menuPedidoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidoCadastrarActionPerformed(evt);
            }
        });
        menuPedido.add(menuPedidoCadastrar);

        menuBarra.add(menuPedido);

        menuRelatorio.setText("Relatório");

        menuRelatorioDoacao.setText("Doação");
        menuRelatorioDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioDoacaoActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelatorioDoacao);

        menuRelatorioPedido.setText("Pedido");
        menuRelatorioPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioPedidoActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelatorioPedido);

        menuBarra.add(menuRelatorio);

        setJMenuBar(menuBarra);

        pack();
        setLocationRelativeTo(null);
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
        if(!Character.isLetter(verificador) && verificador != ' '){
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
        if(!Character.isLetter(verificador) && verificador != ' '){
            evt.consume();
        }
    }//GEN-LAST:event_tfNomePacienteKeyTyped

    private void tfQtdDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtdDiasKeyTyped
        char verificador = evt.getKeyChar();
        if(!Character.isDigit(verificador)){
            evt.consume();
        }
    }//GEN-LAST:event_tfQtdDiasKeyTyped

    private void tfEnderecoCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoCepKeyTyped
        char verificador = evt.getKeyChar();
        if(!Character.isDigit(verificador)){
            evt.consume();
        }
    }//GEN-LAST:event_tfEnderecoCepKeyTyped

    private void tfEnderecoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoNumeroKeyTyped
        char verificador = evt.getKeyChar();
        if(!Character.isDigit(verificador)){
            evt.consume();
        }
    }//GEN-LAST:event_tfEnderecoNumeroKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cl.show(pnCard, "cdHome");
        try {
            carregarCidade();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void btAdicionarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarCidadeActionPerformed
        cadastroCidade.setLocationRelativeTo(this);
        cadastroCidade.setVisible(true);
    }//GEN-LAST:event_btAdicionarCidadeActionPerformed

    private void cbEnderecoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEnderecoCidadeActionPerformed
        Cidade cidadeSelecionada = (Cidade) cbEnderecoCidade.getSelectedItem();
        if (cidadeSelecionada != null) {
            cbEnderecoUf.setSelectedItem(cidadeSelecionada.getEstado()); // define a UF automaticamente
        }
    }//GEN-LAST:event_cbEnderecoCidadeActionPerformed

    private void btCadastroPessoaLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPessoaLimparActionPerformed
        limparcamposCadastroUsuario();
    }//GEN-LAST:event_btCadastroPessoaLimparActionPerformed
    
    private void btCadastroPessoaRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPessoaRegistrarActionPerformed
        Endereco endereco = null;
        Pessoa novaPessoa = null;
        Paciente paciente = null;
        String telefone = ffTelefone.getText().replaceAll("[^\\d]", "");
        
        Cidade cidadeEscolhida = (Cidade) cbEnderecoCidade.getSelectedItem();
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
        try{
            if (tfQtdDias.getText()!= null && !tfQtdDias.getText().trim().isEmpty()){
                paciente = new Paciente(tfNomePaciente.getText(), Integer.parseInt(tfQtdDias.getText()));
            }
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }

        if ((String)cbTipoUsuario.getSelectedItem() == "Assistente") {
            novaPessoa.setTipoUsuario(TipoCad.ASSISTENTE);
        } else if ((String)cbTipoUsuario.getSelectedItem() == "Beneficiário") {
            novaPessoa.setTipoUsuario(TipoCad.BENEFICIARIO);
        } else if ((String)cbTipoUsuario.getSelectedItem() == "Doador") {
            novaPessoa.setTipoUsuario(TipoCad.DOADOR);   
        }

        if(cbLocalInternacao.getSelectedIndex() == 0){
            novaPessoa.setLocal(Pessoa.Local.HOSPITAL);
        }else{
            novaPessoa.setLocal(Pessoa.Local.PRONTOSOCORRO);
        }
        
        novaPessoa.setEmail(tfEmail.getText());
        if(rbPessoaFisica.isSelected()){
            novaPessoa.setTipoPessoa(Pessoa.TipoPessoa.FISICA);
        }
        if(rbPessoaJuridica.isSelected()){
            novaPessoa.setTipoPessoa(Pessoa.TipoPessoa.JURIDICA);
        }
        novaPessoa.setIdentificacao(ffDocumento.getText().replaceAll("[^\\d]", ""));
        novaPessoa.setObservacao(taObservacao.getText());
        novaPessoa.setPaciente(paciente);
        
        try{
            enderecoController.cadastrarEndereco(endereco, cidadeEscolhida);
            if(!pessoaController.cadastrarPessoa(novaPessoa, paciente)){
                JOptionPane.showMessageDialog(rootPane, "Erro ao Cadastrar o Usuário", "Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Sucesso ao Cadastrar o Usuário", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
                limparcamposCadastroUsuario();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btCadastroPessoaRegistrarActionPerformed

    private void cbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoUsuarioActionPerformed
        if(cbTipoUsuario.getSelectedIndex()==0){
            tfNomePaciente.setEnabled(false);
            tfQtdDias.setEnabled(false);
            cbLocalInternacao.setEnabled(true);
        }else if (cbTipoUsuario.getSelectedIndex()==1){
            tfNomePaciente.setEnabled(true);
            tfQtdDias.setEnabled(true);
            cbLocalInternacao.setEnabled(true);
        } else if (cbTipoUsuario.getSelectedIndex()==2){
            tfNomePaciente.setEnabled(false);
            tfQtdDias.setEnabled(false);
            cbLocalInternacao.setEnabled(false);
        }
    }//GEN-LAST:event_cbTipoUsuarioActionPerformed

    private void menuPessoaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoaCadastrarActionPerformed
        cl.show(pnCard, "beneficiario");
    }//GEN-LAST:event_menuPessoaCadastrarActionPerformed

    private void menuDoacaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoacaoCadastrarActionPerformed
        cl.show(pnCard, "cdCadastrarDoacao");
    }//GEN-LAST:event_menuDoacaoCadastrarActionPerformed

    private void menuPedidoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidoCadastrarActionPerformed
        cl.show(pnCard, "cdCadastrarPedido");
    }//GEN-LAST:event_menuPedidoCadastrarActionPerformed

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
        // TODO add your handling code here:
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

    private void btDoacaoBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDoacaoBuscarProdActionPerformed

    private void menuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseClicked
        cl.show(pnCard, "cdHome");
    }//GEN-LAST:event_menuInicioMouseClicked

    private void btDoacaoBuscarDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarDoacaoActionPerformed
        buscarDoacao.setLocationRelativeTo(this);
        buscarDoacao.setVisible(true);
    }//GEN-LAST:event_btDoacaoBuscarDoacaoActionPerformed

    private void tableDoacaoProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoacaoProdutosMouseClicked
        int linhaSelecionada = tableDoacaoProdutos.getSelectedRow();
        if(linhaSelecionada != -1){
            Object descricao = tableDoacaoProdutos.getValueAt(linhaSelecionada, 1);
            Object quantidade = tableDoacaoProdutos.getValueAt(linhaSelecionada, 2);
            tfDoacaoSelecionarProd.setText(descricao.toString());
            //tfDoacaoQuantidade.setText(quantidade.toString());
        }
    }//GEN-LAST:event_tableDoacaoProdutosMouseClicked

    private void btDoacaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoDeletarActionPerformed
        int idDoacao = Integer.parseInt(tfDoacaoIdDoacao.getText());
        if(doacaoController.removeDoacao(idDoacao)){
            JOptionPane.showMessageDialog(rootPane, "Doacao Removida com sucesso.", "Remoção", JOptionPane.INFORMATION_MESSAGE);
            limparCamposCadastroDoacao();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Doacao não removida.", "Remoção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btDoacaoDeletarActionPerformed

    private void btDoacaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoLimparActionPerformed
        limparCamposCadastroDoacao();
    }//GEN-LAST:event_btDoacaoLimparActionPerformed

    private void cbRelPedStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelPedStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelPedStatusActionPerformed

    private void btPedidoBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoBuscarPedidoActionPerformed

    private void btPedidoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoBuscarClienteActionPerformed

    private void btPedidoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoRegistrarActionPerformed

    private void tfDoacaoSelecionarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoSelecionarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoSelecionarProdActionPerformed

    private void btPedidoBuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoBuscarCliente1ActionPerformed

    private void btPedidoBuscarCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarCliente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoBuscarCliente2ActionPerformed

    private void btPedidoBuscarCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoBuscarCliente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoBuscarCliente3ActionPerformed
    
    public void preencheDoacao(Doacao doacao){
        List<Produto> produtos = doacaoController.listagemDeProduto(doacao);
        tfDoacaoIdDoacao.setText(String.valueOf(doacao.getId()));
        tfDoacaoIdDoador.setText(String.valueOf(doacao.getDoador().getId()));
        tfDoacaoDoador.setText(doacao.getDoador().getNome());
        ftDoacaoData.setText(String.valueOf(doacao.getDataDoacao()));
        switch (String.valueOf(doacao.getTipo())){
            case "DINHEIRO": cbDoacaoTipo.setSelectedIndex(0);break;
            case "PRODUTO": cbDoacaoTipo.setSelectedIndex(1);break;
        }
        tfDoacaoValor.setValue(doacao.getValor());
        taDoacaoObservacao.setText(doacao.getObservacao());
        modeloTabela.setRowCount(0);
        for(Produto prod : produtos){
            Object[] linha = {prod.getTipo(), prod.getNome(), prod.getQuantidade()};
            modeloTabela.addRow(linha);
        }
        tfDoacaoSelecionarProd.setEnabled(false);
        jsDoacaoQuantidadeProduto.setEnabled(false);
        tfDoacaoIdDoacao.setEnabled(false);
        tfDoacaoIdDoador.setEnabled(false);
        tfDoacaoDoador.setEnabled(false);
        ftDoacaoData.setEnabled(false);
        cbDoacaoTipo.setEnabled(false);
        tfDoacaoValor.setEnabled(false);
        taDoacaoObservacao.setEnabled(false);
    }
    public void aplicarMascara(JFormattedTextField campo, String mascara) {
        campo.setEnabled(true);
        try {
            MaskFormatter formatter = new MaskFormatter(mascara);
            formatter.setPlaceholderCharacter('_');
            campo.setFormatterFactory( new javax.swing.text.DefaultFormatterFactory(formatter));
            campo.setValue(null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void carregarCidade() throws SQLException{
        cbEnderecoCidade.removeAllItems();
        Cidade cidadePadrao = new Cidade("Selecione...", null);
        cbEnderecoCidade.addItem(cidadePadrao);
        List<Cidade> puxarCidade = cidadeController.listarCidade();
        for(Cidade cidade : puxarCidade){
            cbEnderecoCidade.addItem(cidade);
        }
    }
    
    public void limparcamposCadastroUsuario(){
        tfNome.setText("");
        ffTelefone.setText("");
        tfEmail.setText("");
        ffDocumento.setText("");
        taObservacao.setText("");
        tfNomePaciente.setText("");
        tfQtdDias.setText("");
        tfEnderecoCep.setText("");
        tfEnderecoLogradouro.setText("");
        tfEnderecoComplemento.setText("");
        tfEnderecoBairro.setText("");
        tfEnderecoNumero.setText("");
        cbEnderecoCidade.setSelectedIndex(0);
        cbEnderecoUf.setSelectedIndex(0);
        buttonGroupPessoaTipo.clearSelection();
    }
    
    public void limparCamposCadastroDoacao(){
        tfDoacaoIdDoacao.setText("");
        tfDoacaoIdDoador.setText("");
        tfDoacaoDoador.setText("");
        ftDoacaoData.setText("");
        tfDoacaoValor.setValue(0.00);
        taDoacaoObservacao.setText("");
        tfDoacaoSelecionarProd.setText("");
        //jsDoacaoQuantidadeProduto.setText("");
        cbDoacaoTipo.setSelectedIndex(0);
        modeloTabela.setRowCount(0);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCidade;
    private javax.swing.JButton btCadastroPessoaLimpar;
    private javax.swing.JButton btCadastroPessoaRegistrar;
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
    private javax.swing.JButton btDoacaoVoltar;
    private javax.swing.JButton btPedidoBuscarCliente;
    private javax.swing.JButton btPedidoBuscarCliente1;
    private javax.swing.JButton btPedidoBuscarCliente2;
    private javax.swing.JButton btPedidoBuscarCliente3;
    private javax.swing.JButton btPedidoBuscarPedido;
    private javax.swing.JButton btPedidoLimpar;
    private javax.swing.JButton btPedidoRegistrar;
    private javax.swing.JButton btRelDoaFiltrar;
    private javax.swing.JButton btRelDoaVoltar;
    private javax.swing.JButton btRelDoacaoLimpar;
    private javax.swing.JButton btRelDoacaoSalvar;
    private javax.swing.JButton btRelPedFiltrar;
    private javax.swing.JButton btRelPedVoltar;
    private javax.swing.JButton btRelPedidoLimpar;
    private javax.swing.JButton btRelPedidoSalvar;
    private javax.swing.ButtonGroup buttonGroupPessoaTipo;
    private javax.swing.JComboBox<String> cbDoacaoTipo;
    private javax.swing.JComboBox<Cidade> cbEnderecoCidade;
    private javax.swing.JComboBox<String> cbEnderecoUf;
    private javax.swing.JComboBox<String> cbLocalInternacao;
    private javax.swing.JComboBox<String> cbPedidoStatus;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao1;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao2;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto;
    private javax.swing.JComboBox<String> cbRelPedCidade;
    private javax.swing.JComboBox<String> cbRelPedLocal;
    private javax.swing.JComboBox<String> cbRelPedOrdenacao;
    private javax.swing.JComboBox<String> cbRelPedSentido;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JLabel jbRelDoaTorIte;
    private javax.swing.JLabel jbRelDoaTotDin;
    private javax.swing.JLabel jbRelDoaTotProd;
    private javax.swing.JLabel jbRelPedTotCancelado;
    private javax.swing.JLabel jbRelPedTotFechado;
    private javax.swing.JLabel jbRelPedTotMarmitas;
    private javax.swing.JLabel jbRelPedTotPendente;
    private javax.swing.JPanel jpRelPedTotMarmitas;
    private javax.swing.JPanel jpRelPedTotStatus;
    private javax.swing.JSpinner jsDoacaoQuantidadeProduto;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbComplemento;
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
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbLogradouro3;
    private javax.swing.JLabel lbLogradouro5;
    private javax.swing.JLabel lbLogradouro6;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomePaciente;
    private javax.swing.JLabel lbNomePaciente1;
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
    private javax.swing.JLabel lbRelPedDtEntrega;
    private javax.swing.JLabel lbRelPedDtEntrega1;
    private javax.swing.JLabel lbRelPedDtPedido;
    private javax.swing.JLabel lbRelPedDtPedido1;
    private javax.swing.JLabel lbRelPedLocal;
    private javax.swing.JLabel lbRelPedOrdenacao;
    private javax.swing.JLabel lbRelPedStatus;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuDoacao;
    private javax.swing.JMenuItem menuDoacaoCadastrar;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuPedido;
    private javax.swing.JMenuItem menuPedidoCadastrar;
    private javax.swing.JMenu menuPessoa;
    private javax.swing.JMenuItem menuPessoaCadastrar;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioDoacao;
    private javax.swing.JMenuItem menuRelatorioPedido;
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
    private javax.swing.JTextArea taDoacaoObservacao1;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTable tableDoacaoProdutos;
    private javax.swing.JTable tableRelatorioDoacao;
    private javax.swing.JTable tableRelatorioPedido;
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
    private javax.swing.JTextField tfPedidoIdPedido;
    private javax.swing.JTextField tfPedidoIdPedido1;
    private javax.swing.JTextField tfQtdDias;
    private javax.swing.JTextField tfRelDoaDoador;
    private javax.swing.JTextField tfRelDoaProd;
    private javax.swing.JTextField tfRelPedCliente;
    private javax.swing.JFormattedTextField tfRelPedDtEntrega;
    private javax.swing.JFormattedTextField tfRelPedDtPedido;
    private javax.swing.JFormattedTextField tfRelPedDtPedido2;
    private javax.swing.JFormattedTextField tfRelPedDtPedido3;
    private javax.swing.JTextField tfRelPedTotCancelado;
    private javax.swing.JTextField tfRelPedTotFechado;
    private javax.swing.JTextField tfRelPedTotMarmitas;
    private javax.swing.JTextField tfRelPedTotPendente;
    private javax.swing.JTextField tfRelTotDin;
    private javax.swing.JTextField tfRelTotIte;
    private javax.swing.JTextField tfRelTotProd;
    // End of variables declaration//GEN-END:variables
}
