package no.hvl.data102.klient;

import java.util.Arrays;

import javax.swing.JOptionPane;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.classes.Film;
import no.hvl.data102.classes.Sjanger;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm(){
	
	try {	
	int filmnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn film nummer: "));	
	int lansering = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn lansering: "));	
	
	String skaper = JOptionPane.showInputDialog("Skriv inn skaper: ");
	String tittel = JOptionPane.showInputDialog("Skriv inn tittel: ");
	String selskap = JOptionPane.showInputDialog("Skriv inn filmselskap: ");
	
	String sjangerString = JOptionPane.showInputDialog("Skriv inn sjanger: ");
	Sjanger sjanger = Sjanger.finnSjanger(sjangerString);
	
	Film film = new Film(filmnr, lansering, skaper, tittel, sjanger, selskap);
	
	return film;
	}
	catch(Exception e) {
		System.out.print(e);
	}
	return null;
	
	}
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
	
	System.out.println(film.toString());	
		
	}
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma,
	 String delstreng) {
	
	Film[] titler = filma.soekTittel(delstreng);
	
	System.out.println(Arrays.toString(titler));
		
	}
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
    	
	Film[] titler = filma.soekProdusent(delstreng);
	System.out.println(Arrays.toString(titler));	
		
	}
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger	
	public void skrivUtStatistikk(FilmarkivADT filma) {
	
	String statistikk = "\nAntall filmer: " + filma.antall() + "\n" +	
	                    "Antall Action filmer: " + filma.antall(Sjanger.ACTION) + "\n" +
	                    "Antall Drama filmer: " + filma.antall(Sjanger.DRAMA) + "\n" +
	                    "Antall SCI-FI filmer: " + filma.antall(Sjanger.SCIFI) + "\n" +
	                    "Antall Western filmer: " + filma.antall(Sjanger.WESTERN);
	System.out.println(statistikk);	
		
	}
	
}// Class
