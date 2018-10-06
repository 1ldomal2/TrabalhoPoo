package Modelo;
import java.util.Date;
import org.json.*;

public class Voto {
	private Eleitor eleitor;
	private Candidato candidato;
	private Date data;
	private int NumeroUrna;

	public Eleitor getEleitor() {
		return eleitor;
	}

	public Candidato getCandidato() {
		return candidato;
	}
	
	public Date getData() {
		return data;
	}

	public int getNumeroUrna() {
		return NumeroUrna;
	}
	public void setNumeroUrna(int numeroUrna) {
		NumeroUrna = numeroUrna;
	}
	
	public Voto(Eleitor eleitor,Candidato candidato,int NumeroUrna) {
		this.eleitor=eleitor;
		this.candidato=candidato;
		this.NumeroUrna=NumeroUrna;
		data=new Date();
	}
	public Voto(String eleitorCpf,String candidatoCpf,String NumeroUrna){//import Json
		this.eleitor=eleitor;//Depois tem que procura o eleitor por cpf
		this.candidato=candidato;//Procura o candidato por cpf
		this.NumeroUrna=Integer.parseInt(NumeroUrna);
		data=new Date();
	}
	public String makeJson() {
		//Cria um objecto Json
		JSONObject json=new JSONObject();
		json.put("Urna",NumeroUrna);
		json.put("CpfEleitor",eleitor.getCpfString());
		json.put("CpfCandidato",candidato.getCpfString());
		json.put("Data",data.getTime());

		//Transforma em String
		return json.toString();
	}
}