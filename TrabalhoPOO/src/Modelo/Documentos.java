package Modelo;

public class Documentos {
	private boolean fomatedCpf=false;
	private boolean validCpf=false;
	private String formated="";
	private String noFormated="";
	
	public Documentos(String cpf){
		validaCpf(cpf);
	}
	public Documentos(){
		
	}
	public boolean getFomatedCpf() {
		return fomatedCpf;
	}
	public boolean getValidCpf() {
		return validCpf;
	}
	
	public boolean validaCpf(String cpf) {
		int nponto = 0;
		int nhifen = 0;
		int[] dv1 = new int[11];//coloco 11 mas na vdd usa so 9
		int[] dv2 = new int[11];//assim fica mais facil de fazer o for
		int tamanho=cpf.length();
		//Quantidade de caracteres
		int indice=0;
		if(!(tamanho==14 || tamanho==11)) {
			validCpf=false;
			return false;
			//Sem pontuação tamanho é 11 digitos
			//Com pontuação tamanho é 14 = 11 digitos  2 '.' 1'-'
		}
		if(tamanho==14){//Verifica se os pontos estao nos lugares certos
			if(cpf.charAt(3)!='.') {
				validCpf=false;
				return false;
			}
			if(cpf.charAt(7)!='.') {
				validCpf=false;
				return false;
			}
			if(cpf.charAt(11)!='-') {
				validCpf=false;
				return false;
			}

			for (indice = 0; indice < tamanho; indice++) {
				if(cpf.charAt(indice)!='0') {
				//For aninhado evita processamento desneecessário
					if(cpf.charAt(indice)!='1') {
						if(cpf.charAt(indice)!='2') {
							if(cpf.charAt(indice)!='3') {
								if(cpf.charAt(indice)!='4') {
									if(cpf.charAt(indice)!='5') {
										if(cpf.charAt(indice)!='6') {
											if(cpf.charAt(indice)!='7') {
												if(cpf.charAt(indice)!='8') {
													if(cpf.charAt(indice)!='9') {
														if(cpf.charAt(indice)!='.') {
															if(cpf.charAt(indice)!='-') {
																validCpf=false;
																return false;
																//Se não for igual a nenhum digito e nem '.' ou '-' o usuario passou algum caractere invalido
															}else {
																nhifen++;
																if(nhifen >1) {//Evita que tenha mais de 1 hifen
																	validCpf=false;
																	return false;
																}
																continue;
															}
														}else {
															nponto++;
															if(nponto >2) {//Evita que tenha mais de 2 pontos
																validCpf=false;
																return false;
															}
															continue;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					dv1[(indice-(nhifen+nponto))]=( cpf.charAt(indice)-'0')*(10-(indice-(nhifen+nponto)));
					//Primeiramente multiplica-se os 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 e soma os resultados
					dv2[(indice-(nhifen+nponto))]=( cpf.charAt(indice)-'0')*(11-(indice-(nhifen+nponto)));
					//Primeiramente multiplica-se os 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 e soma os resultados
				}
			}
		}
		if(tamanho==11){//Verifica se os pontos estao nos lugares certos
			for (indice = 0; indice < tamanho; indice++) {
				if(cpf.charAt(indice)!='0') {
				//For aninhado evita processamento desneecessário
					if(cpf.charAt(indice)!='1') {
						if(cpf.charAt(indice)!='2') {
							if(cpf.charAt(indice)!='3') {
								if(cpf.charAt(indice)!='4') {
									if(cpf.charAt(indice)!='5') {
										if(cpf.charAt(indice)!='6') {
											if(cpf.charAt(indice)!='7') {
												if(cpf.charAt(indice)!='8') {
													if(cpf.charAt(indice)!='9') {
														validCpf=false;
														return false;//Se não for igual a nenhum digito
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			//OBS:AscII 0 é o primeiro digito e 9 o ultimo
			dv1[indice]=(cpf.charAt(indice)-'0')*(10-indice);
			//Primeiramente multiplica-se os 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 e soma os resultados
			dv2[indice]=(cpf.charAt(indice)-'0')*(11-indice);
			//Primeiramente multiplica-se os 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 e soma os resultados
		
		}
		int total1=0;
		int total2=0;
		for (int i = 0; i < 9; i++) {//Somatorio 
			total1+=dv1[i];
			total2+=dv2[i];
		}

		if(tamanho==11) {//Verifica se os digitos batem "opção sem formataçao"
			if((cpf.charAt(9)-'0')!=((total1*10)%11)) {
				validCpf=false;
				return false;
			}
			if((cpf.charAt(10)-'0')!=((total2*10)%11)) {
				validCpf=false;
				return false;
			}
			fomatedCpf=false;//Seta as variaveis
			noFormated=cpf;//Seta as variaveis
		}else {//Verifica se os digitos batem "opçao com formatação"s
			if(tamanho==14) {
				if((cpf.charAt(12)-'0')!=((total1*10)%11)) {
					validCpf=false;
					return false;
				}
				if((cpf.charAt(13)-'0')!=((total2*10)%11)) {
					validCpf=false;
					return false;
				}
				fomatedCpf=true;//Seta as variaveis
				formated=cpf;
			}
		}
		validCpf=true;
		stringsCpf();
		return true;
			
	}
	public String regiaoCpf(String cpf) {
		if(validCpf != true) {
			return "Cpf Invalido";
		}
		char digito= ' ';
		
		if(fomatedCpf==true) {
			digito=cpf.charAt(10);//9ºDigito
		}else {
			digito=cpf.charAt(8);//9ºDigito
		}
			switch (digito) {
			case '0':
				return "Rio Grande do Sul";
			case '1':
				return "Distrito Federal ou Goiás ou Mato Grosso ou Mato Grosso do Sul ou Tocantins";
			case '2':
				return "Amazonas ou Pará ou Roraima ou Amapá ou Acre ou Rondônia";
			case '3':
				return "Ceará ou Maranhão ou Piauí";
			case '4':
				return "Paraíba ou Pernambuco ou Alagoas ou Rio Grande do Norte";
			case '5':
				return "Bahia ou Sergipe";
			case '6':
				return "Minas Gerais";
			case '7':
				return "Rio de Janeiro ou Espírito Santo";
			case '8':
				return "São Paulo";
			case '9':
				return "Paraná ou Santa Catarina";				
			default:
				return "Cpf Invalido";
			}		
	}
	public void stringsCpf(){
		String cpf ="";
		if(fomatedCpf==true) {
			cpf+=formated.charAt(0);
			cpf+=formated.charAt(1);
			cpf+=formated.charAt(2);
			//.
			cpf+=formated.charAt(4);
			cpf+=formated.charAt(5);
			cpf+=formated.charAt(6);
			//.
			cpf+=formated.charAt(8);
			cpf+=formated.charAt(9);
			cpf+=formated.charAt(10);
			//-
			cpf+=formated.charAt(11);
			cpf+=formated.charAt(12);
			
			this.noFormated=cpf;
		}else {
			cpf+=formated.charAt(0);
			cpf+=formated.charAt(1);
			cpf+=formated.charAt(2);
			cpf+='.';//.
			cpf+=formated.charAt(3);
			cpf+=formated.charAt(4);
			cpf+=formated.charAt(5);
			cpf+='.';//.
			cpf+=formated.charAt(6);
			cpf+=formated.charAt(7);
			cpf+=formated.charAt(8);
			cpf+='-';//-
			cpf+=formated.charAt(9);
			cpf+=formated.charAt(10);
			
			this.noFormated=cpf;
		}
		return;
		
	}
	public String toString(){
		return formated;	
	}
	public String toStringPonto(){
		return noFormated;		
	}
	public boolean equals(String cpf){//Verifica se é igual formatado ou não
		if(cpf.equals(formated)||cpf.equals(noFormated)) {
			return true;	
		}
		return false;
	}
	
}
