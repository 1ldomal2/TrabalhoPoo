import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.json.*;

import DAO.CandidatoDAO;
import DAO.EleitorDAO;
import DAO.PartidoDAO;
import DAO.VotoDAO;
import Modelo.Documentos;
import Modelo.Partido;


public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		CandidatoDAO cDAO =new CandidatoDAO();
		cDAO.CriarCandidato("Nome1", "11", "06680923603", "21", "s1");
		cDAO.CriarCandidato("Nome2", "12", "06680923603", "22", "s2");
		cDAO.CriarCandidato("Nome3", "13", "06680923603", "23", "s3");
		
		EleitorDAO eDAO =new EleitorDAO();
		eDAO.CriarEleitor("Titulo1","Nome1","06680923603",01,"/home/lucas/Área de Trabalho/arq1");
		
		VotoDAO vDAO =new VotoDAO();
		vDAO.CriarVoto(eDAO.Array[0], cDAO.Array[0], 1);
		
	    PartidoDAO pDAO =new PartidoDAO();
	    pDAO.CriarPartido("Nome",01);
	    
		String str=cDAO.makeJson()+"\n"
				+eDAO.makeJson()+"\n"
				+vDAO.makeJson()+"\n"
				+pDAO.makeJson();
		
		System.out.println(str);
		
		Date data=new Date();
	
		System.out.println(	data.getTime());
	}

}
