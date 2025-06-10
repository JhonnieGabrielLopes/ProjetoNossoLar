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
        btCadCidCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");

        pnCadastrarCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Cidade"));

        lbCadCidCidade.setText("Cidade:");

        tfCadCidCidade.setToolTipText("ATENÇÃO: Antes de registrar uma nova Cidade, certifique-se que não tenha a mesma cidade já cadastrada.");
        tfCadCidCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCadCidCidadeActionPerformed(evt);
            }
        });

        lbCadCidUf.setText("UF:");

        cbCadCidUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "MG", "GO", "-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "MA", "MT", "MS", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbCadCidUf.setToolTipText("Selecione a UF.");
        cbCadCidUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCadCidUfActionPerformed(evt);
            }
        });

        btCadCidCadastrar.setText("Cadastrar");
        btCadCidCadastrar.setToolTipText("Realizar cadastro da Cidade.");
        btCadCidCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadCidCadastrarActionPerformed(evt);
            }
        });

        btCadCidCancelar.setText("Cancelar");
        btCadCidCancelar.setToolTipText("Cancelar o registro de Cidade.");
        btCadCidCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadCidCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrarCidadeLayout = new javax.swing.GroupLayout(pnCadastrarCidade);
        pnCadastrarCidade.setLayout(pnCadastrarCidadeLayout);
        pnCadastrarCidadeLayout.setHorizontalGroup(
            pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCadCidCancelar)
                .addGap(18, 18, 18)
                .addComponent(btCadCidCadastrar)
                .addContainerGap())
            .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCadCidCidade)
                    .addComponent(lbCadCidUf)
                    .addComponent(cbCadCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadCidCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnCadastrarCidadeLayout.setVerticalGroup(
            pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrarCidadeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbCadCidCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCadCidCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCadCidUf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCadCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(pnCadastrarCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadCidCadastrar)
                    .addComponent(btCadCidCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnCadastrarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnCadastrarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btCadCidCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadCidCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCadCidCancelarActionPerformed

    private void tfCadCidCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCadCidCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCadCidCidadeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadCidCadastrar;
    private javax.swing.JButton btCadCidCancelar;
    private javax.swing.JComboBox<String> cbCadCidUf;
    private javax.swing.JLabel lbCadCidCidade;
    private javax.swing.JLabel lbCadCidUf;
    private javax.swing.JPanel pnCadastrarCidade;
    private javax.swing.JTextField tfCadCidCidade;
    // End of variables declaration//GEN-END:variables
}
