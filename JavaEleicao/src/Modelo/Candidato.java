package Modelo;
/**Classe para objetos do tipo Candidato
 *private String	 Nome
 *private int		 Numero
 *private Documentos Cpf
 *private Partido	 Partido
 *
 * @author Lucas Mateus Fernandes
 */
public class Candidato {
	private String Nome;
	private int Numero;
	private Documentos Cpf;
	private Partido Partido;
	
	
	public Candidato() {
		
	}
	/**Construtor Candidato (Todos Argumentos são String)
	 * @param Nome - Nome do Candidato
	 * @param Numero - Numero do Candidato
	 * @param Cpf - Cpf do Candidato
	 * @param NumeroPartido-  Numero do Partido
	 * @param NomePartido-  Nome do Partido
	 */	
	public Candidato(String Nome,String Numero,String Cpf,String NumeroPartido,String NomePartido){//Import do Json
		//Tem que fazer o tratamento do Partido depois
		System.out.println("Validando Cpf");
		if(setCpf(Cpf)) {//Se o cpf não for valido ja aborta
			System.out.println("Cpf Valido");
			
			System.out.println("Setando Nome Candidato");
			this.Nome=Nome;
			
			System.out.println("Setando Numero Candidato");
			this.Numero=Integer.parseInt(Numero);
			
			System.out.println("Setando Partido Candidato");
			this.Partido=new Partido(NumeroPartido,NomePartido);
			System.out.println("Partido OK");
			
			System.out.println("Candidato Criado");
		}else {
			System.out.println("Cpf Invalido");
		}
		
	}
	/**@return String-  Nome Candidato
	 */	
	public String getNome() {
		return Nome;
	}
	/**@param String-  Nome Candidato
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	/**@return int-  Numero Candidato
	 */
	public int getNumero() {
		return Numero;
	}
	/**@param int-  Numero Candidato
	 */
	public void setNumero(int numero) {
		Numero = numero;
	}
	/**@param cpf-  Numero Cpf em String
	 * @return Boolean - TRUE (se cpf for valido) FALSE(se cpf for invalido)
	 */
	public boolean setCpf(String cpf) {
		Documentos doc=new Documentos();
		
		System.out.println("Validando novo CPF");
		if(doc.validaCpf(cpf)) {//So muda se o cpf passado for valido
			System.out.println("Trocando CPF");
			this.Cpf = doc;
			return true;
		}else {
			System.out.println("CPF Invalido");
		}
		return false;
	}
	/*
	 * @return String- Cpf do candidato
	 */
	public String getCpfString() {
		return Cpf.toString();
	}
	/*@return Documentos - Objecto Documentos que possui o cpf internamente
	 */
	public Documentos getCpf() {
		return Cpf;
	}
	/*@return Partido - Objecto Partido 
	 */
	public Partido getPartido() {
		return Partido;
	}
	/*@return Candidato - Objecto Candidato 
	 */
	public Candidato getCandidato() {
		return this;
	}
	/*@param partido - Objecto Partido 
	 */
	public void setPartido(Partido partido) {
		Partido = partido;
	}
}