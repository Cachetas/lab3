package Application;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServerProgram {
	
	protected ServerProgram() throws RemoteException {
	}

	public static void main(String[] args) throws RemoteException {
		
		System.out.println("[Server started]");
        
        Registry reg = LocateRegistry.createRegistry(1099);
    
            try {
            	
					reg.rebind("MathServer1", new MathServerClass());

			} catch (RemoteException e) {
				e.printStackTrace();
			}  
	}
}
