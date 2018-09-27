package DAO;

import Modelo.Candidato;
import Modelo.Documentos;
import Modelo.Partido;

public class CandidatoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Candidato[] Array = new Candidato[TAMANHO];
	private Candidato celulaVetor = null;

	public boolean CriarCandidato(String Nome, int Numero, String Cpf, Partido partido) {
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Candidato(Nome, Numero, Cpf, partido);
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
				return true;
			}
		}
		return false;

	}

	public boolean CriarCandidato(Candidato candidato) {
		if (Total <= TAMANHO && candidato != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = candidato;
			Array[Total] = this.celulaVetor;
			Total++;
			return true;
		}
		return false;

	}

	public void DeletaCandidato(Candidato candidato) {
		if(candidato ==null) {//evita erro
			return;
		}
		if (Total != 0) {
			for (int i = 0; i < Total; i++) {
				if (Array[i] == candidato) {
					Array[i] = null;
					Array[i] = Array[Total];
					Array[Total] = null;
					Total--;
					return;
				}
			}
		}

	}

	public Candidato ObjectNumero(int numero) {
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getNumero() == numero) {
					return Array[i];// Retorna o candidato com Numero procurado
				}
			}
		}
		return null;// Não achou

	}

	public Candidato ObjectCpf(String cpf) {
		Documentos doc = new Documentos(cpf);

		if (!doc.validaCpf(cpf)) {// é um cpf valido?
			return null;
		}
		cpf = doc.toString();// pega o sem pontuação pois em candidato fica salvo o sem pontuação

		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getCpf().equals(cpf)) {
					return Array[i];// Retorna o candidato com Numero procurado
				}
			}
		}
		return null;// Não achou

	}
}
