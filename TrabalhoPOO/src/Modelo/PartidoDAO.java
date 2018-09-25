package Modelo;


public class PartidoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Partido[] Array = new Partido[TAMANHO];
	private Partido celulaVetor = null;

	public boolean CriarPartido(String Nome, int Numero) {
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Partido(Nome, Numero ) ;
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
				return true;
			}
		}
		return false;

	}

	public boolean CriarPartido(Partido partido) {
		if (Total <= TAMANHO && partido != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = partido;
			Array[Total] = this.celulaVetor;
			Total++;
			return true;
		}
		return false;

	}

	public void DeletaPartito(Partido partido) {
		if(partido ==null) {//evita erro
			return;
		}
		if (Total != 0) {
			for (int i = 0; i < Total; i++) {
				if (Array[i] == partido) {
					Array[i] = null;
					Array[i] = Array[Total];
					Array[Total] = null;
					Total--;
					return;
				}
			}
		}

	}

	public Partido ObjectNumero(int numero) {
		for (int i = 0; i < Total; i++) {
			if (Array[i].getNumero() == numero) {
				return Array[i];// Retorna o candidato com Numero procurado
			}
		}
		return null;// Não achou

	}

	public Partido ObjectNome(String nome) {
		Documentos doc = new Documentos(nome);

		if (!doc.validaCpf(nome)) {// é um cpf valido?
			return null;
		}
		nome = doc.toString();// pega o sem pontuação pois em candidato fica salvo o sem pontuação

		for (int i = 0; i < Total; i++) {
			if (Array[i].getNome().equals(nome)) {
				return Array[i];// Retorna o candidato com Numero procurado
			}
		}
		return null;// Não achou
	}
	
}
