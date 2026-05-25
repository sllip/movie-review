package appcenter.spring_study.dto.review;

import lombok.Getter;

@Getter
public class ReviewRequestDto {
    private Long movieId;
    private Double rating;
    private String content;
    private Boolean spoilerContains;
}
