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
		System.out.println("Start");
		//Criando Strutura para armazenamento do voto
		VotoDAO vDAO=new VotoDAO();
		//Cria tela de Login
		Login ins=new Login(vDAO);
		ins.setVisible(true);
		
		System.out.println("Esperando Login");
	}
}

