package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Carrello {
	
	private ArrayList<Libro> carrello; 
	private double totale; 
	private String username;
	
	
	public Carrello(){
		this.carrello= new ArrayList<Libro>();
		totale=0.0;
		
	}
	public void setCarrello(ArrayList<Libro> carrello){
		this.carrello=carrello;
	}
	public void setTotale(double totale){
		this.totale+=totale;
		totale = (Math.rint(totale*120))/100;
	}
	public void setUsername(String username){
		this.username=username;
	}
	
	
	public ArrayList<Libro> getCarrello(){
		return this.carrello;
	}
	public double getTotale(){
		return totale;
	}
	public String getUsername(){
		return this.username;
	}
	
	
	public void aggiungiLibro(int id) throws SQLException{
		Libro libro = cercaLibro(id);	
		if(libro!=null){
			if(cercaPosizione(id)!=-1){
				int i=cercaPosizione(id);
				int quantità=carrello.get(i).getQuantità();
				quantità++;
				carrello.get(i).setQuantità(quantità);
				setTotale(libro.getPrezzo());
			}else{
				carrello.add(libro);
				setTotale(libro.getPrezzo());
			}
			
		}
	}
		
	public int cercaPosizione(int id){
		for(int i = 0;i<carrello.size();i++){
			if(carrello.get(i).getId()==id)
				return i;
		}
		return -1;
	}
	
	public boolean rimuoviLibro(int id) throws SQLException{
		Libro libro = cercaLibro(id);
		if(libro!=null){
			for(int i=0;i<carrello.size();i++){
				if(carrello.get(i).getId()==id){
					int quantità=carrello.get(i).getQuantità();
					setTotale(-(libro.getPrezzo()* quantità));
					carrello.remove(i);
				}		
			}
			return true;
		}
		return false;
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
	
	public String getVisualizzacarrello(){
		String out="<h1>libri nel carrello</h1>";
		out+="<table id=\"hor-minimalist-b\"> <tr><th>Id</th><th>Titolo</th><th>Autore</th><th>Prezzo</th><th>Quantità</th></tr>";
		
		for(int i = 0;i<carrello.size();i++){
			if(carrello.get(i)!=null){
				int id= carrello.get(i).getId();
				String titolo=carrello.get(i).getTitolo();
				String autore=carrello.get(i).getAutore();
				double prezzo=carrello.get(i).getPrezzo();
				int quantità=carrello.get(i).getQuantità();
				out+="<tr><td>"+id+"</td><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td><td>"+quantità+"</td>";
				out+="<td><a href=\"Controller?operazione=rimuovi_carrello&id="+id+"\">cancella dal carrello</a></td></td>";
			}
		}
		out+="</table>";
		return out;
	}

	
	
	/*operazioni di compra*/
	public void compra() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		if(carrello!=null){
			st.executeUpdate("INSERT INTO PRENOTAZIONI (USERNAME, ORDINE, DATA, TOTALE, EVASO,RICEVUTO) VALUES ('"+username+"', '"+toString()+"', '"+data()+"', "+totale+", 0,0)"); 
			svuota();
			setTotale(-(getTotale()));
		}
		st.close(); conn.close();
	}
	public void svuota(){
		carrello = new ArrayList<Libro>();
	}
	public String toString(){
		String out="";
		for(int i=0; i<carrello.size(); i++)
			out+=carrello.get(i).toString();
			
		return out;
	}
	public String data(){
		Calendar cal = new GregorianCalendar();
	    int giorno = cal.get(Calendar.DAY_OF_MONTH);
	    int mese = cal.get(Calendar.MONTH)+1;
	    int anno = cal.get(Calendar.YEAR);
	    int ora = cal.get(Calendar.HOUR_OF_DAY);
	    int min = cal.get(Calendar.MINUTE);
	    return (giorno+"/"+mese+"/"+anno+", "+ora+"."+min);
	}
	
	
	/*operazioni sulle prenotazioni*/
	public void rimuoviPrenotazioni(int cod,String username) throws SQLException{
		
			String url = "jdbc:derby://localhost:1527/c:/Database;";
			String user = "app";
			String pwd = "app";
		    Connection conn = DriverManager.getConnection(url, user, pwd);
		    Statement st = conn.createStatement();
		    st.executeUpdate("DELETE FROM PRENOTAZIONI WHERE USERNAME='"+username+"' AND COD="+cod+"");
		    st.close();
		    conn.close();
		
	}
	
	public String getVisualizzaprenotazioni() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		Statement st = conn.createStatement();
		ResultSet rs;
		String prenotazioni = "<table id=\"hor-minimalist-b\"> <tr><th>utente</th><th>Ordine</th><th>Data</th><th>Totale</th></tr>";
		rs = st.executeQuery("SELECT * FROM PRENOTAZIONI WHERE USERNAME='"+username+"'");
		    
		while (rs.next()){
			if((Integer.parseInt(rs.getString("EVASO")))==0 && (Integer.parseInt(rs.getString("RICEVUTO"))==0)){
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td><a href=\"Controller?operazione=rimuovi_pre&cod="+rs.getInt("COD")+"\">cancella prenotazione</a><br><br></td></tr>";
			}else if((Integer.parseInt(rs.getString("EVASO")))==1 && (Integer.parseInt(rs.getString("RICEVUTO"))==0)){
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td><a href=\"Controller?operazione=conferma_condegna&cod="+rs.getInt("COD")+"\">conferma consegna</a><br><br></td></tr>";
			}else{
				prenotazioni +="<tr> <td>"+rs.getString("Username")+"</td><td>"+rs.getString("ORDINE") +"</td><td> "+ rs.getString("DATA")+"</td><td>"+rs.getDouble("TOTALE")+" Euro</td>";
				prenotazioni += "<td><br>L'ordine è evaso e ricevuto.<br><br></td></tr>";
			}
		} 
		prenotazioni+="</table>";	
		st.close();
		conn.close();
		return prenotazioni;
	}
	public void confermaConsegna(int cod) throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		st.executeUpdate("UPDATE PRENOTAZIONI SET RICEVUTO = 1 WHERE COD="+cod);
		st.close(); conn.close();
	}
	
}