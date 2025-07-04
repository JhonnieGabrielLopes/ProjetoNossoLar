/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.edu.iftm.sistemanossolar.view;

import java.sql.Connection;

import br.edu.iftm.sistemanossolar.controller.doacao.ProdutoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.doacao.Produto.TipoProd;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AFSOUZA
 */
public class CadastroProduto extends javax.swing.JDialog {
    private static Telas tela;
    private static ProdutoController produtoController;
    /**
     * Creates new form CadastroProduto1
     */
    public CadastroProduto(java.awt.Frame parent, boolean modal, Connection conexao, Telas tela) {
        super(parent, modal);
        produtoController = new ProdutoController(conexao);
        this.tela = tela;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCadastrarProduto = new javax.swing.JPanel();
        lbCadProdTipo = new javax.swing.JLabel();
        cbCadProdTipoProduto = new javax.swing.JComboBox<>();
        lbCadProdProduto = new javax.swing.JLabel();
        tfCadProdProduto = new javax.swing.JTextField();
        btCadProdSalvar = new javax.swing.JButton();
        btCadProdLimpar = new javax.swing.JButton();
        btCadProdSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbCadProdTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCadProdTipo.setText("Tipo:");

        cbCadProdTipoProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCadProdTipoProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALIMENTO", "LIMPEZA", "OUTRO" }));

        lbCadProdProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCadProdProduto.setText("Descrição:");

        tfCadProdProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btCadProdSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadProdSalvar.setText("Salvar");
        btCadProdSalvar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btCadProdSalvarActionPerformed(evt);
                    }
                });
        btCadProdLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadProdLimpar.setText("Limpar");

        btCadProdSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadProdSair.setText("Sair");
        btCadProdSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadProdSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrarProdutoLayout = new javax.swing.GroupLayout(pnCadastrarProduto);
        pnCadastrarProduto.setLayout(pnCadastrarProdutoLayout);
        pnCadastrarProdutoLayout.setHorizontalGroup(
            pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCadProdTipo)
                    .addComponent(cbCadProdTipoProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCadProdSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCadProdProduto)
                    .addComponent(tfCadProdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCadastrarProdutoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btCadProdLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadProdSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnCadastrarProdutoLayout.setVerticalGroup(
            pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarProdutoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadProdTipo)
                    .addComponent(lbCadProdProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCadProdTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadProdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnCadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadProdSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadProdLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadProdSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadProdSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadProdCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCadProdCancelarActionPerformed

    private void btCadProdSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadProdCadastrarActionPerformed
        Produto produto = new Produto();
        produto.setNome(tfCadProdProduto.getText());
        if((String)cbCadProdTipoProduto.getSelectedItem() == "ALIMENTO"){
            produto.setTipo(TipoProd.ALIMENTO);
        }else if((String)cbCadProdTipoProduto.getSelectedItem() == "LIMPEZA"){
            produto.setTipo(TipoProd.LIMPEZA);
        }else if((String)cbCadProdTipoProduto.getSelectedItem() == "OUTRO"){
            produto.setTipo(TipoProd.OUTRO);
        }
        try{
            produtoController.cadastrarProduto(produto);
            JOptionPane.showMessageDialog(rootPane, "Produto Cadastrado", "Produto Cadstrado", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }catch(SQLException ex){
        }
    }//GEN-LAST:event_btCadProdCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadProdLimpar;
    private javax.swing.JButton btCadProdSair;
    private javax.swing.JButton btCadProdSalvar;
    private javax.swing.JComboBox<String> cbCadProdTipoProduto;
    private javax.swing.JLabel lbCadProdProduto;
    private javax.swing.JLabel lbCadProdTipo;
    private javax.swing.JPanel pnCadastrarProduto;
    private javax.swing.JTextField tfCadProdProduto;
    // End of variables declaration//GEN-END:variables
}
