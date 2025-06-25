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
        pnAlterarPessoa = new javax.swing.JPanel();
        pnBuscar = new javax.swing.JPanel();
        tfBuscarNome = new javax.swing.JTextField();
        lbBuscarNome = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        lbBuscarId = new javax.swing.JLabel();
        tfBuscarId = new javax.swing.JTextField();
        pnCadastrarDoacao = new javax.swing.JPanel();
        pnDoacao = new javax.swing.JPanel();
        lbDoacaoIdDoacao = new javax.swing.JLabel();
        tfDoacaoIdDoacao = new javax.swing.JTextField();
        btDoacaoBuscarDoacao = new javax.swing.JButton();
        lbDoacaoDoador = new javax.swing.JLabel();
        tfDoacaoIdDoador = new javax.swing.JTextField();
        tfDoacaoDoador = new javax.swing.JTextField();
        btDoacaoBuscarDoador = new javax.swing.JButton();
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
        pnDoacaoProduto = new javax.swing.JPanel();
        lbDoacaoSelecionarProd = new javax.swing.JLabel();
        tfDoacaoSelecionarProd = new javax.swing.JTextField();
        btDoacaoBuscarProd = new javax.swing.JButton();
        lbDoacaoQuantidade = new javax.swing.JLabel();
        tfDoacaoQuantidade = new javax.swing.JTextField();
        btDoacaoAddProd = new javax.swing.JButton();
        pnListBoxProd = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoacaoProdutos = new javax.swing.JTable();
        btDoacaoAltProd = new javax.swing.JButton();
        btDoacaoDelProd = new javax.swing.JButton();
        btDoacaoRegistrarDoacao = new javax.swing.JButton();
        btDoacaoLimpar = new javax.swing.JButton();
        btDoacaoRelatorio = new javax.swing.JButton();
        btDoacaoVoltar = new javax.swing.JButton();
        pnCadastrarPedido = new javax.swing.JPanel();
        pnPedido = new javax.swing.JPanel();
        tfPedidoCliente = new javax.swing.JTextField();
        btPedidoBuscarCliente = new javax.swing.JButton();
        lbPedidoCliente = new javax.swing.JLabel();
        tfPedidoQtdMarmitas = new javax.swing.JTextField();
        lbPedidoQtdMarmitas = new javax.swing.JLabel();
        ffPedidoDtPedido = new javax.swing.JFormattedTextField();
        lbPedidoDtPedido = new javax.swing.JLabel();
        lbPedidoId = new javax.swing.JLabel();
        tfPedidoId = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDoacaoObservacao1 = new javax.swing.JTextArea();
        lbPedidoObservacao = new javax.swing.JLabel();
        lbPedidoDtEntrega = new javax.swing.JLabel();
        ffPedidoDtEntrega = new javax.swing.JFormattedTextField();
        cbPedidoStatus = new javax.swing.JComboBox<>();
        lbPedidoStatus = new javax.swing.JLabel();
        btPedidoRegistrar = new javax.swing.JButton();
        btPedidoLimpar = new javax.swing.JButton();
        pnAlterarPedido = new javax.swing.JPanel();
        pnPedido1 = new javax.swing.JPanel();
        tfAltPedCliente = new javax.swing.JTextField();
        btAltPedBuscar = new javax.swing.JButton();
        lbAltPedCliente = new javax.swing.JLabel();
        tfAltPedQtdMarmitas = new javax.swing.JTextField();
        lbAltPedQtdMarmitas = new javax.swing.JLabel();
        lbAltPedId = new javax.swing.JLabel();
        ffAltPedId = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        taDoacaoObservacao2 = new javax.swing.JTextArea();
        tfAltPedObs = new javax.swing.JLabel();
        lbAltPedDtPedido = new javax.swing.JLabel();
        ffAltPedDtPedido = new javax.swing.JFormattedTextField();
        cbAltPedStatus = new javax.swing.JComboBox<>();
        lbAltPedStatus = new javax.swing.JLabel();
        btAltPedAtualizar = new javax.swing.JButton();
        btAltPedLimpar = new javax.swing.JButton();
        pnRelatorioDoacao = new javax.swing.JPanel();
        pnRelDoa = new javax.swing.JPanel();
        pnRelFiltros = new javax.swing.JPanel();
        lbRelDoaDtInicial = new javax.swing.JLabel();
        ffRelDoaDtInicial = new javax.swing.JFormattedTextField();
        lbRelDoaDtFinal = new javax.swing.JLabel();
        ffRelDoaDtFinal = new javax.swing.JFormattedTextField();
        lbRelDoaDoador = new javax.swing.JLabel();
        tfRelDoaDoador = new javax.swing.JTextField();
        btRelDoaDoador = new javax.swing.JButton();
        lbRelDoaTpDoacao = new javax.swing.JLabel();
        cbRelDoaTpDoacao = new javax.swing.JComboBox<>();
        lbRelDoaOrdenacao = new javax.swing.JLabel();
        cbRelDoaOrdenacao1 = new javax.swing.JComboBox<>();
        cbRelDoaOrdenacao2 = new javax.swing.JComboBox<>();
        lbRelDoaProd = new javax.swing.JLabel();
        tfRelDoaProd = new javax.swing.JTextField();
        btRelDoaProd = new javax.swing.JButton();
        lbRelDoaTpProduto = new javax.swing.JLabel();
        cbRelDoaTpProduto = new javax.swing.JComboBox<>();
        btRelDoaFiltrar = new javax.swing.JButton();
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
        pnRelFiltros1 = new javax.swing.JPanel();
        lbRelDoaDtInicial4 = new javax.swing.JLabel();
        ffRelDoaDtInicial4 = new javax.swing.JFormattedTextField();
        lbRelDoaDtFinal4 = new javax.swing.JLabel();
        ffRelDoaDtFinal4 = new javax.swing.JFormattedTextField();
        lbRelDoaDoador3 = new javax.swing.JLabel();
        tfRelDoaDoador3 = new javax.swing.JTextField();
        btRelDoaDoador3 = new javax.swing.JButton();
        lbRelDoaTpDoacao3 = new javax.swing.JLabel();
        cbRelDoaTpDoacao3 = new javax.swing.JComboBox<>();
        lbRelDoaOrdenacao3 = new javax.swing.JLabel();
        cbRelDoaOrdenacao7 = new javax.swing.JComboBox<>();
        cbRelDoaOrdenacao8 = new javax.swing.JComboBox<>();
        lbRelDoaTpProduto3 = new javax.swing.JLabel();
        cbRelDoaTpProduto3 = new javax.swing.JComboBox<>();
        btRelDoaFiltrar3 = new javax.swing.JButton();
        lbRelDoaTpDoacao4 = new javax.swing.JLabel();
        cbRelDoaTpDoacao4 = new javax.swing.JComboBox<>();
        lbRelDoaTpProduto4 = new javax.swing.JLabel();
        cbRelDoaTpProduto4 = new javax.swing.JComboBox<>();
        pnRelResultado1 = new javax.swing.JPanel();
        spRelPedResultado = new javax.swing.JScrollPane();
        tableRelatorioPedido1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbRelPedTotDin1 = new javax.swing.JLabel();
        tfRelPedTotProd2 = new javax.swing.JTextField();
        jbRelPedTotDin2 = new javax.swing.JLabel();
        tfRelPedTotProd3 = new javax.swing.JTextField();
        jbRelPedTotDin3 = new javax.swing.JLabel();
        tfRelPedTotProd4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tfRelPedTotProd1 = new javax.swing.JTextField();
        jbRelPedTotDin = new javax.swing.JLabel();
        btRelPedidoSalvar = new javax.swing.JButton();
        btRelPedidoLimpar = new javax.swing.JButton();
        btRelPedVoltar = new javax.swing.JButton();
        pnHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuPessoa = new javax.swing.JMenu();
        menuPessoaCadastrar = new javax.swing.JMenuItem();
        menuPessoaAlterar = new javax.swing.JMenuItem();
        menuDoacao = new javax.swing.JMenu();
        menuDoacaoCadastrar = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenu();
        menuPedidoCadastrar = new javax.swing.JMenuItem();
        menuPedidoAlterar = new javax.swing.JMenuItem();
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

        lbLogradouro.setText("Logradouro:");

        lbNumero.setText("Número:");

        tfEnderecoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoNumeroKeyTyped(evt);
            }
        });

        lbBairro.setText("Bairro:");

        lbLogradouro3.setText("Cidade:");

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

        lbLogradouro5.setText("CEP:");

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

        lbNome.setText("Nome:");

        try {
            ffTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbTelefone.setText("Telefone:");

        lbEmail.setText("E-mail:");

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

        lbPessoaTipo.setText("Tipo:");

        lbDocumento.setText("Nº do Documento:");

        lbNomePaciente.setText("Nome do Paciente:");

        tfNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomePacienteKeyTyped(evt);
            }
        });

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

        jLabel1.setText("Tipo de Usuário");

        jLabel2.setText("Local de Internação");

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
                .addContainerGap(136, Short.MAX_VALUE))
        );
        pnCadastroPessoaLayout.setVerticalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(158, Short.MAX_VALUE))
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastroPessoaRegistrar)
                            .addComponent(btCadastroPessoaLimpar))
                        .addGap(114, 114, 114))))
        );

        pnCard.add(pnCadastroPessoa, "beneficiario");

        pnBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Pessoa"));

        tfBuscarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscarNomeKeyTyped(evt);
            }
        });

        lbBuscarNome.setText("Nome:");

        btBuscar.setText("Buscar");

        lbBuscarId.setText("ID:");

        tfBuscarId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscarIdKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnBuscarLayout = new javax.swing.GroupLayout(pnBuscar);
        pnBuscar.setLayout(pnBuscarLayout);
        pnBuscarLayout.setHorizontalGroup(
            pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscarNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBuscarLayout.createSequentialGroup()
                        .addGap(0, 326, Short.MAX_VALUE)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBuscarLayout.createSequentialGroup()
                        .addGroup(pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBuscarNome)
                            .addComponent(lbBuscarId)
                            .addComponent(tfBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnBuscarLayout.setVerticalGroup(
            pnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBuscarNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBuscarId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnAlterarPessoaLayout = new javax.swing.GroupLayout(pnAlterarPessoa);
        pnAlterarPessoa.setLayout(pnAlterarPessoaLayout);
        pnAlterarPessoaLayout.setHorizontalGroup(
            pnAlterarPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPessoaLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(pnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(733, Short.MAX_VALUE))
        );
        pnAlterarPessoaLayout.setVerticalGroup(
            pnAlterarPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPessoaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(590, Short.MAX_VALUE))
        );

        pnCard.add(pnAlterarPessoa, "cdAlterarPessoa");

        pnDoacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Doação"));

        lbDoacaoIdDoacao.setText("Código");

        tfDoacaoIdDoacao.setEditable(false);

        btDoacaoBuscarDoacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarDoacao.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btDoacaoBuscarDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoBuscarDoacaoActionPerformed(evt);
            }
        });

        lbDoacaoDoador.setText("Doador");

        tfDoacaoIdDoador.setEditable(false);
        tfDoacaoIdDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoIdDoadorActionPerformed(evt);
            }
        });

        tfDoacaoDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoDoadorActionPerformed(evt);
            }
        });

        btDoacaoBuscarDoador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btDoacaoBuscarDoador.setMargin(new java.awt.Insets(1, 1, 1, 1));

        lbDoacaoTipo.setText("Tipo");

        cbDoacaoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO", "PRODUTO" }));

        lbDoacaoData.setText("Data da Doação");

        ftDoacaoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftDoacaoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftDoacaoDataActionPerformed(evt);
            }
        });

        lbDoacaoValor.setText("Valor");

        tfDoacaoValor.setColumns(10);
        tfDoacaoValor.setValue(0.00);
        tfDoacaoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoValorActionPerformed(evt);
            }
        });

        lbDoacaoObservacao.setText("Observação");

        taDoacaoObservacao.setColumns(20);
        taDoacaoObservacao.setRows(5);
        taDoacaoObservacao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDoacaoObservacao);

        btDoacaoRecibo.setText("Gerar Recibo");

        btDoacaoDeletar.setText("Deletar");
        btDoacaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoDeletarActionPerformed(evt);
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
                            .addComponent(lbDoacaoTipo)
                            .addComponent(cbDoacaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoacaoData)
                            .addComponent(ftDoacaoData, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbDoacaoIdDoacao)
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addComponent(tfDoacaoIdDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDoacaoBuscarDoacao))
                    .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnDoacaoLayout.createSequentialGroup()
                            .addComponent(btDoacaoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btDoacaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbDoacaoObservacao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnDoacaoLayout.createSequentialGroup()
                            .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbDoacaoDoador)
                                .addComponent(tfDoacaoIdDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfDoacaoDoador)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btDoacaoBuscarDoador))
                        .addComponent(tfDoacaoValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbDoacaoValor, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnDoacaoLayout.setVerticalGroup(
            pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbDoacaoIdDoacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDoacaoIdDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoBuscarDoacao))
                .addGap(18, 18, 18)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoLayout.createSequentialGroup()
                        .addComponent(lbDoacaoDoador)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDoacaoIdDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfDoacaoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btDoacaoBuscarDoador)))
                .addGap(18, 18, 18)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDoacaoTipo)
                    .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnDoacaoLayout.createSequentialGroup()
                            .addComponent(lbDoacaoData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ftDoacaoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbDoacaoTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbDoacaoValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDoacaoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDoacaoObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDoacaoDeletar)
                    .addComponent(btDoacaoRecibo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnDoacaoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        lbDoacaoSelecionarProd.setText("Descrição");

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

        lbDoacaoQuantidade.setText("Quantidade");

        tfDoacaoQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoQuantidadeActionPerformed(evt);
            }
        });

        btDoacaoAddProd.setText("Adicionar");
        btDoacaoAddProd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btDoacaoAddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoacaoAddProdActionPerformed(evt);
            }
        });

        pnListBoxProd.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos doados"));

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

        btDoacaoAltProd.setText("Alterar");

        btDoacaoDelProd.setText("Deletar");

        javax.swing.GroupLayout pnListBoxProdLayout = new javax.swing.GroupLayout(pnListBoxProd);
        pnListBoxProd.setLayout(pnListBoxProdLayout);
        pnListBoxProdLayout.setHorizontalGroup(
            pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListBoxProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListBoxProdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btDoacaoAltProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoDelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnListBoxProdLayout.setVerticalGroup(
            pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListBoxProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnListBoxProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoDelProd)
                    .addComponent(btDoacaoAltProd))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnDoacaoProdutoLayout = new javax.swing.GroupLayout(pnDoacaoProduto);
        pnDoacaoProduto.setLayout(pnDoacaoProdutoLayout);
        pnDoacaoProdutoLayout.setHorizontalGroup(
            pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListBoxProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoSelecionarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(tfDoacaoSelecionarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDoacaoBuscarProd)
                                .addGap(6, 6, 6)))
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDoacaoQuantidade)
                            .addComponent(tfDoacaoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDoacaoAddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnDoacaoProdutoLayout.setVerticalGroup(
            pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbDoacaoSelecionarProd))
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDoacaoSelecionarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btDoacaoBuscarProd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfDoacaoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btDoacaoAddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnListBoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        btDoacaoRegistrarDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRegistrarDoacao.setText("Registrar Doação");

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
                .addGap(20, 20, 20)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(btDoacaoRegistrarDoacao)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnCadastrarDoacaoLayout.setVerticalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDoacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoRegistrarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastrarDoacao, "cdCadastrarDoacao");

        pnPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        tfPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPedidoClienteActionPerformed(evt);
            }
        });

        btPedidoBuscarCliente.setText("Buscar");

        lbPedidoCliente.setText("Cliente");

        lbPedidoQtdMarmitas.setText("Quantidade de Marmitas");

        ffPedidoDtPedido.setText("_____ / _____ / _____");

        lbPedidoDtPedido.setText("Data do Pedido");

        lbPedidoId.setText("ID Gerado");

        tfPedidoId.setText("ID Gerado e Data automáticos após clicar em Registrar");
        tfPedidoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPedidoIdActionPerformed(evt);
            }
        });

        taDoacaoObservacao1.setColumns(20);
        taDoacaoObservacao1.setRows(5);
        taDoacaoObservacao1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taDoacaoObservacao1);

        lbPedidoObservacao.setText("Observação");

        lbPedidoDtEntrega.setText("Data de Entrega");

        ffPedidoDtEntrega.setText("_____ / _____ / _____");

        cbPedidoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Finalizado", "Cancelado", " " }));

        lbPedidoStatus.setText("Status do Pedido");

        btPedidoRegistrar.setText("Registrar");

        btPedidoLimpar.setText("Limpar");

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPedidoRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbPedidoCliente)
                        .addGroup(pnPedidoLayout.createSequentialGroup()
                            .addComponent(tfPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btPedidoBuscarCliente))
                        .addComponent(lbPedidoStatus)
                        .addGroup(pnPedidoLayout.createSequentialGroup()
                            .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbPedidoQtdMarmitas)
                                .addComponent(tfPedidoQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbPedidoDtEntrega))
                        .addComponent(cbPedidoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPedidoObservacao)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPedidoId, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPedidoId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPedidoDtPedido))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPedidoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPedidoBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoQtdMarmitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPedidoQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoDtEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffPedidoDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPedidoStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPedidoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPedidoObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoDtPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffPedidoDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidoLayout.createSequentialGroup()
                        .addComponent(lbPedidoId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPedidoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPedidoRegistrar)
                    .addComponent(btPedidoLimpar))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout pnCadastrarPedidoLayout = new javax.swing.GroupLayout(pnCadastrarPedido);
        pnCadastrarPedido.setLayout(pnCadastrarPedidoLayout);
        pnCadastrarPedidoLayout.setHorizontalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        pnCadastrarPedidoLayout.setVerticalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastrarPedido, "cdCadastrarPedido");

        pnPedido1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Pedido"));

        tfAltPedCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAltPedClienteActionPerformed(evt);
            }
        });

        btAltPedBuscar.setText("Buscar");

        lbAltPedCliente.setText("Cliente");

        lbAltPedQtdMarmitas.setText("Quantidade de Marmitas");

        lbAltPedId.setText("ID Gerado");

        ffAltPedId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffAltPedIdActionPerformed(evt);
            }
        });

        taDoacaoObservacao2.setColumns(20);
        taDoacaoObservacao2.setRows(5);
        taDoacaoObservacao2.setWrapStyleWord(true);
        jScrollPane5.setViewportView(taDoacaoObservacao2);

        tfAltPedObs.setText("Observação");

        lbAltPedDtPedido.setText("Data do Pedido");

        ffAltPedDtPedido.setText("_____ / _____ / _____");

        cbAltPedStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Finalizado", "Cancelado", " " }));

        lbAltPedStatus.setText("Status do Pedido");

        btAltPedAtualizar.setText("Atualizar");

        btAltPedLimpar.setText("Limpar");

        javax.swing.GroupLayout pnPedido1Layout = new javax.swing.GroupLayout(pnPedido1);
        pnPedido1.setLayout(pnPedido1Layout);
        pnPedido1Layout.setHorizontalGroup(
            pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPedido1Layout.createSequentialGroup()
                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedido1Layout.createSequentialGroup()
                                .addComponent(lbAltPedCliente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfAltPedCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAltPedDtPedido)
                            .addComponent(ffAltPedDtPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAltPedId)
                            .addGroup(pnPedido1Layout.createSequentialGroup()
                                .addComponent(ffAltPedId, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAltPedBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnPedido1Layout.createSequentialGroup()
                        .addComponent(tfAltPedObs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnPedido1Layout.createSequentialGroup()
                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedido1Layout.createSequentialGroup()
                                .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPedido1Layout.createSequentialGroup()
                                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbAltPedQtdMarmitas)
                                            .addComponent(tfAltPedQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbAltPedStatus)
                                            .addComponent(cbAltPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedido1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btAltPedLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAltPedAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnPedido1Layout.setVerticalGroup(
            pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedido1Layout.createSequentialGroup()
                .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnPedido1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbAltPedCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAltPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAltPedQtdMarmitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAltPedQtdMarmitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPedido1Layout.createSequentialGroup()
                        .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedido1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbAltPedId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ffAltPedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAltPedBuscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnPedido1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAltPedDtPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ffAltPedDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addComponent(lbAltPedStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAltPedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfAltPedObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(pnPedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAltPedLimpar)
                    .addComponent(btAltPedAtualizar))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnAlterarPedidoLayout = new javax.swing.GroupLayout(pnAlterarPedido);
        pnAlterarPedido.setLayout(pnAlterarPedidoLayout);
        pnAlterarPedidoLayout.setHorizontalGroup(
            pnAlterarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPedidoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        pnAlterarPedidoLayout.setVerticalGroup(
            pnAlterarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPedidoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pnPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        pnCard.add(pnAlterarPedido, "cdAlterarPedido");

        pnRelDoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório Doação"));

        pnRelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        lbRelDoaDtInicial.setText("Data Inicial");

        lbRelDoaDtFinal.setText("Data Final");

        lbRelDoaDoador.setText("Doador");

        btRelDoaDoador.setText("Buscar");

        lbRelDoaTpDoacao.setText("Tipo de Doação");

        cbRelDoaTpDoacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Produto", "Dinheiro" }));

        lbRelDoaOrdenacao.setText("Ordenação");

        cbRelDoaOrdenacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Código", "Nome do Doador", "Valor", "Quantidade de Produtos" }));

        cbRelDoaOrdenacao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrente", "Crescente" }));

        lbRelDoaProd.setText("Produto");

        btRelDoaProd.setText("Buscar");

        lbRelDoaTpProduto.setText("Tipo de Produto");

        cbRelDoaTpProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento", "Limpeza", "Outros" }));

        btRelDoaFiltrar.setText("Filtrar");

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
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRelDoaProd)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaDoador)
                            .addComponent(tfRelDoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRelDoaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRelDoaProd)
                            .addComponent(btRelDoaDoador))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpProduto)
                            .addComponent(cbRelDoaTpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbRelDoaTpDoacao)
                    .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        pnRelFiltrosLayout.setVerticalGroup(
            pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRelDoaDoador)
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDtInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDtFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDoador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelDoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelFiltrosLayout.createSequentialGroup()
                        .addComponent(lbRelDoaTpDoacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelDoaOrdenacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaOrdenacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbRelDoaOrdenacao2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelDoaProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnRelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfRelDoaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btRelDoaProd)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltrosLayout.createSequentialGroup()
                                .addComponent(lbRelDoaTpProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );

        pnRelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

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

        jbRelDoaTotDin.setText("Valor total");

        tfRelTotDin.setEditable(false);
        tfRelTotDin.setText("R$ 0,00");

        jbRelDoaTotProd.setText("Produtos total");

        tfRelTotProd.setEditable(false);
        tfRelTotProd.setText("0");

        jbRelDoaTorIte.setText("Itens total");

        tfRelTotIte.setEditable(false);
        tfRelTotIte.setText("0");

        javax.swing.GroupLayout pnRelResultadoLayout = new javax.swing.GroupLayout(pnRelResultado);
        pnRelResultado.setLayout(pnRelResultadoLayout);
        pnRelResultadoLayout.setHorizontalGroup(
            pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spRelResultado)
                    .addGroup(pnRelResultadoLayout.createSequentialGroup()
                        .addGroup(pnRelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotDin)
                            .addComponent(tfRelTotDin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                .addComponent(spRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap())
        );

        btRelDoacaoSalvar.setText("Salvar Relatório");

        btRelDoacaoLimpar.setText("Limpar");

        btRelDoaVoltar.setText("Voltar");

        javax.swing.GroupLayout pnRelDoaLayout = new javax.swing.GroupLayout(pnRelDoa);
        pnRelDoa.setLayout(pnRelDoaLayout);
        pnRelDoaLayout.setHorizontalGroup(
            pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelDoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnRelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelDoaLayout.createSequentialGroup()
                        .addComponent(btRelDoacaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addGroup(pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelDoacaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoaVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnRelatorioDoacaoLayout = new javax.swing.GroupLayout(pnRelatorioDoacao);
        pnRelatorioDoacao.setLayout(pnRelatorioDoacaoLayout);
        pnRelatorioDoacaoLayout.setHorizontalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnRelatorioDoacaoLayout.setVerticalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioDoacao, "relatorioDoacao");
        pnRelatorioDoacao.getAccessibleContext().setAccessibleName("");

        pnRelPed.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório Pedidos"));

        pnRelFiltros1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        lbRelDoaDtInicial4.setText("D:ata do Pedido");

        lbRelDoaDtFinal4.setText("Data da Entrega:");

        lbRelDoaDoador3.setText("Assistente/Beneficiário");

        btRelDoaDoador3.setText("Buscar");

        lbRelDoaTpDoacao3.setText("Tipo Cliente:");

        cbRelDoaTpDoacao3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Assistente", "Beneficiário" }));
        cbRelDoaTpDoacao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelDoaTpDoacao3ActionPerformed(evt);
            }
        });

        lbRelDoaOrdenacao3.setText("Ordenação");

        cbRelDoaOrdenacao7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cliente", "Data do Pedido", "Data da Entrega", "Status", "Marmitas" }));

        cbRelDoaOrdenacao8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crescente", "Decrescente" }));

        lbRelDoaTpProduto3.setText("Local:");

        cbRelDoaTpProduto3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hospital São José", "Pronto Socorro" }));

        btRelDoaFiltrar3.setText("Filtrar");

        lbRelDoaTpDoacao4.setText("Status:");

        cbRelDoaTpDoacao4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendente", "Finalizado", "Cancelado" }));
        cbRelDoaTpDoacao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelDoaTpDoacao4ActionPerformed(evt);
            }
        });

        lbRelDoaTpProduto4.setText("Cidade:");

        cbRelDoaTpProduto4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento", "Limpeza", "Outros" }));

        javax.swing.GroupLayout pnRelFiltros1Layout = new javax.swing.GroupLayout(pnRelFiltros1);
        pnRelFiltros1.setLayout(pnRelFiltros1Layout);
        pnRelFiltros1Layout.setHorizontalGroup(
            pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffRelDoaDtInicial4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelDoaDtInicial4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRelDoaDtFinal4)
                            .addComponent(ffRelDoaDtFinal4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaOrdenacao3)
                            .addComponent(cbRelDoaOrdenacao7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRelDoaOrdenacao8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpDoacao4)
                            .addComponent(cbRelDoaTpDoacao4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpDoacao3)
                            .addComponent(cbRelDoaTpDoacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaDoador3)
                            .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(tfRelDoaDoador3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRelDoaDoador3))))
                    .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpProduto3)
                            .addComponent(cbRelDoaTpProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpProduto4)
                            .addComponent(cbRelDoaTpProduto4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(334, 334, 334)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRelDoaFiltrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        pnRelFiltros1Layout.setVerticalGroup(
            pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaDtInicial4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ffRelDoaDtInicial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaDtFinal4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ffRelDoaDtFinal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaTpDoacao4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpDoacao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaTpDoacao3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpDoacao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaDoador3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfRelDoaDoador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btRelDoaDoador3))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRelDoaFiltrar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(pnRelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaOrdenacao3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaOrdenacao7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbRelDoaOrdenacao8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaTpProduto3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelFiltros1Layout.createSequentialGroup()
                                .addComponent(lbRelDoaTpProduto4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpProduto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );

        pnRelResultado1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        tableRelatorioPedido1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód.", "Cliente", "Tipo", "Status", "Qtd. Marmitas", "Local", "Observação", "Data do Pedido", "Data da Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spRelPedResultado.setViewportView(tableRelatorioPedido1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jbRelPedTotDin1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbRelPedTotDin1.setText("Aberto:");

        tfRelPedTotProd2.setEditable(false);
        tfRelPedTotProd2.setText("0");

        jbRelPedTotDin2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbRelPedTotDin2.setText("Fechado:");

        tfRelPedTotProd3.setEditable(false);
        tfRelPedTotProd3.setText("0");

        jbRelPedTotDin3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbRelPedTotDin3.setText("Cancelado:");

        tfRelPedTotProd4.setEditable(false);
        tfRelPedTotProd4.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotDin1)
                    .addComponent(tfRelPedTotProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotDin2)
                    .addComponent(tfRelPedTotProd3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRelPedTotDin3)
                    .addComponent(tfRelPedTotProd4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbRelPedTotDin1)
                            .addGap(46, 46, 46)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotProd3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbRelPedTotDin2)
                            .addGap(46, 46, 46)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfRelPedTotProd4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbRelPedTotDin3)
                            .addGap(46, 46, 46))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfRelPedTotProd1.setEditable(false);
        tfRelPedTotProd1.setText("0");

        jbRelPedTotDin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbRelPedTotDin.setText("Total de Marmitas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbRelPedTotDin)
            .addComponent(tfRelPedTotProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jbRelPedTotDin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRelPedTotProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRelResultado1Layout = new javax.swing.GroupLayout(pnRelResultado1);
        pnRelResultado1.setLayout(pnRelResultado1Layout);
        pnRelResultado1Layout.setHorizontalGroup(
            pnRelResultado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelResultado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelResultado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spRelPedResultado)
                    .addGroup(pnRelResultado1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnRelResultado1Layout.setVerticalGroup(
            pnRelResultado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelResultado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spRelPedResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnRelResultado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRelResultado1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnRelResultado1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        btRelPedidoSalvar.setText("Salvar Relatório");

        btRelPedidoLimpar.setText("Limpar");

        btRelPedVoltar.setText("Voltar");

        javax.swing.GroupLayout pnRelPedLayout = new javax.swing.GroupLayout(pnRelPed);
        pnRelPed.setLayout(pnRelPedLayout);
        pnRelPedLayout.setHorizontalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnRelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnRelResultado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelPedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRelPedidoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRelPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRelPedVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnRelPedLayout.setVerticalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnRelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRelResultado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelPedidoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelPedidoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelPedVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnRelatorioPedidoLayout = new javax.swing.GroupLayout(pnRelatorioPedido);
        pnRelatorioPedido.setLayout(pnRelatorioPedidoLayout);
        pnRelatorioPedidoLayout.setHorizontalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRelatorioPedidoLayout.setVerticalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioPedido, "relatorioPedido");

        pnHome.setBackground(new java.awt.Color(245, 245, 246));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NossoLarMenor.png"))); // NOI18N

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(326, 326, 326))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pnCard.add(pnHome, "cdHome");

        javax.swing.GroupLayout pnDadosPrincipalLayout = new javax.swing.GroupLayout(pnDadosPrincipal);
        pnDadosPrincipal.setLayout(pnDadosPrincipalLayout);
        pnDadosPrincipalLayout.setHorizontalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnDadosPrincipalLayout.setVerticalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        menuPessoaAlterar.setText("Alterar");
        menuPessoaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoaAlterarActionPerformed(evt);
            }
        });
        menuPessoa.add(menuPessoaAlterar);

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

        menuPedidoAlterar.setText("Alterar");
        menuPedidoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidoAlterarActionPerformed(evt);
            }
        });
        menuPedido.add(menuPedidoAlterar);

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

    private void menuPessoaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoaAlterarActionPerformed
        cl.show(pnCard, "cdAlterarPessoa");
    }//GEN-LAST:event_menuPessoaAlterarActionPerformed

    private void menuDoacaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoacaoCadastrarActionPerformed
        cl.show(pnCard, "cdCadastrarDoacao");
    }//GEN-LAST:event_menuDoacaoCadastrarActionPerformed

    private void menuPedidoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidoCadastrarActionPerformed
        cl.show(pnCard, "cdCadastrarPedido");
    }//GEN-LAST:event_menuPedidoCadastrarActionPerformed

    private void menuPedidoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidoAlterarActionPerformed
        cl.show(pnCard, "cdAlterarPedido");
    }//GEN-LAST:event_menuPedidoAlterarActionPerformed

    private void tfBuscarNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarNomeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarNomeKeyTyped

    private void tfBuscarIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarIdKeyTyped

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

    private void tfDoacaoQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoQuantidadeActionPerformed

    private void tfPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPedidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPedidoClienteActionPerformed

    private void tfPedidoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPedidoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPedidoIdActionPerformed

    private void tfAltPedClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAltPedClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAltPedClienteActionPerformed

    private void ffAltPedIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffAltPedIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ffAltPedIdActionPerformed

    private void menuRelatorioDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioDoacaoActionPerformed
        cl.show(pnCard, "relatorioDoacao");
    }//GEN-LAST:event_menuRelatorioDoacaoActionPerformed

    private void menuRelatorioPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioPedidoActionPerformed
        cl.show(pnCard, "relatorioPedido");
    }//GEN-LAST:event_menuRelatorioPedidoActionPerformed

    private void btDoacaoBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoacaoBuscarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDoacaoBuscarProdActionPerformed

    private void tfDoacaoSelecionarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoSelecionarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoSelecionarProdActionPerformed

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
            tfDoacaoQuantidade.setText(quantidade.toString());
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

    private void cbRelDoaTpDoacao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelDoaTpDoacao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelDoaTpDoacao3ActionPerformed

    private void cbRelDoaTpDoacao4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelDoaTpDoacao4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelDoaTpDoacao4ActionPerformed
    
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
        tfDoacaoQuantidade.setEnabled(false);
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
        tfDoacaoQuantidade.setText("");
        cbDoacaoTipo.setSelectedIndex(0);
        modeloTabela.setRowCount(0);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCidade;
    private javax.swing.JButton btAltPedAtualizar;
    private javax.swing.JButton btAltPedBuscar;
    private javax.swing.JButton btAltPedLimpar;
    private javax.swing.JButton btBuscar;
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
    private javax.swing.JButton btPedidoLimpar;
    private javax.swing.JButton btPedidoRegistrar;
    private javax.swing.JButton btRelDoaDoador;
    private javax.swing.JButton btRelDoaDoador3;
    private javax.swing.JButton btRelDoaFiltrar;
    private javax.swing.JButton btRelDoaFiltrar3;
    private javax.swing.JButton btRelDoaProd;
    private javax.swing.JButton btRelDoaVoltar;
    private javax.swing.JButton btRelDoacaoLimpar;
    private javax.swing.JButton btRelDoacaoSalvar;
    private javax.swing.JButton btRelPedVoltar;
    private javax.swing.JButton btRelPedidoLimpar;
    private javax.swing.JButton btRelPedidoSalvar;
    private javax.swing.ButtonGroup buttonGroupPessoaTipo;
    private javax.swing.JComboBox<String> cbAltPedStatus;
    private javax.swing.JComboBox<String> cbDoacaoTipo;
    private javax.swing.JComboBox<Cidade> cbEnderecoCidade;
    private javax.swing.JComboBox<String> cbEnderecoUf;
    private javax.swing.JComboBox<String> cbLocalInternacao;
    private javax.swing.JComboBox<String> cbPedidoStatus;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao1;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao2;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao7;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao8;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao3;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao4;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto3;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto4;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JFormattedTextField ffAltPedDtPedido;
    private javax.swing.JFormattedTextField ffAltPedId;
    private javax.swing.JFormattedTextField ffDocumento;
    private javax.swing.JFormattedTextField ffPedidoDtEntrega;
    private javax.swing.JFormattedTextField ffPedidoDtPedido;
    private javax.swing.JFormattedTextField ffRelDoaDtFinal;
    private javax.swing.JFormattedTextField ffRelDoaDtFinal4;
    private javax.swing.JFormattedTextField ffRelDoaDtInicial;
    private javax.swing.JFormattedTextField ffRelDoaDtInicial4;
    private javax.swing.JFormattedTextField ffTelefone;
    private javax.swing.JFormattedTextField ftDoacaoData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jbRelDoaTorIte;
    private javax.swing.JLabel jbRelDoaTotDin;
    private javax.swing.JLabel jbRelDoaTotProd;
    private javax.swing.JLabel jbRelPedTotDin;
    private javax.swing.JLabel jbRelPedTotDin1;
    private javax.swing.JLabel jbRelPedTotDin2;
    private javax.swing.JLabel jbRelPedTotDin3;
    private javax.swing.JLabel lbAltPedCliente;
    private javax.swing.JLabel lbAltPedDtPedido;
    private javax.swing.JLabel lbAltPedId;
    private javax.swing.JLabel lbAltPedQtdMarmitas;
    private javax.swing.JLabel lbAltPedStatus;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbBuscarId;
    private javax.swing.JLabel lbBuscarNome;
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
    private javax.swing.JLabel lbPedidoId;
    private javax.swing.JLabel lbPedidoObservacao;
    private javax.swing.JLabel lbPedidoQtdMarmitas;
    private javax.swing.JLabel lbPedidoStatus;
    private javax.swing.JLabel lbPessoaTipo;
    private javax.swing.JLabel lbRelDoaDoador;
    private javax.swing.JLabel lbRelDoaDoador3;
    private javax.swing.JLabel lbRelDoaDtFinal;
    private javax.swing.JLabel lbRelDoaDtFinal4;
    private javax.swing.JLabel lbRelDoaDtInicial;
    private javax.swing.JLabel lbRelDoaDtInicial4;
    private javax.swing.JLabel lbRelDoaOrdenacao;
    private javax.swing.JLabel lbRelDoaOrdenacao3;
    private javax.swing.JLabel lbRelDoaProd;
    private javax.swing.JLabel lbRelDoaTpDoacao;
    private javax.swing.JLabel lbRelDoaTpDoacao3;
    private javax.swing.JLabel lbRelDoaTpDoacao4;
    private javax.swing.JLabel lbRelDoaTpProduto;
    private javax.swing.JLabel lbRelDoaTpProduto3;
    private javax.swing.JLabel lbRelDoaTpProduto4;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuDoacao;
    private javax.swing.JMenuItem menuDoacaoCadastrar;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuPedido;
    private javax.swing.JMenuItem menuPedidoAlterar;
    private javax.swing.JMenuItem menuPedidoCadastrar;
    private javax.swing.JMenu menuPessoa;
    private javax.swing.JMenuItem menuPessoaAlterar;
    private javax.swing.JMenuItem menuPessoaCadastrar;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioDoacao;
    private javax.swing.JMenuItem menuRelatorioPedido;
    private javax.swing.JPanel pnAlterarPedido;
    private javax.swing.JPanel pnAlterarPessoa;
    private javax.swing.JPanel pnBuscar;
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
    private javax.swing.JPanel pnPedido1;
    private javax.swing.JPanel pnPessoaCliente;
    private javax.swing.JPanel pnRelDoa;
    private javax.swing.JPanel pnRelFiltros;
    private javax.swing.JPanel pnRelFiltros1;
    private javax.swing.JPanel pnRelPed;
    private javax.swing.JPanel pnRelResultado;
    private javax.swing.JPanel pnRelResultado1;
    private javax.swing.JPanel pnRelatorioDoacao;
    private javax.swing.JPanel pnRelatorioPedido;
    private javax.swing.JRadioButton rbPessoaFisica;
    private javax.swing.JRadioButton rbPessoaJuridica;
    private javax.swing.JScrollPane spRelPedResultado;
    private javax.swing.JScrollPane spRelResultado;
    private javax.swing.JTextArea taDoacaoObservacao;
    private javax.swing.JTextArea taDoacaoObservacao1;
    private javax.swing.JTextArea taDoacaoObservacao2;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTable tableDoacaoProdutos;
    private javax.swing.JTable tableRelatorioDoacao;
    private javax.swing.JTable tableRelatorioPedido1;
    private javax.swing.JTextField tfAltPedCliente;
    private javax.swing.JLabel tfAltPedObs;
    private javax.swing.JTextField tfAltPedQtdMarmitas;
    private javax.swing.JTextField tfBuscarId;
    private javax.swing.JTextField tfBuscarNome;
    private javax.swing.JTextField tfDoacaoDoador;
    private javax.swing.JTextField tfDoacaoIdDoacao;
    private javax.swing.JTextField tfDoacaoIdDoador;
    private javax.swing.JTextField tfDoacaoQuantidade;
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
    private javax.swing.JFormattedTextField tfPedidoId;
    private javax.swing.JTextField tfPedidoQtdMarmitas;
    private javax.swing.JTextField tfQtdDias;
    private javax.swing.JTextField tfRelDoaDoador;
    private javax.swing.JTextField tfRelDoaDoador3;
    private javax.swing.JTextField tfRelDoaProd;
    private javax.swing.JTextField tfRelPedTotProd1;
    private javax.swing.JTextField tfRelPedTotProd2;
    private javax.swing.JTextField tfRelPedTotProd3;
    private javax.swing.JTextField tfRelPedTotProd4;
    private javax.swing.JTextField tfRelTotDin;
    private javax.swing.JTextField tfRelTotIte;
    private javax.swing.JTextField tfRelTotProd;
    // End of variables declaration//GEN-END:variables
}
