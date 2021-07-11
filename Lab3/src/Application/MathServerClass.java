package Application;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map.Entry;

public class MathServerClass extends UnicastRemoteObject implements MathServer {
	
	
	//Construtor
	protected MathServerClass() throws RemoteException {
			
	}
	
	private static final long serialVersionUID = 6002403091583962682L;
	
	double average;	
	
	public double getAverage(HashMap<Integer, Double> hmap) throws RemoteException {
		int counter = 0;
		double total = 0;
		average = 0;
		for(Entry<Integer, Double> value : hmap.entrySet()) {
			total = total + value.getValue();
			counter++;
			
		}
		
		average = total / counter;
		System.out.println("Média calculada: " + average);
		return average;
		
	}
	
		
	public double getMin(HashMap<Integer, Double> hmap) throws RemoteException {
		 boolean firstElement = true;
		 double min = 0; 
		for(Entry<Integer, Double> value : hmap.entrySet()) {
			
			if (firstElement == true) {
				min = value.getValue();
				firstElement = false;
			} else {
				
				if (value.getValue() <= min) {
					min = value.getValue();
				} 
			}
		}
		
		System.out.println("Minimo calculado: " + min);
		return min;
		
	}
	
	public double getMax(HashMap<Integer, Double> hmap) throws RemoteException {
		boolean firstElement = true;
		double max = 0;
		for(Entry<Integer, Double> value : hmap.entrySet()) {
			
			if (firstElement == true) {
				max = value.getValue();
				firstElement = false;
			} else {
	
				if (value.getValue() >= max) {
					max = value.getValue();
				}
			}
		}
		System.out.println("Maximo calculado: " + max);
		return max;
	}
	
	
	public double getDeviation(HashMap<Integer, Double> hmap) throws RemoteException {
		int counter = 0;
		double deviation = 0;
		for(Entry<Integer, Double> value : hmap.entrySet()) {
			deviation = deviation + (value.getValue() - average) * (value.getValue() - average);
			counter++;
		}
		
		counter--;
		deviation = deviation / counter;
		deviation = Math.sqrt(deviation);
		
		System.out.println("Devio padrao calculado: " + deviation);
		return deviation;
	}
}


