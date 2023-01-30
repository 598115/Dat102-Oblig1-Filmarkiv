package no.hvl.data102.klient;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.classes.Film;
import no.hvl.data102.classes.Sjanger;

public class Meny {
	
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
	
    tekstgr = new Tekstgrensesnitt();
    this.filmarkiv = filmarkiv;

    }

  public void start(){
   
Film film1 = new Film(1, 2012, "Quentin Tarantino", "Django Unchained", Sjanger.DRAMA, "The Weinstein Company");
Film film2 = new Film(2, 1994, "Quentin Tarantino", "Kill Bill 2", Sjanger.DRAMA, "Miramax Films");	
Film film3 = new Film(3, 2003, "Quentin Tarantino", "Kill Bill 1", Sjanger.ACTION, "A Band Apart");	
Film film4 = new Film(4, 2012, "Kevin Feige", "The Avengers", Sjanger.ACTION, "Marvel Studios");	
Film film5 = new Film(5, 2007, "Michael Bay", "Transformers", Sjanger.ACTION, "DreamWorks");	

//Film film6 = tekstgr.lesFilm();
//filmarkiv.leggTilFilm(film6);

filmarkiv.leggTilFilm(film1);
filmarkiv.leggTilFilm(film2);
filmarkiv.leggTilFilm(film3);
filmarkiv.leggTilFilm(film4);
filmarkiv.leggTilFilm(film5);

//filmarkiv.slettFilm(1);             //Sletter basert på filmnummer (Parameter nr 1)
//filmarkiv.slettFilm(2);
//filmarkiv.slettFilm(3);
//filmarkiv.slettFilm(4);
//filmarkiv.slettFilm(5);
//filmarkiv.slettFilm(6);


tekstgr.visFilm(film5);

tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Kill");

tekstgr.skrivUtFilmProdusent(filmarkiv, "Quentin Tarantino");

tekstgr.skrivUtStatistikk(filmarkiv);


  }


}//Class



