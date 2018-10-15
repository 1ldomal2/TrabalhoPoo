package Central;

import DAO.CandidatoDAO;
import DAO.EleitorDAO;
import DAO.PartidoDAO;
import DAO.VotoDAO;
import VISAO.CentralBotão;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start");
		//Criando Strutura para armazenamento
			//Candidatos
			CandidatoDAO cDAO=new CandidatoDAO();
			//Eleitores
			EleitorDAO eDAO=new EleitorDAO();
			//Partidos
			PartidoDAO pDAO=new PartidoDAO();
			//Votos
			VotoDAO vDAO=new VotoDAO();
			
		//Cria tela da Central
		CentralBotão ins=new CentralBotão(cDAO,eDAO,pDAO,vDAO);
		ins.setVisible(true);
		

	}

}
