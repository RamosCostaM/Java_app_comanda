/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppratofeito;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class GerenciarMesas {
    
    private static ArrayList<Mesa> mesas = new ArrayList<Mesa> ();
    
    public static void adicionar(Mesa m){
        mesas.add(m);
    }
    
    public static  Mesa buscar (String numero){
        for(Mesa m: mesas){
            if (m.getnMesa().equals(numero) && m.isFechado()== false){
                return m;
            }
        }
        return null;
    }
    
    public static String imprimir (){
        String aux = "";
        
        for(Mesa m: mesas){
            aux += m.imprimir() + "\n";
        }
        return aux;
    }
    
    public static boolean regPedido (String numero, int novoRefri, int novoDog, int novoBatata){
        Mesa pedido = buscar(numero);
        if(pedido != null){
            pedido.setRefrigerante(pedido.getRefrigerante() +novoRefri);
            pedido.setCachorroQuente(pedido.getCachorroQuente()+ novoDog);
            pedido.setBatataFrita(pedido.getBatataFrita()+ novoBatata);
        
            return true;
        }
            return false;
    }
         
    public static String maiorConsumo (){
            String aux = "Mesa que tem o maior consumo \n";
            int consumo = 0;
            for(Mesa m: mesas){
            if ((m.getBatataFrita()+ m.getCachorroQuente()+ m.getRefrigerante()) >= consumo){
                consumo =(m.getBatataFrita()+ m.getCachorroQuente()+ m.getRefrigerante());}
            }
            for(Mesa m: mesas){
            if ((m.getBatataFrita()+ m.getCachorroQuente()+ m.getRefrigerante()) == consumo){
                aux += m.imprimir() + "\n";}
            }
            return aux;
    }
   }
