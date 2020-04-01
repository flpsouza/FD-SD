package Servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class IniciaServidor {
    
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando servidor");
            LocateRegistry.createRegistry(1099);
            
            Produto objetoPrduto = new Produto();
            Naming.rebind("rmi://127.0.0.1:1099/Produto", objetoPrduto);
            
        } catch (RemoteException re) {
            
            System.out.println("Erro remoto: " + re.toString());            
        } catch (Exception e) {
            
            System.out.println("Erro Local: " + e.toString());            
        }
    }
    
}
