/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Jona xD
 */
public class forkJoin extends RecursiveAction {

    private char[] arrcha;
    private int[] en;
    private int vueltas;
    
    
    public forkJoin(char[] arrcha,int [] en,int vueltas){
        this.arrcha = arrcha;
        this.en = en;
        this.vueltas = vueltas;
    }
    
    
    
    @Override
    protected void compute() {
        //0
        if(vueltas != 0){
            
            int cant = vueltas;
            int posicio = en[vueltas];
            
            forkJoin le = new forkJoin(arrcha,en,vueltas-1);
           
            le.compute();
            
            char letra = arrcha[posicio+1];
           
            System.out.println("");
           // System.out.println("la letra es: "+letra);
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
    
    public void recurPalabra(char[] arrcha,int [] en,int vueltas){
        
      
        if(vueltas+1 != 0){
            //int medio = text.length()/2;
            int cant = vueltas;
            int posicio = en[vueltas];
            recurPalabra(arrcha,en,vueltas-1);
            
            
            char letra = arrcha[posicio+1];
            
           
            System.out.println("la letra es: "+letra);
            
            if(Character.isUpperCase(letra)){
               
                arrcha[posicio+1] = Character.toLowerCase(letra);
            }else{
                arrcha[posicio+1] =  Character.toUpperCase(letra);
            }
            
            
        }else{
            
        }
        
        
    }
    
}
