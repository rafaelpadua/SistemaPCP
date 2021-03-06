/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.TelaPrincipalController;

/**
 *
 * @author Rafael
 */
public class TelaPrincipalView extends javax.swing.JFrame {
    
    TelaPrincipalController controller;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalView(TelaPrincipalController controller) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCadProd = new javax.swing.JButton();
        btPrevVendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btDisponibilidade = new javax.swing.JButton();
        btSuprimento = new javax.swing.JButton();
        btSetup = new javax.swing.JButton();
        btPcp = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BEM-VINDO AO SISTEMA PCP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setFocusCycleRoot(true);

        btCadProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCadProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/CadastroProduto.png"))); // NOI18N
        btCadProd.setText("Cadastro de Produto");
        btCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadProdActionPerformed(evt);
            }
        });

        btPrevVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPrevVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Demanda.png"))); // NOI18N
        btPrevVendas.setText("Previsão de Vendas");
        btPrevVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrevVendasActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        btDisponibilidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDisponibilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dispo.png"))); // NOI18N
        btDisponibilidade.setText("Disponibilidade");
        btDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDisponibilidadeActionPerformed(evt);
            }
        });

        btSuprimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSuprimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/suprimentos.png"))); // NOI18N
        btSuprimento.setText("Suprimentos");
        btSuprimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuprimentoActionPerformed(evt);
            }
        });

        btSetup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/setup.png"))); // NOI18N
        btSetup.setText("setup");
        btSetup.setActionCommand("");
        btSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSetupActionPerformed(evt);
            }
        });

        btPcp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPcp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pcp.png"))); // NOI18N
        btPcp.setText("PCP");
        btPcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPcpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPrevVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDisponibilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCadProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSuprimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPcp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btCadProd)))
                .addGap(28, 28, 28)
                .addComponent(btPrevVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btSuprimento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btPcp, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fundoII.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadProdActionPerformed
        controller.exibirCadastroDeProdutoView();
    }//GEN-LAST:event_btCadProdActionPerformed
    
    private void btPrevVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrevVendasActionPerformed
        controller.exibirCadastroDeDemandaView();
    }//GEN-LAST:event_btPrevVendasActionPerformed
    
    private void btDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisponibilidadeActionPerformed
        controller.exibirCadastroDeDisponibilidadeView();
    }//GEN-LAST:event_btDisponibilidadeActionPerformed
    
    private void btSuprimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuprimentoActionPerformed
        controller.exibirSuprimentosView();
    }//GEN-LAST:event_btSuprimentoActionPerformed
    
    private void btSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSetupActionPerformed
        controller.exibirSetupView();
    }//GEN-LAST:event_btSetupActionPerformed
    
    private void btPcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPcpActionPerformed
        controller.exibirPcpView();
    }//GEN-LAST:event_btPcpActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadProd;
    private javax.swing.JButton btDisponibilidade;
    private javax.swing.JButton btPcp;
    private javax.swing.JButton btPrevVendas;
    private javax.swing.JButton btSetup;
    private javax.swing.JButton btSuprimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void bloquearBotoesEngenheiroProducao() {
        btDisponibilidade.setEnabled(false);
        btPcp.setEnabled(false);
        btPrevVendas.setEnabled(false);
        btSuprimento.setEnabled(false);
        btDisponibilidade.setEnabled(false);
    }
    
    public void bloquearBotoesAnalistaPCP(){
    btCadProd.setEnabled(false);
    btSetup.setEnabled(false);
    btSuprimento.setEnabled(false);
    }
    
    public void BloquearCompras(){
    btCadProd.setEnabled(false);
    btDisponibilidade.setEnabled(false);
    btPcp.setEnabled(false);
    btPrevVendas.setEnabled(false);
    btSetup.setEnabled(false);
    }
    
    public void bloquearGerenytePCP(){
    btCadProd.setEnabled(false);
    btDisponibilidade.setEnabled(false);
    btSetup.setEnabled(false);
    btSuprimento.setEnabled(false);
    }
}
