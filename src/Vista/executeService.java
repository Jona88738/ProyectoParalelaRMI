/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Jona xD
 */
public class executeService implements Runnable {

    private char[] arrcha;
    private int[] en;
    private int in;
    private int limite;
    
    public executeService(char[] arrcha,int [] en,int in,int limite){
        
        this.arrcha = arrcha;
        this.en = en;
        this.in = in;
        this.limite = limite;
        
    }
    @Override
    public void run() {
        
        recurPalabra(arrcha,en,limite);
    }
    
           
    public void recurPalabra(char[] arrcha,int [] en,int limite){
        //!=
        if(in != limite){
           
            //int cant = limite;
            int posicio = en[limite];
            recurPalabra(arrcha,en,limite-1);
            
            
             char letra = arrcha[posicio+1];
            
            
            //System.out.println("");
            if(Character.isUpperCase(letra)){
               
                arrcha[posicio+1] = Character.toLowerCase(letra);
            }else{
                arrcha[posicio+1] =  Character.toUpperCase(letra);
            }
            
            
        }else{
            
            
            char letra = arrcha[0];
        if(Character.isUpperCase(letra)){
               
                arrcha[0] = Character.toLowerCase(letra);
            }else{
                arrcha[0] =  Character.toUpperCase(letra);
            }
        }
        
       
        
    }
    
}
