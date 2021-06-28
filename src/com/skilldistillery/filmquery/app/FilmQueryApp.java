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
		app.launch();
		//Verify program end.
		System.out.println("Program ended.");
	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean looping = true;
		while (looping) {
			// Display Menu Prompt and Execute Selected Method
			switch (menu(input)) {
			case 1:
				lookUpFilmById(input);
				break;
			case 2:
				lookUpFilmByKeyword(input);
				break;
			case 3:
				looping = false;
				//Program ends after this line is executed
				break;
			default:
			}
		}
	}
	
	//Method to display menu and return user selection as an int
	private int menu(Scanner input) {
		int menuSelection;
		while (true) {
			System.out.println("+---------------------------------------+");
			System.out.println("|                  Menu                 |");
			System.out.println("+---------------------------------------+");
			System.out.println("| 1. Look up film by its id             |");
			System.out.println("| 2. Look up a film by a search keyword |");
			System.out.println("| 3. Exit the application               |");
			System.out.println("+---------------------------------------+");
			System.out.print("+-> Enter a selection: ");
			menuSelection = input.nextInt();

			// Input Validation
			if (menuSelection < 1 || menuSelection > 3) {
				System.out.println("Invalid input. Please try again");
			}
			else
				break;
		}
		return menuSelection;
	}
	
	private void lookUpFilmById(Scanner input) {
		Film film;
		while (true) {
			System.out.print("Enter film ID: ");
			film = db.findFilmById(input.nextInt());
			//Input Validation
			if (film == null) {
				System.out.println("Input out of range. Please try again.");
			} 
			else
				break;
		}
		System.out.println(film);
		System.out.println();
	}
	
	private void lookUpFilmByKeyword(Scanner input) {
		List<Film> films;
		String keyword;
		System.out.print("Enter film search keyword: ");
		keyword = input.next();
		films = db.findFilmByKeyword("%" + keyword + "%");
		if(films.size() == 0) {
			System.out.println("\nNo results found.\n");
		}
		for (Film film : films) {
			System.out.println(film);
			System.out.println();
		}
	}

}
