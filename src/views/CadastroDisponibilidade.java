/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CadastroDisponibilidadeController;
import entidades.Disponibilidade;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Rafael
 */
public class CadastroDisponibilidade extends javax.swing.JFrame {

    private MaskFormatter formatoData;
    private CadastroDisponibilidadeController controller;
    private Disponibilidade disponivel;

    /**
     * Creates new form CadastroDisponivel
     */
    public CadastroDisponibilidade(CadastroDisponibilidadeController controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = controller;
        preencheComboMes();
        preencheComboAno();
        bloquearCampos();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDias = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxMes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxAno = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisponibilidade = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DISPONIBILIDADE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Dias");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Horas");

        txtCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtDias.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtHoras.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mês");

        jComboBoxMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ano:");

        jComboBoxAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Obs:");

        txtObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObs)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 364, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");

        btExcluir.setText("Excluir");

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btVisualizar.setText("Visualizar");
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btNovo)
                .addGap(51, 51, 51)
                .addComponent(btSalvar)
                .addGap(28, 28, 28)
                .addComponent(btVisualizar)
                .addGap(29, 29, 29)
                .addComponent(btEditar)
                .addGap(26, 26, 26)
                .addComponent(btExcluir)
                .addGap(34, 34, 34)
                .addComponent(btSair)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabelaDisponibilidade.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaDisponibilidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Mês", "Ano", "Dias", "Horas/Turno"
            }
        ));
        tabelaDisponibilidade.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(tabelaDisponibilidade);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        desbloquearCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
     controller.salvar();
        preencheJtable();
        bloquearCampos();
        limparCampos();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        controller.listarDisponibilidade();
    }//GEN-LAST:event_btVisualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JComboBox jComboBoxAno;
    private javax.swing.JComboBox jComboBoxMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDisponibilidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtObs;
    // End of variables declaration//GEN-END:variables

    public void preencheComboMes() {

        jComboBoxMes.removeAllItems();
        jComboBoxMes.addItem("Selecione");
        jComboBoxMes.addItem("Janeiro");
        jComboBoxMes.addItem("Fevereiro");
        jComboBoxMes.addItem("Março");
        jComboBoxMes.addItem("Abril");
        jComboBoxMes.addItem("Maio");
        jComboBoxMes.addItem("Junho");
        jComboBoxMes.addItem("Julho");
        jComboBoxMes.addItem("Agosto");
        jComboBoxMes.addItem("Setembro");
        jComboBoxMes.addItem("Outubro");
        jComboBoxMes.addItem("Novembro");
        jComboBoxMes.addItem("Dezembro");
    }

    public void preencheComboAno() {
        jComboBoxAno.removeAllItems();
        jComboBoxAno.addItem("Selecione");
        for (int i = 2012; i <= 2020; i++) {
            jComboBoxAno.addItem(i);
        }
    }

    public void sincronizarModelComView(Disponibilidade disp) {

        if (!txtCodigo.getText().equals("")) {
            disp.setCodigo(Integer.parseInt(txtCodigo.getText()));
        } else {
            disp.setCodigo(null);
        }

        if (!jComboBoxMes.getSelectedItem().equals("Selecione")) {
            disp.setMes((String) jComboBoxMes.getSelectedItem());     
        } else {
            JOptionPane.showMessageDialog(null, "O campo mês é obrigatório");
        }

        if (!jComboBoxAno.getSelectedItem().equals("Selecione")) {
            disp.setAno((Integer)jComboBoxAno.getSelectedItem());
        } else {
            JOptionPane.showMessageDialog(null, "O campo Ano é obrigatório");
        }

        if (!txtDias.getText().equals("")) {
            disp.setDia(Integer.parseInt(txtDias.getText()));      
        } else {
            JOptionPane.showMessageDialog(null, "O campo dias é obrigatório");
        }

        if (!txtHoras.getText().equals("")) {
            disp.setHoras(Time.valueOf(txtHoras.getText()));         
        } else {
            JOptionPane.showMessageDialog(null, "O campo horas é obrigatório");
        }
        
        if (!txtObs.getText().equals("")){
            disp.setObservacao(txtObs.getText());
        }else{
             JOptionPane.showMessageDialog(null, "O campo é obrigatório");
        }
    }

    /**
     * Bloquea os campos do formulário para edição
     */
    public void bloquearCampos() {
        txtCodigo.setEditable(false);
        jComboBoxMes.setEditable(false);
        jComboBoxAno.setEditable(false);
        txtDias.setEditable(false);
        txtHoras.setEditable(false);

    }

    /**
     * Desbloqueia os campos do formulário para edição
     */
    public void desbloquearCampos() {
        txtCodigo.setEditable(true);
        jComboBoxMes.setEditable(true);
        jComboBoxAno.setEditable(true);
        txtDias.setEditable(true);
        txtHoras.setEditable(true);
    }

    public void limparCampos() {

        txtCodigo.setText("");
        jComboBoxAno.setSelectedItem("Selecione");
        jComboBoxAno.setSelectedItem("Selecone");
        txtDias.setText("");
        txtHoras.setText("");
    }

    /**
     * Preenche as o jtable com os clientes cadastrados
     */
    public void preencheJtable() {

        List<Disponibilidade> lista = controller.listarDisponibilidade();
        DefaultTableModel modelo = (DefaultTableModel) tabelaDisponibilidade.getModel();

        for (int i = (modelo.getRowCount() - 1); i >= 0; --i) {
            modelo.removeRow(i);
        }

        for (Disponibilidade objeto : lista) {
            modelo.addRow(new Object[]{objeto.getCodigo(), objeto.getMes(), objeto.getDia(), objeto.getHoras()});
        }
    }

    private Date formatarData(String text) {
        SimpleDateFormat formatador = new SimpleDateFormat("MM/yyyy");
        Date dataFormatada = null;
        try {
            dataFormatada = formatador.parse(text);
            return dataFormatada;
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar data" + ex);
        }
        return dataFormatada;
    }
}
