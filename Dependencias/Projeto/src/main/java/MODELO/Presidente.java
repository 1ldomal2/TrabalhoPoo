/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author lucas
 */
public class Presidente extends Candidato {

   
    public Presidente(String Nome, String Numero, String Cpf, String NumeroPartido, String NomePartido,String Sigla) throws Throwable{
        //Chama o construtor do pai
        super(Nome,Numero,Cpf,NumeroPartido,NomePartido);
        //Se o Cpf foi valido continua fazendo o Deputado
        if(this.getNome()!= null){
         
            if(Sigla != Estados.BR.getSigla()){
                this.finalize();
            }
        }
        
    }
    public Presidente(String Nome, String Numero, String Cpf, String NumeroPartido, String NomePartido,int Cod) throws Throwable{
        //Chama o construtor do pai
        super(Nome,Numero,Cpf,NumeroPartido,NomePartido);
        //Se o Cpf foi valido continua fazendo o Deputado
        if(this.getNome()!= null){
            if(Cod != Estados.BR.getCod()){
                this.finalize();
            }
        }
        
    }
}
