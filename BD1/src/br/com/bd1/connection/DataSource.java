package br.com.bd1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataSource implements IDataSource {

	private String url;
	private String driver;
	private String usuario;
	private String senha;
	
	public DataSource(String url, String driver, String usuario, String senha) {
		super();
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	    try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Classe n�o encontrada!!!");
			e.printStackTrace();
		}
	
	}

	@Override
	public Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(url,usuario,senha);
		
		//return null;
	}

}
