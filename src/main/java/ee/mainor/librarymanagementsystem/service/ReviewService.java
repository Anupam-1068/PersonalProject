package ee.mainor.librarymanagementsystem.service;

import ee.mainor.librarymanagementsystem.dto.ReviewDto;
import ee.mainor.librarymanagementsystem.libraryRepository.ReviewRepository;
import ee.mainor.librarymanagementsystem.mapper.ReviewMapper;
import ee.mainor.librarymanagementsystem.model.ReviewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDto> getAllReview(){
        List<ReviewModel> reviewModel = reviewRepository.getAllReview();

        return getReviewDtos(reviewModel);
    }

    public ReviewDto getReviewModelById(Long id){
        ReviewModel reviewModel = reviewRepository.findReviewModelById(id);

        return ReviewMapper.toDto(reviewModel);
    }
    public List<ReviewDto> getReviewByUserEmail(String userEmail){
        List<ReviewModel> ReviewModels = reviewRepository.findReviewModelByUserEmail(userEmail);

        return getReviewDtos(ReviewModels);

    }

    private static List<ReviewDto> getReviewDtos(List<ReviewModel> ReviewModels) {
        return ReviewModels.stream().map(ReviewModel -> {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setId(ReviewModel.getId());
            reviewDto.setUserEmail(ReviewModel.getUserEmail());
            reviewDto.setDate(ReviewModel.getDate());
            reviewDto.setRating(ReviewModel.getRating());
            reviewDto.setBookId(ReviewModel.getBookId());
            reviewDto.setReviewDescription(ReviewModel.getReviewDescription());
            return reviewDto;
        }).toList();
    }

    @Transactional
    public ReviewDto createReview(ReviewDto reviewDto) {

        ReviewModel reviewModel = ReviewMapper.toEntity(reviewDto, null);

        ReviewModel reviewModel1 = reviewRepository.save(reviewModel);

        return ReviewMapper.toDto(reviewModel1);

    }

    @Transactional
    public ReviewDto updateReview(Long id, ReviewDto reviewDto) {
        ReviewModel initialReview = requireReview(id);
        ReviewModel reviewModel = ReviewMapper.toEntity(reviewDto, initialReview);

        return ReviewMapper.toDto(reviewRepository.save(reviewModel));
    }
    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


    private ReviewModel requireReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Review with id: %s was not found", id)));
    }
}
