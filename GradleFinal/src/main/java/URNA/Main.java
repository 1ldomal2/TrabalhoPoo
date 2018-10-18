package URNA;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import DAO.VotoDAO;
import VISAO.Login;


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

