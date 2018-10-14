package Interface;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.CandidatoDAO;
import DAO.EleitorDAO;
import DAO.PartidoDAO;
import Modelo.Documentos;
import Modelo.Eleitor;
import Modelo.Partido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cambraia
 */
public class TelaEleitor extends javax.swing.JFrame {
	private CentralBotão TelaSuperior=null;
	private EleitorDAO eDAO=null;
	private boolean imgOK=false;
	private Eleitor elei=null;
   
	 public TelaEleitor(){
	    	initComponents();
	    	Confirmar.setEnabled(false);
	 }
	
    public TelaEleitor(CentralBotão TelaSuperior,EleitorDAO eDAO){
    	this.eDAO=eDAO;
    	this.TelaSuperior=TelaSuperior;
    	initComponents();
    	Confirmar.setEnabled(false);
    }

    private boolean VerificaCampo(){
     	Documentos doc=new Documentos();
     	//Verifica se foi digitado algo no campo nome
        if (NomeEleitor.getText().length() > 0) {
        	
        	//Verifica se foi digitado titulo de eleitor
            if (TituloEleitor.getText().length() >0) {
            	
            	//Verifica se Cpf tem a Quantidade Certa de caracteres
                if (CpfEleitor.getText().length() == 11 || CpfEleitor.getText().length() == 14) {//Verifica CPF
                	
                	//Verifica se o Cpf Digitado é valido
                	if(doc.validaCpf(CpfEleitor.getText())) {
                		
                		//Verifica se digitou algo no campo partido
                		if (SecaoEleitor.getText().length()>0) {
                			
                			//Tem que verificar se o Partido Existe Começa procurando por Nome
                			try {
								Integer.parseInt(SecaoEleitor.getText());
							} catch (Exception e) {

								Confirmar.setEnabled(false);
								return false;
							}

                			if(imgOK==true) {
                				Confirmar.setEnabled(true);
                				return true;
                			}else {
                				Confirmar.setEnabled(false);
                				return false;
                			}
	                    }
                	}
                }
            }
        }
        Confirmar.setEnabled(false);
        return false;
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        Carregar = new javax.swing.JButton();
        TituloEleitor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SecaoEleitor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FotoEleitor = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CpfEleitor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NomeEleitor = new javax.swing.JTextField();
        Confirmar = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(300, 400));
       
       
        	
        //Listeners
        CpfEleitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	VerificaCampo(evt);
            } 
        });
        NomeEleitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	VerificaCampo(evt);
            } 
        });
        SecaoEleitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	VerificaCampo(evt);
            } 
        });
        TituloEleitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	VerificaCampo(evt);
            } 
        });
        
        
        
        jLabel1.setText("Titulo de Eleitor");

        TituloEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloEleitorActionPerformed(evt);
            }
        });

        jLabel2.setText("Seção");

        FotoEleitor.setText("Foto do Eleitor");

        Foto.setText("AQUI FICA A FOTO");

        jLabel7.setText("CPF do Eleitor");

        CpfEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpfEleitorActionPerformed(evt);
            }
        });
        Carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CarregarActionPerformed(evt);
            }
        });
        

        jLabel4.setText("Nome do eleitor");

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CpfEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomeEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TituloEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FotoEleitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SecaoEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(Carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TituloEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CpfEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(FotoEleitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SecaoEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addComponent(Carregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void VerificaCampo(java.awt.event.KeyEvent evt){ 
    	//ERRO Quero primeiro adicionar o Numero ao campo e depois Chamar o evento AJUDA
    	VerificaCampo();
    }    
        
    private void TituloEleitorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void CpfEleitorActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	if(imgOK) {
    		elei.setNome(NomeEleitor.getText());
    		elei.setCpf(CpfEleitor.getText());
    		elei.setTituloEleitor(TituloEleitor.getText());
    		elei.setUrnaVotacao(Integer.parseInt(SecaoEleitor.getText()));
    		//Imagem ja foi setada ao carregar a imagem
    		//Acabo de Criar o eleitor
    		eDAO.CriarEleitor(elei);
    		JOptionPane.showMessageDialog(null,"Eleitor Cadastrado com Sucesso\n"+
									    		"\nNome:"+elei.getNome()+
									    		"\nCPF:"+elei.getCpf().toStringPonto()+
									    		"\nTitulo Eleitor:"+elei.getTituloEleitor()+
									    		"\nUrna de Votaçao:"+elei.getUrnaVotacao()+
									    		"\n\nHash:"+elei.getHash());
    		
        	TelaSuperior.setVisible(true);
    		this.dispose();
    		    
    	}else {
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
    	}
    }      
    private void CarregarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	System.out.println("Localizando Imagem");
		String pathInicial="/home/lucas/Área de Trabalho/TrabalhoPoo/Arquivos PPM/";
		JFileChooser arquivo = new JFileChooser(pathInicial);
		arquivo.setFileFilter(new FileNameExtensionFilter("Image files", "ppm"));
		arquivo.setAcceptAllFileFilterUsed(false);
		arquivo.showOpenDialog(null);
		File file = arquivo.getSelectedFile();
		if(file!=null) {
			System.out.println("Arquivo Localizado");
			String caminho = file.getAbsolutePath();
			//Cria senha
			imgOK=true;
			elei=new Eleitor();
			try {
				elei.setImagemSenha(caminho);
			} catch (NoSuchAlgorithmException | IOException e) {
				e.printStackTrace();
				imgOK=false;
				elei=null;
			}
			VerificaCampo();
		}else {
			imgOK=false;
			elei=null;
			VerificaCampo();
		}

    }      
    

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
            java.util.logging.Logger.getLogger(TelaEleitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEleitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEleitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEleitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEleitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Carregar;
    private javax.swing.JButton Confirmar;
    private javax.swing.JTextField CpfEleitor;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel FotoEleitor;
    private javax.swing.JTextField NomeEleitor;
    private javax.swing.JTextField SecaoEleitor;
    private javax.swing.JTextField TituloEleitor;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration                   
}
