package Modelo;

import java.util.Date;

public class Partido {
	private static int TotalPartidos=0;
	private String Nome;
	private int Numero;
	private Date DataCadastro;
	
	public Partido() {
		this("Não cadastrado",-1);
	}
	public Partido(String nome,int numero) {
		setNome(nome);
		setNumero(numero);
		DataCadastro=new Date();
		TotalPartidos++;
		
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
