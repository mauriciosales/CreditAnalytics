package br.com.bd1.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataSource {
	 public abstract Connection getConnection() throws SQLException;
}
