/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproyectopalabras;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Jona xD
 */
public interface funciones extends Remote  {
    
    public String cadena(String text) throws RemoteException;
    public String secuencial() throws RemoteException;
}
