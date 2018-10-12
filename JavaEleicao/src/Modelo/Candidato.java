package Modelo;
import org.json.*;

public class Candidato {
	private String Nome;
	private int Numero;
	private Documentos Cpf;
	private Partido Partido;
	
	public Candidato() {
		
	}
	public Candidato(String Nome,int Numero,String Cpf,Partido partido){
		if(setCpf(Cpf)) {
			this.Nome=Nome;
			this.Numero=Numero;
			this.Partido=partido;
		}
	}
	
	public Candidato(String Nome,String Numero,String Cpf,String NumeroPartido,String NomePartido){//Import do Json
		//Tem que fazer o tratamento do Partido depois
		if(setCpf(Cpf)) {//Se o cpf não for valido ja aborta
			this.Nome=Nome;
			this.Numero=Integer.parseInt(Numero);
			this.Partido=new Partido(NomePartido,NumeroPartido);
			
		}
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public boolean setCpf(String cpf) {
		Documentos doc=new Documentos();
		if(doc.validaCpf(cpf)) {//So muda se o cpf passado for valido
			this.Cpf = doc;
			return true;
		}
		return false;
	}
	public String getCpfString() {
		return Cpf.toString();
	}
	public Documentos getCpf() {
		return Cpf;
	}
	public Partido getPartido() {
		return Partido;
	}
	public Candidato getCandidato() {
		return this;
	}
	public void setPartido(Partido partido) {
		Partido = partido;
	}
	public String makeJson() {
		//Cria um objecto Json
		JSONObject json=new JSONObject();
		json.put("Nome",Nome);
		json.put("Numero",Numero);
		json.put("Cpf",Cpf.toString());
		json.put("Partido",Partido.toString());
		
		//Transforma em String
		return json.toString();
	}
}