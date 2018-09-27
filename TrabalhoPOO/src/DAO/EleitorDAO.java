package DAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import Modelo.Eleitor;

public class EleitorDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Eleitor[] Array = new Eleitor[TAMANHO];
	private Eleitor celulaVetor = null;

	public boolean CriarEleitor(String TituloEleitor, String Nome, String Cpf, int UrnaVotacao, String Path) throws NoSuchAlgorithmException, IOException {
		if (Total <= TAMANHO) {// Evita estourar Array
			this.celulaVetor = new Eleitor(TituloEleitor, Nome, Cpf, UrnaVotacao, Path);
			if (celulaVetor != null) {// Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
				return true;
			}
		}
		return false;

	}

	public boolean CriarEleitor(Eleitor eleitor) {
		if (Total <= TAMANHO && eleitor != null) {// Evita estourar Array e "lixo" no array
			this.celulaVetor = eleitor;
			Array[Total] = this.celulaVetor;
			Total++;
			return true;
		}
		return false;

	}

	public void DeletaEleitor(Eleitor eleitor) {
		if(eleitor==null) {//Evita erro 
			return;
		}
		if (Total != 0) {
			for (int i = 0; i < Total; i++) {
				if(Array[i]!=null) {
					if (Array[i] == eleitor) {
						Array[i] = null;
						Array[i] = Array[Total];
						Array[Total] = null;
						Total--;
						return;
					}
				}
			}
		}

	}
	//Buscar por titulo e por cpf
	public Eleitor ObjectTitulo(String titulo) {
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getTituloEleitor().equals(titulo)) {
					return Array[i];// Retorna o eleitor com Numero Titulo de eleitor procurado
				}
			}
		}
		return null;// Não achou

	}
	
	public Eleitor ObjectCpf(String cpf) {
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getCpf().equals(cpf)) {
					return Array[i];// Retorna o eleitor com cpf procurado
				}
			}
		}
		return null;// Não achou

	}


}
