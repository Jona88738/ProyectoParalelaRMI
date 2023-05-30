/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Arrays;

/**
 *
 * @author Jona xD
 */
public class secuencial {
    
    private String text;
    private int[] arrEn;
    //private char[]  arrcha ;
    public secuencial(String text,int[] arrEn){
        this.text = text;
        this.arrEn = arrEn;
       // this.arrcha  = new char[text.length()];
    }
                         
    public void recurPalabra(char[] arrcha,int [] en,int vueltas){
        
        //1
        if(vueltas != 0){
            //int medio = text.length()/2;
            int cant = vueltas;
            int posicio = en[vueltas];
            recurPalabra(arrcha,en,vueltas-1);
            
            
            char letra = arrcha[posicio+1];
            //char pa = ' ';
            System.out.println("");
            //System.out.println("la letra es: "+letra);
            //arrcha[vueltas+1] = letra;
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
