package Modelo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EleitorDAO {
	private final int TAMANHO = 50;
	private static int TotalEleitores = 0;
	private Eleitor[] EleitorArray = new Eleitor[TAMANHO];
	private Eleitor celulaVetor = null;

	public void CriarEleitor(String TituloEleitor, String Nome, String Cpf, int UrnaVotacao, String Path) throws NoSuchAlgorithmException, IOException {
		if (TotalEleitores <= TAMANHO) {// Evita estourar Array
			this.celulaVetor = new Eleitor(TituloEleitor, Nome, Cpf, UrnaVotacao, Path);
			if (celulaVetor != null) {// Evita "lixo" no array
				EleitorArray[TotalEleitores] = this.celulaVetor;
				TotalEleitores++;
			}
		}
		return;

	}

	public void CriarEleitor(Eleitor eleitor) {
		if (TotalEleitores <= TAMANHO && eleitor != null) {// Evita estourar Array e "lixo" no array
			this.celulaVetor = eleitor;
			EleitorArray[TotalEleitores] = this.celulaVetor;
			TotalEleitores++;
		}
		return;

	}

	public void DeletaEleitor(Eleitor eleitor) {

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

}
