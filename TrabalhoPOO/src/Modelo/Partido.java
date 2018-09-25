package Modelo;

import java.util.Date;

public class Partido {
	private  int TotalPartidos=0;
	private String Nome;
	private int Numero;
	private Date DataCadastro;
	
	
	public Partido(String nome,int numero) {//Neste caso chamar funçoes gera uma sobrecarga mas é possivel
		setNome(nome);
		setNumero(numero);
		DataCadastro=new Date();
		TotalPartidos++;
		
	}
	public Partido() {
	
	}
	

	
	public Date getDataCadastro() {
		return DataCadastro;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public String getNome() {
		return Nome;
	}
	public String getNOME() {//ESTA FUNCIONANDO ?????????????
		String aux=this.Nome.toUpperCase();//Transforma tudo em caixa alta
		String[] parts = aux.split(" ");//Separa em espaços
		String retorno ="";
		for (int i = 0; i < parts.length; i++) {//Junta tudo ignorando espaço
			retorno+=parts[i];
		}
				
		return retorno;
	}
	
	public void setNumero(int numero) {
		Numero = numero;
	}
	
	public int getNumero() {
		return Numero;
	}
}
