/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproyectopalabras;

import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Jona xD
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public funciones servidor;
    public Cliente(){
        
        try{
            int port = 1099;
            
            
            Registry rmii = LocateRegistry.getRegistry("192.168.100.6",port);
             servidor = (funciones) rmii.lookup("Chat");
            //new Thread(new implementacionClienteChat(nom, servidor)).start();
            
        }catch(HeadlessException | NotBoundException | RemoteException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            int port = 1099;
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            
            Registry rmii = LocateRegistry.getRegistry("192.168.100.6",port);
            funciones servidor = (funciones) rmii.lookup("Chat");
            //new Thread(new implementacionClienteChat(nom, servidor)).start();
            
        }catch(HeadlessException | NotBoundException | RemoteException e){
            System.out.println(e.getMessage());
        }
    }
    }
    

