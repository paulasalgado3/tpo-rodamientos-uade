package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.ProveedorService;

@SuppressWarnings("serial")
public class ProveedorServiceImpl extends UnicastRemoteObject implements
		ProveedorService {

	public ProveedorServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
