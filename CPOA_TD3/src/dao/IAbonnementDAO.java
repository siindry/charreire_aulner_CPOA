package dao;

import java.util.ArrayList;

import metier.Abonnement;

public interface IAbonnementDAO extends DAO<Abonnement>{

	public abstract ArrayList<Abonnement> findAll();
	public abstract Abonnement getBy2Id(int id1, int id2);
	public abstract ArrayList<Integer> createGetKey(Abonnement atest1);
}
