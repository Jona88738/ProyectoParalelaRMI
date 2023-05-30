/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiproyectopalabras;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Jona xD
 */
public class Servidor {
    
    public static void main(String [] arg) throws RemoteException{
        Registry rmi = LocateRegistry.createRegistry(1099);
            System.out.println("ahora");
            /*
            System.setProperty("java.rmi.server.useCodebaseOnly", "false");
           if (System.getSecurityManager() == null) {
    System.setSecurityManager(new SecurityManager());
}*/
            //servidorRMI servi = new servidorRMI();
            
            //Naming.rebind("//localhost/Chat",(Remote) new implementacionChat());
            //implementacionChat im =  (implementacionChat)  UnicastRemoteObject.exportObject(servi, 0);
            
           rmi.rebind("Chat",(Remote) new implementacionFunciones());
            System.out.println("Servidor Activo");
    }
}
