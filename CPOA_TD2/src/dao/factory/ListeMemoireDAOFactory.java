package dao.factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.IPeriodiciteDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import dao.memoire.ListeMemoireAbonnementDAO;
import dao.memoire.ListeMemoireClientDAO;
import dao.memoire.ListeMemoirePeriodiciteDAO;
import dao.memoire.ListeMemoireRevueDAO;
import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLPeriodiciteDAO;
import dao.mysql.MySQLRevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public IPeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireRevueDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireAbonnementDAO.getInstance();
	}

}
