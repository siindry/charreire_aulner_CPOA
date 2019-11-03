package controller;

import java.io.IOException;
import java.sql.SQLException;

public interface ITableController {
	
	public abstract void affMod();
	public abstract void affAdd();
	public abstract void quitter() throws IOException;
	public abstract void supprimer() throws IOException, SQLException;
	
}
