package appcenter.spring_study.service;

import appcenter.spring_study.domain.Movie;
import appcenter.spring_study.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class MovieServiceTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void 영화_등록() {
        Movie movie = new Movie(
                "Interstellar",
                "Christopher Nolan",
                "SF"
        );

        Movie savedMovie = movieRepository.save(movie);

        assertThat(savedMovie.getTitle()).isEqualTo("Interstellar");
    }
}
