package no.hvl.data102.klient;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.classes.Filmarkiv2;

public class KlientFilmarkiv {
	
public static void main(String[] args) {
	
FilmarkivADT filma = new Filmarkiv2();

Meny meny = new Meny(filma);

meny.start();

 }
} //Class

