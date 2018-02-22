package br.com.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import br.com.bd.connection.IDAO;
import br.com.bd.connection.IPool;

public class BDDAO implements IDAO<Object>{

	
	 private IPool pool;

	    public BDDAO(IPool pool) {
		
	    	this.pool=pool;
	    	// TODO Auto-generated constructor stub
		}
	
	@Override
	public Object cadastrar(Object entidade) {
		
		
		
	    PreparedStatement statement = null;
		PreparedStatement stmt=null;
		//ResultSet rs=null;
		Connection con=pool.getConnection();
		//Fornecedor forn=(Fornecedor)fornecedor; 
		//ContaBancaria conta=entidade;
		
		//con.setAutoCommit(false);
		try {
			
			Random geradornome=new Random();
			Random geradortelefone=new Random();
			Random geradorcurso=new Random();
			String Maria="Maria ";
			String Marcio="Marcio ";
			String Marcelo="Marcelo ";
			String João="João ";
			String Katia="Katia ";
			String Julia="Julia ";
			 GregorianCalendar gc = new GregorianCalendar();

		        
			for(int i=0 ; i<100 ;i++){
				String nome="Maria "+i+1;
				int year = randBetween(1970, 1990);

		        gc.set(gc.YEAR, year);
		        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

		        gc.set(gc.DAY_OF_YEAR, dayOfYear);

				stmt=con.prepareStatement("insert into Aluno ( nome, sexo,  data_nasc, telefone,cod_curso) VALUES ( ?, ?, ?, ?,? )");
		        stmt.setString(1,nome );
			    stmt.setString(2, "F");
			    stmt.setString(3, gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH));
			    stmt.setString(4, 9+geradortelefone.nextInt(9)+1+"");
			    stmt.setString(5,geradorcurso.nextInt(10)+1+"");
	            
			    stmt.executeUpdate();
	            //rs=stmt.getGeneratedKeys();
	           
		        con.commit();
	            
	            stmt.close();
	            pool.liberarConnection(con);				
				
				
			}
			
			
		 	
            //conecta.closeConnection();
	        
	        return "true";
		} catch (SQLException e) {
			System.out.print(e.getMessage()+"");
			
			pool.liberarConnection(con);
	        return "sqlerror";
	        // TODO: handle exception
		}catch(Exception io){
			pool.liberarConnection(con);
		    return "error";
		}	}

	 public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }
	
	
	@Override
	public Object update(Object entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object excluir(Object entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(Object entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
