package no.hvl.data102.classes;

import java.util.Objects;

public class Film {  
	
	private int filmnr;
	private int lansering;
	private String skaper;
	private String tittel;
	private String selskap;
	private Sjanger sjanger;
	

	public Film() {
		
	}


	public Film(int filmnr, int lansering, String skaper, String tittel, Sjanger sjanger, String selskap) {
		
		this.filmnr = filmnr;
		this.lansering = lansering;
		this.skaper = skaper;
		this.tittel = tittel;
		this.selskap = selskap;
		this.sjanger = sjanger;
	}


	public int getFilmnr() {
		return filmnr;
	}


	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}


	public int getLansering() {
		return lansering;
	}


	public void setLansering(int lansering) {
		this.lansering = lansering;
	}


	public String getSkaper() {
		return skaper;
	}


	public void setSkaper(String skaper) {
		this.skaper = skaper;
	}


	public String getTittel() {
		return tittel;
	}


	public void setTittel(String tittel) {
		this.tittel = tittel;
	}


	public String getSelskap() {
		return selskap;
	}


	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}


	public Sjanger getSjanger() {
		return sjanger;
	}


	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr;
	}
	
	@Override
	public String toString() {
				
		String print = "";
		String skille = "||==============================||";
		
	try {	
		String sjanger = this.sjanger.toString();
		
		print = "\n" + skille + "\n" +
                "   Filmtittel: " + tittel + "\n" +
		        "   Sjanger: " + sjanger + "\n" +
		        "   Film nummer: " + filmnr + "\n" +
				"   Lansering: " + lansering + "\n" +
				"   Filmskaper: " + skaper + "\n" +
				"   Filmselskap: " + selskap + "\n" +
		        skille + "\n";
				
	    }
	catch (Exception e) {
		System.out.println(e);
	}
	return print;
	}

	
} //Class
