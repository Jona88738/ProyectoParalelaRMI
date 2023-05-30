/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproyectopalabras;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Jona xD
 */
public class implementacionFunciones  extends UnicastRemoteObject implements funciones {
    public static ArrayList<String> lista;
    // public ArrayList<chatCliente> clientes;        
    implementacionFunciones() throws RemoteException{
        lista = new ArrayList<String>();
    }

    @Override
    public String cadena(String text) throws RemoteException {
        lista.add(text);
    return "d";    
    }

    @Override
    public String secuencial() throws RemoteException {
        String cadena =lista.get(0)+"intermedio"+lista.get(1);
        System.out.println(cadena);
   return " d";
    }
    
}
