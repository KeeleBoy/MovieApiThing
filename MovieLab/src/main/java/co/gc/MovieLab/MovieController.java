package co.gc.MovieLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.gc.MovieLab.Entity.Movie;
import co.gc.MovieLab.dao.MovieDao;

@RestController

public class MovieController {

	@Autowired
	private MovieDao movieDao;

	@GetMapping("/movies")
	public List<Movie> listMovies() {
		return movieDao.findAll();
	}

	@GetMapping("/genre/{genre}")
	public List<Movie> listCategories(@PathVariable(value = "genre", required = false) String genre) {
		return movieDao.findByGenreContainingIgnoreCaseOrderByName(genre);
	}

	@GetMapping("/movies/name")
	public List<Movie> name(@RequestParam("name") String name) {
		return movieDao.findByNameContainingIgnoreCaseOrderByName(name);
	}

	@GetMapping("/movies/random")
	public Movie name1() {
		Random rand = new Random();
		Long num = (long) (rand.nextInt(3) + 1);
		return movieDao.findById(num).orElse(null);
	}

	@GetMapping("/movies/random/{genre}")
	public Movie randomWithGenre(@PathVariable(value = "genre", required = false) String genre) {
		Random rand = new Random();

		List<Movie> list = new ArrayList<>();
		list.addAll(movieDao.findByGenreContainingIgnoreCaseOrderByName(genre));

		int num = (rand.nextInt(list.size()));
		return list.get(num);
	}

	@GetMapping("/movies/random-list")
	public ArrayList<Movie> randomMovies(@RequestParam(value = "size", required = false) int size) {

		ArrayList<Movie> list = new ArrayList<>();
		list.addAll(movieDao.findAll());

		ArrayList<Movie> list2 = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			Random rand = new Random();
			int randomNumer = rand.nextInt(list.size());
			list2.add(list.get(randomNumer));

		}

		return list2;

	}
}
