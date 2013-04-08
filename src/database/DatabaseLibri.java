package database;

import java.sql.*;





public class DatabaseLibri {
	public static void main(String [] args){
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		String name="LIBRI";
		
		try{
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
			Connection conn = DriverManager.getConnection(url,user,pwd);
		
			creaTabella(name, conn, url, user, pwd);
			caricaDati(name, conn, url, user, pwd);
			mostraTabella(conn, name);
			
			conn.close();
		} catch (SQLException e) {System.out.println(e.getMessage());}
		
		
	}
	
	public static void mostraTabella(Connection conn, String name) throws SQLException{
		String out="";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM "+name);
		
		while (rs.next())
			out += "("+rs.getInt("ID")+") "+rs.getString("TITOLO") + ", di "+ rs.getString("AUTORE") +", "+ rs.getDouble("PREZZO")+"\n"; 
		System.out.println(out);
		rs.close();
		st.close();
	
	}
	
	public static void caricaDati(String name, Connection conn, String url, String user, String pwd) throws SQLException{
		Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Moby Dick', 'H. Melville', 9.50)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il processo', 'F. Kafka', 8.90)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il vecchio e il mare', 'E. Hemingway', 7.90)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il nome della rosa', 'U. Eco', 6.50)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('I promessi sposi', 'A. Manzoni', 7.50)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('La storia', 'E. Morante', 6.90)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Lettera al padre', 'F. Kafka', 5.50)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il giocatore', 'F. Dostoevskij', 10.90)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il maestro e Margherita', 'M. Bulgakov', 8.95)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il barone rampante', 'I. Calvino', 9.50)");
		st.executeUpdate("INSERT INTO "+name+" (TITOLO, AUTORE, PREZZO) VALUES ('Il castello', 'F. Kafka', 8.50)");
		st.close();
	}
	
	public static String creaTabella (String name, Connection conn, String url, String user, String pwd) throws SQLException{
		Statement st = conn.createStatement();
		try{
			st.execute("DROP TABLE "+name);
			System.out.println("tabella eliminata");
		}catch(SQLException e){}
		st.executeUpdate("CREATE TABLE "+name+" (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, TITOLO VARCHAR(30) NOT NULL, AUTORE VARCHAR(30) NOT NULL, PREZZO FLOAT NOT NULL)");
		System.out.println("tabella creata");
		st.close();
		return name;
	}
}
