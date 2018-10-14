package Urna;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import DAO.*;
import Modelo.*;

public class Urna {
	private static int TotalUrnas=0;
	private int Numero;
	private CandidatoDAO ArrayCandidato=new CandidatoDAO();
	private EleitorDAO ArrayEleitor=new EleitorDAO();
	private VotoDAO ArrayVoto=new VotoDAO();
	private PartidoDAO ArrayPartido=new PartidoDAO();
	//Questoes de segurança
	private boolean Logado=false;
	private Eleitor User=null;
	
	
	public static int getTotalUrnas() {
		return TotalUrnas;
	}
	public int getNumero() {
		return Numero;
	}
	public boolean getLogado() {
		return this.Logado;
	}
	public Urna() {
		TotalUrnas++;
		Numero=TotalUrnas;
	}
	public void Receive() {
	//Pega DO GOOGLE dRIVE
		System.out.println("Carregou Candidatos");
		ArrayCandidato.Receive();
		
		System.out.println("Carregou Eleitores");
		ArrayEleitor.Receive();

		System.out.println("Carregou Partidos");
		ArrayPartido.Receive();
		
		System.out.println("Carregou Votos");
		ArrayVoto.Receive();
	}
	public void Send() {
		//MANDA PARA O GOOGLE DRIVE
		
	}
	public Eleitor Login(String Path){//Logar deixa salvo o eleitor
		
		System.out.println("Transformando a Img em Hash");
		Senha psw=null;
		try {
			psw = new Senha(Path);
		} catch (NoSuchAlgorithmException | IOException e) {e.printStackTrace();}//Transforma a Img em Hash
		
		String hash=psw.getHash();//Salvo a Hash
		System.out.println("Imagem>Hash :"+hash);
		
		System.out.println("Procurando pelo Hash");
		Eleitor eleitor = ArrayEleitor.ObjectHash(hash);//Eleitor logado
		
		if(eleitor == null) {//Nao logou
			System.out.println("Não Logou");
			Deslogar();//Ter um controle de segurança
			return null;
		}
		System.out.println("Logado como :"+eleitor.getNome());
		this.Logado=true;//Ter um controle de segurança
		this.User=eleitor;//Switch on
		return eleitor;
	}
	public void Deslogar() {
		this.Logado=false;//Ter um controle de segurança
		this.User=null;//switch off
		System.out.println("Deslogado");
	}
	
	//Cria o Voto
	public boolean Votar(Candidato candidato) {//Ao votar vc desloga
		if(Logado==false) {
			System.out.println("Não é possivel Votar sem estar Logado");
			System.out.println("Flag Logado=False");
			return false;
		}
		if(this.User == null) {
			System.out.println("Não é possivel Votar sem estar Logado");
			System.out.println("User=NULL");
			return false;
		}
			this.ArrayVoto.CriarVoto(this.User,candidato,this.Numero);//Criou o voto e armazenou no Array da urna
			Deslogar();
			return true;
	
		
	}
}
