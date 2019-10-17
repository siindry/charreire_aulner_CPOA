package dao;

public interface DAO<T> {
	
	abstract T getById(int id);
	abstract boolean create(T objet);
	abstract boolean update(T objet);
	abstract boolean delete(T objet);
	
}
