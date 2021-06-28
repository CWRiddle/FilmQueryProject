package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Film {

	// Fields
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> cast;
	private String language;
	private String category;
	//toStringHelper Fields
	Map<Integer, String> fdo = new HashMap<>();
	Map<String, Integer> fsl = new HashMap<>();

	// Constructors
	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> cast, String language, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.cast = cast;
		this.language = language;
		this.category=category;
		toStringFormatHelper();
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	// toString, hashCode, equals methods...
	@Override
	public String toString() {
		int nRows = 7;
		
		//Populate Dashed and Spaced Lines using appropriate lengths
		StringBuilder dynamicDashedLine = new StringBuilder();
		List<StringBuilder> dynamicSpacedLine = new ArrayList<>();
		
		//Populate Dashed Line
		for(int i=0; i<=this.description.length()+1; i++) {
			dynamicDashedLine.append("-");
		}
		
		//Populate Spaced Line
		for(int i=0; i<nRows; i++) {
			dynamicSpacedLine.add(new StringBuilder());
			for(int j=0; j<description.length()-fsl.get(fdo.get(i)); j++) {
				dynamicSpacedLine.get(i).append(" ");
			}
		}
		
		//Format Cast String
		StringBuilder formattedFilmCast = new StringBuilder();
		for(Actor actor : cast) {
			formattedFilmCast.append("\n| - " + actor);
		}
		formattedFilmCast.append("\n+--------------");
		
		return "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|TITLE:       | " + title + dynamicSpacedLine.get(0) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|RELEASE YEAR:| " + releaseYear + dynamicSpacedLine.get(1) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|RATING:      | " + rating +  dynamicSpacedLine.get(2) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|CATEGORY:    | " + category + dynamicSpacedLine.get(3) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|DESCRIPTION: | " + description + dynamicSpacedLine.get(4) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|LANGUAGE:    | " + language +  dynamicSpacedLine.get(5) + " |" +
			   "\n+-------------+" + dynamicDashedLine + "+" +
			   "\n|CAST:        |" +
			   "\n+-------------+" +
			   formattedFilmCast;
	}
	
	private void toStringFormatHelper() {
		
		//Map<String, Integer> fsl = new HashMap<>();
		
		fsl.put("id", String.valueOf(this.id).length());
		fsl.put("title", this.title.length());
		fsl.put("description", this.description.length());
		fsl.put("releaseYear", String.valueOf(this.releaseYear).length());
		fsl.put("languageId", String.valueOf(this.languageId).length());
		fsl.put("rentalDuration", String.valueOf(this.rentalDuration).length());
		fsl.put("rentalRate", String.valueOf(this.rentalRate).length());
		fsl.put("length", String.valueOf(this.length).length());
		fsl.put("replacementCost", String.valueOf(this.replacementCost).length());
		fsl.put("rating", this.rating.length());
		fsl.put("specialFeatures", this.specialFeatures.length());
		fsl.put("language", this.language.length());
		fsl.put("category", this.category.length());
		
		//Map<Integer, String> fdo = new HashMap<>();
		
		fdo.put(6, "id");
		fdo.put(0, "title");
		fdo.put(4, "description");
		fdo.put(1, "releaseYear");
		fdo.put(7, "languageId");
		fdo.put(8, "rentalDuration");
		fdo.put(9, "rentalRate");
		fdo.put(10, "length");
		fdo.put(11, "replacementCost");
		fdo.put(2, "rating");
		fdo.put(12, "specialFeatures");
		fdo.put(5, "language");
		fdo.put(3, "category");
		
	}

//BACKUP TOSTRING METHOD
//	@Override
//	public String toString() {
//		return "FILM ID: " + id + "\nTITLE: " + title + "\nDESCRIPTION: " + description + "\nRELEASE YEAR: " + releaseYear
//				+ "\nLANGUAGE ID: " + languageId + "\nRENTAL DURATION: " + rentalDuration + "\nRENTAL RATE: " + rentalRate
//				+ "\nLENGTH: " + length + "\nREPLACEMENT COST: " + replacementCost + "\nRATING: " + rating
//				+ "\nSPECIAL FEATURES: " + specialFeatures + "\nCAST: " + cast;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
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
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
