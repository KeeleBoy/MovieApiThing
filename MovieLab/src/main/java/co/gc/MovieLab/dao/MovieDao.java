package co.gc.MovieLab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gc.MovieLab.Entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

	List<Movie> findByNameContainingIgnoreCaseOrderByName(String name);

	List<Movie> findByGenreContainingIgnoreCaseOrderByName(String category);

}
