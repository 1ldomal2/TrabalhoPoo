package CENTRAL;

import DAO.DAO;
import DAO.EleitorDAO;
import DAO.VotoDAO;
import DAO.CandidatoDAO;
import DAO.PartidoDAO;
import MODELO.Partido;
import MODELO.Documentos;
import MODELO.Eleitor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

import VISAO.TelaCentral;



public class Central {
	
	private TelaCentral tela=null;
	private CandidatoDAO cDAO=null;
	private EleitorDAO eDAO=null;
	private PartidoDAO pDAO=null;
	private VotoDAO	vDAO=null;
	private int[] nVotos=null;

	/**
	 * Inicializa a Central ,
	 * Carrega os dados Salvos,
	 * Inicia a tela;
	 * 
	 */
	public Central() {
		//Inicia Central
		this.cDAO=new CandidatoDAO();
		this.eDAO=new EleitorDAO();
		this.pDAO=new PartidoDAO();
		this.vDAO=new VotoDAO();
		
		//Carrega Dados Da ultima seção 
             cDAO.Receive();
	     eDAO.Receive();
	     pDAO.Receive();
	     vDAO.Receive();
	    
		nVotos=new int[eDAO.Total];//Trocar .TOTAL para get TOTAL

		//Habilita a Tela
		tela=new TelaCentral(this);
		tela.setVisible(true);
		
	}
	
	
	/**
	 * 
	 * @param Path - Caminho para Salvar
	 * @return Arquivo .json com todos os dados
	 */
	public boolean Send(String Path) {
	//Salva os Arquivos
		//Cria um arquivo
    	FileWriter arq;
		try {
			arq = new FileWriter(Path);
			PrintWriter gravarArq = new PrintWriter(arq);//Objeto buffer
	    	
	    	DAO EstrutraDados=new DAO(cDAO,eDAO,pDAO,vDAO);
	    	String Json=EstrutraDados.Salvar();//Convertendo tudo para string
	    	
	    	gravarArq.printf(Json);
			arq.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showInternalMessageDialog(null,"Erro Ao criar Arquivo");
		}
			
		return true;
	}

