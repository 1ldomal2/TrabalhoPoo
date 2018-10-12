package DAO;

import org.json.JSONArray;
import org.json.JSONObject;

import Modelo.Candidato;
import Modelo.Documentos;

/**Classe para objetos do tipo CandidatoDAO, onde armazena um vetor 'this.Array' com n Candidatos
 * @author Lucas Mateus Fernandes
 */

public class CandidatoDAO {
	private final int TAMANHO = 50;
	private static int Total = 0;
	public Candidato[] Array = new Candidato[TAMANHO];
	private Candidato celulaVetor = null;
	

	/**Le o Json
	 * @param String - Json
	 * @return Void  - Preenche "this.Array" de acordo com Json
	 */
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
	/**Cria o Json
	 * @param Void
	 * @return String - contendo o Json de "this.Array"
	 * */
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
	/**Cria Candidato e insere em 'this.array'
	 * @param String - Nome Candidato
	 * @param String - Numero Candidato
	 * @param String - Cpf do Candidato
	 * @param String - Nome do Partido
	 * @param String - Numero do Partido
	 * @return Boolean - Confirmando se criou ou nao o candidato
	 * */
	
	public boolean CriarCandidato(String Nome, String Numero, String Cpf, String NomePartido,String NumeroPartido) {
		if (Total < TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Candidato(Nome, Numero, Cpf, NomePartido, NumeroPartido);
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
				return true;
			}
		}
		return false;
	}
	/**Cria Candidato e insere em 'this.array'
	 * @param Candidato - Objeto candidato
	 * @return Boolean -  Confirma se inseriu ou nao o candidato em this this.array
	 */
	public boolean CriarCandidato(Candidato candidato) {
		if (Total <= TAMANHO && candidato != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = candidato;
			Array[Total] = this.celulaVetor;
			Total++;
			return true;
		}
		return false;

	}
	
	/**Deleta Candidato de 'this.array'
	 * @param Candidato - Objeto candidato
	 * @return Void
	 */
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
	
	/**Numero de pessoas que possui o cpf 'x' em 'this.array'
	 * @param String - Cpf do candidato
	 * @return int - Numero de pessoas com cpf 'x'
	 */
	public int intCCPF(String cpf) {
		int contador=0;
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getCpf().equals(cpf)) {
					contador++;
				}
			}
		}
		return contador;// Não achou
	}
	
	/**Procura e retorna a pessoas que possui o numero 'x' em 'this.array'
	 * @param String - Numero do candidato
	 * @return Candidato - Retorono o Objeto Candidato presente em this.array que possui o numero x
	 */
	public Candidato ObjectNumero(String numero) {
		int num=Integer.parseInt(numero);
		for (int i = 0; i < Total; i++) {
			if(Array[i]!=null) {
				if (Array[i].getNumero() == num) {
					return Array[i];// Retorna o candidato com Numero procurado
				}
			}
		}
		return null;// Não achou

	}
	/**Numero de pessoas que possui o cpf 'x' em 'this.array'
	 * @param String - cpf do candidato
	 * @return Candidato - Retorono o Objeto Candidato presente em this.array que possui o numero x
	 */
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
