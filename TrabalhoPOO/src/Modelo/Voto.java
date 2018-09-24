package Modelo;

import java.util.Date;

public class Voto {
	private Eleitor Eleitor;
	private Candidato Candidato;
	private Date Data;
	private int NumeroUrna;

	public Eleitor getEleitor() {
		return Eleitor;
	}
	private void setEleitor(Eleitor eleitor) {
		Eleitor = eleitor;
	}
	public Candidato getCandidato() {
		return Candidato;
	}
	private void setCandidato(Candidato candidato) {
		Candidato = candidato;
	}
	public Date getData() {
		return Data;
	}

	public int getNumeroUrna() {
		return NumeroUrna;
	}
	public void setNumeroUrna(int numeroUrna) {
		NumeroUrna = numeroUrna;
	}
	
	public Voto(Eleitor Eleitor,Candidato Candidato,int NumeroUrna) {
		Data=new Date();
	}
	public Voto() {
		Data=new Date();
		
	}
	
}
