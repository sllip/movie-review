package appcenter.spring_study.dto.review;

import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long reviewId;
    private Long movieId;
    private Double rating;
    private String content;
    private Boolean spoilerContains;

    public ReviewResponseDto(Long reviewId, Long movieId, Double rating, String content, Boolean spoilerContains) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.rating = rating;
        this.content = content;
        this.spoilerContains = spoilerContains;
    }
}
