package dao;

import java.util.ArrayList;

import metier.Revue;

public interface IRevueDAO extends DAO<Revue> {

	public abstract ArrayList<Revue> findAll();

	public abstract int createGetKey(Revue ptest1);

}
