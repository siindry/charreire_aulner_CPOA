package dao;

import java.sql.SQLException;

public interface DAO<T> {
	
	abstract T getById(int id) throws SQLException;
	abstract boolean create(T objet) throws SQLException;
	abstract boolean update(T objet) throws SQLException;
	abstract boolean delete(T objet);
	
}
