import org.json.*;

import DAO.CandidatoDAO;
import Modelo.Documentos;
import Modelo.Partido;


public class Main {

	public static void main(String[] args) {
		/*CandidatoDAO DAO =new CandidatoDAO();
		DAO.CriarCandidato("Nome", "Numero", "06680923603", "NomePartido", "123");
		DAO.CriarCandidato("Nome", "Numero", "06680923603", "NomePartido", "123");
		DAO.CriarCandidato("Nome", "Numero", "06680923603", "NomePartido", "123");
		String str=DAO.makeJson();
		System.out.println(str);*/

		Documentos doc =new Documentos();
		System.out.println(doc.validaCpf("06680923603"));
	}

}
