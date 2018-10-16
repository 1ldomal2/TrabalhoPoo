package DAO;

import MODELO.Voto;
import MODELO.Candidato;
import MODELO.Eleitor;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import JSON.JSONArray;
import JSON.JSONException;
import JSON.JSONObject;

/**Classe para objetos do tipo Voto, onde armazena um vetor 'this.Array' com n Votos
 * @author Lucas Mateus Fernandes
 */
public class VotoDAO {
	private final int TAMANHO = 50;
	private  int Total = 0;
	private Voto[] Array = new Voto[TAMANHO];
	private Voto celulaVetor = null;
	//Quando carregar ???
	private EleitorDAO ArrayE = null;
	private CandidatoDAO ArrayC = null;
	
	
	/**Conexao com Google drive*/
	public void Receive() {
		System.out.println("Conexao com Google Drive 'Votos'");
		//Carrega Votos
		String json="{\"Voto\":[{\"CpfCandidato\":\"066.809.236-03\",\"CpfEleitor\":\"066.809.236-03\",\"nUrna\":\"1\",\"Time\":\"1539405966018\"},{\"CpfCandidato\":\"066.809.236-03\",\"CpfEleitor\":\"066.809.236-03\",\"nUrna\":\"1\",\"Time\":\"1539405966018\"}]}";
		
		//Carrega Candidatos
		ArrayC=new CandidatoDAO();
		ArrayC.Receive();
		//Carrega Eleitores
		ArrayE=new EleitorDAO();
		ArrayE.Receive();
		
		try {
			ReadJson(json);
		} catch (NoSuchAlgorithmException | JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**Le o Json
	 * @param Sjson - Json
	 * @return Void  - Preenche "this.Array" de acordo com Json
	 */
	public void ReadJson(String Sjson) throws NoSuchAlgorithmException, JSONException, IOException {//Acho que não precisa mas é para futuras Modificações
		System.out.println("Lendo Json");
		//Cria um Objeto Json com a String passada como parametro
		JSONObject json=new JSONObject(Sjson);
		
		//Quebra o Json no Vetor
		JSONArray jsonVoto = json.getJSONArray("Voto");
		//Le o json  Voto por Voto
		for (int i = 0; i < jsonVoto.length(); i++) {
			//recupera candidato de índice "i" no array 
            JSONObject v = jsonVoto.getJSONObject(i);
            //Procura Candidato por Cpf
            Candidato cand=ArrayC.ObjectCpf(v.getString("CpfCandidato"));
            //Procura Eleitor por Cpf
            Eleitor ele=ArrayE.ObjectCpf(v.getString("CpfEleitor"));
            
			//Adiciona ao Vetor
            this.CriarVoto(ele,cand, Integer.parseInt(v.getString("nUrna")),Long.parseLong(v.getString("Time")));
		}
	}
	
	/**Cria o Json
	 * @param Void
	 * @return String - contendo o Json de "this.Array"
	 * */
	public String makeJson() {
		System.out.println("Criando Json");
		System.out.println(Total);
		JSONObject json=new JSONObject();//Superior
		JSONArray votos=new JSONArray();
		JSONObject[] voto=new JSONObject[Total];//Superior
		for (int i = 0; i < Total; i++) {
			voto[i]=new JSONObject();
			//Cria Objetos Json
			voto[i].put("CpfEleitor", Array[i].getECPF());
			voto[i].put("CpfCandidato", Array[i].getCCPF());
			voto[i].put("nUrna",""+Array[i].getNumeroUrna());
			voto[i].put("Time",""+Array[i].getTime());
			//Adicionao Objeto Json em um vetor de Jsons
			votos.put(voto[i]);
		}
		json.put("Voto",votos);
		return json.toString();
	}
	/**Cria o Voto e o insere em 'this.array'  É ACONSELHAVEL USAR ESTE METODO DENTRO DA URNA POIS A DATA DO VOTO É GERADA AUTOMATICAMENTE
	 * @param Eleitor Objeto Eleitor
	 * @param Candidato - Objeto Candidato
	 * @param numero - numero da urna
	 * @return Boolean - Confirmando se criou ou nao o voto
	 * */
	public void CriarVoto(Eleitor eleitor,Candidato candidato,int numero) {
		System.out.println("Criando Voto");
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Voto(eleitor,candidato, numero ) ;
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
			}
		}
		return;

	}
	/**Cria o Voto e o insere em 'this.array'  É ACONSELHAVEL USAR ESTE METODO DENTRO DA CENTRAL POIS A DATA DO VOTO NÃO É GERADA AUTOMATICAMENTE
	 
	 *@param eleitor Objeto Eleito
	 *@param candidato - Objeto Candidato
	 *@param numero - numero da urna
	 *@param time - long refente a data de criação do voto (segundos decorridos deste o inicio de 1970) 
	 *@return Boolean - Confirmando se criou ou nao o voto
	 * */
	public void CriarVoto(Eleitor eleitor,Candidato candidato,int numero,long time) {
		System.out.println("Criando Voto");
		if (Total <= TAMANHO) {//Evita estourar Array
			this.celulaVetor = new Voto(eleitor,candidato, numero,time) ;
			if (celulaVetor != null) {//Evita "lixo" no array
				Array[Total] = this.celulaVetor;
				Total++;
			}
		}
		return;

	}
	/**Cria Voto e insere em 'this.array'
	 * @param Voto - Objeto Voto
	 * @return Boolean -  Confirma se inseriu ou nao o Voto em this this.array
	 */
	public void CriarVoto(Voto Voto) {
		System.out.println("Criando Voto");
		if (Total <= TAMANHO && Voto != null) {//Evita estourar Array e "lixo" no array
			this.celulaVetor = Voto;
			Array[Total] = this.celulaVetor;
			Total++;
		}
		return;

	}

	public int getTotal() {
		return Total;
	}
	
	/**Deleta Voto de 'this.array'
	 * @param Voto - Objeto Voto
	 * @return Void
	 */
	public void DeletaVoto(Voto Voto) {
		System.out.println("Deletando Voto");
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
	/**Pesquisa em 'this.array' o numero de votos que o candidato 'x' recebeu 
	 * @param Candidato - Objeto Candidato
	 * @return int - Numero de votos que o Candidato 'x' recebeu
	 */
	public int NVotosCandidato(Candidato candidato) {
		if(candidato==null) {
			System.out.println("Candidato não Existe");
			return 0;
		}
		
		System.out.println("Contabilizando Votos de "+candidato.getNome());
		int nVotos=0;//Variavel a ser retornada		
		for (int i = 0; i < Total; i++) {
			if(Array[i] != null) {//evita erro
				if(Array[i].getCandidato()==candidato) {
					nVotos++;// Conta Numero de votos no candidato "x"
				}
			}
		}
		return nVotos;
	}
}


