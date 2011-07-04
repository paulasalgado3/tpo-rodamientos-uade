package service.impl;

import java.util.List;

import dao.impl.ItemDAOImpl;

import modelo.Item;
import modelo.SolicitudCompra;
import service.ItemService;

public class ItemServiceImpl implements ItemService {
	private ItemDAOImpl iDAO = new ItemDAOImpl();

	@Override
	public List<Item> findAll() {
				
		return iDAO.findAll(Item.class);	
	}

}
