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
		//app.test();
		 app.launch();
	}

	private void test() throws SQLException {
		// findFilmById
		System.out.println("Find Film By ID: ");
		Film film = db.findFilmById(1);
		System.out.println(film);
		System.out.println();

		// findActorById
		System.out.println("Find Actor By ID: ");
		Actor actor = db.findActorById(1);
		System.out.println(actor);
		System.out.println();

		// findActorsByFilmId
		System.out.println("Find Actors By Film ID: ");
		List<Actor> actors = db.findActorsByFilmId(2);
		for (Actor actor2 : actors) {
			System.out.println(actor2.toString());
		}
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean looping = true;
		int selection;
		while (looping) {
			while (true) {
				System.out.println("What would you like to do?");

				System.out.println("1. Look up film by its id");
				System.out.println("2. Look up a film by a search keyword");
				System.out.println("3. Exit the application");

				System.out.print("Enter a selection: ");
				selection = input.nextInt();
				if (selection < 0 || selection > 3) {
					System.out.println("Invalid input. Please try again");
				} else
					break;
			}

			switch (selection) {
			case 1:
				Film film;
				while(true) {
				System.out.print("Enter film ID: ");
				film = db.findFilmById(input.nextInt());
				if(film == null) {
					System.out.println("Input out of range. Please try again.");
				}
				else
					break;
				}
				System.out.println("-------------");
				System.out.println(film);
				System.out.println("-------------");
				System.out.println();
				break;
			case 2:
				List<Film> films;
				String keyword;
				System.out.print("Enter film search keyword: ");
				keyword = input.nextLine();
				films = db.findFilmByKeyword("%"+keyword+"%");
				for(Film film2 : films) {
					System.out.println(film2);
					System.out.println();
				}
				break;
			case 3:
				looping = false;
				break;
			default:
			}

		}
		System.out.println("Program ended.");
	}

}
