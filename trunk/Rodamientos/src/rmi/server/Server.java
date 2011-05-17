package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			
			//Naming.rebind("//localhost", arg1);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
