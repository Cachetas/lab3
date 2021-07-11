package Application;

import java.rmi.RemoteException;

public class ClientProgram {
	
	public static void main(String[] args)  {
		Client client = new Client();
	
		try {
			client.readFile();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Média: " + client.getAverage() + ";\nValor Min: " + client.getMin() + ";" );
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} 
		try {
			System.out.println("Valor Max: " + client.getMax() + ";\nDesvio Padrão: " + client.getDeviation());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
	}
	
}
