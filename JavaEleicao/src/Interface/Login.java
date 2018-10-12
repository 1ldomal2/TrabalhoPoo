package Interface;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Urna.Urna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cambraia
 */
public class Login extends javax.swing.JFrame {
	private Urna inst = null;

	/**
	 * Creates new form Login
	 */
	public Login() {
		// Inicia componentes da tela
		initComponents();

		// Instancia a Urna
		inst = new Urna();

		// Pega Dados do Google Drive
		inst.Receive();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		CaminhoArquivo = new javax.swing.JFileChooser();
		Texto = new javax.swing.JLabel();
		TextoCaminho = new javax.swing.JTextField();
		AbrirCaminho = new javax.swing.JButton();
		ConfirmarLogin = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		Texto.setText("Digite a senha: (Caminho)");

		TextoCaminho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TextoCaminhoActionPerformed(evt);
			}
		});

		AbrirCaminho.setIcon(new javax.swing.ImageIcon("/home/cambraia/NetBeansProjects/TelaUrnaCandidato/icone.png")); // NOI18N
		AbrirCaminho.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AbrirCaminhoMouseClicked(evt);
			}
		});
		AbrirCaminho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AbrirCaminhoActionPerformed(evt);
			}
		});

		ConfirmarLogin.setText("Login");
		ConfirmarLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ConfirmarLoginActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(ConfirmarLogin))
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(TextoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(AbrirCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(Texto))
						.addGap(0, 78, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(Texto).addGap(32, 32, 32)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(TextoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(AbrirCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
						.addComponent(ConfirmarLogin)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void TextoCaminhoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TextoCaminhoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TextoCaminhoActionPerformed

	private void AbrirCaminhoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_AbrirCaminhoMouseClicked

	}// GEN-LAST:event_AbrirCaminhoMouseClicked

	private void AbrirCaminhoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AbrirCaminhoActionPerformed
		// TODO add your handling code here:
		JFileChooser arquivo = new JFileChooser();
		arquivo.setFileFilter(new FileNameExtensionFilter("Image files", "ppm"));
		arquivo.setAcceptAllFileFilterUsed(false);
		arquivo.showOpenDialog(null);
		File file = arquivo.getSelectedFile();
		String caminho = file.getAbsolutePath();
		TextoCaminho.setText(caminho);
	}// GEN-LAST:event_AbrirCaminhoActionPerformed

	private void ConfirmarLoginActionPerformed(java.awt.event.ActionEvent evt) {
		// Faz login
		if (TextoCaminho.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Abra o arquivo");
		} else {
			// Verifica se a senha è igual
			boolean login = false;
			try {
				login = inst.Login(TextoCaminho.getText());
			} catch (NoSuchAlgorithmException | IOException e) {
				e.printStackTrace();
			}
			//Se for igual chama Console.Urna
			if (login) {
				new ConsoleUrna().setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Senha Incorreta");
			}
		}
	}// GEN-LAST:event_ConfirmarLoginActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton AbrirCaminho;
	private javax.swing.JFileChooser CaminhoArquivo;
	private javax.swing.JButton ConfirmarLogin;
	private javax.swing.JLabel Texto;
	private javax.swing.JTextField TextoCaminho;
	// End of variables declaration//GEN-END:variables
}
