package appcenter.spring_study.service;

import appcenter.spring_study.entity.Movie;
import appcenter.spring_study.entity.Review;
import appcenter.spring_study.dto.review.ReviewRequestDto;
import appcenter.spring_study.dto.review.ReviewResponseDto;
import appcenter.spring_study.repository.MovieRepository;
import appcenter.spring_study.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewResponseDto create(ReviewRequestDto request) {
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영화입니다."));

        Review review = new Review(
                request.getRating(),
                request.getContent(),
                request.getSpoilerContains()
        );

        review.setMovie(movie);

        reviewRepository.save(review);
        return new ReviewResponseDto(
                review.getReviewId(),
                review.getMovie().getMovieId(),
                review.getRating(),
                review.getContent(),
                review.getSpoilerContains()
        );
    }

    public ReviewResponseDto search(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다."));

        return new ReviewResponseDto(
                review.getReviewId(),
                review.getMovie().getMovieId(),
                review.getRating(),
                review.getContent(),
                review.getSpoilerContains()
        );
    }

    public List<ReviewResponseDto> searchAll() {

        List<Review> reviews = reviewRepository.findAll();

        List<ReviewResponseDto> result = new ArrayList<>();

        for (Review review : reviews) {
            result.add(new ReviewResponseDto(
                    review.getReviewId(),
                    review.getMovie().getMovieId(),
                    review.getRating(),
                    review.getContent(),
                    review.getSpoilerContains()
            ));
        }

        return result;
    }

    public void delete(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다."));
        reviewRepository.delete(review);
    }
}
