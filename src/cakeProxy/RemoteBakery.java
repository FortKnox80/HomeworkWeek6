package cakeProxy;

import java.rmi.*;

public interface RemoteBakery extends Remote {
	public int getCakeCount () throws RemoteException;
	public String getLocation() throws RemoteException;

}
