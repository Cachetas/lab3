package Application;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;


public class Client {
	
	private MathServer mathServer;
	
 	String row;
 	String pathFileName = "data.csv";
	int date = 0, close = 1;
	BufferedReader csv;
	boolean notNumber = true;
	HashMap<Integer, Double> hmap = new HashMap<Integer, Double>();
	
	 public Client() {
	        try {
	            mathServer = (MathServer) Naming.lookup("rmi://server/MathServer1");
	        } catch (NotBoundException | MalformedURLException | RemoteException e){
	            e.printStackTrace();
	        }
	    }

	 public void readFile() throws RemoteException {
			
			try {
			 csv = new BufferedReader(new FileReader(pathFileName));

			 while ((row = csv.readLine()) != null) {
				    String[] data = row.split(";");
				    if (notNumber == true) {
				    	notNumber = false;
				    } else {
				    	
				    	 hmap.put(Integer.valueOf(data[date]), Double.parseDouble(data[close]));
				    }
				}
			}	catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	 
		public double getAverage() throws RemoteException {
		
			return mathServer.getAverage(hmap);			
		}
				
		public double getMin() throws RemoteException {	
			return mathServer.getMin(hmap);
		}

		public double getMax() throws RemoteException {
			return mathServer.getMax(hmap);
		}

		public double getDeviation() throws RemoteException {
			return mathServer.getDeviation(hmap);
		}
}
