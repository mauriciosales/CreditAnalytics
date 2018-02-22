package br.com.bd1.connection;
import java.sql.Connection;





public interface IPool {

    public abstract void setDataSource(IDataSource ds);

    public abstract Connection getConnection();

    public void liberarConnection(Connection con);

}
