package Interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cambraia
 */
public class TelaCandidato extends javax.swing.JFrame {

    /**
     * Creates new form TelaCandidato
     */
    public TelaCandidato() {
        initComponents();
        ConfirmarCandidato.setEnabled(false);
    }

    private boolean VerificaCampo() {
        if (CampoNomeCandidato.getText().length() > 0) {
            if (CampoNumCandidato.getText().length() == 5) {
                if (CampoCPFC.getText().length() >= 9 || CampoCPFC.getText().length() <= 14) {
                    if (CampoPartidoF.getText().length() >= 9 || CampoCPFC.getText().length() <= 14) {
                        ConfirmarCandidato.setVisible(true);
                        return true;
                    }
                }
            }
        }
        ConfirmarCandidato.setVisible(false);
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNomeCandidato = new javax.swing.JLabel();
        CampoNomeCandidato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelNumCandidato = new javax.swing.JLabel();
        CampoNumCandidato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelCPFC = new javax.swing.JLabel();
        CampoCPFC = new javax.swing.JTextField();
        CampoPartidoF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LabelPartidoF = new javax.swing.JLabel();
        ConfirmarCandidato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelNomeCandidato.setText("Nome do candidato");

        CampoNomeCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeCandidatoActionPerformed(evt);
            }
        });

        jLabelNumCandidato.setText("Numero do candidato");

        CampoNumCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNumCandidatoActionPerformed(evt);
            }
        });

        jLabelCPFC.setText("CPF do candidato");

        LabelPartidoF.setText("Partido Filiado");

        ConfirmarCandidato.setIcon(new javax.swing.ImageIcon("/home/cambraia/NetBeansProjects/TelaUrnaCandidato/confirmar.png")); // NOI18N
        ConfirmarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarCandidatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelCPFC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(CampoNomeCandidato, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelNomeCandidato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNumCandidato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(CampoNumCandidato, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 149, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LabelPartidoF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CampoPartidoF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCPFC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmarCandidato))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNomeCandidato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CampoNomeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNumCandidato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoNumCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCPFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoCPFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPartidoF)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfirmarCandidato)
                    .addComponent(CampoPartidoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoNomeCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNomeCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNomeCandidatoActionPerformed

    private void CampoNumCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNumCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNumCandidatoActionPerformed

    private void ConfirmarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarCandidatoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCandidato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoCPFC;
    private javax.swing.JTextField CampoNomeCandidato;
    private javax.swing.JTextField CampoNumCandidato;
    private javax.swing.JTextField CampoPartidoF;
    private javax.swing.JButton ConfirmarCandidato;
    private javax.swing.JLabel LabelNomeCandidato;
    private javax.swing.JLabel LabelPartidoF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCPFC;
    private javax.swing.JLabel jLabelNumCandidato;
    // End of variables declaration//GEN-END:variables
}
