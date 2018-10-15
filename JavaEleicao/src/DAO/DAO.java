package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cria Json de tudo misturado
 * @author lucas
 *
 */
public class DAO {
	private CandidatoDAO cDAO=null;
	private EleitorDAO eDAO=null;
	private PartidoDAO pDAO=null;
	private VotoDAO vDAO=null;
	
	public DAO(CandidatoDAO cDAO,EleitorDAO eDAO,PartidoDAO pDAO,VotoDAO vDAO){
		this.cDAO=cDAO;
		this.eDAO=eDAO;
		this.pDAO=pDAO;
		this.vDAO=vDAO;
	}

	/**
	 * 
	 * @return Json com todos os Dados DAO
	 */
	public String Salvar() {
		System.out.println("Criado Json Geral");
		JSONObject json=new JSONObject();//Superior
		
		JSONObject cJson=new JSONObject(cDAO.makeJson());
		JSONArray jsonCandidato = cJson.getJSONArray("Candidato");//Quebra o Json no Vetor
		
		JSONObject eJson=new JSONObject(eDAO.makeJson());
		JSONArray jsonEleitor = eJson.getJSONArray("Eleitor");//Quebra o Json no Vetor
		
		JSONObject pJson=new JSONObject(pDAO.makeJson());
		JSONArray jsonPartido = pJson.getJSONArray("Partido");//Quebra o Json no Vetor
		
		JSONObject vJson=new JSONObject(vDAO.makeJson());
		JSONArray jsonVoto = vJson.getJSONArray("Voto");//Quebra o Json no Vetor
		
		json.put("Candidato", jsonCandidato);
		json.put("Eleitor", jsonEleitor);
		json.put("Partido", jsonPartido);
		json.put("Voto", jsonVoto);
		return json.toString();
	}
	

}
