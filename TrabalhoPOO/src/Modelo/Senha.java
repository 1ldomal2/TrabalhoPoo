package Modelo;
/**
 * 
 * @author lucas
 *Por motivos segurança é permitido apenas set da senha
 *Get da senha retorna um hash para verificação
 */
public class Senha {
	private int[][] Imagem;
	private String Hash;
	
	public Senha(){
	
	}
	public void setImagem(int[][] imagem) {
		Imagem = imagem;
	}
	private int[][] getImagem() {
		return Imagem;
	}
	private void setHash(String hash) {
		Hash = hash;
	}
	public String getHash() {
		return Hash;
	}
}
