package database;

import java.sql.*;

public class DatabaseUtenti {
	static String url = "jdbc:derby://localhost:1527/c:/Database;";
	static String user = "app";
	static String pwd = "app";
	public static void main(String [] args) throws SQLException{
		DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
		creaTabella();
		caricaDati();
			
		}
	
	public static void creaTabella() throws SQLException{
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		try{
			st.execute("DROP TABLE ACCOUNT");
		}catch (SQLException e){System.out.println(e.getMessage());}
		st.executeUpdate("CREATE TABLE ACCOUNT(UTENTE VARCHAR(255) PRIMARY KEY,PASSWORD VARCHAR(255) NOT NULL, RUOLO VARCHAR(255) NOT NULL)");
		System.out.println("tabella creata nel database");
		st.close();
		conn.close();
		
	}
	
	public static void caricaDati() throws SQLException{
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO ACCOUNT(UTENTE,PASSWORD,RUOLO) VALUES('sabawalker','tonino','admin')");
		st.executeUpdate("INSERT INTO ACCOUNT(UTENTE,PASSWORD,RUOLO) VALUES('dario','tonino','user')");
		st.close();
		conn.close();
	}
}
