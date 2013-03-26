package model;

import java.sql.*;

public class Operazioni {
	private String operazione=null;
	
	public Operazioni(){
		this.operazione="sconosciuta";
	}
	public String getOperazione(){
		return this.operazione;
	}
	public void setOperazione(String operazione){
		this.operazione=operazione;
	}
	
	public String getVisualizzalibri() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String out="";
		ResultSet rs =st.executeQuery("SELECT * FROM libri");
		out+="<table border=2> <tr><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		while(rs.next()){
			out+="<tr><td> "+ rs.getString("TITOLO") + "</td><td> "+ rs.getString("AUTORE") +"</td> <td> " + rs.getDouble("PREZZO") +"</td></tr>";
		}
		out+="</table";
		rs.close(); st.close(); conn.close();	
		return out;
	}
	public String getSelezionalibro() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String out="";
		ResultSet rs =st.executeQuery("SELECT * FROM LIBRI");
		out+="<select name=id>";
		while(rs.next()){
			
			out+="<option value="+ rs.getInt("ID")+">titolo= "+ rs.getString("TITOLO") + "autore= "+ rs.getString("AUTORE") +"prezzo=" + rs.getDouble("PREZZO") +"</option>";
		}
		out+="</select>";
		rs.close(); st.close(); conn.close();
		return out;
	}
	
	
}
