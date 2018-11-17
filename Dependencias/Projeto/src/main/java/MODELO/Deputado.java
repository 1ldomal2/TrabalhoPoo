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
public class Deputado  extends Candidato{
    private String estado = null;

    public Deputado(String Nome, String Numero, String Cpf, String NumeroPartido, String NomePartido,String Sigla) throws Throwable{
        //Chama o construtor do pai
        super(Nome,Numero,Cpf,NumeroPartido,NomePartido);
        //Se o Cpf foi valido continua fazendo o Deputado
        if(this.getNome()!= null){
            //Seta o Estado
            estado=Estados.valueOf(Sigla).getSigla();
            //Se estado=null nao foi possivel criar o Deputado
            if(estado == null){
                this.finalize();
            }else{
               if(estado == Estados.BR.getSigla()){//Se vier BR é presidente e não deputado Federal
                this.finalize();
               } 
            }
        }
        
    }
    public void setEstado(String estado){
        this.estado=estado;
        return;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
}
