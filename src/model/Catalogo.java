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
	
	/*-------------------operazioni base--------------------------------------------*/
	
	public String getVisualizzalibri() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String out="";
		ResultSet rs =st.executeQuery("SELECT * FROM libri");
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</th><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		while(rs.next()){
			out+="<tr><td>"+rs.getInt("ID")+"</td><td> "+ rs.getString("TITOLO") + "</td><td> "+ rs.getString("AUTORE") +"</td> <td> " + rs.getDouble("PREZZO") +"</td></tr>";
		}
		out+="</table";
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
		    	rs = st.executeQuery("SELECT * FROM LIBRI WHERE LOWER(AUTORE) LIKE LOWER('%"+autore+"%')");
		    else if(!(titolo==null || titolo.equals("")) && (autore==null || autore.equals("")))
		    	rs = st.executeQuery("SELECT * FROM LIBRI WHERE LOWER(TITOLO) LIKE LOWER('%"+titolo+"%')");
		    else if((titolo==null || titolo.equals("")) && (autore==null || autore.equals("")))
		    	rs = st.executeQuery("SELECT * FROM LIBRI");
		    else
		    	rs = st.executeQuery("c AND AUTORE='"+autore+"'");
		    
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
	


	
	public String getVisualizzasearch(){
		String out="\n lista dei libri cercati:";
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</td><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		
		for(int i = 0;i<catalogo.size();i++){
			if(catalogo.get(i)!=null){
				int id =catalogo.get(i).getId();
				String titolo=catalogo.get(i).getTitolo();
				String autore=catalogo.get(i).getAutore();
				double prezzo=catalogo.get(i).getPrezzo();
				out+="<tr><td>"+id+"</td><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td></tr>";
				
			}
		}
		out+="</table>";
		return out;
	}
	
	/*------------------------fine operazioni base------------------------------------------------*/
	
	/*-----------------------operazioni di amministrazione---------------------------------------*/
	
	public String getVisualizzaamministratore() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String out="";
		ResultSet rs =st.executeQuery("SELECT * FROM libri");
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</th><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		while(rs.next()){
			out+="<tr><td>"+rs.getInt("ID")+"</td><td> "+ rs.getString("TITOLO") + "</td><td> "+ rs.getString("AUTORE") +"</td> <td> " + rs.getDouble("PREZZO")+"</td>" ;
			out+= "<td><button onclick=\"top.location.href = 'Controller?operazione=rimuovi_libro&id="+rs.getInt("ID")+"'\">rimuovi</button><br><br></td>";
			out+="<td><button onclick=\"top.location.href ='modifica.jsp?id="+rs.getInt("ID")+"'\">modifica</button></td> <br><br></tr>";
		}
		out+="</table>";
		rs.close(); st.close(); conn.close();	
		return out;
	}
	
	public String getVisualizzasearchadmin(){
		String out="\n lista dei libri cercati:";
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</td><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		
		for(int i = 0;i<catalogo.size();i++){
			if(catalogo.get(i)!=null){
				int id =catalogo.get(i).getId();
				String titolo=catalogo.get(i).getTitolo();
				String autore=catalogo.get(i).getAutore();
				double prezzo=catalogo.get(i).getPrezzo();
				out+="<tr><td>"+id+"</td><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td>";
				out+="<td><button onclick=\"top.location.href = 'Controller?operazione=rimuovi_libro&id="+id+"'\">rimuovi dal catalogo</button></td>";
				out+="<td><button onclick=\"top.location.href = 'modifica.jsp?id="+id+"'\">modifica libro</button></td></tr>";
				
			}
		}
		out+="</table>";
		return out;
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
	
	public void rimuoviLibro(int id) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		st.executeUpdate("DELETE FROM LIBRI WHERE ID="+id);
		st.close(); conn.close();
	}

	public void modificaLibro(int id,String titolo,String autore, Double prezzo) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
			
		 if(!(titolo.equals("")||titolo==null)){
			 st.executeUpdate(" UPDATE LIBRI SET TITOLO='"+titolo+"' WHERE ID="+id); 
		 }
		 if(!(autore.equals("")||autore==null)){
			 st.executeUpdate(" UPDATE LIBRI SET AUTORE='"+autore+"' WHERE ID="+id);  
		 }
		 if(!((prezzo==0)||prezzo==null)){
			 st.executeUpdate(" UPDATE LIBRI SET PREZZO="+prezzo+"WHERE ID="+id); 
		 }
		}
	public Libro cercaLibro(int id) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Libro libro = new Libro();
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM libri WHERE ID ="+id+"");
		while(rs.next()){
			libro.setId(id);
			libro.setTitolo(rs.getString("TITOLO"));
			libro.setAutore(rs.getString("AUTORE"));
			libro.setPrezzo(rs.getDouble("PREZZO"));
		}
		rs.close(); st.close(); conn.close();
		return libro;
	}
	
	
	public String getVisualizzaprenotazioni() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		Statement st = conn.createStatement();
		ResultSet rs;
		String prenotazioni = "<table id=\"hor-minimalist-b\"> <tr><th>utente</th><th>Ordine</th><th>Data</th><th>Totale</th></tr>";
		rs = st.executeQuery("SELECT * FROM PRENOTAZIONI");
		    
		while (rs.next()){
			if((Integer.parseInt(rs.getString("EVASO")))==0 && (Integer.parseInt(rs.getString("RICEVUTO"))==0)){
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td><a href=\"Controller?operazione=evadi_pre&cod="+rs.getInt("COD")+"\">evadi prenotazione</a><br><br></td></tr>";
			}else if((Integer.parseInt(rs.getString("EVASO")))==1 && (Integer.parseInt(rs.getString("RICEVUTO"))==1)){
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td>L'ordine è evaso e ricevuto.<br><br></td>";
				prenotazioni += "<td><a href=\"Controller?operazione=rimuovi_pre_admin&cod="+rs.getInt("COD")+"\">cancella prenotazione</a><br><br></td></tr>";
			}
			else{
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td>L'ordine è evaso.<br><br></td></tr>";
			}
		} 
			
		st.close();
		conn.close();
		return prenotazioni;
	}
	public void rimuoviPrenotazioni(int cod) throws SQLException{
		
			String url = "jdbc:derby://localhost:1527/c:/Database;";
			String user = "app";
			String pwd = "app";
		    Connection conn = DriverManager.getConnection(url, user, pwd);
		    Statement st = conn.createStatement();
		    st.executeUpdate("DELETE FROM PRENOTAZIONI WHERE COD="+cod+"");
		    st.close();
		    conn.close();
		
	}
	public void evadiOrdine(int codice) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		st.executeUpdate("UPDATE PRENOTAZIONI SET EVASO = 1 WHERE COD="+codice);
		st.close(); conn.close();
	}
	
	/*-----------------------fine operazioni di amministrazione----------------------------------------*/
	
	/*------------------------operazioni utente---------------------------------------------------------*/
	public String getSelezionalibro() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String out="";
		ResultSet rs =st.executeQuery("SELECT * FROM LIBRI");
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</th><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		while(rs.next()){
			out+="<tr><td>"+rs.getInt("ID")+"</td><td> "+ rs.getString("TITOLO") + "</td><td> "+ rs.getString("AUTORE") +"</td> <td> " + rs.getDouble("PREZZO") +"</td>";
			out+="<td><button onclick=\"top.location.href = 'Controller?operazione=aggiungialcarrello&id="+rs.getInt("ID")+"'\">aggiungi al carrello</button></td></tr>";
		}
		out+="</table>";
		rs.close(); st.close(); conn.close();
		return out;
	}
	public String getVisualizzasearchuser(){
		String out="\n lista dei libri cercati:";
		out+="<table id=\"hor-minimalist-b\"> <tr><th>ID</td><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		
		for(int i = 0;i<catalogo.size();i++){
			if(catalogo.get(i)!=null){
				int id =catalogo.get(i).getId();
				String titolo=catalogo.get(i).getTitolo();
				String autore=catalogo.get(i).getAutore();
				double prezzo=catalogo.get(i).getPrezzo();
				out+="<tr><td>"+id+"</td><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td>";
				out+="<td><button onclick=\"top.location.href = 'Controller?operazione=aggiungialcarrello&id="+id+"'\">aggiungi al carrello</button></td>";
				
				
			}
		}
		out+="</table>";
		return out;
	}
	
	/*----------------------fine operazioni user--------------------------------------------*/
	
}
