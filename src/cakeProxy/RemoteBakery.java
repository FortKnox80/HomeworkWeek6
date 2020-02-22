package cakeProxy;

import java.rmi.*;

public interface RemoteBakery  extends Remote {
	//Get the count
	public int getCakeCount () throws RemoteException;
	//Get the location
	public String getLocation() throws RemoteException;

}