	public String Receive(String Path) {
		//Abre o Arquivo localizado em $Path
			FileReader arq=null;
			try {
				System.out.println("Abrindo "+Path);
				arq = new FileReader(Path);
				BufferedReader lerArq = new BufferedReader(arq);
				String conteudoArq="";
				//Passa do Arquivo para uma unica String
				while(arq.ready()){
					conteudoArq+=lerArq.readLine();  
				}
				//Fecha Arquivo
				arq.close();
		        return conteudoArq;
			} catch (IOException e1) {
				System.out.println("Arquivo não encontrado");
				JOptionPane.showMessageDialog(null,"Erro ao Abrir Arquivo");
				return null;
			}
	}
	/**
	 * Retorna uma string   "Nome:NumeroVotos \n" Com nome de todos os candidatos
	 * @return String com os votos
	 */
	public String Resultado() {
	     String resultado="";
	     for (int i = 0; i < nVotos.length; i++) {//Pega a Quantidade de Votos de cada eleitor
		     nVotos[i]=vDAO.NVotosCandidato(cDAO.Array[i]);
		     resultado=cDAO.Array[i].getNome()+":\t"+nVotos[i]+"\n";
	     };
	     return resultado;
	}
	
	
	
	
	public boolean CadastrarCandidato(String CampoPartido,String CampoNomeCandidato,String CampoNumeroCandidato,String CampoCPF) {//Passa os N Campos
               
                //Verificando Nome
                if(CampoNomeCandidato.length()==0){
                    JOptionPane.showMessageDialog(null, "Nome não pode ser Nulo");
                    return false;
                }
                
                //Verificando Numero
                if(CampoNumeroCandidato.length()!=5){
                    JOptionPane.showMessageDialog(null, "Numero do Candidato deve ter 5 Digitos");
                    return false;
                }else{
                    int numero=0;
                    try{
                        Integer.parseInt(CampoNumeroCandidato);
                    }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "5 DIGITOS");
                    }
                }                 
                
                //Verificando Cpf
                Documentos doc=new Documentos(CampoCPF);
                if(!doc.getValidCpf()){
                    JOptionPane.showMessageDialog(null, "Cpf Invalido");
                    return false;
                }
                
                //Partido
		Partido partido=null;
		boolean criado=false;//Retorno
		//Procura PARTIDO
			//Procura Partido pelo Nome
			partido=pDAO.ObjectNome(CampoPartido);
			
			if(partido==null) {//Se Não Achou por Nome  Procura o Partido pelo numero

				//Converte string para numero
				try{
					int numeroPartido=Integer.parseInt(CampoPartido);
					
					//Procura Partido pelo numero
					partido=pDAO.ObjectNumero(numeroPartido);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Este partido não existe");
					return false;
				}
				
				if(partido==null) {//Se não achou por numero o Partido não esta cadastrado
					JOptionPane.showMessageDialog(null, "Partido Invalido");
					
					return false;
				}
			}
			
		//Procurar se ja existe algum candidato com mesmo numero

		try {
			criado=cDAO.CriarCandidato(CampoNomeCandidato, CampoNumeroCandidato, CampoCPF,partido);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}

		//Conseguiu Criar o Candidato
		if(criado==true) {
			Documentos doc=new Documentos(CampoCPF);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso \n"+
												"\nNome:"+CampoNomeCandidato+
												"\nNumero:"+CampoNumeroCandidato+
												"\nCPF:"+doc.toStringPonto()+
												"\nNome Partido:"+partido.getNome()+
												"\nNumero Partido:"+partido.getNumero());
			return true;
		}
		return false;
	}
	
	
	public boolean CadastrarPartido(String CampoNumeroPartido,String CampoNomePartido){
		 Partido partido=null;
		 boolean verificacao=false;
		 int numeroPartido=0;

		//Procura Partidos pelo Nome
			partido=pDAO.ObjectNome(CampoNumeroPartido);

			if(partido!=null) {//Achou com o mesmo nome
				System.out.println("Existe Partido com este nome");
		    	return false;
			}

		//Procura Partidos pelo Numero
			try {//Tenta Converter String para numero
				numeroPartido=Integer.parseInt(CampoNumeroPartido);//Verifica se é Numero
			} catch (Exception e) {
				System.out.println("Numero Invalido");
	        	return false;
	    	}

	    	partido=pDAO.ObjectNumero(numeroPartido);
	    	if(partido!=null) {//achou com mesmo numero
	    		System.out.println("Existe Partido com este numero");
	        	return false;
	    	}else {
	        	verificacao=true;
	    	}

	    //Cria Partido
	    	if(verificacao){
	    		if(pDAO.CriarPartido(CampoNumeroPartido,CampoNomePartido)){
	    			 JOptionPane.showMessageDialog(null, "Partido Criado com sucesso\n"+
	    				"\nNumero:"+CampoNumeroPartido+
	    				"\nNome:"+CampoNomePartido);
	    			 return true;
	    		}else{
	    			JOptionPane.showMessageDialog(null, "Erro ao criar o Partido");
	    			return false;
	    		}
	    	}
	   return verificacao;

	}

public boolean CriarEleitor(String Path,String CampoNome,String CampoTitulo,String CampoCPF,String CampoUrna){
	Eleitor eleitor=null;
	int numero=0;
	eleitor=new Eleitor();
        try{
            eleitor.setImagemSenha(Path);
        }catch(Exception e){
            return false;
        }
	eleitor.setNome(CampoNome);
	eleitor.setCpf(CampoCPF);
	eleitor.setTituloEleitor(CampoTitulo);
	try{
		numero=Integer.parseInt(CampoUrna);
	}catch(Exception e){
		System.out.println("Numero Invalido");
		return false;
	}
	eleitor.setUrnaVotacao(numero);
	//Imagem ja foi setada ao carregar a imagem

	if(eDAO.CriarEleitor(eleitor)){
		JOptionPane.showMessageDialog(null,"Eleitor Cadastrado com Sucesso\n"+
								    		"\nNome:"+CampoNome+
								    		"\nCPF:"+eleitor.getCpf().toStringPonto()+
								    		"\nTitulo Eleitor:"+eleitor.getTituloEleitor()+
								    		"\nUrna de Votaçao:"+eleitor.getUrnaVotacao()+
								    		"\n\nHash:"+eleitor.getHash());
		return true;
	}else{
		JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
		return false;
	}
}

}
