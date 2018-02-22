package br.com.bd1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import br.com.bd1.connection.IDAO;
import br.com.bd1.connection.IPool;

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
             String dia="";
		        String mes="";
			for(int i=0 ; i<100 ;i++){
				String nome="Paulo Roberto "+i+1;
				int year = randBetween(1970, 1990);

		        gc.set(gc.YEAR, year);
		          		        
		        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                
		        gc.set(gc.DAY_OF_YEAR, dayOfYear);
		        
                 if(gc.get(gc.DAY_OF_MONTH)<=9){
                	 dia="0"+gc.get(gc.DAY_OF_MONTH);
                 }else{
                	 dia=""+gc.get(gc.DAY_OF_MONTH);
                 }
                 
                 
                 if(gc.get(gc.MONTH)<=9){
                	 mes="0"+gc.get(gc.MONTH);
                	 if(mes.equalsIgnoreCase("02")){
                		 dia="26";
                	 }
                	 
                 }else{
                	 mes=""+gc.get(gc.MONTH);
                 }
				stmt=con.prepareStatement("insert into Aluno ( nome, sexo, data_nasc, telefone,cod_curso,mae) VALUES (?,?,?,?,?,?)");
		        stmt.setString(1,nome );
			    stmt.setString(2, "M");
			    stmt.setString(3, gc.get(gc.YEAR) + "-" + mes + "-" +dia );
			    stmt.setString(4, "9"+geradortelefone.nextInt(9)+1+"");
			    stmt.setInt(5,geradorcurso.nextInt(10)+1);
	            stmt.setString(6, "MAE");
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
	 public static double randBetween2(double start, double end) {
	        return start + (double)Math.round(Math.random() * (end - start));
	    }

		public Object cadastraMatricula(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			try {
				
				
				Random geradorprof=new Random();
				    String cod_turma="";
				for(int i=0 ; i<100000 ;i++){
					
					
					
					
					float Final=0.0f;
					float Mediafinal=0.0f;
					//int semestre = randBetween(1, 2);
                    int status=0;
			        float gq1=(float)randBetween2(0.0, 10.0);
			        float gq2=(float)randBetween2(0.0, 10.0);
			          		        float mediagq= ((gq1*2)+(gq2*3))/5;
			          		        if(mediagq<5.0){
			          		           Final=(float)randBetween2(0.0, 10.0);	
			          		           Mediafinal=Final+mediagq;
			          		           if(Mediafinal<10.0){
			          		        	   status=3;
			          		           }else{
			          		        	   status=2;
			          		           }
			          		        }else{
			          		           status=randBetween(4, 6);   	
			          		        }
			        
	               
					stmt=con.prepareStatement("insert into Matric_Disc ( cod_turma, ano, semestre,matric,Gq1,Gq2,mediagq,final,mediafinal,stat) select cod_turma ,ano,semestre ,floor(60+(rand()*(465-60))),?,?,?, ?, ?,? from turma_disc order by rand() limit 1");
			        stmt.setFloat(1,gq1);
				    stmt.setFloat(2, gq2);
				    stmt.setFloat(3, mediagq  );
				    stmt.setFloat(4, Final);
				    stmt.setFloat(5,Mediafinal);
		            stmt.setInt(6, status);
		            stmt.executeUpdate();
		            
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
			}	
		}
	 
	 public Object cadastra(Object entidade) {
	    PreparedStatement statement = null;
		PreparedStatement stmt=null;
		//ResultSet rs=null;
		Connection con=pool.getConnection();
		//Fornecedor forn=(Fornecedor)fornecedor; 
		//ContaBancaria conta=entidade;
		
		//con.setAutoCommit(false);
		try {
			
			
			Random geradorprof=new Random();
			geradorprof.nextBoolean();
			    String cod_turma="";
			for(int i=0 ; i<80 ;i++){
				
				
				if(i<9){
					 cod_turma="NS0"+(i+1);
				}else{
					 cod_turma="NS"+i+1;
				}
				
				
			
				int semestre = randBetween(1, 2);

		        int ano=randBetween(2000, 2014);
		          		        
		        int id_prof = geradorprof.nextInt(20);
                int numH=randBetween(2, 6);
                int cod_disciplina=randBetween(1,35);
		        
               
				stmt=con.prepareStatement("insert into Turma_Disc ( cod_turma, ano, semestre, horario1 ,horario2,id_prof,cod_disciplina) VALUES (?,?,?,?,?,?,?)");
		        stmt.setString(1,cod_turma );
			    stmt.setInt(2, ano);
			    stmt.setInt(3, semestre );
			    stmt.setString(4, numH+"LM");
			    stmt.setString(5,numH+"NO");
	            stmt.setInt(6, geradorprof.nextInt(20)+1);
	            stmt.setString(7,""+cod_disciplina );
			    stmt.executeUpdate();
	            
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
		}	
	}

	 
	 public Object cadastraDimensaoCliente(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			//Fornecedor forn=(Fornecedor)fornecedor; 
			//ContaBancaria conta=entidade;
			
			//con.setAutoCommit(false);
			try {
				
				char temcelular,tememail,sexo,trabalha;
				int idade,quantidadeDependentes;
				String escolaridade="Ensino Medio Completo";
				String estadocivil="Casado";
				String rendimentos="Dois salarios minino";
				
				Random geradorprof=new Random();
				    String cod_turma="";
				for(int i=0 ; i<1001 ;i++){
					
					
					if(geradorprof.nextBoolean()){
						 temcelular='S';
					}else{
						 temcelular='N';
						 
					}
					if(geradorprof.nextBoolean()){
						
						tememail='S';
					}else{
						tememail='N';
					}
					if(geradorprof.nextBoolean()){
						sexo='S';
						
					}else{
						sexo='N';
					}
					
					int val=randBetween(1, 4);
					if(val==1){
						estadocivil="Casado";
					}if(val==2){
						estadocivil="Solteiro";
					}if(val==3){
						estadocivil="Viuvo";
						
					}if(val==4){
						estadocivil="Divorciado";
					}
					
					int val2;
					val2=randBetween(1, 3);
					if(val2==1){
						escolaridade="Ensino Medio Imcompleto";
					}if(val2==2){
						escolaridade="Ensino Medio Completo";
					}if(val2==3){
						escolaridade="Ensino Superior Completo";
					}
					
					
					int val3;
					val3=randBetween(1, 3);
					if(val3==1){
						rendimentos="Acima de tres salarios minino";
						
					}if(val3==2){
						rendimentos="Dois salarios minino";
						
					}if(val==3){
						rendimentos="Um salario Minimo";
					}
					idade=randBetween(1, 6);
					
					//temcelular=randBetween("s", "n");
					
					
					
			        
	               
					stmt=con.prepareStatement("insert into dimensaocliente (temcelular , tememail, idade, sexo ,estadocivil,escolaridade,rendimentos) VALUES (?,?,?,?,?,?,?)");
			        stmt.setString(1,""+temcelular );
				    stmt.setString(2, ""+tememail);
				    stmt.setInt(3, idade );
				    stmt.setString(4, sexo+"");
				    stmt.setString(5,estadocivil);
		            stmt.setString(6, escolaridade);
		            stmt.setString(7,rendimentos );
				    stmt.executeUpdate();
		            
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
			}	
		}

	 
	 
	 public Object cadastraDimensaoFatura(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			//Fornecedor forn=(Fornecedor)fornecedor; 
			//ContaBancaria conta=entidade;
			
			//con.setAutoCommit(false);
			try {
				
				char classesocial='A';
				int diasparapagamento=1;
				String faturasituacao;
				String formadepagamento="Dinheiro";
				float valorfatura;
				int j=1;
				    String cod_turma="";
				    Random geradorprof=new Random();
					Random geradias=new java.security.SecureRandom();
					Random geraclasse =new java.security.SecureRandom();
				for(int i=0 ; i<3001 ;i++){
					
					int valor= (int)randBetween(1, 5);
					int classe= randBetween(1, 4);
					if(classe==2){
						classesocial='A';
					}if(classe==1){
						classesocial='B';
						 
					}if(classe==4){
						classesocial='C';
					}if(classe==3)
					{
						classesocial='D';
					}
					
					
					
					if(geradias.nextBoolean()){
						faturasituacao="Pago";
					}else{
						faturasituacao="Atrasado";
					}
					
					int val= randBetween(1, 4);
					if(val==2){
						formadepagamento="Cheque";
					}if(val==3){
						formadepagamento="Dinheiro";
					}if(val==4){
						formadepagamento="Debito";
						
					}if(val==1){
						formadepagamento="Credito";
					}
					
					
					
				     //valorfatura =geradorprof.nextInt(49000)+geradorprof.nextFloat()+100.00f ;
			           
					
					
					int dias=(int) randBetween(0, 6);
					if(dias==0){
						diasparapagamento=10;
					}if(dias==2){
						diasparapagamento=15;
					}if(dias==3){
						diasparapagamento=30;
					}if(dias==4){
						diasparapagamento=45;
					}if(dias==5){
						diasparapagamento=60;
					}if(dias==6){
						diasparapagamento=90;
					}if(dias==1){
						diasparapagamento=120;
					}
	               
					stmt=con.prepareStatement("insert into dimensaofatura (faturasituacao , valordafatura, diasparapagar, formadepagamento ,classesocial) VALUES (?,?,?,?,?)");
			        stmt.setString(1,""+faturasituacao );
				    stmt.setString(2, ""+valor);
				    stmt.setInt(3, diasparapagamento );
				    stmt.setString(4, formadepagamento+"");
				    stmt.setString(5,classesocial+"");
		            stmt.executeUpdate();
		            
			        con.commit();
		            
		            stmt.close();
		            pool.liberarConnection(con);				
					
					j=j*-1;
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
			}	
		}
	 
	 
	 public Object cadastraDimensaoData(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			//Fornecedor forn=(Fornecedor)fornecedor; 
			//ContaBancaria conta=entidade;
			
			//con.setAutoCommit(false);
			try {
				
				char temcelular,tememail,sexo,trabalha;
				int idade,quantidadeDependentes;
				String escolaridade="Ensino Medio Completo";
				String estadocivil="Casado";
				String rendimentos="Dois salarios minino";
				
				Random geradorprof=new Random();
				    String cod_turma="";
				for(int i=0 ; i<3001 ;i++){
					
					
					 GregorianCalendar gc = new GregorianCalendar();
					
					idade=randBetween(1, 6);
					
					//temcelular=randBetween("s", "n");
					String dia,mes1;
					int mes=randBetween(1, 12);
					int dias=randBetween(1, 29);
					 if(dias<=9){
	                	 dia="0"+dias;
	                 }else{
	                	 dia=""+dias;
	                 }
	                 
	                 
	                 if(mes<=9){
	                	 mes1="0"+mes;
	                	 
	                	 }
	                 
	               
					stmt=con.prepareStatement("insert into dimensaodata (mes , dia, ano ) VALUES (?,?,?)");
			        stmt.setString(1,""+mes );
				    stmt.setString(2, dia);
				    stmt.setInt(3, 2015 );
				   
				    stmt.executeUpdate();
		            
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
			}	
		}
	
	 public Object cadastraTabelaFatoa(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			//Fornecedor forn=(Fornecedor)fornecedor; 
			//ContaBancaria conta=entidade;
			
			//con.setAutoCommit(false);
			try {
				
				
				for(int i=0 ; i<3001 ;i++){
					
				     
	            
	                 
	               
					stmt=con.prepareStatement("insert into fato2 (chave_data , chave_cliente, chave_fatura ) VALUES (?,?,?)");
			        stmt.setInt(1,i+1 );
				    stmt.setInt(2, i+1);
				    stmt.setInt(3, i+1 );
				   
				    stmt.executeUpdate();
		            
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
			}	
		}
	
	 public Object cadastraTabelaFatura(Object entidade) {
		    PreparedStatement statement = null;
			PreparedStatement stmt=null;
			//ResultSet rs=null;
			Connection con=pool.getConnection();
			//Fornecedor forn=(Fornecedor)fornecedor; 
			//ContaBancaria conta=entidade;
			
			//con.setAutoCommit(false);
			try {
				
				int i=0;
				while(i<1000){
					
				     
	            
	                 
	               
					stmt=con.prepareStatement("update dimensaofatura set faturasituacao=? where id_fatura=? ");
			        stmt.setString(1,"Atrasado" );
				    stmt.setInt(2, i);
				    //stmt.setInt(3, i+1 );
				   
				    stmt.executeUpdate();
		            
			        con.commit();
		            
		            stmt.close();
		            pool.liberarConnection(con);				
					i=i+13;
					
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
			}	
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
