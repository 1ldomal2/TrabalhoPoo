package Modelo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EleitorDAO {
	private final int TAMANHO = 50;
	private static int TotalEleitores = 0;
	private Eleitor[] EleitorArray = new Eleitor[TAMANHO];
	private Eleitor celulaVetor = null;

	public boolean CriarEleitor(String TituloEleitor, String Nome, String Cpf, int UrnaVotacao, String Path) throws NoSuchAlgorithmException, IOException {
		if (TotalEleitores <= TAMANHO) {// Evita estourar Array
			this.celulaVetor = new Eleitor(TituloEleitor, Nome, Cpf, UrnaVotacao, Path);
			if (celulaVetor != null) {// Evita "lixo" no array
				EleitorArray[TotalEleitores] = this.celulaVetor;
				TotalEleitores++;
				return true;
			}
		}
		return false;

	}

	public boolean CriarEleitor(Eleitor eleitor) {
		if (TotalEleitores <= TAMANHO && eleitor != null) {// Evita estourar Array e "lixo" no array
			this.celulaVetor = eleitor;
			EleitorArray[TotalEleitores] = this.celulaVetor;
			TotalEleitores++;
			return true;
		}
		return false;

	}

	public void DeletaEleitor(Eleitor eleitor) {
		if(eleitor==null) {//Evita erro 
			return;
		}
		if (TotalEleitores != 0) {
			for (int i = 0; i < TotalEleitores; i++) {
				if (EleitorArray[i] == eleitor) {
					EleitorArray[i] = null;
					EleitorArray[i] = EleitorArray[TotalEleitores];
					EleitorArray[TotalEleitores] = null;
					TotalEleitores--;
					return;
				}
			}
		}

	}
	//Buscar por titulo e por cpf
	public Eleitor ObjectTitulo(String titulo) {
		for (int i = 0; i < TotalEleitores; i++) {
			if (EleitorArray[i].getTituloEleitor().equals(titulo)) {
				return EleitorArray[i];// Retorna o eleitor com Numero Titulo de eleitor procurado
			}
		}
		return null;// Não achou

	}
	
	public Eleitor ObjectCpf(String cpf) {
		for (int i = 0; i < TotalEleitores; i++) {
			if (EleitorArray[i].getCpf().equals(cpf)) {
				return EleitorArray[i];// Retorna o eleitor com cpf procurado
			}
		}
		return null;// Não achou

	}


}
