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
		String out="\n lista dei libri nel carrello:";
		out+="<table border=2> <tr><th>Id</th><th>Titolo</th><th>Autore</th><th>Prezzo</th><th>Quantità</th></tr>";
		
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

	public String Visualizzacarrello(){
		String out="\n lista dei libri nel carrello:";
		out+="";
		
		for(int i = 0;i<carrello.size();i++){
			if(carrello.get(i)!=null){
				String titolo=carrello.get(i).getTitolo();
				String autore=carrello.get(i).getAutore();
				double prezzo=carrello.get(i).getPrezzo();
				int quantità=carrello.get(i).getQuantità();
				out+=""+ titolo + ","+ autore +"," + prezzo +","+quantità+"\n";
			}
		}
		out+="";
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
			st.executeUpdate("INSERT INTO PRENOTAZIONI (USERNAME, ORDINE, DATA, TOTALE, EVASO) VALUES ('"+username+"', '"+toString()+"', '2001/01/01', "+totale+", 0)"); 
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
	public void rimuoviPrenotazioni(int cod,String username){
		try{
			String url = "jdbc:derby://localhost:1527/c:/Database;";
			String user = "app";
			String pwd = "app";
		    Connection conn = DriverManager.getConnection(url, user, pwd);
		    Statement st = conn.createStatement();
		    st.executeUpdate("DELETE FROM PRENOTAZIONI WHERE USERNAME='"+username+"' AND COD="+cod+"");
		    st.close();
		    conn.close();
		}catch(SQLException e){ System.out.println(e.getMessage());}
	}
	public String getVisualizzaprenotazioni() throws SQLException{
		String url = "jdbc:derby://localhost:1527/c:/Database;";
		String user = "app";
		String pwd = "app";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		Statement st = conn.createStatement();
		ResultSet rs;
		String prenotazioni = "";
		rs = st.executeQuery("SELECT * FROM PRENOTAZIONI WHERE USERNAME='"+username+"'");
		prenotazioni="Le tue prenotazioni, "+username+"<br><br>";
		    
		while (rs.next()){
			if((Integer.parseInt(rs.getString("EVASO")))==0){
				prenotazioni +="<br> Ordine"+rs.getString("ORDINE") +" Data"+ rs.getString("DATA")+", Totale: "+rs.getDouble("TOTALE")+" euro<br>";
				prenotazioni += "<a href=\"Controller?operazione=rimuovi_pre&cod="+rs.getInt("COD")+"\">cancella prenotazione</a><br><br>";
			}else{
				prenotazioni +="<br>"+rs.getString("ORDINE") +""+ rs.getString("DATA")+", Totale: "+rs.getDouble("TOTALE")+" euro<br>";
				prenotazioni += "<br>L'ordine è stato evaso.<br><br>";
			}
		} 
			
		st.close();
		conn.close();
		return prenotazioni;
	}
	
}