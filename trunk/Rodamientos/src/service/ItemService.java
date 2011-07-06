package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import modelo.Item;

public interface ItemService extends Remote{
	public List<Item> findAll()throws RemoteException;
	public Item findById(int id) throws RemoteException;

}
