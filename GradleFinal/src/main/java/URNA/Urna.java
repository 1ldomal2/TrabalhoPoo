package URNA;

import CONEXAO.Quickstart;
import DAO.EleitorDAO;
import DAO.VotoDAO;
import DAO.CandidatoDAO;
import DAO.PartidoDAO;
import JSON.JSONArray;
import JSON.JSONObject;
import MODELO.Senha;
import MODELO.Candidato;
import MODELO.Eleitor;
import com.google.api.services.drive.Drive;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class Urna {

    private static int TotalUrnas = 0;
    private int Numero;
    private CandidatoDAO ArrayCandidato = new CandidatoDAO();
    private EleitorDAO ArrayEleitor = new EleitorDAO();
    private VotoDAO ArrayVoto = new VotoDAO();
    private PartidoDAO ArrayPartido = new PartidoDAO();
    //Questoes de segurança
    private boolean Logado = false;
    private boolean TelaVisivel = false;
    private Eleitor User = null;

    public boolean getLogado() {
        return this.Logado;
    }

    public boolean getTelaVisivel() {
        return this.TelaVisivel;
    }

    public void setTelaVisivel(boolean arg) {
        this.TelaVisivel = arg;
    }

    public static int getTotalUrnas() {
        return TotalUrnas;
    }

    public int getNumero() {
        return Numero;
    }

    public Urna() {
        TotalUrnas++;
        Numero = TotalUrnas;
    }

    public void Receive() {
        //Pega DO GOOGLE dRIVE
        try {
            ArrayPartido.Receive();
            //Partido tem que vir antes de Candidato
            ArrayCandidato.Receive();
            ArrayEleitor.Receive();
            ArrayVoto.Receive();//Voto tem que vir depois de eleitor e de candidato
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Baixar do Drive,Verifique sua Conexão");
        }
    }

    public boolean Send() {
        String Path = "./Eleicao.json";
        String Nome = "Eleicao.json";

        //Salva os Arquivos
        //Cria um arquivo
        FileWriter arq;
        try {
            arq = new FileWriter(Path);
            PrintWriter gravarArq = new PrintWriter(arq);//Objeto buffer

            String Json = makeJson();//Convertendo tudo para string
            gravarArq.printf(Json);
            arq.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showInternalMessageDialog(null, "Erro Ao criar Arquivo");
        }

        Quickstart drive = new Quickstart();
        Drive conexao = null;
        try {
            //conecta ao Drive
            conexao = drive.Conexao();
            //Apaga o Arquivo que ja estava no Drive
            drive.Delete(conexao, Nome);
            System.out.println("Apagou Arquivo Anterior");
            //Envia o Arquivopara o Drive
            drive.Upload(conexao, Nome, Path);
            System.out.println("Arquivo Enviado");
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
    
     /**
	 * 
	 * @return Json com todos os Dados DAO
	 */
	public String makeJson() {
		System.out.println("Criado Json Geral");
		JSONObject json=new JSONObject();//Superior
		
		JSONObject cJson=new JSONObject(ArrayCandidato.makeJson());
		JSONArray jsonCandidato = cJson.getJSONArray("Candidato");//Quebra o Json no Vetor
		
		JSONObject eJson=new JSONObject(ArrayEleitor.makeJson());
		JSONArray jsonEleitor = eJson.getJSONArray("Eleitor");//Quebra o Json no Vetor
		
		JSONObject pJson=new JSONObject(ArrayPartido.makeJson());
		JSONArray jsonPartido = pJson.getJSONArray("Partido");//Quebra o Json no Vetor
		
		JSONObject vJson=new JSONObject(ArrayVoto.makeJson());
		JSONArray jsonVoto = vJson.getJSONArray("Voto");//Quebra o Json no Vetor
		
		json.put("Candidato", jsonCandidato);
		json.put("Eleitor", jsonEleitor);
		json.put("Partido", jsonPartido);
		json.put("Voto", jsonVoto);
		return json.toString();
	}

    public Eleitor Login(String Path) {//Logar deixa salvo o eleitor
        if (ArrayEleitor.getTotal() == 0) {
            JOptionPane.showMessageDialog(null, "Não existe Eleitor Cadastrado");
            return null;
        }
        System.out.println("Transformando a Img em Hash");
        Senha psw = null;
        try {
            psw = new Senha(Path);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }//Transforma a Img em Hash

        String hash = psw.getHash();//Salvo a Hash
        System.out.println("Imagem>Hash :" + hash);

        System.out.println("Procurando pelo Hash");
        Eleitor eleitor = ArrayEleitor.ObjectHash(hash);//Eleitor logado

        if (eleitor == null) {//Nao logou
            System.out.println("Não Logou");
            Deslogar();//Ter um controle de segurança
            return null;
        }
        System.out.println("Logado como :" + eleitor.getNome());
        this.Logado = true;//Ter um controle de segurança
        this.User = eleitor;//Switch on
        return eleitor;
    }

    public void Deslogar() {
        this.Logado = false;//Ter um controle de segurança
        this.User = null;//switch off
        System.out.println("Deslogado");
    }

    //Cria o Voto
    public boolean Votar(Eleitor User, Candidato candidato, int nUrna) {//Ao votar vc desloga
        if (Logado == false) {
            System.out.println("Não é possivel Votar sem estar Logado");
            System.out.println("Flag Logado=False");
            return false;
        }
        if (this.User == null) {
            System.out.println("Não é possivel Votar sem estar Logado");
            System.out.println("User=NULL");
            return false;
        }
        this.ArrayVoto.CriarVoto(User, candidato, nUrna);//Criou o voto e armazenou no Array da urna
        Deslogar();
        return true;
    }

    public Candidato ProcuraCandidato(String NumeroCandidato) {
        if(ArrayCandidato.getTotal()==0){
            JOptionPane.showMessageDialog(null, "Não existe Candidato cadastrado ou você esta sem internet");
            return null;
        }
        Candidato candidato = ArrayCandidato.ObjectNumero(NumeroCandidato);
        return candidato;
    }
}
