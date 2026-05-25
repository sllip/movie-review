package appcenter.spring_study.controller;

import appcenter.spring_study.dto.movie.MovieRequestDto;
import appcenter.spring_study.dto.movie.MovieResponseDto;
import appcenter.spring_study.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("")
    public MovieResponseDto register(@RequestBody MovieRequestDto request) {
        return movieService.create(request);
    }

    @GetMapping("")
    public List<MovieResponseDto> searchAll() {
        return movieService.searchAll();
    }

    @GetMapping("/{id}")
    public MovieResponseDto search(@PathVariable Long id) {
        return movieService.search(id);
    }

    public String delete(@PathVariable Long id) {
        movieService.delete(id);
        return "영화가 삭제되었습니다.";
    }
}
