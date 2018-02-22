package br.com.bd1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco
/*    */ {
/*  9 */   private Connection conexao = null;
/* 10 */   private String urlBanco = null;
/* 11 */   private String userName = null;
/* 12 */   private String userPassword = null;
/* 13 */   private String jdbcDriver = null;
/*    */ 
/*    */   public ConectaBanco()
/*    */   {
/* 17 */     this.userName = "mauricio";
/* 18 */     this.userPassword = "232425";
/* 19 */     this.urlBanco = "jdbc:mysql://127.0.0.1/dbo";
/* 20 */     this.jdbcDriver = "org.gjt.mm.mysql.Driver";
/*    */   }
/*    */ 
/*    */   public Connection getConnection()
/*    */   {
/*    */     try
/*    */     {
/* 27 */       if (this.conexao == null) {
/* 28 */         Class.forName(this.jdbcDriver);
/* 29 */         this.conexao = DriverManager.getConnection(this.urlBanco, this.userName, this.userPassword);
/* 30 */         this.conexao.setAutoCommit(false);
/*    */       }
/* 32 */       if (this.conexao.isClosed()) {
/* 33 */         this.conexao = null;
/* 34 */         return getConnection();
/*    */       }
/*    */     } catch (ClassNotFoundException e) {
/* 37 */       e.printStackTrace();
/*    */     } catch (SQLException e) {
/* 39 */       e.printStackTrace();
/*    */     }
/* 41 */     return this.conexao;
/*    */   }
/*    */ 
/*    */   public void closeConnection()
/*    */   {
/* 46 */     if (this.conexao == null) return; try
/*    */     {
/* 48 */       this.conexao.close();
/*    */     } catch (SQLException e) {
/* 50 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void rollback()
/*    */     throws SQLException
/*    */   {
/* 57 */     this.conexao.rollback();
/*    */   }
/*    */ 
/*    */   public void commit() throws SQLException
/*    */   {
/* 62 */     this.conexao.commit();
/*    */   }
/*    */ 
/*    */   public void AutoCommit(boolean bol) throws SQLException
/*    */   {
/* 67 */     this.conexao.setAutoCommit(bol);
/*    */   }
/*    */ }


