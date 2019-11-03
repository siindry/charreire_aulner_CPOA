package controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IAddModController {
	
	public abstract void sendToDB() throws SQLException, IOException;
	public abstract void quitter() throws IOException;
	
}
