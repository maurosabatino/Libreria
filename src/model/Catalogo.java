package model;

import java.sql.*;
import java.util.ArrayList;

public class Catalogo {
	
	private ArrayList <Libro> catalogo; 
	String risultato;
	
	public Catalogo(){
		this.catalogo= new ArrayList<Libro>();
		this.risultato="";
	}
	public ArrayList<Libro> getCatalogo(){
		return this.catalogo;
	}
	public String getRisultato(){
		return this.risultato;
	}
	
	public void setCatalogo(ArrayList<Libro> catalogo){
		this.catalogo=catalogo;
	}
	public void setRisultato(String risultato){
		this.risultato=risultato;
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
	
	public ArrayList<Libro> search(String titolo, String autore) throws SQLException{
			String url = "jdbc:derby://localhost:1527/c:/Database;";
			String user = "app";
			String pwd = "app";
		    Connection conn = DriverManager.getConnection(url, user, pwd);
		    Statement st = conn.createStatement();
		    ResultSet rs;
		    if((titolo==null || titolo.equals("")) && !(autore==null || autore.equals(""))) 
		    	rs = st.executeQuery("SELECT * FROM LIBRI WHERE AUTORE='"+autore+"'");
		    else if(!(titolo==null || titolo.equals("")) && (autore==null || autore.equals("")))
		    	rs = st.executeQuery("SELECT * FROM LIBRI WHERE TITOLO='"+titolo+"'");
		    else if((titolo==null || titolo.equals("")) && (autore==null || autore.equals("")))
		    	rs = st.executeQuery("SELECT * FROM LIBRI");
		    else
		    	rs = st.executeQuery("SELECT * FROM LIBRI WHERE TITOLO='"+titolo+"' AND AUTORE='"+autore+"'");
		    
		    while(rs.next()) {
		    	Libro libro = new Libro();
		    	libro.setId(rs.getInt("ID"));
		    	libro.setTitolo(rs.getString("TITOLO"));
		    	libro.setAutore(rs.getString("AUTORE"));
		    	libro.setPrezzo(rs.getDouble("PREZZO"));
		    	catalogo.add(libro);
		    }
		    
		    st.close(); conn.close();
		    return catalogo;
	}
	
	public void inserisciLibro(String titolo,String autore,Double prezzo) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO LIBRI (TITOLO, AUTORE, PREZZO) VALUES ('"+titolo+"', '"+autore+"', "+prezzo+")");
		st.close(); conn.close();
	}
	
	
	public String getVisualizzasearch(){
		String out="\n lista dei libri cercati:";
		out+="<table border=2> <tr><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		
		for(int i = 0;i<catalogo.size();i++){
			if(catalogo.get(i)!=null){
				String titolo=catalogo.get(i).getTitolo();
				String autore=catalogo.get(i).getAutore();
				double prezzo=catalogo.get(i).getPrezzo();
				out+="<tr><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td></tr>";
			}
		}
		out+="</table>";
		return out;
	}
	
	
	
}