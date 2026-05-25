package appcenter.spring_study.dto.movie;

import lombok.Getter;

@Getter
public class MovieResponseDto {
    private Long movieId;
    private String title;
    private String director;
    private String genre;

    public MovieResponseDto(Long movieId, String title, String director, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.genre = genre;
    }
}
