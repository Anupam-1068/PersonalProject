package ee.mainor.librarymanagementsystem.web;

import ee.mainor.librarymanagementsystem.dto.ReviewDto;
import ee.mainor.librarymanagementsystem.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("id")
    public List<ReviewDto> getBookByUserEmail(@RequestParam String userEmail) {
        return reviewService.getReviewByUserEmail(userEmail);
    }

    @PostMapping
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }

    @PutMapping("{id}")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto, @PathVariable Long id) {
        return reviewService.updateReview(id, reviewDto);

    }

    @DeleteMapping("{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
