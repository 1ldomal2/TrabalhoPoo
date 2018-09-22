package Modelo;

import java.util.Date;

public class Partido {
	private String Nome;
	private int Numero;
	private Date DataCadastro;
	
	public Partido() {
		Partido("Não cadastrado",-1);
	}

	public Partido(String nome,int numero) {
		setNome(nome);
		setNumero(numero);
		DataCadastro=new Date();
		
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
	
	public void setNumero(int numero) {
		Numero = numero;
	}
	
	public int getNumero() {
		return Numero;
	}
}
