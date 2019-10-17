package dao;

import java.util.ArrayList;

import metier.Periodicite;

public interface IPeriodiciteDAO extends DAO<Periodicite> {
	//pour ajouter des spécificités à une table
	public abstract int createGetKey(Periodicite objet);

	public abstract ArrayList<Periodicite> findAll();

	public abstract Periodicite getByLib(String lib);
}
