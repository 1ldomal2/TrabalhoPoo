package Urna;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public void Receive() {//Não sei o que tem que retorna}
		//Pega DO GOOGLE dRIVE
		  ArrayCandidato.Receive();
		  ArrayEleitor.Receive();
		  ArrayVoto.Receive();
		  ArrayPartido.Receive();
		
	}
	public void Send() {
		//MANDA PARA O GOOGLE DRIVE
		JSONObject json=new JSONObject();
		
	}
	public boolean Login(String Path) throws NoSuchAlgorithmException, IOException {//Logar deixa salvo o eleitor
		Senha psw=new Senha(Path);//Transforma a Img em Hash
		String hash=psw.getHash();//Salvo a Hash
		Eleitor eleitor = ArrayEleitor.ObjectHash(hash);//Eleitor logado
		if(eleitor == null) {//Nao logou
			Deslogar();//Ter um controle de segurança
			return false;
		}
		this.Logado=true;//Ter um controle de segurança
		this.User=eleitor;//Switch on
		return true;
	}
	public void Deslogar() {
		this.Logado=false;//Ter um controle de segurança
		this.User=null;//switch off
	}
	
	//Cria o Voto
	public boolean Votar(Candidato candidato) {//Ao votar vc desloga
		if(Logado==false) {
			return false;
		}
		if(this.User == null) {
			return false;
		}
			this.ArrayVoto.CriarVoto(this.User,candidato,this.Numero);//Criou o voto e armazenou no Array da urna
			Deslogar();
			return true;
	
		
	}
}
