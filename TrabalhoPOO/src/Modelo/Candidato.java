package Modelo;

public class Candidato {
	private String Nome;
	private int Numero;
	private String Cpf;
	private Partido Partido;
	
	public Candidato(String Nome,int Numero,String Cpf,Partido partido){
		this.Nome=Nome;
		this.Numero=Numero;
		this.Partido=partido;
		Documentos cpf=new Documentos(Cpf);
		this.Cpf=cpf.toString();
		
		
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
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Documentos doc=new Documentos(Cpf);
		this.Cpf=doc.toString();
	}
	public Partido getPartido() {
		return Partido;
	}
	public void setPartido(Partido partido) {
		Partido = partido;
	}
}
