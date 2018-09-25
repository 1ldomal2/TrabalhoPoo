package Modelo;

public class VotoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Voto[] Array = new Voto[TAMANHO];
	private Voto celulaVetor = null;


	
	
	public void CriarVoto(Eleitor eleitor,Candidato candidato,int numero) {
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Voto(eleitor,candidato, numero ) ;
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
			}
		}
		return;

	}

	public void CriarVoto(Voto Voto) {
		if (Total <= TAMANHO && Voto != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = Voto;
			Array[Total] = this.celulaVetor;
			Total++;
		}
		return;

	}

	public void DeletaVoto(Voto Voto) {
		if(Voto ==null) {//evita erro
			return;
		}
		if (Total != 0) {
			for (int i = 0; i < Total; i++) {
				if (Array[i] == Voto) {
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
