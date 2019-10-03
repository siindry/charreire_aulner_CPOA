package dao.factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.IPeriodiciteDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
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
		public abstract RevueDAO getRevueDAO();
		public abstract ClientDAO getClientDAO();
		public abstract AbonnementDAO getAbonnementDAO();
}
