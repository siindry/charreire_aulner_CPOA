package dao;

import java.util.ArrayList;

import metier.Client;

public interface IClientDAO extends DAO<Client> {

	public abstract int createGetKey(Client ptest1);

	public abstract ArrayList<Client> findAll();


}
