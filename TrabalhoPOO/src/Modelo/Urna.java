package Modelo;

public class Urna {
	private static int TotalUrnas=0;
	private int Numero;
	
	public static int getTotalUrnas() {
		return TotalUrnas;
	}
	public int getNumero() {
		return Numero;
	}
	public Urna() {
		TotalUrnas++;
		Numero=TotalUrnas;
	}
	public void Receive() {//Não sei o que tem que retorna
		//Pega DO GOOGLE dRIVE
	}
	public void Send() {
		//mANDA PARA O GOOGLE DRIVE
	}
	public boolean Login() {
		
	}
	public Voto Votar() {
		
	}

}
