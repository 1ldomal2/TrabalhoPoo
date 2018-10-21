package URNA;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import DAO.VotoDAO;
import VISAO.Login;
import VISAO.TelaLogin;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		System.out.println("Start");
		//Criando Strutura para armazenamento do voto
		Urna instancia=new Urna();
                
		//Cria tela de Login
                TelaLogin ins=new TelaLogin(instancia);
                while(true){
                    try{
                        if(ins.getTelaVisivel()==false && ins.getLogado()==false){
                            System.out.println("Esperando Login");
                            ins=new TelaLogin(instancia);
                        }else{
                            //System.out.println("Se eu comentar essa Linha da um bug Estranho");
                            continue;
                        }
                    }catch(Exception evt){
                        System.out.println("BUG");
                         ins=new TelaLogin(instancia);
                    }
                }
	}
}

