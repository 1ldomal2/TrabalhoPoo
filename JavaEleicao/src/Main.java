import org.json.*;

import DAO.CandidatoDAO;
import Modelo.Documentos;
import Modelo.Partido;


public class Main {

	public static void main(String[] args) {
		CandidatoDAO DAO =new CandidatoDAO();
		DAO.CriarCandidato("Nome", "123", "06680923603", "123", "qqq");
		DAO.CriarCandidato("Nome", "321", "06680923603", "123", "aa");
		DAO.CriarCandidato("Nome", "123", "06680923603", "123", "ss");
		String str=DAO.makeJson();
		System.out.println(str);
		
	}

}
