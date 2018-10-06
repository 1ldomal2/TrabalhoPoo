package DAO;

import org.json.JSONArray;
import org.json.JSONObject;

import Modelo.Candidato;
import Modelo.Documentos;
import Modelo.Partido;

public class CandidatoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Candidato[] Array = new Candidato[TAMANHO];
	private Candidato celulaVetor = null;
	
	
	public void ReadJson(String Sjson) {
		//Cria um Objeto Json com a String passada como parametro
		JSONObject json=new JSONObject(Sjson);
		
		//Quebra o Json no Vetor
		JSONArray jsonCandidatos = json.getJSONArray("Candidato");
		
		//Le o json  Candidato por Candidato
		for (int i = 0; i < jsonCandidatos.length(); i++) {
			//recupera candidato de índice "i" no array 
            JSONObject c = jsonCandidatos.getJSONObject(i);
			//Adiciona ao Vetor
            this.CriarCandidato(c.getString("Nome"), c.getString("Numero"),c.getString("Cpf"),c.getString("NomePartido"),c.getString("NumeroPartido"));
			
		}
		
		
	}
	public String makeJson() {
		JSONObject json=new JSONObject();//Superior
		JSONArray candidatos=new JSONArray();
		JSONObject candidato=new JSONObject();//Superior
		for (int i = 0; i < Total; i++) {
			//Cria Objetos Json
			candidato.put("Nome", Array[i].getNome());
			candidato.put("Numero", Array[i].getNumero());
			candidato.put("Cpf", Array[i].getCpf());
			candidato.put("NomePartido", Array[i].getPartido().getNome());
			candidato.put("NumeroPartido", Array[i].getPartido().getNumero());
			//Adicionao Objeto Json em um vetor de Jsons
			candidatos.put(candidato);
		}
		json.put("Candidato",candidatos);
		return json.toString();
	}
	
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
	public boolean CriarCandidato(String Nome, String Numero, String Cpf, String NomePartido,String NumeroPartido) {
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Candidato(Nome, Numero, Cpf, NomePartido, NumeroPartido);
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
