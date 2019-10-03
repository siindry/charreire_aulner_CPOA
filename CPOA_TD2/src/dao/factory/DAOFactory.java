package dao.factory;

import dao.IAbonnementDAO;
import dao.IClientDAO;
import dao.IPeriodiciteDAO;
import dao.IRevueDAO;
import enumeration.EPersistance;

public abstract class DAOFactory {

	public static DAOFactory getDAOFactory(EPersistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
		case MYSQL:
		daoF = new MySQLDAOFactory();
		break;
		case LISTE_MEMOIRE:
		daoF = new ListeMemoireDAOFactory();
		break;
		}
		return daoF;
		}
	
	
		public abstract IPeriodiciteDAO getPeriodiciteDAO();
		public abstract IRevueDAO getRevueDAO();
		public abstract IClientDAO getClientDAO();
		public abstract IAbonnementDAO getAbonnementDAO();
}
