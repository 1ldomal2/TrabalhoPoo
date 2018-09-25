package Modelo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Eleitor {
	private String TituloEleitor;
	private String Nome;
	private Documentos Cpf;
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
	
	public void setCpf(String cpf) {
		Documentos c=new Documentos();
		if(c.validaCpf(cpf)) {//So muda se o cpf passado for valido
			this.Cpf = c;
		}
	}
	
	public Documentos getCpf() {
		return Cpf;
	}
	public void setUrnaVotacao(int urnaVotacao) {
		UrnaVotacao = urnaVotacao;
	}//Possivel Erro é se Colocar para votar em uma urna que não existe
	
	public int getUrnaVotacao() {
		return UrnaVotacao;
	}
	//Provavelmente cancelar esse metodo pois deixa vuneravel
	public void setImagemSenha(Senha imagemSenha) {//Ja passa a senha para a pessoa
		this.ImagemSenha = imagemSenha;
	}
	public void setImagemSenha(String Path) throws NoSuchAlgorithmException, IOException {//Passa o caminho do arquivo
		this.ImagemSenha = new Senha(Path);
	}
	
	
	
		
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
	
}
