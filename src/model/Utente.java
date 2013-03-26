package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utente {

	private String user;
	private String password;
	private String ruolo;
	
	public Utente(){
		user="sconosciuto";
		password="sconosciuto";
		ruolo="sconosciuto";
		
	}
	public String getUser(){
		return user;
	}
	public String getPassword(){
		return password;
	}
	public String getRuolo(){
		return ruolo;
	}
	public void setUser(String user){
		this.user=user;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setRuolo(String ruolo){
		this.ruolo=ruolo;
	}
	public boolean Autenticazione() throws SQLException{
		String ur="jdbc:derby://localhost:1527/C:/Database";
		DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
		Connection conn = DriverManager.getConnection(ur,"app","app");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT*FROM ACCOUNT");
		while(rs.next()){
			if(!user.equals("sconosciuto")||!user.equals("")) {
				if(rs.getString("UTENTE").equals(user)){
					if(rs.getString("PASSWORD").equals(password)){
						ruolo=rs.getString("RUOLO");
						return true;
					}
				}
			}else{
				return false;
			}
		}
		conn.close();st.close();rs.close();
		return false;
	}
	
}

