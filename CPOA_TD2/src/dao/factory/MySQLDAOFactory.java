package dao.factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.IPeriodiciteDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLPeriodiciteDAO;
import dao.mysql.MySQLRevueDAO;

public class MySQLDAOFactory extends DAOFactory {

	//doit utiliser toutes les méthodes de DAOFactory! 
	
	@Override
	public IPeriodiciteDAO getPeriodiciteDAO() {
	return MySQLPeriodiciteDAO.getInstance();
	}
	
	
	@Override
	public IRevueDAO getRevueDAO() {
	return MySQLRevueDAO.getInstance();
	}
	
	@Override
	public IClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	
	@Override
	public IAbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}


	
	
	
}
