package CENTRAL;

import DAO.*;
import JSON.JSONArray;
import JSON.JSONObject;
import MODELO.*;
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
	public int[] nVotos=null;

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
            pDAO.Receive();//Partido tem que vir antes de Candidato
            cDAO.Receive();
	    eDAO.Receive();
	    vDAO.Receive();//Voto tem que vir depois de eleitor e de candidato
	    
            nVotos=new int[50];
            //Cria com 50 mas nao usa Todos

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
	 * Retorna uma string   {Nome:"Candidato",Eleitor:"NumeroDeVotos"}
	 * @return Json com o resultado da votacao
	 */
	public String Resultado() {
            CalculaVotos();
            return JsonResultado();
            
	}
	
	private void CalculaVotos(){
            for (int i = 0; i < cDAO.getTotal(); i++) {//Pega a Quantidade de Votos de cada eleitor
		nVotos[i]=vDAO.NVotosCandidato(cDAO.CandidatoIndice(i));
                System.out.println(cDAO.CandidatoIndice(i).getNome()+" possui "+nVotos[i]+" votos");
	    };
        }
        private String JsonResultado(){
             JSONObject json=new JSONObject();//Json que vai retornar
             JSONArray resultados=new JSONArray();//de Candidatos/Votos
             JSONObject[] resultado=new JSONObject[cDAO.getTotal()];//Superior
	     for (int i = 0; i < cDAO.getTotal(); i++) {//Pega a Quantidade de Votos de cada eleitor
                     //Cria Objetos Json
			resultado[i]=new JSONObject();
			resultado[i].put("Nome",cDAO.CandidatoIndice(i).getNome());
			resultado[i].put("Votos",""+nVotoIndice(i));
			//Adicionao Objeto Json em um vetor de Jsons
			resultados.put(resultado[i]);
	     };
            json.put("Resultado",resultados);
            return json.toString();
        }
        
	
	/**
         * 
         * @param CampoPartido  Nome do partido
         * @param CampoNomeCandidato Nome do Candidato
         * @param CampoNumeroCandidato  Numero do Candidato
         * @param CampoCPF  CPF do candidato
         * @return se foi possivel criar o candidato
         */
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
                         return false;
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
			Documentos docs=new Documentos(CampoCPF);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso \n"+
												"\nNome:"+CampoNomeCandidato+
												"\nNumero:"+CampoNumeroCandidato+
												"\nCPF:"+docs.toStringPonto()+
												"\nNome Partido:"+partido.getNome()+
												"\nNumero Partido:"+partido.getNumero());
			return true;
		}
		return false;
	}
	
	/**
         * 
         * @param CampoNumeroPartido Numero do Partido
         * @param CampoNomePartido Nome do partido
         * @return Se foi possivelcriar o Partido
         */
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

        /**
         * 
         * @param Path  Caminho da Foto
         * @param CampoNome Nome
         * @param CampoTitulo Titulo de Eleitor
         * @param CampoCPF  CPF do Eleitor
         * @param CampoUrna Urna de Votacao
         * @return Se foi possivel criar o eleitor
         */
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
    /**
     * @return Retorna o Numero de votos ou seja posiçoes nao nulas de vDAO
     */
    public int TotalVotos(){
        return vDAO.getTotal();
    }
    /**
     * @param i Indice
     * @return Retorna o voto presente em vDAO com indice 'i'
     */
    public Voto VotoIndice(int i){
        return this.vDAO.VotoIndice(i);
    }
    /**
     * 
     * @return Retorna o total de candidatos ou seja numeo de posiçoes nao nula de cDAO
     */
    public int TotalCandidatos(){
        return cDAO.getTotal();
    }
     /**
     * @param i Indice
     * @return Retorna o voto presente em cDAO com indice 'i'
     */
    public Candidato CandidatoIndice(int i){
        return this.cDAO.CandidatoIndice(i);
    }
    
    public int nVotoIndice(int i) {
        return nVotos[i];
    }
}
