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
		c.validaCpf(cpf);
		if(c.getValidCpf()==true) {
			Cpf = c;
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
	
	
	
	
}
