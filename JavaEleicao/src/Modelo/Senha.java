package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;

/**
 * 
 * @author lucas 
 * 		   Por motivos segurança é permitido apenas set da senha
 *         Get da senha retorna hash em string para verificação
 */
public class Senha {
	//private int[][] Imagem;
	private String senha;
	private String Hash;
	private Boolean Inconsistencia=false;
	//Se o Hash foi setado na mão, o dado é inconsistente 
	//Todo dado que sai do google e vai para urna será inconsistente
	//Se o dado for incosistente não sera possivel passar da central para o google
	
	public Senha(String path) throws NoSuchAlgorithmException, IOException {
		this.setImagem(path);
	}
	public Senha(String Inconsistente,String Hash) {
		if(Inconsistente.equals("INCONSISTENTE")) {
			this.Hash=Hash;
			this.Inconsistencia=true;
		}
	}
	
	public void setHash(String Hash) {//So é possivel setar o hash na hora de importar o json
		this.Hash=Hash;
	}

	public void setImagem(String path) throws IOException, NoSuchAlgorithmException{
		
		FileReader arq = new FileReader(path);//Abre o Arquivo localizada em $Path
		
		BufferedReader lerArq = new BufferedReader(arq);//Buffer do Arrquivo aberto

		String conteudoArq="";
        try {
			while(arq.ready()){//Le Arquivo
				conteudoArq+=lerArq.readLine();  //Concatena todo o arquivo é uma so string      	
			}
		} catch (IOException e) {//Nao entendo ainda o que é try catch mas foipara evitar erro
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        arq.close();//Fecha Arquivo
        this.senha=conteudoArq;//transfere da variavel de escopo local para uma variavel persistente
        
		setHash();
	}

	private void setHash() throws NoSuchAlgorithmException {// SHA-256
		MessageDigest crypto = MessageDigest.getInstance("SHA-256");// Seleciona o tipo de cripitografia
		crypto.update(this.senha.getBytes());// Numero de bytes a ser cripitografado
		byte[] cadeiaByte = crypto.digest();// Retorna a cripitografia em binário

		//Converte o vetor de bytes em string
		StringBuilder aux = new StringBuilder();// Constroi uma string
		for (int i = 0; i < cadeiaByte.length; i++) {// Percorre N-bytes
			// Basicamente é bitwise,
			int parteAlta = ((cadeiaByte[i] >> 4) & 0xf) << 4;
			int parteBaixa = cadeiaByte[i] & 0xf;
			if (parteAlta == 0)
				aux.append('0');
			aux.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		Hash=aux.toString();//Transforma em String
	}	

	public String getHash() {
		return Hash;
	}
	
	public boolean equals(Senha senha) {//Verifica se o Hash de ambas senhas são iguais
		return this.Hash.equals(senha.Hash);
	}
	public boolean equals(String senha) {//Verifica se o Hash de ambas senhas são iguais
		return this.Hash.equals(senha);
	}
	
}
