package Modelo;

public class Urna {
	private static int TotalUrnas=0;
	private int Numero;
	
	public static int getTotalUrnas() {
		return TotalUrnas;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public int getNumero() {
		return Numero;
	}
	public Urna() {
		TotalUrnas++;
		Numero=TotalUrnas;
	}
	
}
