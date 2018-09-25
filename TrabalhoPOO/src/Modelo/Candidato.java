package Modelo;

public class Candidato {
	private String Nome;
	private int Numero;
	private Documentos Cpf;
	private Partido Partido;
	
	public Candidato(String Nome,int Numero,String Cpf,Partido partido){
		if(setCpf(Cpf)) {
			this.Nome=Nome;
			this.Numero=Numero;
			this.Partido=partido;
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
	public Documentos getCpf() {
		return Cpf;
	}
	public Partido getPartido() {
		return Partido;
	}
	public void setPartido(Partido partido) {
		Partido = partido;
	}
}
