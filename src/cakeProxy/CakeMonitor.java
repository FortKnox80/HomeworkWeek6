package cakeProxy;

import java.rmi.*;
import java.rmi.server.*;

public class CakeMonitor extends UnicastRemoteObject implements RemoteBakery {
	//Set the unicoding
	private static final long serialVersionUID = 1L;
	RemoteBakery remoteBakery; 
	
	public CakeMonitor(RemoteBakery remoteBakery) throws RemoteException {
		this.remoteBakery = remoteBakery;
	}

	//A way to report out
	public void report() {
		try {
			System.out.println("The cake is at: " + remoteBakery.getLocation());
			System.out.println("Number of cakes being delivered: " + remoteBakery.getCakeCount());
		}
		catch ( RemoteException e) {
			e.printStackTrace();
		}
		
	}

	//Get the count
	public int getCakeCount() throws RemoteException {
		return remoteBakery.getCakeCount();
	}

	//Get the location
	public String getLocation() throws RemoteException {
		return remoteBakery.getLocation();
	}
}
