package ee.mainor.librarymanagementsystem.mapper;
import ee.mainor.librarymanagementsystem.dto.ReviewDto;
import ee.mainor.librarymanagementsystem.model.ReviewModel;

public class ReviewMapper {

    public static ReviewDto toDto(ReviewModel ReviewModels) {
        ReviewDto reviewDto = new ReviewDto();
        if (ReviewModels == null) {
            return reviewDto;
        }
        reviewDto.setId(ReviewModels.getId());
        reviewDto.setUserEmail(ReviewModels.getUserEmail());
        reviewDto.setDate(ReviewModels.getDate());
        reviewDto.setRating(ReviewModels.getRating());
        reviewDto.setReviewDescription(ReviewModels.getReviewDescription());
        return reviewDto;

    }

    public static ReviewModel toEntity(ReviewDto reviewDto, ReviewModel reviewModel) {
        if (reviewModel == null) {
            reviewModel = new ReviewModel();
        }
        if (reviewDto == null) {
            return reviewModel;
        }
        reviewModel.setUserEmail(reviewDto.getUserEmail());
        reviewModel.setDate(reviewDto.getDate());
        reviewModel.setRating(reviewDto.getRating());
        reviewModel.setReviewDescription(reviewDto.getReviewDescription());
        return reviewModel;
    }
}
