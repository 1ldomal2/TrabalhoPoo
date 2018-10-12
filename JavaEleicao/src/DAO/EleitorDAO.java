package DAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Modelo.Eleitor;

/**Classe para objetos do tipo Eleitor, onde armazena um vetor 'this.Array' com n Eleitores
 * @author Lucas Mateus Fernandes
 */
public class EleitorDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	public Eleitor[] Array = new Eleitor[TAMANHO];
	private Eleitor celulaVetor = null;


	/**Le o Json
	 * @param String - Json
	 * @return Void  - Preenche "this.Array" de acordo com Json
	 */
	public void ReadJson(String Sjson) throws NoSuchAlgorithmException, JSONException, IOException {
		//Cria um Objeto Json com a String passada como parametro
		JSONObject json=new JSONObject(Sjson);
		
		//Quebra o Json no Vetor
		JSONArray jsonEleitor = json.getJSONArray("Eleitor");
		
		//Le o json  Candidato por Candidato
		for (int i = 0; i < jsonEleitor.length(); i++) {
			//recupera candidato de índice "i" no array 
            JSONObject e = jsonEleitor.getJSONObject(i);
			//Adiciona ao Vetor
            this.CriarEleitor(e.getString("TituloEleitor"), e.getString("Nome"),e.getString("Cpf"),e.getString("UrnaVotacao"),e.getString("Senha"));
			
		}
	}
	/**Cria o Json
	 * @param Void
	 * @return String - contendo o Json de "this.Array"
	 * */
	public String makeJson() {
		JSONObject json=new JSONObject();//Superior
		JSONArray eleitores=new JSONArray();
		JSONObject eleitor=new JSONObject();//Superior
		for (int i = 0; i < Total; i++) {
			//Cria Objetos Json
			eleitor.put("Nome", Array[i].getNome());
			eleitor.put("Cpf", Array[i].getCpfString());
			eleitor.put("TituloEleitor", Array[i].getTituloEleitor());
			eleitor.put("UrnaVotacao", Array[i].getUrnaVotacao());
			eleitor.put("Senha", Array[i].getHash());
			//Adicionao Objeto Json em um vetor de Jsons
			eleitores.put(eleitor);
		}
		json.put("Eleitor",eleitores);
		return json.toString();
	}
	
	/**Cria EleitorS e insere em 'this.array' Porem a senha é setada na mão
	 * @param String -Titulo Eleitor 
	 * @param String - Nome Eleitor
	 * @param String - Cpf do Eleitor 11 digitos
	 * @param String - Numero da urna de votação
	 * @param String - Senha Hash do  do eleitor
	 * @return Boolean - Confirmando se criou ou nao o eleitor
	 * */
	public boolean CriarEleitor(String TituloEleitor, String Nome, String Cpf, String UrnaVotacao, String Senha) throws NoSuchAlgorithmException, IOException {
		if (Total <= TAMANHO) {// Evita estourar Array
			this.celulaVetor = new Eleitor(TituloEleitor, Nome, Cpf, UrnaVotacao, Senha);
			if (celulaVetor != null) {// Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
				return true;
			}
		}
		return false;

	}

	/**Cria Eleitor e insere em 'this.array' Porem a senha é gerada apartir do path
	 * @param String -Titulo Eleitor 
	 * @param String - Nome Eleitor
	 * @param String - Cpf do Eleitor 11 digitos
	 * @param Int - Numero da urna de votação
	 * @param String - Caminho da imagem .ppm
	 * @return Boolean - Confirmando se criou ou nao o eleitor
	 * */
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
	/**Cria Eleitor e insere em 'this.array'
	 * @param Eleitor - Objeto eleitor
	 * @return Boolean - Confirma se inseriu ou nao o eleitor em this this.array
	 */
	public boolean CriarEleitor(Eleitor eleitor) {
		if (Total <= TAMANHO && eleitor != null) {// Evita estourar Array e "lixo" no array
			this.celulaVetor = eleitor;
			Array[Total] = this.celulaVetor;
			Total++;
			return true;
		}
		return false;

	}
	/**Deleta Eleitor de 'this.array'
	 * @param Eleitor - Objeto eleitor
	 * @return Void
	 */
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

	/**Procura e retorna a pessoas que possui o titulo 'x' em 'this.array'
	 * @param String - Titulo de eleitor
	 * @return Eleitor - Retorono o Objeto eleitor presente em this.array que possui o titulo 'x'
	 */
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
	/**Retorna a pessoa que possui o cpf 'x' em 'this.array'
	 * @param String - Numero do eleitor
	 * @return Eleitor - Retorona o Objeto Eleitor presente em this.array que possui o cpf x
	 */
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
	/**Retorna a pessoa que possui presente em 'this.array' que possui a senha hash 'x'
	 * @param String - Senha Hash do eleitor
	 * @return Eleitor - Retorona o Objeto Eleitor presente em this.array que possui a senha hash x
	 */
	public Eleitor ObjectHash(String hash) {//SeRetorna algo diferente de null é pq Senha deu Match
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getHash().equals(hash)) {
					return Array[i];// Retorna o eleitor com cpf procurado
				}
			}
		}
		return null;// Não achou
	}
	


}
