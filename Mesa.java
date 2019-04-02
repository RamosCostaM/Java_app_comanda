/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppratofeito;

/**
 *
 * @author Diego
 */
public class Mesa {
    
    private String nMesa;
    private int qtdPessoas;
    private boolean fechado;
    private int refrigerante;
    private int cachorroQuente;
    private int batataFrita;

    public Mesa(String numeroDaMesa, int qtdPessoas, boolean fechado, int refri, int dog, int batata) {
        this.nMesa = numeroDaMesa;
        this.qtdPessoas = qtdPessoas;
        this.fechado = fechado;
        this.refrigerante = refri;
        this.cachorroQuente = dog;
        this.batataFrita = batata;
    }
    
  public Mesa(String numero) {
        this(numero, 0, false, 0, 0,0);
    }

    public String getnMesa() {
        return nMesa;
    }

    public void setnMesa(String nMesa) {
        this.nMesa = nMesa;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public int getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(int refrigerante) {
        this.refrigerante = refrigerante;
    }

    public int getCachorroQuente() {
        return cachorroQuente;
    }

    public void setCachorroQuente(int cachorroQuente) {
        this.cachorroQuente = cachorroQuente;
    }

    public int getBatataFrita() {
        return batataFrita;
    }

    public void setBatataFrita(int batataFrita) {
        this.batataFrita = batataFrita;
    }
   
    public String statusConta(){
       String aux="";
       
       if(this.isFechado() != true)
            aux = "\nConta aberta.\n";
       else
            aux = "\nConta fechada.\n";
       
       return aux;
    }
    
    public double valorConta() {
        double valorConta;
        
        valorConta = (this.refrigerante*2) + (this.cachorroQuente*5) + (this.batataFrita*4);
        
        return valorConta;
    }
   
    public String imprimir (){
     
        return "Comanda mesa: "+ this.nMesa + "\nQuantidade de pessoas: "+ this.qtdPessoas +"\n"+ 
                "\nRefrigerante: " + this.refrigerante + " - Valor = R$ " + 
                (this.refrigerante * 2) + "\nCachorro-quente: "+
                this.cachorroQuente +" - Valor = R$ " + (this.cachorroQuente * 5) 
                + "\nBatata frita: "+ this.batataFrita + " - Valor = R$ " + 
                (this.batataFrita * 4) + "\nValor total: R$" + valorConta() + "\n    "+ statusConta();
    }
}