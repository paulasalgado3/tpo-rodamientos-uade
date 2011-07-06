package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.ItemDAOImpl;

import modelo.Item;

import service.ItemService;

public class ItemServiceImpl extends UnicastRemoteObject implements ItemService {
	public ItemServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	private ItemDAOImpl iDAO = new ItemDAOImpl();

	@Override
	public List<Item> findAll()throws RemoteException {
				
		return iDAO.findAll(Item.class);	
	}
	public Item findById(int id)throws RemoteException{
		return iDAO.findById(id);
	}

}
