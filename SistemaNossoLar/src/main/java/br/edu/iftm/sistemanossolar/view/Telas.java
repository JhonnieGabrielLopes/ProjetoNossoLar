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

/**
 *
 * @author AFSOUZA
 */
public class Telas extends javax.swing.JFrame {
    private CardLayout cl;
    private static CidadeController cidadeController;
    private static CadastroCidade cadastroCidade;
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
        initComponents();
        cl = (CardLayout) pnCard.getLayout();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPessoaTipo = new javax.swing.ButtonGroup();
        pnDadosPrincipal = new javax.swing.JPanel();
        pnMenuLateral = new javax.swing.JPanel();
        lbMenu = new javax.swing.JLabel();
        btCadastrarCliente = new javax.swing.JButton();
        btCadastrarDoador = new javax.swing.JButton();
        btCadastrarCidade = new javax.swing.JButton();
        pnCard = new javax.swing.JPanel();
        pnCadastroPessoaCliente = new javax.swing.JPanel();
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
        btLimpar = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();
        pnCadastroCidade = new javax.swing.JPanel();
        pnEndereco1 = new javax.swing.JPanel();
        lbLogradouro4 = new javax.swing.JLabel();
        lbLogradouro8 = new javax.swing.JLabel();
        cbEnderecoUf1 = new javax.swing.JComboBox<>();
        tfCadastroCidade = new javax.swing.JTextField();
        btRegistrar1 = new javax.swing.JButton();
        pnCadastroPessoaDoador = new javax.swing.JPanel();
        pnEnderecoDoador = new javax.swing.JPanel();
        tfEnderecoLogradouro1 = new javax.swing.JTextField();
        lbLogradouro1 = new javax.swing.JLabel();
        lbNumero1 = new javax.swing.JLabel();
        tfEnderecoNumero1 = new javax.swing.JTextField();
        tfEnderecoBairro1 = new javax.swing.JTextField();
        lbBairro1 = new javax.swing.JLabel();
        lbLogradouro7 = new javax.swing.JLabel();
        tfEnderecoComplemento1 = new javax.swing.JTextField();
        lbComplemento1 = new javax.swing.JLabel();
        cbEnderecoCidade1 = new javax.swing.JComboBox<>();
        tfEnderecoCep1 = new javax.swing.JTextField();
        lbLogradouro9 = new javax.swing.JLabel();
        lbLogradouro10 = new javax.swing.JLabel();
        cbEnderecoUf2 = new javax.swing.JComboBox<>();
        btAdicionarCidade1 = new javax.swing.JButton();
        pnPessoaDoador = new javax.swing.JPanel();
        tfNome1 = new javax.swing.JTextField();
        lbNome1 = new javax.swing.JLabel();
        ffTelefone1 = new javax.swing.JFormattedTextField();
        lbTelefone1 = new javax.swing.JLabel();
        lbEmail1 = new javax.swing.JLabel();
        tfEmail1 = new javax.swing.JTextField();
        lbObservacao1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taObservacao1 = new javax.swing.JTextArea();
        rbPessoaFisica1 = new javax.swing.JRadioButton();
        rbPessoaJuridica1 = new javax.swing.JRadioButton();
        lbPessoaTipo1 = new javax.swing.JLabel();
        lbDocumento1 = new javax.swing.JLabel();
        tfDocumento1 = new javax.swing.JTextField();
        lbNomePaciente5 = new javax.swing.JLabel();
        tfNumeroId1 = new javax.swing.JTextField();
        btLimparDoador = new javax.swing.JButton();
        btRegistrarDoador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(29, 29, 29));
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnMenuLateral.setBackground(new java.awt.Color(230, 230, 230));
        pnMenuLateral.setPreferredSize(new java.awt.Dimension(800, 300));

        lbMenu.setForeground(new java.awt.Color(0, 0, 0));
        lbMenu.setText("Menu Principal");

        btCadastrarCliente.setText("Cadastrar Cliente");
        btCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarClienteActionPerformed(evt);
            }
        });

        btCadastrarDoador.setText("Cadastrar Doador");
        btCadastrarDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarDoadorActionPerformed(evt);
            }
        });

        btCadastrarCidade.setText("Cadastrar Cidade");
        btCadastrarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLateralLayout = new javax.swing.GroupLayout(pnMenuLateral);
        pnMenuLateral.setLayout(pnMenuLateralLayout);
        pnMenuLateralLayout.setHorizontalGroup(
            pnMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLateralLayout.createSequentialGroup()
                .addGroup(pnMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnMenuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbMenu)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addComponent(btCadastrarDoador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCadastrarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnMenuLateralLayout.setVerticalGroup(
            pnMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCadastrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCadastrarDoador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCadastrarCidade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        cbEnderecoUf.setForeground(new java.awt.Color(0, 0, 0));
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

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assistente", "Beneficiário", "Doador" }));
        cbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Usuário");

        jLabel2.setText("Local de Internação");

        cbLocalInternacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hospital ", "Pronto Socorro" }));

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

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroPessoaClienteLayout = new javax.swing.GroupLayout(pnCadastroPessoaCliente);
        pnCadastroPessoaCliente.setLayout(pnCadastroPessoaClienteLayout);
        pnCadastroPessoaClienteLayout.setHorizontalGroup(
            pnCadastroPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnCadastroPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCadastroPessoaClienteLayout.setVerticalGroup(
            pnCadastroPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnCadastroPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                        .addComponent(pnPessoaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCadastroPessoaClienteLayout.createSequentialGroup()
                        .addComponent(pnEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                        .addGroup(pnCadastroPessoaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRegistrar)
                            .addComponent(btLimpar))
                        .addGap(29, 29, 29))))
        );

        pnCard.add(pnCadastroPessoaCliente, "beneficiario");

        pnEndereco1.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));

        lbLogradouro4.setText("Cidade:");

        lbLogradouro8.setText("UF");

        cbEnderecoUf1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        btRegistrar1.setText("Registrar");

        javax.swing.GroupLayout pnEndereco1Layout = new javax.swing.GroupLayout(pnEndereco1);
        pnEndereco1.setLayout(pnEndereco1Layout);
        pnEndereco1Layout.setHorizontalGroup(
            pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEndereco1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogradouro4)
                    .addComponent(tfCadastroCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEndereco1Layout.createSequentialGroup()
                        .addComponent(lbLogradouro8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbEnderecoUf1, 0, 112, Short.MAX_VALUE))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEndereco1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnEndereco1Layout.setVerticalGroup(
            pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEndereco1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogradouro8)
                    .addComponent(lbLogradouro4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEndereco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEnderecoUf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btRegistrar1)
                .addGap(227, 227, 227))
        );

        javax.swing.GroupLayout pnCadastroCidadeLayout = new javax.swing.GroupLayout(pnCadastroCidade);
        pnCadastroCidade.setLayout(pnCadastroCidadeLayout);
        pnCadastroCidadeLayout.setHorizontalGroup(
            pnCadastroCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroCidadeLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pnEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCadastroCidadeLayout.setVerticalGroup(
            pnCadastroCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroCidadeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCard.add(pnCadastroCidade, "cidade");

        pnEnderecoDoador.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));

        lbLogradouro1.setText("Logradouro:");

        lbNumero1.setText("Número:");

        lbBairro1.setText("Bairro:");

        lbLogradouro7.setText("Cidade:");

        lbComplemento1.setText("Complemento:");

        cbEnderecoCidade1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbLogradouro9.setText("CEP:");

        lbLogradouro10.setText("UF");

        cbEnderecoUf2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        btAdicionarCidade1.setText("+");
        btAdicionarCidade1.setToolTipText("Cadastrar novo endereço");

        javax.swing.GroupLayout pnEnderecoDoadorLayout = new javax.swing.GroupLayout(pnEnderecoDoador);
        pnEnderecoDoador.setLayout(pnEnderecoDoadorLayout);
        pnEnderecoDoadorLayout.setHorizontalGroup(
            pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoDoadorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEnderecoDoadorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero1)
                            .addComponent(tfEnderecoNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro1)
                            .addComponent(tfEnderecoBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbComplemento1)
                            .addComponent(tfEnderecoComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(pnEnderecoDoadorLayout.createSequentialGroup()
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogradouro9)
                            .addComponent(tfEnderecoCep1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogradouro7)
                            .addComponent(cbEnderecoCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEnderecoDoadorLayout.createSequentialGroup()
                                .addComponent(lbLogradouro10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbEnderecoUf2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btAdicionarCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(pnEnderecoDoadorLayout.createSequentialGroup()
                        .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEnderecoLogradouro1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLogradouro1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnEnderecoDoadorLayout.setVerticalGroup(
            pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoDoadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdicionarCidade1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoDoadorLayout.createSequentialGroup()
                        .addComponent(lbLogradouro7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnderecoCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoDoadorLayout.createSequentialGroup()
                        .addComponent(lbLogradouro10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnderecoUf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEnderecoDoadorLayout.createSequentialGroup()
                        .addComponent(lbLogradouro9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEnderecoCep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbLogradouro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoLogradouro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero1)
                    .addComponent(lbBairro1)
                    .addComponent(lbComplemento1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnderecoNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEnderecoComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        pnPessoaDoador.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Doador"));

        lbNome1.setText("Nome:");

        lbTelefone1.setText("Telefone:");

        lbEmail1.setText("E-mail:");

        lbObservacao1.setText("Observação:");

        taObservacao1.setColumns(20);
        taObservacao1.setLineWrap(true);
        taObservacao1.setRows(5);
        jScrollPane2.setViewportView(taObservacao1);

        buttonGroupPessoaTipo.add(rbPessoaFisica1);
        rbPessoaFisica1.setText("Pessoa Física (CPF)");

        buttonGroupPessoaTipo.add(rbPessoaJuridica1);
        rbPessoaJuridica1.setText("Pessoa Jurídica (CNPJ)");

        lbPessoaTipo1.setText("Tipo:");

        lbDocumento1.setText("Nº do Documento:");

        lbNomePaciente5.setText("ID Gerado do Cadastro:");

        tfNumeroId1.setToolTipText("");

        javax.swing.GroupLayout pnPessoaDoadorLayout = new javax.swing.GroupLayout(pnPessoaDoador);
        pnPessoaDoador.setLayout(pnPessoaDoadorLayout);
        pnPessoaDoadorLayout.setHorizontalGroup(
            pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPessoaDoadorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNomePaciente5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNumeroId1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbDocumento1)
                        .addComponent(lbPessoaTipo1)
                        .addGroup(pnPessoaDoadorLayout.createSequentialGroup()
                            .addComponent(rbPessoaFisica1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbPessoaJuridica1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                        .addComponent(lbObservacao1)
                        .addComponent(lbEmail1)
                        .addComponent(lbTelefone1)
                        .addComponent(lbNome1)
                        .addComponent(tfEmail1)
                        .addComponent(ffTelefone1)
                        .addComponent(tfNome1)
                        .addComponent(tfDocumento1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnPessoaDoadorLayout.setVerticalGroup(
            pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPessoaDoadorLayout.createSequentialGroup()
                .addComponent(lbNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTelefone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ffTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEmail1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPessoaTipo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPessoaFisica1)
                    .addComponent(rbPessoaJuridica1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDocumento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbObservacao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNomePaciente5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNumeroId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btLimparDoador.setText("Limpar");

        btRegistrarDoador.setText("Registrar");

        javax.swing.GroupLayout pnCadastroPessoaDoadorLayout = new javax.swing.GroupLayout(pnCadastroPessoaDoador);
        pnCadastroPessoaDoador.setLayout(pnCadastroPessoaDoadorLayout);
        pnCadastroPessoaDoadorLayout.setHorizontalGroup(
            pnCadastroPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnCadastroPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                        .addComponent(btLimparDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRegistrarDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                        .addComponent(pnPessoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnEnderecoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCadastroPessoaDoadorLayout.setVerticalGroup(
            pnCadastroPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnCadastroPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                        .addComponent(pnPessoaDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCadastroPessoaDoadorLayout.createSequentialGroup()
                        .addComponent(pnEnderecoDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                        .addGroup(pnCadastroPessoaDoadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRegistrarDoador)
                            .addComponent(btLimparDoador))
                        .addGap(29, 29, 29))))
        );

        pnCard.add(pnCadastroPessoaDoador, "doador");

        javax.swing.GroupLayout pnDadosPrincipalLayout = new javax.swing.GroupLayout(pnDadosPrincipal);
        pnDadosPrincipal.setLayout(pnDadosPrincipalLayout);
        pnDadosPrincipalLayout.setHorizontalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnMenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDadosPrincipalLayout.setVerticalGroup(
            pnDadosPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
            .addGroup(pnDadosPrincipalLayout.createSequentialGroup()
                .addComponent(pnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        getContentPane().add(pnDadosPrincipal, java.awt.BorderLayout.CENTER);

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

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparcamposCadastroUsuario();
    }//GEN-LAST:event_btLimparActionPerformed
    
    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        Cidade cidadeEscolhida = (Cidade) cbEnderecoCidade.getSelectedItem();
        Endereco endereco = new Endereco(
            tfEnderecoLogradouro.getText(),
            Integer.parseInt(tfEnderecoNumero.getText()),
            tfEnderecoBairro.getText(),
            tfEnderecoCep.getText(),
            tfEnderecoComplemento.getText(),
            cidadeEscolhida);

        Paciente paciente = new Paciente();
        paciente.setNome(tfNomePaciente.getText());
        
        try{
            if (tfQtdDias.getText()!= null && !tfQtdDias.getText().trim().isEmpty()){
                paciente.setPrevisaoDias(Integer.parseInt(tfQtdDias.getText()));
            }
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        
        String telefone = ffTelefone.getText().replaceAll("[^\\d]", "");
        Pessoa novaPessoa = new Pessoa(
            tfNome.getText(),
            telefone,
            endereco
        );

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
    }//GEN-LAST:event_btRegistrarActionPerformed

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
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCidade;
    private javax.swing.JButton btAdicionarCidade1;
    private javax.swing.JButton btCadastrarCidade;
    private javax.swing.JButton btCadastrarCliente;
    private javax.swing.JButton btCadastrarDoador;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btLimparDoador;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btRegistrar1;
    private javax.swing.JButton btRegistrarDoador;
    private javax.swing.ButtonGroup buttonGroupPessoaTipo;
    private javax.swing.JComboBox<Cidade> cbEnderecoCidade;
    private javax.swing.JComboBox<String> cbEnderecoCidade1;
    private javax.swing.JComboBox<String> cbEnderecoUf;
    private javax.swing.JComboBox<String> cbEnderecoUf1;
    private javax.swing.JComboBox<String> cbEnderecoUf2;
    private javax.swing.JComboBox<String> cbLocalInternacao;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JFormattedTextField ffDocumento;
    private javax.swing.JFormattedTextField ffTelefone;
    private javax.swing.JFormattedTextField ffTelefone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbBairro1;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbComplemento1;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbDocumento1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbLogradouro1;
    private javax.swing.JLabel lbLogradouro10;
    private javax.swing.JLabel lbLogradouro3;
    private javax.swing.JLabel lbLogradouro4;
    private javax.swing.JLabel lbLogradouro5;
    private javax.swing.JLabel lbLogradouro6;
    private javax.swing.JLabel lbLogradouro7;
    private javax.swing.JLabel lbLogradouro8;
    private javax.swing.JLabel lbLogradouro9;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JLabel lbNomePaciente;
    private javax.swing.JLabel lbNomePaciente1;
    private javax.swing.JLabel lbNomePaciente5;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbNumero1;
    private javax.swing.JLabel lbObservacao;
    private javax.swing.JLabel lbObservacao1;
    private javax.swing.JLabel lbPessoaTipo;
    private javax.swing.JLabel lbPessoaTipo1;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTelefone1;
    private javax.swing.JPanel pnCadastroCidade;
    private javax.swing.JPanel pnCadastroPessoaCliente;
    private javax.swing.JPanel pnCadastroPessoaDoador;
    private javax.swing.JPanel pnCard;
    private javax.swing.JPanel pnDadosPrincipal;
    private javax.swing.JPanel pnEndereco1;
    private javax.swing.JPanel pnEnderecoCliente;
    private javax.swing.JPanel pnEnderecoDoador;
    private javax.swing.JPanel pnMenuLateral;
    private javax.swing.JPanel pnPessoaCliente;
    private javax.swing.JPanel pnPessoaDoador;
    private javax.swing.JRadioButton rbPessoaFisica;
    private javax.swing.JRadioButton rbPessoaFisica1;
    private javax.swing.JRadioButton rbPessoaJuridica;
    private javax.swing.JRadioButton rbPessoaJuridica1;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextArea taObservacao1;
    private javax.swing.JTextField tfCadastroCidade;
    private javax.swing.JTextField tfDocumento1;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfEnderecoBairro;
    private javax.swing.JTextField tfEnderecoBairro1;
    private javax.swing.JTextField tfEnderecoCep;
    private javax.swing.JTextField tfEnderecoCep1;
    private javax.swing.JTextField tfEnderecoComplemento;
    private javax.swing.JTextField tfEnderecoComplemento1;
    private javax.swing.JTextField tfEnderecoLogradouro;
    private javax.swing.JTextField tfEnderecoLogradouro1;
    private javax.swing.JTextField tfEnderecoNumero;
    private javax.swing.JTextField tfEnderecoNumero1;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNome1;
    private javax.swing.JTextField tfNomePaciente;
    private javax.swing.JTextField tfNumeroId1;
    private javax.swing.JTextField tfQtdDias;
    // End of variables declaration//GEN-END:variables
}
