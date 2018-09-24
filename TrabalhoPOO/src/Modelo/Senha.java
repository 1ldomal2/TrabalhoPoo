package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author lucas 
 * 		   Por motivos segurança é permitido apenas set da senha
 *         Get da senha retorna hash em string para verificação
 */
public class Senha {
	private int[][] Imagem;
	private String ImagemConcatenada;
	private String Hash;

	public Senha() {

	}

	public void setImagem(int[][] imagem) throws NoSuchAlgorithmException {
		Imagem = imagem;
		setHash();
	}

	private void setHash() throws NoSuchAlgorithmException {// SHA-256
		MessageDigest crypto = MessageDigest.getInstance("SHA-256");// Seleciona o tipo de cripitografia
		crypto.update(ImagemConcatenada.getBytes());// Numero de bytes a ser cripitografado
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
	
	public boolean equal(Senha senha) {//Verifica se o Hash de ambas senhas são iguais
		return this.Hash.equals(senha.Hash);
	}
}
