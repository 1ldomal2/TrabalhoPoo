package Central;

import DAO.CandidatoDAO;
import DAO.EleitorDAO;
import DAO.PartidoDAO;
import DAO.VotoDAO;
import VISAO.TelaCentral;

public class VerificacaoTela {

	private CandidatoDAO cDAO=null;
	private EleitorDAO eDAO=null;
	private PartidoDAO pDAO=null;
	private VotoDAO	vDAO=null;
	
	public VerificacaoTela(CandidatoDAO cDAO,EleitorDAO eDAO,PartidoDAO pDAO,VotoDAO vDAO) {
		//Seta as Principais Variaveis
		this.cDAO=cDAO;
		this.eDAO=eDAO;
		this.pDAO=pDAO;
		this.vDAO=vDAO;	
	}
	
}
