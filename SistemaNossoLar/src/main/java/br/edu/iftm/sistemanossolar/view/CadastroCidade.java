package br.edu.iftm.sistemanossolar.view;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonn
 */
public class CadastroCidade extends javax.swing.JDialog {
    private static CidadeController cidadeController;
    private static Telas tela;
    
    public CadastroCidade(java.awt.Frame parent, boolean modal, Connection conexao, Telas tela) {
        super(parent, modal);
        cidadeController = new CidadeController(conexao);
        this.tela = tela;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCadastrarCidade = new javax.swing.JPanel();
        lbCadCidCidade = new javax.swing.JLabel();
        tfCadCidCidade = new javax.swing.JTextField();
        lbCadCidUf = new javax.swing.JLabel();
        cbCadCidUf = new javax.swing.JComboBox<>();
        btCadCidCadastrar = new javax.swing.JButton();
        btCadCidLimpar = new javax.swing.JButton();
        btCadCidSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");

        lbCadCidCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCadCidCidade.setText("Cidade:");

        tfCadCidCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbCadCidUf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCadCidUf.setText("UF:");

        cbCadCidUf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCadCidUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MT", "MS", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbCadCidUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCadCidUfActionPerformed(evt);
            }
        });

        btCadCidCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadCidCadastrar.setText("Salvar");
        btCadCidCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadCidCadastrarActionPerformed(evt);
            }
        });

        btCadCidLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadCidLimpar.setText("Limpar");
        btCadCidLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadCidLimparActionPerformed(evt);
            }
        });

        btCadCidSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadCidSair.setText("Sair");
        btCadCidSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadCidSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrarCidadeLayout = new javax.swing.GroupLayout(pnCadastrarCidade);
        pnCadastrarCidade.setLayout(pnCadastrarCidadeLayout);
        pnCadastrarCidadeLayout.setHorizontalGroup(
            pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                        .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCadCidCidade)
                            .addComponent(tfCadCidCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCadCidUf)
                            .addComponent(cbCadCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                        .addComponent(btCadCidCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadCidLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadCidSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnCadastrarCidadeLayout.setVerticalGroup(
            pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                        .addComponent(lbCadCidCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCadCidCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                        .addComponent(lbCadCidUf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCadCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCadCidCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCadCidSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCadCidLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCadastrarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnCadastrarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadCidCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadCidCadastrarActionPerformed
        Cidade cidade = new Cidade(
            tfCadCidCidade.getText(),
            (String)cbCadCidUf.getSelectedItem()
        );
        try {
            if(!cidadeController.existeCidade(cidade)){
                if(cidadeController.cadastrarCidade(cidade)){
                    JOptionPane.showMessageDialog(rootPane, "Cidade cadastrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    tela.carregarCidade();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível cadastrar a cidade!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Cidade já cadastrada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dispose();
    }//GEN-LAST:event_btCadCidCadastrarActionPerformed

    private void cbCadCidUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCadCidUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCadCidUfActionPerformed

    private void btCadCidSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadCidSairActionPerformed
        dispose();
    }//GEN-LAST:event_btCadCidSairActionPerformed

    private void btCadCidLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadCidLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCadCidLimparActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadCidCadastrar;
    private javax.swing.JButton btCadCidLimpar;
    private javax.swing.JButton btCadCidSair;
    private javax.swing.JComboBox<String> cbCadCidUf;
    private javax.swing.JLabel lbCadCidCidade;
    private javax.swing.JLabel lbCadCidUf;
    private javax.swing.JPanel pnCadastrarCidade;
    private javax.swing.JTextField tfCadCidCidade;
    // End of variables declaration//GEN-END:variables
}
