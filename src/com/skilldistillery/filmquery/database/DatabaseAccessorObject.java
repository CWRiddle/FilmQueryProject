package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	public static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);

				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures, findActorsByFilmId(filmId));
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE actor.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);

				actor = new Actor(id, firstName, lastName);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors= new ArrayList<>();
		Actor actor = null;
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT DISTINCT actor.id, actor.first_name, actor.last_name, film.title "
					+ "FROM actor "
					+ "JOIN film_actor "
					+ "ON actor.id=film_actor.actor_id "
					+ "JOIN film "
					+ "ON film_actor.film_id=film.id WHERE film.id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				
				actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return actors;
	}

}
