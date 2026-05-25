package appcenter.spring_study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    private Double rating;

    private String content;

    @Column(name = "contains_spoiler")
    private Boolean spoilerContains;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review(Double rating, String content, Boolean spoilerContains) {
        this.rating = rating;
        this.content = content;
        this.spoilerContains = spoilerContains;
    }
}
