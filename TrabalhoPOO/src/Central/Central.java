package Central;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import DAO.*;
import Modelo.*;

public class Central {

	private CandidatoDAO candidato = new CandidatoDAO();
	private EleitorDAO eleitor = new EleitorDAO();
	private PartidoDAO partido = new PartidoDAO();
	private VotoDAO voto = new VotoDAO();


	public boolean Send() {
		// Envia todos os Sends
	}

	public boolean Receive() {
		// Chama todos os Receives
		// Por enquanto tem so um receive mesmo
	}

	public boolean Resultado() {
		// Pesquisar os resultados
		// Fazer uma relação de Candidatos Votos (Procurar voto por Candidato)
		// Fazer uma relação de Partidos Votos (Procurar voto por partido)
		// **Se quiser ponto extra //Fazer um "Grafico de regiao" com percentual de cada
		// Candidato

	}

	public boolean CadastroEleitor(String cpf, String tituloEleitor, String nome, String Path, int nUrna)
			throws NoSuchAlgorithmException, IOException {
		Eleitor eleitor = new Eleitor();

		// String Cpf - Pesquisar e ver se mais alguem tem o mesmo Cpf
		if (this.eleitor.ObjectCpf(cpf) != null) {
			return false;// Ja existe alguem com este cpf
		}
		eleitor.setCpf(cpf);

		// String TituloEleitor
		eleitor.setTituloEleitor(tituloEleitor);

		// String Nome
		eleitor.setNome(nome);

		// String Senha
		eleitor.setImagemSenha(Path);

		// int UrnaVotação, Pesquisar e ver se a urna existe
		// ????????
		// ????????
		// ????????

		if (this.eleitor.CriarEleitor(eleitor))// Adiciona o eleitor
			return true;// If de uma linha - caso o comando dentro do if seja de apenas uma linha não
						// precisa de chave
		return false;

	}

	public boolean CadastroCandidatos(String nome, int numero, String cpf, Partido partido) {
		if (partido == null) {
			return false;
		}
		Candidato candidato = new Candidato();//Cria o objeto para colocar no Array

		// int Numero Pesquisar e ver se mais alguem tem o mesmo Numero
		if (this.candidato.ObjectNumero(numero) != null)// se diferente de null é porque ja existe esse cpf cadastrado
			return false;
		candidato.setNumero(numero);

		// String Cpf Pesquisar e ver se mais alguem tem o mesmo Cpf
		if (this.candidato.ObjectNumero(numero) != null)// se diferente de null é porque ja existe esse numero
														// cadastrado
			return false;
		candidato.setNumero(numero);

		// String Nome
		candidato.setNome(nome);

		// Partido partido
		candidato.setPartido(partido);

		if (this.candidato.CriarCandidato(candidato))// Adiciona o candidato
			return true;// If de uma linha - caso o comando dentro do if seja de apenas uma linha não
						// precisa de chave
		return false;

	}

	public boolean CadastroPartidos(String nome,int numero) {
		Partido partido=new Partido();//Cria o objeto para colocar no Array

		// String Nome, Pesquisar se mais alguem tem o mesmo nome (Colocando em caixa alta e tirando espaço)
		if(this.partido.ObjectNome(nome)!=null)//verifica se não existe nimguem com o mesmo nome
			return false;
		partido.setNome(nome);
		

		// int Numero Pesquisar se mais alguem tem o mesmo numero
		if(this.partido.ObjectNumero(numero)!=null)//verifica se não existe nimguem com o mesmo nome
			return false;
		partido.setNumero(numero);
		
		if (this.partido.CriarPartido(partido))// Adiciona o candidato
			return true;// If de uma linha - caso o comando dentro do if seja de apenas uma linha não
						// precisa de chave
		return false;
	}
	
}
