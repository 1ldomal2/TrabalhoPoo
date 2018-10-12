package Urna;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.json.*;

import DAO.CandidatoDAO;
import DAO.EleitorDAO;
import DAO.PartidoDAO;
import DAO.VotoDAO;
import Interface.Login;
import Modelo.Documentos;
import Modelo.Partido;


public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		//Cria tela de Login
		Login ins=new Login();
		ins.setVisible(true);
	}
}

