package Modelo;
import org.json.*;
import java.util.Date;

public class Partido {
	private String Nome;
	private int Numero;
	private Date DataCadastro;
	
	
	//Neste caso chamar funçoes gera uma sobrecarga ou seja é possivel fazer mas não é viavel
	public Partido(String nome,int numero) {
		setNome(nome);
		setNumero(numero);
		DataCadastro=new Date();		
	}
	public Partido(String nome,String numero) {//Import do Json
		this.Numero=Integer.parseInt(numero);
		this.Nome=nome;
		DataCadastro=null;//So é relevante para a Central		
	}
		
	public Date getDataCadastro() {
		return DataCadastro;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public String getNome() {
		return Nome;
	}
	public String getNOME() {//ESTA FUNCIONANDO ?????????????
		String aux=this.Nome.toUpperCase();//Transforma tudo em caixa alta
		String[] parts = aux.split(" ");//Separa em espaços
		String retorno ="";
		for (int i = 0; i < parts.length; i++) {//Junta tudo ignorando espaço
			retorno+=parts[i];
		}
				
		return retorno;
	}
	
	public void setNumero(int numero) {
		Numero = numero;
	}
	
	public int getNumero() {
		return Numero;
	}
	
	public String toString(){
		return Nome;	
	}
	
	public String makeJson() {
		//Cria um objecto Json
		JSONObject json=new JSONObject();
		json.put("Nome",Nome);
		json.put("Numero",Numero);
		json.put("Data",DataCadastro.getTime());

		//Transforma em String
		return json.toString();
	}
	
}