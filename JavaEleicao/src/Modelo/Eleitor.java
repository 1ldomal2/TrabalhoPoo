package Modelo;
import org.json.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Eleitor {
	private String Nome;
	private Documentos Cpf;
	private String TituloEleitor;
	private int UrnaVotacao;
	private Senha ImagemSenha;

	
	public void setTituloEleitor(String tituloEleitor) {
		TituloEleitor = tituloEleitor;
	}
	public String getTituloEleitor() {
		return TituloEleitor;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getNome() {
		return Nome;
	}
	
	public String getCpfString() {
		return Cpf.toString();
	}
	
	public Documentos getCpf() {
		return Cpf;
	}
	
	public void setCpf(String cpf) {
		Documentos doc=new Documentos();
		if(doc.validaCpf(cpf)) {//So muda se o cpf passado for valido
			this.Cpf = doc;
		}
	}
	
	
	public void setUrnaVotacao(int urnaVotacao) {
		UrnaVotacao = urnaVotacao;
	}//Possivel Erro é se Colocar para votar em uma urna que não existe
	
	public int getUrnaVotacao() {
		return UrnaVotacao;
	}
	
	public void setImagemSenha(Senha imagemSenha){//Provavelmente cancelar esse metodo pois deixa vuneravel
		this.ImagemSenha = imagemSenha;
	}
	public void setImagemSenha(String Path) throws NoSuchAlgorithmException, IOException {//Passa o caminho do arquivo
		this.ImagemSenha = new Senha(Path);
	}
	public String getHash() {//Retorna o Hash da senha
		return ImagemSenha.getHash();
	}
	
	public String makeJson() {
		//Cria um objecto Json
		JSONObject json=new JSONObject();
		json.put("Nome",Nome);
		json.put("Cpf",Cpf.toString());
		json.put("TituloEleitor",TituloEleitor);
		json.put("UrnaVotacao",UrnaVotacao);
		json.put("Senha",ImagemSenha.getHash());
		
		//Transforma em String
		return json.toString();
	}
	
	
	
	
	
	//Depois tem que apagar alguns desses construtores
	public Eleitor(String TituloEleitor,String Nome, Documentos Cpf,int UrnaVotacao,Senha ImagemSenha) {
		this.TituloEleitor=TituloEleitor;
		this.Nome=Nome;
		this.Cpf=Cpf;
		this.UrnaVotacao=UrnaVotacao;
		this.ImagemSenha=ImagemSenha;
	}
	public Eleitor(String TituloEleitor,String Nome, String Cpf,int UrnaVotacao,Senha ImagemSenha) {
		this.TituloEleitor=TituloEleitor;
		this.Nome=Nome;
		this.Cpf=new Documentos(Cpf);
		this.UrnaVotacao=UrnaVotacao;
		this.ImagemSenha=ImagemSenha;
	}
	public Eleitor(String TituloEleitor,String Nome, String Cpf,int UrnaVotacao,String ImagemSenha) throws NoSuchAlgorithmException, IOException {
		this.TituloEleitor=TituloEleitor;
		this.Nome=Nome;
		this.Cpf=new Documentos(Cpf);
		this.UrnaVotacao=UrnaVotacao;
		this.ImagemSenha=new Senha(ImagemSenha);
	}
	public Eleitor(String TituloEleitor,String Nome, Documentos Cpf,int UrnaVotacao,String ImagemSenha) throws NoSuchAlgorithmException, IOException {
		this.TituloEleitor=TituloEleitor;
		this.Nome=Nome;
		this.Cpf=Cpf;
		this.UrnaVotacao=UrnaVotacao;
		this.ImagemSenha=new Senha(ImagemSenha);
	}
	public Eleitor(String TituloEleitor,String Nome, String Cpf,String UrnaVotacao,String Hash) throws NoSuchAlgorithmException, IOException {////Import do Json
		Documentos cpf=new Documentos(Cpf);
		if (cpf.getValidCpf()) {		
			this.TituloEleitor=TituloEleitor;
			this.Nome=Nome;
			this.Cpf=cpf;
			this.UrnaVotacao=Integer.parseInt(UrnaVotacao);
			this.ImagemSenha=new Senha("INCONSISTENTE",Hash);//So será permitido setar o Hash por conta do Json
		}
	}
	public Eleitor() {
		// TODO Auto-generated constructor stub
	}
	
	
}
