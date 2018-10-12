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
	/**Construtor Candidato
	 * @param String - Nome do Candidato
	 * @param String - Numero
	 * @param String - Cpf
	 * @param String-  NumeroPartido
	 * @param String-  NomePartido
	 */	
	public Candidato(String Nome,String Numero,String Cpf,String NumeroPartido,String NomePartido){//Import do Json
		//Tem que fazer o tratamento do Partido depois
		if(setCpf(Cpf)) {//Se o cpf não for valido ja aborta
			this.Nome=Nome;
			this.Numero=Integer.parseInt(Numero);
			this.Partido=new Partido(NomePartido,NumeroPartido);
			
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
	/**@param String-  Numero Cpf
	 * @return Boolean - TRUE (se cpf for valido) FALSE(se cpf for invalido)
	 */
	public boolean setCpf(String cpf) {
		Documentos doc=new Documentos();
		if(doc.validaCpf(cpf)) {//So muda se o cpf passado for valido
			this.Cpf = doc;
			return true;
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
	/*@param Partido - Objecto Partido 
	 */
	public void setPartido(Partido partido) {
		Partido = partido;
	}
	
	/*
	public String makeJson() {
		//Cria um objecto Json
		JSONObject json=new JSONObject();
		json.put("Nome",Nome);
		json.put("Numero",Numero);
		json.put("Cpf",Cpf.toString());
		json.put("Partido",Partido.toString());
		
		//Transforma em String
		return json.toString();
	}*/
}