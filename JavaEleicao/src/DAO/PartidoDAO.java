package DAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Modelo.Documentos;
import Modelo.Partido;

public class PartidoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	private Partido[] Array = new Partido[TAMANHO];
	private Partido celulaVetor = null;

	public void ReadJson(String Sjson) throws NoSuchAlgorithmException, JSONException, IOException {//Acho que não precisa mas é para futuras Modificações
		//Cria um Objeto Json com a String passada como parametro
		JSONObject json=new JSONObject(Sjson);
		
		//Quebra o Json no Vetor
		JSONArray jsonPartido = json.getJSONArray("Partido");
		
		//Le o json  Candidato por Candidato
		for (int i = 0; i < jsonPartido.length(); i++) {
			//recupera candidato de índice "i" no array 
            JSONObject p = jsonPartido.getJSONObject(i);
			//Adiciona ao Vetor
            this.CriarPartido(p.getString("NomePartido"),Integer.parseInt(p.getString("NumeroPartido")));
			
		}
	}
	

	public String makeJson() {
		JSONObject json=new JSONObject();//Superior
		JSONArray partidos=new JSONArray();
		JSONObject partido=new JSONObject();//Superior
		for (int i = 0; i < Total; i++) {
			//Cria Objetos Json
			partido.put("Nome", Array[i].getNome());
			partido.put("Numero", Array[i].getNumero());
			//Adicionao Objeto Json em um vetor de Jsons
			partidos.put(partido);
		}
		json.put("Partido",partidos);
		return json.toString();
	}
	
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
			if(Array[i]!=null) {
				if (Array[i].getNumero() == numero) {
					return Array[i];// Retorna o candidato com Numero procurado
				}
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
			if(Array[i]!=null) {
				if (Array[i].getNome().equals(nome)) {
					return Array[i];// Retorna o candidato com Numero procurado
				}
			}
		}
		return null;// Não achou
	}
	
}
