package in.suthan.movieservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findMoviesByName(String name);
}
