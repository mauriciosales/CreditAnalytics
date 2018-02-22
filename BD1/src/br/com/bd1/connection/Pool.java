package br.com.bd1.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;



public class Pool implements IPool {
    private IDataSource ds;
    private ArrayBlockingQueue<Connection> conexoesLivres;
    private HashMap<String,Connection> conexoesUtilizadas;
    private int numeroMaximoConexoes;
    private ResourceBundle config;
    Connection con=null;

    public Pool(){
        config=ResourceBundle.getBundle("br.com.bd1.connection.sql");
		
		ds=new DataSource(config.getString("url"), config.getString("driver"), config.getString("usuario"), config.getString("senha"));
	    
		numeroMaximoConexoes=Integer.parseInt(config.getString("numeroMaximoConexoes"));
		conexoesLivres = new ArrayBlockingQueue<Connection>(numeroMaximoConexoes, true);
		conexoesUtilizadas = new HashMap<String, Connection>();
    }

    public void setDataSource(IDataSource ds){
    }

    public Connection getConnection(){
		 con=null;
			try {
				
				if(conexoesUtilizadas.size()<numeroMaximoConexoes){
					
					con=conexoesLivres.poll();
					if(con==null){
						con=ds.getConnection();
						con.setAutoCommit(false);
					}else if(con.isClosed()){
							this.getConnection();
						
					}
					conexoesUtilizadas.put(con.toString(),con);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			return con;
    }

    public void liberarConnection(Connection con){
    	conexoesLivres.add(con);
		conexoesUtilizadas.remove(con.toString());
    }

    public void rollback() throws SQLException{
    	this.con.rollback();
    }

    public void commit() throws SQLException 
    {
      this.con.commit();
    }
  
    public void AutoCommit(boolean bol) throws SQLException 
    {
      this.con.setAutoCommit(bol);
    }

}