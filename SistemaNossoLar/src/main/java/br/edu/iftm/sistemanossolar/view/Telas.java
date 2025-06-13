/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.iftm.sistemanossolar.view;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
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
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;

/**
 *
 * @author AFSOUZA
 */
public class Telas extends javax.swing.JFrame {
    private CardLayout cl;
    private static CidadeController cidadeController;
    private static CadastroCidade cadastroCidade;
    private static CadastroProduto cadastroProduto;
    private static PessoaController pessoaController;
    private static EnderecoController enderecoController;
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
        cadastroCidade = new CadastroCidade(this, true, conexao, this);
        cadastroProduto = new CadastroProduto(this, true, conexao, this);
        initComponents();
        cl = (CardLayout) pnCard.getLayout();
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
        lbDoacaoDoador = new javax.swing.JLabel();
        tfDoacaoIdDoador = new javax.swing.JTextField();
        tfDoacaoDoador = new javax.swing.JTextField();
        btDoacaoBuscarDoador = new javax.swing.JButton();
        lbDoacaoTipo = new javax.swing.JLabel();
        cbDoacaoTipo = new javax.swing.JComboBox<>();
        lbDoacaoValor = new javax.swing.JLabel();
        tfDoacaoValor = new javax.swing.JFormattedTextField();
        lbDoacaoData = new javax.swing.JLabel();
        ftDoacaoData = new javax.swing.JFormattedTextField();
        lbDoacaoObservacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDoacaoObservacao = new javax.swing.JTextArea();
        btDoacaoDeletar = new javax.swing.JButton();
        btDoacaoRecibo = new javax.swing.JButton();
        btDoacaoBuscarDoador2 = new javax.swing.JButton();
        pnDoacaoProduto = new javax.swing.JPanel();
        lbDoacaoSelecionarProd = new javax.swing.JLabel();
        lbDoacaoQuantidade = new javax.swing.JLabel();
        tfDoacaoQuantidade = new javax.swing.JTextField();
        btDoacaoAddProd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoacaoProdutos = new javax.swing.JTable();
        btDoacaoAltProd = new javax.swing.JButton();
        btDoacaoDelProd = new javax.swing.JButton();
        tfDoacaoDoador1 = new javax.swing.JTextField();
        btProdutoNovo = new javax.swing.JButton();
        btDoacaoRegistrarDoacao = new javax.swing.JButton();
        btDoacaoLimpar = new javax.swing.JButton();
        btDoacaoLimpar1 = new javax.swing.JButton();
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
        btRelDoaExtrair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbRelDoaDtInicial = new javax.swing.JLabel();
        ffRelDoaDtInicial = new javax.swing.JFormattedTextField();
        lbRelDoaDtFinal = new javax.swing.JLabel();
        ffRelDoaDtFinal = new javax.swing.JFormattedTextField();
        lbRelDoaTpDoacao = new javax.swing.JLabel();
        cbRelDoaTpDoacao = new javax.swing.JComboBox<>();
        lbRelDoaTpProduto = new javax.swing.JLabel();
        cbRelDoaTpProduto = new javax.swing.JComboBox<>();
        lbRelDoaDoador = new javax.swing.JLabel();
        tfRelDoaDoador = new javax.swing.JTextField();
        lbRelDoaOrdenacao = new javax.swing.JLabel();
        cbRelDoaOrdenacao = new javax.swing.JComboBox<>();
        btRelDoaFiltrar = new javax.swing.JButton();
        btRelDoaFiltrar2 = new javax.swing.JButton();
        cbRelDoaOrdenacao1 = new javax.swing.JComboBox<>();
        lbRelDoaDoador1 = new javax.swing.JLabel();
        tfRelDoaDoador1 = new javax.swing.JTextField();
        btRelDoaFiltrar3 = new javax.swing.JButton();
        btRelDoaExtrair1 = new javax.swing.JButton();
        btRelDoaExtrair2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbRelDoaTotDin1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jbRelDoaTotDin2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jbRelDoaTotDin = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableRelatorioDoacao = new javax.swing.JTable();
        pnRelatorioPedido = new javax.swing.JPanel();
        pnRelPed = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableRelatorioPedido = new javax.swing.JTable();
        lbRelDoaDtInicial1 = new javax.swing.JLabel();
        ffRelDoaDtInicial1 = new javax.swing.JFormattedTextField();
        lbRelDoaDtFinal1 = new javax.swing.JLabel();
        ffRelDoaDtFinal1 = new javax.swing.JFormattedTextField();
        lbRelPedStatusPedido = new javax.swing.JLabel();
        cbRelPedStatusPedido = new javax.swing.JComboBox<>();
        lbRelPedCliente = new javax.swing.JLabel();
        tfRelPedCliente = new javax.swing.JTextField();
        lbRelPedLocal = new javax.swing.JLabel();
        cbRelPedLocal = new javax.swing.JComboBox<>();
        lbRelPedPessoa = new javax.swing.JLabel();
        cbRelPedPessoa = new javax.swing.JComboBox<>();
        lbRelPedOrdenacao = new javax.swing.JLabel();
        cbRelPedOrdenacao = new javax.swing.JComboBox<>();
        btRelPedFiltrar = new javax.swing.JButton();
        btRelPedExtrair = new javax.swing.JButton();
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
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnCadastroPessoaLayout.setVerticalGroup(
            pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(203, Short.MAX_VALUE))
                    .addGroup(pnCadastroPessoaLayout.createSequentialGroup()
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                        .addGroup(pnCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastroPessoaRegistrar)
                            .addComponent(btCadastroPessoaLimpar))
                        .addGap(29, 29, 29))))
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
                .addContainerGap(700, Short.MAX_VALUE))
        );
        pnAlterarPessoaLayout.setVerticalGroup(
            pnAlterarPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPessoaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(589, Short.MAX_VALUE))
        );

        pnCard.add(pnAlterarPessoa, "cdAlterarPessoa");

        pnDoacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Doação"));

        lbDoacaoIdDoacao.setText("Código");

        tfDoacaoIdDoacao.setEditable(false);

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

        btDoacaoBuscarDoador.setText("Buscar");

        lbDoacaoTipo.setText("Tipo");

        cbDoacaoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Doação" }));

        lbDoacaoValor.setText("Valor");

        try {
            tfDoacaoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDoacaoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoValorActionPerformed(evt);
            }
        });

        lbDoacaoData.setText("Data da Doação");

        ftDoacaoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftDoacaoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftDoacaoDataActionPerformed(evt);
            }
        });

        lbDoacaoObservacao.setText("Observação");

        taDoacaoObservacao.setColumns(20);
        taDoacaoObservacao.setRows(5);
        taDoacaoObservacao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDoacaoObservacao);

        btDoacaoDeletar.setText("Deletar");

        btDoacaoRecibo.setText("Gerar Recibo");

        btDoacaoBuscarDoador2.setText("Buscar");

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
                        .addComponent(btDoacaoBuscarDoador2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(btDoacaoBuscarDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btDoacaoBuscarDoador2))
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
                .addGroup(pnDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoDeletar)
                    .addComponent(btDoacaoRecibo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnDoacaoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        lbDoacaoSelecionarProd.setText("Descrição");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos doados"));

        tableDoacaoProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Alimento", "Arroz",  new Integer(4)},
                {"Limpeza", "Detergente",  new Integer(2)},
                {"Outro", "Panela",  new Integer(1)},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableDoacaoProdutos);

        btDoacaoAltProd.setText("Alterar");

        btDoacaoDelProd.setText("Deletar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btDoacaoAltProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoDelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoacaoDelProd)
                    .addComponent(btDoacaoAltProd))
                .addGap(12, 12, 12))
        );

        tfDoacaoDoador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDoacaoDoador1ActionPerformed(evt);
            }
        });

        btProdutoNovo.setText("Buscar");
        btProdutoNovo.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btProdutoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutoNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDoacaoProdutoLayout = new javax.swing.GroupLayout(pnDoacaoProduto);
        pnDoacaoProduto.setLayout(pnDoacaoProdutoLayout);
        pnDoacaoProdutoLayout.setHorizontalGroup(
            pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                        .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoSelecionarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(tfDoacaoDoador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btProdutoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(tfDoacaoDoador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btProdutoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoacaoProdutoLayout.createSequentialGroup()
                                .addComponent(lbDoacaoQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnDoacaoProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfDoacaoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btDoacaoAddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        btDoacaoRegistrarDoacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoRegistrarDoacao.setText("Registrar Doação");

        btDoacaoLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoLimpar.setText("Cancelar");

        btDoacaoLimpar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDoacaoLimpar1.setText("Relatório");

        javax.swing.GroupLayout pnCadastrarDoacaoLayout = new javax.swing.GroupLayout(pnCadastrarDoacao);
        pnCadastrarDoacao.setLayout(pnCadastrarDoacaoLayout);
        pnCadastrarDoacaoLayout.setHorizontalGroup(
            pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarDoacaoLayout.createSequentialGroup()
                        .addComponent(btDoacaoRegistrarDoacao)
                        .addGap(18, 18, 18)
                        .addComponent(btDoacaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pnCadastrarDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDoacaoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDoacaoLimpar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
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
                    .addComponent(btDoacaoLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
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
                .addContainerGap(601, Short.MAX_VALUE))
        );
        pnCadastrarPedidoLayout.setVerticalGroup(
            pnCadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarPedidoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
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
                .addContainerGap(420, Short.MAX_VALUE))
        );
        pnAlterarPedidoLayout.setVerticalGroup(
            pnAlterarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarPedidoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pnPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        pnCard.add(pnAlterarPedido, "cdAlterarPedido");

        pnRelDoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório Doação"));

        btRelDoaExtrair.setText("Salvar Relatório");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        lbRelDoaDtInicial.setText("Data Inicial");

        lbRelDoaDtFinal.setText("Data Final");

        lbRelDoaTpDoacao.setText("Tipo de Doação");

        cbRelDoaTpDoacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Produto", "Dinheiro" }));

        lbRelDoaTpProduto.setText("Tipo de Produto");

        cbRelDoaTpProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento", "Limpeza", "Outros" }));

        lbRelDoaDoador.setText("Doador");

        lbRelDoaOrdenacao.setText("Ordenação");

        cbRelDoaOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Código", "Nome do Doador", "Valor", "Quantidade de Produtos" }));

        btRelDoaFiltrar.setText("Filtrar");

        btRelDoaFiltrar2.setText("Buscar");

        cbRelDoaOrdenacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrente", "Crescente" }));

        lbRelDoaDoador1.setText("Produto");

        btRelDoaFiltrar3.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffRelDoaDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelDoaDtInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRelDoaDtFinal)
                            .addComponent(ffRelDoaDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaOrdenacao)
                            .addComponent(cbRelDoaOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRelDoaOrdenacao1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRelDoaDoador1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaDoador)
                            .addComponent(tfRelDoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRelDoaDoador1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRelDoaFiltrar3)
                            .addComponent(btRelDoaFiltrar2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaTpProduto)
                            .addComponent(cbRelDoaTpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbRelDoaTpDoacao)
                    .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRelDoaFiltrar2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbRelDoaDtInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbRelDoaDtFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbRelDoaDoador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRelDoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbRelDoaTpDoacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRelDoaTpDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRelDoaFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbRelDoaOrdenacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbRelDoaOrdenacao1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbRelDoaDoador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfRelDoaDoador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btRelDoaFiltrar3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbRelDoaTpProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRelDoaTpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );

        btRelDoaExtrair1.setText("Limpar");

        btRelDoaExtrair2.setText("Voltar");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        jbRelDoaTotDin1.setText("Produtos total");

        jTextField2.setEditable(false);
        jTextField2.setText("0");

        jbRelDoaTotDin2.setText("Itens total");

        jTextField3.setEditable(false);
        jTextField3.setText("0");

        jbRelDoaTotDin.setText("Valor total");

        jTextField1.setEditable(false);
        jTextField1.setText("R$ 0,00");

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
                "Código", "Doador", "Tipo da Doação", "Valor", "Produtos", "Observação", "Data"
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
        jScrollPane6.setViewportView(tableRelatorioDoacao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotDin)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotDin1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRelDoaTotDin2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jbRelDoaTotDin1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jbRelDoaTotDin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbRelDoaTotDin2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnRelDoaLayout = new javax.swing.GroupLayout(pnRelDoa);
        pnRelDoa.setLayout(pnRelDoaLayout);
        pnRelDoaLayout.setHorizontalGroup(
            pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelDoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRelDoaLayout.createSequentialGroup()
                        .addComponent(btRelDoaExtrair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaExtrair1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRelDoaExtrair2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnRelDoaLayout.setVerticalGroup(
            pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelDoaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnRelDoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelDoaExtrair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoaExtrair1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelDoaExtrair2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnRelatorioDoacaoLayout = new javax.swing.GroupLayout(pnRelatorioDoacao);
        pnRelatorioDoacao.setLayout(pnRelatorioDoacaoLayout);
        pnRelatorioDoacaoLayout.setHorizontalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnRelatorioDoacaoLayout.setVerticalGroup(
            pnRelatorioDoacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioDoacaoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnRelDoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioDoacao, "relatorioDoacao");
        pnRelatorioDoacao.getAccessibleContext().setAccessibleName("");

        pnRelPed.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório Pedido"));

        tableRelatorioPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "12/01/2025", "15/01/2025", "Alan", "Beneficiário", "Pendente", "2", "Araguari", "MG", "Solicitação para 2 pessoas"},
                {"2", "22/04/2025", "22/04/2025", "Joice", "Assistente", "Finalizado", "4", "Patos de Minas", "MG", "4 Pessoas no hospital"},
                {"3", "05/05/2025", "08/05/2025", "Jhonnie", "Assistente", "Finalizado", "3", "Paracatu", "MG", ""},
                {"4", "08/06/2025", "", "Luiz", null, "Cancelado", "2", "Cristalina", "GO", "Paciente não veio"}
            },
            new String [] {
                "ID do Pedido", "Data do Pedido", "Data da Entrega", "Nome do Cliente", "Tipo Pessoa", "Status Pedido", "Qtd Marmitas", "Local/Cidade", "UF", "Observação"
            }
        ));
        jScrollPane7.setViewportView(tableRelatorioPedido);

        lbRelDoaDtInicial1.setText("Data Pedido");

        ffRelDoaDtInicial1.setText(" ____ / ____ / ____");

        lbRelDoaDtFinal1.setText("Data Entrega");

        ffRelDoaDtFinal1.setText(" ____ / ____ / ____");

        lbRelPedStatusPedido.setText("Status Pedido");

        cbRelPedStatusPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Finalizado", "Pendente", "Cancelado", " " }));

        lbRelPedCliente.setText("Cliente");

        lbRelPedLocal.setText("Local/Cidade");

        cbRelPedLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Araguari", "Patos de Minas", "Paracatu", " " }));

        lbRelPedPessoa.setText("Tipo Pessoa");

        cbRelPedPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beneficiário", "Assistente", " " }));
        cbRelPedPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelPedPessoaActionPerformed(evt);
            }
        });

        lbRelPedOrdenacao.setText("Ordenação");

        cbRelPedOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data do Pedido", "Data da Entrega", "ID", "Nome do Cliente", "Status", "Qtd Marmitas" }));
        cbRelPedOrdenacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRelPedOrdenacaoActionPerformed(evt);
            }
        });

        btRelPedFiltrar.setText("Filtrar");
        btRelPedFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelPedFiltrarActionPerformed(evt);
            }
        });

        btRelPedExtrair.setText("Extrair relatório");

        javax.swing.GroupLayout pnRelPedLayout = new javax.swing.GroupLayout(pnRelPed);
        pnRelPed.setLayout(pnRelPedLayout);
        pnRelPedLayout.setHorizontalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnRelPedLayout.createSequentialGroup()
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelDoaDtInicial1)
                            .addComponent(ffRelDoaDtInicial1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffRelDoaDtFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelDoaDtFinal1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRelPedStatusPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelPedStatusPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedCliente)
                            .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelPedLocal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedPessoa)
                            .addComponent(cbRelPedPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRelPedOrdenacao)
                            .addGroup(pnRelPedLayout.createSequentialGroup()
                                .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRelPedFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btRelPedExtrair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnRelPedLayout.setVerticalGroup(
            pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelPedLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRelPedLayout.createSequentialGroup()
                        .addComponent(lbRelDoaDtInicial1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffRelDoaDtInicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRelPedLayout.createSequentialGroup()
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRelDoaDtFinal1)
                            .addComponent(lbRelPedStatusPedido)
                            .addComponent(lbRelPedCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ffRelDoaDtFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRelPedStatusPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRelPedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelPedLayout.createSequentialGroup()
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRelPedLocal)
                            .addComponent(lbRelPedPessoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRelPedLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRelPedPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRelPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbRelPedOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btRelPedFiltrar))
                    .addGroup(pnRelPedLayout.createSequentialGroup()
                        .addComponent(lbRelPedOrdenacao)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRelPedExtrair)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRelatorioPedidoLayout = new javax.swing.GroupLayout(pnRelatorioPedido);
        pnRelatorioPedido.setLayout(pnRelatorioPedidoLayout);
        pnRelatorioPedidoLayout.setHorizontalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRelatorioPedidoLayout.setVerticalGroup(
            pnRelatorioPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRelatorioPedidoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnRelPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pnCard.add(pnRelatorioPedido, "relatorioPedido");

        javax.swing.GroupLayout pnDadosPrincipalLayout = new javax.swing.GroupLayout(pnDadosPrincipal);
        pnDadosPrincipal.setLayout(pnDadosPrincipalLayout);
        pnDadosPrincipalLayout.setHorizontalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnDadosPrincipalLayout.setVerticalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnDadosPrincipal, java.awt.BorderLayout.CENTER);

        menuBarra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        menuInicio.setText("Inicio");
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

    private void cbRelPedPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelPedPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelPedPessoaActionPerformed

    private void cbRelPedOrdenacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRelPedOrdenacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRelPedOrdenacaoActionPerformed

    private void btRelPedFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelPedFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelPedFiltrarActionPerformed

    private void menuRelatorioDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioDoacaoActionPerformed
        cl.show(pnCard, "relatorioDoacao");
    }//GEN-LAST:event_menuRelatorioDoacaoActionPerformed

    private void menuRelatorioPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioPedidoActionPerformed
        cl.show(pnCard, "relatorioPedido");
    }//GEN-LAST:event_menuRelatorioPedidoActionPerformed

    private void btProdutoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutoNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btProdutoNovoActionPerformed

    private void tfDoacaoDoador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDoacaoDoador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDoacaoDoador1ActionPerformed
    
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
    private javax.swing.JButton btDoacaoBuscarDoador;
    private javax.swing.JButton btDoacaoBuscarDoador2;
    private javax.swing.JButton btDoacaoDelProd;
    private javax.swing.JButton btDoacaoDeletar;
    private javax.swing.JButton btDoacaoLimpar;
    private javax.swing.JButton btDoacaoLimpar1;
    private javax.swing.JButton btDoacaoRecibo;
    private javax.swing.JButton btDoacaoRegistrarDoacao;
    private javax.swing.JButton btPedidoBuscarCliente;
    private javax.swing.JButton btPedidoLimpar;
    private javax.swing.JButton btPedidoRegistrar;
    private javax.swing.JButton btProdutoNovo;
    private javax.swing.JButton btRelDoaExtrair;
    private javax.swing.JButton btRelDoaExtrair1;
    private javax.swing.JButton btRelDoaExtrair2;
    private javax.swing.JButton btRelDoaFiltrar;
    private javax.swing.JButton btRelDoaFiltrar2;
    private javax.swing.JButton btRelDoaFiltrar3;
    private javax.swing.JButton btRelPedExtrair;
    private javax.swing.JButton btRelPedFiltrar;
    private javax.swing.ButtonGroup buttonGroupPessoaTipo;
    private javax.swing.JComboBox<String> cbAltPedStatus;
    private javax.swing.JComboBox<String> cbDoacaoTipo;
    private javax.swing.JComboBox<Cidade> cbEnderecoCidade;
    private javax.swing.JComboBox<String> cbEnderecoUf;
    private javax.swing.JComboBox<String> cbLocalInternacao;
    private javax.swing.JComboBox<String> cbPedidoStatus;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao;
    private javax.swing.JComboBox<String> cbRelDoaOrdenacao1;
    private javax.swing.JComboBox<String> cbRelDoaTpDoacao;
    private javax.swing.JComboBox<String> cbRelDoaTpProduto;
    private javax.swing.JComboBox<String> cbRelPedLocal;
    private javax.swing.JComboBox<String> cbRelPedOrdenacao;
    private javax.swing.JComboBox<String> cbRelPedPessoa;
    private javax.swing.JComboBox<String> cbRelPedStatusPedido;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JFormattedTextField ffAltPedDtPedido;
    private javax.swing.JFormattedTextField ffAltPedId;
    private javax.swing.JFormattedTextField ffDocumento;
    private javax.swing.JFormattedTextField ffPedidoDtEntrega;
    private javax.swing.JFormattedTextField ffPedidoDtPedido;
    private javax.swing.JFormattedTextField ffRelDoaDtFinal;
    private javax.swing.JFormattedTextField ffRelDoaDtFinal1;
    private javax.swing.JFormattedTextField ffRelDoaDtInicial;
    private javax.swing.JFormattedTextField ffRelDoaDtInicial1;
    private javax.swing.JFormattedTextField ffTelefone;
    private javax.swing.JFormattedTextField ftDoacaoData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel jbRelDoaTotDin;
    private javax.swing.JLabel jbRelDoaTotDin1;
    private javax.swing.JLabel jbRelDoaTotDin2;
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
    private javax.swing.JLabel lbRelDoaDoador1;
    private javax.swing.JLabel lbRelDoaDtFinal;
    private javax.swing.JLabel lbRelDoaDtFinal1;
    private javax.swing.JLabel lbRelDoaDtInicial;
    private javax.swing.JLabel lbRelDoaDtInicial1;
    private javax.swing.JLabel lbRelDoaOrdenacao;
    private javax.swing.JLabel lbRelDoaTpDoacao;
    private javax.swing.JLabel lbRelDoaTpProduto;
    private javax.swing.JLabel lbRelPedCliente;
    private javax.swing.JLabel lbRelPedLocal;
    private javax.swing.JLabel lbRelPedOrdenacao;
    private javax.swing.JLabel lbRelPedPessoa;
    private javax.swing.JLabel lbRelPedStatusPedido;
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
    private javax.swing.JPanel pnPedido;
    private javax.swing.JPanel pnPedido1;
    private javax.swing.JPanel pnPessoaCliente;
    private javax.swing.JPanel pnRelDoa;
    private javax.swing.JPanel pnRelPed;
    private javax.swing.JPanel pnRelatorioDoacao;
    private javax.swing.JPanel pnRelatorioPedido;
    private javax.swing.JRadioButton rbPessoaFisica;
    private javax.swing.JRadioButton rbPessoaJuridica;
    private javax.swing.JTextArea taDoacaoObservacao;
    private javax.swing.JTextArea taDoacaoObservacao1;
    private javax.swing.JTextArea taDoacaoObservacao2;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTable tableDoacaoProdutos;
    private javax.swing.JTable tableRelatorioDoacao;
    private javax.swing.JTable tableRelatorioPedido;
    private javax.swing.JTextField tfAltPedCliente;
    private javax.swing.JLabel tfAltPedObs;
    private javax.swing.JTextField tfAltPedQtdMarmitas;
    private javax.swing.JTextField tfBuscarId;
    private javax.swing.JTextField tfBuscarNome;
    private javax.swing.JTextField tfDoacaoDoador;
    private javax.swing.JTextField tfDoacaoDoador1;
    private javax.swing.JTextField tfDoacaoIdDoacao;
    private javax.swing.JTextField tfDoacaoIdDoador;
    private javax.swing.JTextField tfDoacaoQuantidade;
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
    private javax.swing.JTextField tfRelDoaDoador1;
    private javax.swing.JTextField tfRelPedCliente;
    // End of variables declaration//GEN-END:variables
}
