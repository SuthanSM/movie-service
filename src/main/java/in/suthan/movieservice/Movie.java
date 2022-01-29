package in.suthan.movieservice;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Movie {

    @Id
    private String id;
    private String name;
    private String language;
    private String year;
    private String genre;
    private MovieType type;
    private Boolean isWatched;
}
