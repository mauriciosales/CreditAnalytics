package br.com.bd1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.bd1.bean.Atributo;
import br.com.bd1.connection.IDAO;
import br.com.bd1.connection.IPool;

public class TreinamentoRedesBayesianas implements IDAO<Object> {

	 private IPool pool;
	 public TreinamentoRedesBayesianas(IPool pool){
		 this.pool=pool;
	 }
	 public Object treinamentoDaClasse(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
		    float probabilidadeInadimplente, probabilidadeAdimplente=0.0f;
			try {
				          
	                 String situacao=""+entidade;
				//PreparedStatement stmt = null;
				ResultSet rs = null;
				stmt = con.prepareStatement("select (count(distinct f.id_fatura)/count(distinct f2.id_fatura)) as prob from dimensaofatura as f, dimensaofatura as f2 where f.faturasituacao=?");
                stmt.setString(1, situacao);
				rs = stmt.executeQuery();
				    // Usuario usuario = null;

				if (rs.next())
				{

					
                    probabilidadeInadimplente=(float)rs.getFloat("prob");
                    //System.out.println("% Inadimplentes:"+probabilidadeInadimplente);
					stmt.close();
					rs.close();
					
					
					pool.liberarConnection(con);
					return probabilidadeInadimplente;
				}
				return false;
				} catch (SQLException e) {
				System.out.print(e.getMessage()+"");
				
				pool.liberarConnection(con);
		        return "sqlerror";
		        // TODO: handle exception
			}catch(Exception io){
				pool.liberarConnection(con);
			    return "error";
			}	
		}

	 public Object treinamentoAtributosBayesiano(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
		    float probabilidade=0.0f;
			try {
				   Atributo atributo=(Atributo)entidade;       
	              String val="c.sexo";   
				//PreparedStatement stmt = null;
				ResultSet rs = null;
				stmt = con.prepareStatement("select (count(distinct c.id_cliente)/count(distinct f2.id_fatura)) as prob from dimensaofatura as f, dimensaofatura as f2, dimensaocliente as c, fato2 as fato where f2.faturasituacao=? and fato.chave_cliente=c.id_cliente and fato.chave_fatura=f.id_fatura and "+atributo.getNomeAtributo() +"=? and f.faturasituacao=? ");
                stmt.setString(1, ""+atributo.getClasse());
				stmt.setString(2, ""+atributo.getAtributo());
				//stmt.setString(3, "c.sexo");
				stmt.setString(3, ""+atributo.getClasse());
                rs = stmt.executeQuery();
				    // Usuario usuario = null;

				if (rs.next())
				{

					
                 probabilidade=(float)rs.getFloat("prob");
                 //System.out.println("% da classe Inadimplentes sao masculinos:"+probabilidade);
					stmt.close();
					rs.close();
				
					
					pool.liberarConnection(con);
					return probabilidade;
				}
				return false;
				} catch (SQLException e) {
				System.out.print(e.getMessage()+"");
				
				pool.liberarConnection(con);
		        return "sqlerror";
		        // TODO: handle exception
			}catch(Exception io){
				pool.liberarConnection(con);
			    return "error";
			}	
		}

	 public Object treinamentoAtributoEstadoCivil(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
		    float probabilidade=0.0f;
			try {
				   Atributo atributo=(Atributo)entidade;       
	                 
				//PreparedStatement stmt = null;
				ResultSet rs = null;
				stmt = con.prepareStatement("select (count(distinct c.id_cliente)/count(distinct f2.id_fatura)) as prob from dimensaofatura as f, dimensaofatura as f2, dimensaocliente as c, fato2 as fato where f2.faturasituacao=? and fato.chave_cliente=c.id_cliente and fato.chave_fatura=f.id_fatura and c.estadocivil=? and f.faturasituacao=? ");
             stmt.setString(1, ""+atributo.getClasse());
				stmt.setString(2, ""+atributo.getAtributo());
				stmt.setString(3, ""+atributo.getClasse());
             rs = stmt.executeQuery();
				    // Usuario usuario = null;

				if (rs.next())
				{

					
              probabilidade=(float)rs.getFloat("prob");
              //System.out.println("% da classe Inadimplentes sao masculinos:"+probabilidade);
					stmt.close();
					rs.close();
				
					
					pool.liberarConnection(con);
					return probabilidade;
				}
				return false;
				} catch (SQLException e) {
				System.out.print(e.getMessage()+"");
				
				pool.liberarConnection(con);
		        return "sqlerror";
		        // TODO: handle exception
			}catch(Exception io){
				pool.liberarConnection(con);
			    return "error";
			}	
		}
	 
	 @Override
	public Object cadastrar(Object entidade) {
		// TODO Auto-generated method stub
		return null;
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
