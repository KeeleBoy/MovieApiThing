package co.gc.MovieLab.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String genre;

	@Override
	public String toString() {
		return "Movie [id=" + id + ", genre=" + genre + ", name=" + name + "]";
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	private String name;

}
