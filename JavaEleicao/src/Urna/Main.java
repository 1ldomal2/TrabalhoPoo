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
		//Criando Strutura para armazenamento do voto
		VotoDAO vDAO=new VotoDAO();
		
		System.out.println("Start");
		//Cria tela de Login
		Login ins=new Login(vDAO);
		ins.setVisible(true);
		
		System.out.println("Esperando Login");
	}
}

