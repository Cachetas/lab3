package Application;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface MathServer extends Remote {


	
	public double getAverage(HashMap<Integer, Double> hmap) throws RemoteException;

	public double getMin(HashMap<Integer, Double> hmap) throws RemoteException;

	public double getMax(HashMap<Integer, Double> hmap) throws RemoteException;

	public double getDeviation(HashMap<Integer, Double> hmap) throws RemoteException; 

}
