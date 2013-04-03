package database;

import java.sql.*;

public class DatabasePrenotazioni {
	public static void main(String [] args){
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		String name="PRENOTAZIONI";
		try{
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
			Connection conn = DriverManager.getConnection(url,user,pwd);
			creaTabella(name, conn, url, user, pwd);
			conn.close();
		} catch (SQLException e) {System.out.println(e.getMessage());}
	}
	
	
	public static void creaTabella (String name, Connection conn, String url, String user, String pwd) throws SQLException{
		try{
		
			Statement st = conn.createStatement();
			try{st.execute("DROP TABLE "+name);}catch(SQLException e){}
			st.executeUpdate("CREATE TABLE "+name+" (COD INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, USERNAME VARCHAR(20) NOT NULL, ORDINE VARCHAR(500) NOT NULL, DATA VARCHAR(20), TOTALE FLOAT, EVASO INT,RICEVUTO INT)");
			st.close();
			System.out.println("Restarted\n");
			conn.close();
		} catch (SQLException e) {System.out.println(e.getMessage());}
		
		
	}


}
