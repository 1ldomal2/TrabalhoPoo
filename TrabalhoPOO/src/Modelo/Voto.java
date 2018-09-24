package Modelo;

import java.util.Date;

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
	
	public Voto(Eleitor Eleitor,Candidato Candidato,int NumeroUrna) {
		data=new Date();
	}
	
}
