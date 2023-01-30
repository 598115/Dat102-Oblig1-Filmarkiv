
package no.hvl.data102.classes;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT { //Ferdig////

	private Film[] filmarkiv;
	private int antall;
	
	public Filmarkiv(int size) {
		
	    filmarkiv =  new Film[size];
		antall = 0;
		
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		
	Film[] nytab = new Film[n];
	int i = 0;
	while (i<n) {
		nytab[i] = tab[i];
		i++;
	}
	
	return nytab;
		
	}
	
	public Film[] utvid() {
		
		Film[] temp = new Film[filmarkiv.length*2];
		
		for(int i = 0; i < filmarkiv.length; i++) {
			
		if (filmarkiv[i] != null) {      //I tilfelle det er en nullpeker I tabellen
			temp[i] = filmarkiv[i];
		}
					
		}
		
		filmarkiv = temp;
				
		return filmarkiv;      
	}
	@Override
	public Film finnFilm(int nr) {
		
		Film[] temp = trimTab(filmarkiv, this.antall); //Trimmer tabell for å unngå nullpekere i gjennomgang
				
		for(int i = 0; i < temp.length; i++) {
			
			if(temp[i] == null) {
				return null;
			}
			if(temp[i].getFilmnr() == nr) {
				return temp[i];
			}			
		}
		return null;
		
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		
	if (antall < filmarkiv.length) {
		filmarkiv[antall] = nyFilm;
		antall++;
	}
	else {
		utvid();
		leggTilFilm(nyFilm);
	}
		
	}
	@Override
	public boolean slettFilm(int filmnr) {
		
	int pos = -1;
	Film[] temp = trimTab(filmarkiv, this.antall); //Trimmer tabell for å unngå nullpekere i gjennomgang
	
	for (int i = 0; i<temp.length; i++) {
		
		if(temp[i].getFilmnr() == filmnr) {
			pos = i;
		}		
	}	
	if(pos >= 0) {
		antall--;
		filmarkiv[pos] = filmarkiv[antall];
		filmarkiv[antall] = null;
		return true;
	}
	else {
	return false;	
	}

   }
	@Override
  public Film[] soekTittel(String delstreng) {
	   
    Film[] temp = trimTab(filmarkiv, this.antall);  //Trimmer tabell for å unngå nullpekere i gjennomgang
    Film[] result = new Film[temp.length];          //og redusere nullpeke i return(result) tabellen
                                                   
    int neste = 0;                                 
    
    for(int i = 0; i<temp.length; i++) {
    	
    	if (temp[i].getTittel().contains(delstreng)) {   //Søker I alle filmer om tittelen inneholder
    		                                            //delstrengen.   	
    		result[neste] = temp[i];                    
    		neste++;  	 
    	}    	
    }
    result = trimTab(result, neste);
    return result;
   }
  @Override
  public Film[] soekProdusent(String delstreng) {
	  	  
	  Film[] temp = trimTab(filmarkiv, this.antall); //Trimmer filmarkiv tabell for å unngå nullpekere i gjennomgang
	  Film[] result = new Film[temp.length];         //og redusere nullpekere i return(result) tabellen
	    int neste = 0;
	    
	    for(int i = 0; i<temp.length; i++) {
	    	
	    	if (temp[i].getSkaper().contains(delstreng)) {  //Søker I alle filmer om skaperen matcher
	    		                                           //delstrengen.	    	 	                                            
	    		result[neste] = temp[i];                    
	    		neste++;
	    	 
	    	}    	
	    }
	    result = trimTab(result, neste);
	    return result;
  }
  @Override
  public int antall(Sjanger sjanger) {
	  
	int antall = 0;
	Film[] temp = trimTab(filmarkiv, this.antall); //Trimmer tabell for å unngå nullpekere i gjennomgang
	
	for(int i = 0; i < temp.length; i++) {
		
		if(temp[i].getSjanger() == sjanger) {
			antall++;
		}		
	}
	  return antall;
  }
  
  public int antall() {
	  return antall;
  }
  
  @Override
  public String toString() {
	  
	  Film[] temp = trimTab(filmarkiv, antall);
	  String print = "";
	  
	  for(Film f: temp) {
		  
		print += f.toString();
		  
	  }
	  return print;
	  
  }
  		
} //Class

