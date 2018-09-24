package Modelo;

import java.util.Date;

public class Partido {
	private  int TotalPartidos=0;
	private String Nome;
	private int Numero;
	private Date DataCadastro;
	
	public Partido() {
		this("Não cadastrado",-1);
	}
	public Partido(String nome,int numero) {//Neste caso chamar funçoes gera uma sobrecarga mas é possivel
		setNome(nome);
		setNumero(numero);
		DataCadastro=new Date();
		TotalPartidos++;
		
	}
	public Partido(String nome) {//palavra this não é necessária
		Nome=nome;
		DataCadastro=new Date();
		TotalPartidos++;
		Numero=TotalPartidos;
		
	}
	//Tenho que evitar que N partidos tenham o mesmo numero
	

	
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
