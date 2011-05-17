package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.RodamientoService;

@SuppressWarnings("serial")
public class RodamientoServiceImpl extends UnicastRemoteObject implements
		RodamientoService {

	public RodamientoServiceImpl() throws RemoteException {
		super();
	}

}
