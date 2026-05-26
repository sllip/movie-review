package appcenter.spring_study.controller;

import appcenter.spring_study.dto.review.ReviewRequestDto;
import appcenter.spring_study.dto.review.ReviewResponseDto;
import appcenter.spring_study.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("")
    public ReviewResponseDto register(@RequestBody ReviewRequestDto request) {
        return reviewService.create(request);
    }

    @GetMapping("")
    public List<ReviewResponseDto> searchAll() {
        return reviewService.searchAll();
    }

    @GetMapping("/{id}")
    public ReviewResponseDto search(@PathVariable Long id) {
        return reviewService.search(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
