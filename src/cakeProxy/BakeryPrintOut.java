package cakeProxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class BakeryPrintOut {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		//Set the locations
		String[] location = {"rmi.santafe.bakery.com/bakery",
							 "rmi.delaware.bakery.com/bakery",
							 "rmi.columbus.bakery.com/bakery"};
		
		//Set up a monitor
		CakeMonitor[] monitor = new CakeMonitor[location.length];
		
		
		for(int i=0; i< location.length; i++) {
			try {
				RemoteBakery remote = (RemoteBakery) Naming.lookup(location[i]);
				monitor[i] = new CakeMonitor(remote); 
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		for(int i =0; i<monitor.length; i++) {
			monitor[i].report();
		}
	}

}
