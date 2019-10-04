package dao.factory;

import dao.IAbonnementDAO;
import dao.IClientDAO;
import dao.IPeriodiciteDAO;
import dao.IRevueDAO;
import dao.memoire.ListeMemoireAbonnementDAO;
import dao.memoire.ListeMemoireClientDAO;
import dao.memoire.ListeMemoirePeriodiciteDAO;
import dao.memoire.ListeMemoireRevueDAO;



public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public IPeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public IRevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireRevueDAO.getInstance();
	}

	@Override
	public IClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public IAbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireAbonnementDAO.getInstance(); //ancienne version
	}

}
