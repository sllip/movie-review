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
        //given
        Movie movie = new Movie(
                "Interstellar",
                "Christopher Nolan",
                "SF"
        );

        //when
        Movie savedMovie = movieRepository.save(movie);

        //then
        assertThat(savedMovie.getTitle()).isEqualTo("Interstellar");
        assertThat(savedMovie.getDirector()).isEqualTo("Christopher Nolan");
        assertThat(savedMovie.getGenre()).isEqualTo("SF");
    }
}
