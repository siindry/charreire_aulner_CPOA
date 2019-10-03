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
	public RevueDAO getRevueDAO() {
	return MySQLRevueDAO.getInstance();
	}
	
	@Override
	public ClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	
	@Override
	public AbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}


	
	
	
}
