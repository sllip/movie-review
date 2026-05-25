package appcenter.spring_study.service;

import appcenter.spring_study.entity.Movie;
import appcenter.spring_study.dto.movie.MovieRequestDto;
import appcenter.spring_study.dto.movie.MovieResponseDto;
import appcenter.spring_study.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponseDto create(MovieRequestDto request) {
        Movie movie = new Movie(
                request.getTitle(),
                request.getDirector(),
                request.getGenre()
        );

        movieRepository.save(movie);
        return new MovieResponseDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenre());
    }

    public MovieResponseDto search(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영화입니다."));

        return new MovieResponseDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenre()
        );
    }

    public List<MovieResponseDto> searchAll() {
        List<Movie> movies = movieRepository.findAll();

        List<MovieResponseDto> result = new ArrayList<>();

        for (Movie movie : movies) {
            result.add(new MovieResponseDto(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getGenre()
            ));
        }

        return result;
    }

    public void delete(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영화입니다."));
        movieRepository.delete(movie);
    }
}
