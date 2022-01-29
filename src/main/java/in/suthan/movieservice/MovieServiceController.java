package in.suthan.movieservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class MovieServiceController {

    @Autowired
    private MovieRepository movieRepository;

    @PutMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        log.info("Saving movie: {}", movie);
        return movieRepository.save(movie);
    }

    @GetMapping("/")
    public String getRoot() {
        log.info("Get root");
        return "Welcome to Movie-Service";
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovie(@PathVariable String id) {
        log.info("Retrieving movie: {}", id);
        return movieRepository.findById(id);
    }

    @GetMapping("/movies")
    public List<Movie> getMovieByName(@RequestParam(required = false) String name) {
        if(name != null) {
            log.info("Retrieving movie by name: {}", name);
            return movieRepository.findMoviesByName(name);
        } else {
            log.info("Retrieving all movies");
            return movieRepository.findAll();
        }
    }
}