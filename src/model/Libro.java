package model;

public class Libro {
	private int id;
	private String titolo;
	private String autore;
	private double prezzo;
	
	public Libro(){
		id=0;
		titolo="sconosciuto";
		autore="sconosciuto";
		prezzo=0.0;
	}
	
	public String getTitolo(){
		return this.titolo;
	}
	public int getId(){
		return this.id;
	}
	public String getAutore(){
		return this.autore;
	}
	public double getPrezzo(){
		return this.prezzo;
	}
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setAutore(String autore){
		this.autore=autore;
	}
	public void setPrezzo(double prezzo){
		this.prezzo=prezzo;
	}
}
