package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
    //app.launch();
  }

  private void test() throws SQLException{
	  //findFilmById
	 System.out.println("Find Film By ID: ");
    Film film = db.findFilmById(1);
    System.out.println(film);
    System.out.println();
	  
	  //findActorById
    System.out.println("Find Actor By ID: ");
	  Actor actor = db.findActorById(1);
	  System.out.println(actor);
	  System.out.println();
	  
	  //findActorsByFilmId
	  System.out.println("Find Actors By Film ID: ");
	  List<Actor> actors = db.findActorsByFilmId(2);
	  for(Actor actor2 : actors) {
		  System.out.println(actor2.toString());
	  }
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    
	  System.out.println("Enter actor ID: ");
	  int actorId = input.nextInt();
	  
	  
  }

}
