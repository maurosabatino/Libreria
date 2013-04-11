package model;

public class Libro {
	private int id;
	private String titolo;
	private String autore;
	private double prezzo;
	private int quantit�;
	
	public Libro(){
		id=0;
		titolo="sconosciuto";
		autore="sconosciuto";
		prezzo=0.0;
		quantit�=1;
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
	public int getQuantit�(){
		return this.quantit�;
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
	public void setQuantit�(int quantit�){
		this.quantit�=quantit�;
	}
	public String toString(){
		String out="Libro "+id+", "+titolo+", "+autore+", "+prezzo+", "+quantit�+" \n";
		return out;
	}
}
