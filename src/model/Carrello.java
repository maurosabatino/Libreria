package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Carrello {

	private ArrayList<Libro> carrello; 
	private double totale; 
	
	public Carrello(){
		this.carrello= new ArrayList<Libro>();
		totale=0.0;
	}
	public void setCarrello(ArrayList<Libro> carrello){
		this.carrello=carrello;
	}
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	public ArrayList<Libro> getCarrello(){
		return this.carrello;
	}
	public double getTotale(){
		return totale;
	}
	public boolean aggiungiLibro(int id) throws SQLException{
		Libro libro = cercaLibro(id);	
		if(libro!=null){
			this.carrello.add(libro);
			totale+=libro.getPrezzo();
			return true;
		}else return false;
	}
	public boolean rimuoviLibro(int id) throws SQLException{
		Libro libro = cercaLibro(id);
		if(libro!=null){
			carrello.remove(libro);
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
		return libro;
	}
	
	public String getVisualizzacarrello(){
		String out="\n lista dei libri nel carrello:";
		out+="<table border=2> <tr><th>Titolo</th><th>Autore</th><th>Prezzo</th></tr>";
		
		for(int i = 0;i<carrello.size();i++){
			if(carrello.get(i)!=null){
				String titolo=carrello.get(i).getTitolo();
				String autore=carrello.get(i).getAutore();
				double prezzo=carrello.get(i).getPrezzo();
				out+="<tr><td> "+ titolo + "</td><td> "+ autore +"</td> <td> " + prezzo +"</td></tr>";
			}
		}
		out+="</table>";
		return out;
	}
	
	public String Visualizzacarrello(){
		String out="";
		for(int i=0;i<carrello.size();i++){
			out+="titolo: "+ carrello.get(i).getTitolo() + "autore: "+ carrello.get(i).getAutore() +"prezzo: " + carrello.get(i).getPrezzo() +"\n";
		}
		return out;
	}
}