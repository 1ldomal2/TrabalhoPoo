package Modelo;

public class CandidatoDAO {
	private final int TAMANHO = 50;
	private static int TotalCandidatos = 0;
	private Candidato[] CandidatoArray = new Candidato[TAMANHO];
	private Candidato celulaVetor = null;

	public void CriarCandidato(String Nome, int Numero, String Cpf, Partido partido) {
		if (TotalCandidatos <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Candidato(Nome, Numero, Cpf, partido);
			if (celulaVetor != null) {//Evita "lixo" no array
				CandidatoArray[TotalCandidatos] = this.celulaVetor;
				TotalCandidatos++;
			}
		}
		return;

	}

	public void CriarCandidato(Candidato candidato) {
		if (TotalCandidatos <= TAMANHO && candidato != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = candidato;
			CandidatoArray[TotalCandidatos] = this.celulaVetor;
			TotalCandidatos++;
		}
		return;

	}

	public void DeletaCandidato(Candidato candidato) {

		if (TotalCandidatos != 0) {
			for (int i = 0; i < TotalCandidatos; i++) {
				if (CandidatoArray[i] == candidato) {
					CandidatoArray[i] = null;
					CandidatoArray[i] = CandidatoArray[TotalCandidatos];
					CandidatoArray[TotalCandidatos] = null;
					TotalCandidatos--;
					return;
				}
			}
		}

	}

	public int IndiceNumero(int numero) {
		for (int i = 0; i < TotalCandidatos; i++) {
			if (CandidatoArray[i].getNumero() == numero) {
				return i;// Retorna o indice do candidato com Numero procurado
			}
		}
		return -1;// Não achou

	}

	public int IndiceCpf(String cpf) {
		Documentos doc = new Documentos(cpf);

		if (!doc.validaCpf(cpf)) {// é um cpf valido?
			return -1;
		}
		cpf = doc.toString();// pega o sem pontuação pois em candidato fica salvo o sem pontuação

		for (int i = 0; i < TotalCandidatos; i++) {
			if (CandidatoArray[i].getCpf().equals(cpf)) {
				return i;// Retorna o indice do candidato com Numero procurado
			}
		}
		return -1;// Não achou

	}

	public Candidato ObjectNumero(int numero) {
		for (int i = 0; i < TotalCandidatos; i++) {
			if (CandidatoArray[i].getNumero() == numero) {
				return CandidatoArray[i];// Retorna o indice do candidato com Numero procurado
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

		for (int i = 0; i < TotalCandidatos; i++) {
			if (CandidatoArray[i].getCpf().equals(cpf)) {
				return CandidatoArray[i];// Retorna o indice do candidato com Numero procurado
			}
		}
		return null;// Não achou

	}
}