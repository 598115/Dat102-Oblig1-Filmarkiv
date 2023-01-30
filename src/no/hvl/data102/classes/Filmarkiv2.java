package no.hvl.data102.classes;


import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT { //Ferdig

	private LinearNode<Film> start;
	private int antall;
	
	public Filmarkiv2() {	
	    start = null;
		antall = 0;		
	}
		

	private Film[] toTabell() {                   
		
		LinearNode<Film> temp = start;
		
		Film[] tab = new Film[antall];
		
		for(int i = 0; i < antall; i++) {
			
			tab[i] = temp.getElement();
						
			temp = temp.getNeste();			
		}
		return tab;
		}
	
	
	private boolean erTom() {
		
		if (antall == 0) {   
			return true;
		}
		else return false;		
	}
	
	private LinearNode<Film> finnNode(Film film) {
		
		boolean funnet = false;
		LinearNode<Film> noden = null;
		LinearNode<Film> compare = start;
		
		for (int i = 0; i < antall && !funnet; i++) {
			
			if(compare.getElement().equals(film)) {
				funnet = true;
				noden = compare;
			}
			else {
				compare = compare.getNeste();
			}
		}
		return noden;
	}
	
		
	@Override
	public Film finnFilm(int nr) {
	
	LinearNode<Film> compare = start;	//Brukes for å sammenligne filmnummerene i kjeden til paramateret.
	                                    //Begynner å lete i første noden i kjeden
	boolean funnet = false;
	Film filmen = null;                 //filmen det letes etter som skal returneres
	
	for(int i = 0; i < antall && !funnet; i++) {
		
		if(compare.getElement().getFilmnr() == nr) {
			funnet = true;
			filmen = compare.getElement();
		}
		else {
			compare = compare.getNeste();  //Om filmen ikke ble funnet i noden byttes noden til den neste i kjeden
		}		
	}				
      return filmen;   //Filmen returneres om den fantes I arkivet. null returneres ellers.
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
	
	LinearNode<Film> nynode = new LinearNode<Film>(nyFilm);
	
	nynode.setNeste(start);
	start = nynode;
	antall++;		

	}
		
	
	@Override
	public boolean slettFilm(int filmnr) {
		
		Film FilmSlett = finnFilm(filmnr); //Finner filmen som skal slettes
		LinearNode<Film> nodeSlett = finnNode(FilmSlett);
		boolean slettet = false;
		
		if(nodeSlett != null && !(erTom()) && !(nodeSlett.equals(start))) {
			
			nodeSlett.setElement(start.getElement());  
			start = start.getNeste();
			antall--;
			slettet = true;			
		}
		else if (!(erTom()) && (nodeSlett.equals(start))) {
			start = start.getNeste();
			antall--;
			slettet = true;
		}						
		return slettet;
   }
	
	@Override
  public Film[] soekTittel(String delstreng) {
	   
	  if (erTom()) {	
	  throw new NullPointerException("Arkivet er tomt"); 	  	  
	  }
	  
      LinearNode<Film> temp = start;
      Filmarkiv2 retur = new Filmarkiv2();
           
      for(int i = 0; i < antall; i++) {
    	  
    	  if(temp.getElement().getTittel().contains(delstreng)) {
    		  retur.leggTilFilm(temp.getElement());
    	  }
    	       	      temp = temp.getNeste();   	    
      }
    Film[] returTab = retur.toTabell();
    return returTab;
   }
	
  @Override
  public Film[] soekProdusent(String delstreng) {
	  	  
if (erTom()) { throw new NullPointerException("Arkivet er tomt");}
	  
      LinearNode<Film> temp = start;
      Filmarkiv2 retur = new Filmarkiv2();
      
      
      for(int i = 0; i < antall; i++) {
    	  
    	  if(temp.getElement().getSkaper().contains(delstreng)) {
    		  retur.leggTilFilm(temp.getElement());
    	  }   	    
    	      temp = temp.getNeste();
       }
    
    Film[] returTab = retur.toTabell();
    return returTab;
	  
  }
  
  @Override
  public int antall(Sjanger sjanger) {	 
  
  int antall = 0;
  LinearNode<Film> temp = start;
  
  for(int i = 0; i<this.antall; i++) {
	  
	  if(temp.getElement().getSjanger() == sjanger) {
		  antall++;
	  }
      if (temp.getNeste() != null) {  
	      temp = temp.getNeste();
      }
  }
   return antall; 
  }
  

  @Override
  public int antall() {
	
	return this.antall;
 }
  	
	
} //Class