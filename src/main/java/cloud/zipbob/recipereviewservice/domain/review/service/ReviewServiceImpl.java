package cloud.zipbob.recipereviewservice.domain.review.service;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import cloud.zipbob.recipereviewservice.domain.review.exception.ReviewException;
import cloud.zipbob.recipereviewservice.domain.review.exception.ReviewExceptionType;
import cloud.zipbob.recipereviewservice.domain.review.repository.ReviewRepository;
import cloud.zipbob.recipereviewservice.domain.review.request.*;
import cloud.zipbob.recipereviewservice.domain.review.response.GetReviewsResponse;
import cloud.zipbob.recipereviewservice.domain.review.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponse createReview(ReviewCreateRequest request) {
        Review review = request.toEntity();
        reviewRepository.save(review);
        return ReviewResponse.of(review);
    }

    @Override
    public GetReviewsResponse getReviewsByRecipe(GetReviewsByRecipeRequest request) {
        List<Review> reviews = reviewRepository.findByRecipeId(request.recipeId());
        if(reviews.isEmpty()) {throw new ReviewException(ReviewExceptionType.REVIEW_NOT_FOUND_FOR_RECIPE);}
        return GetReviewsResponse.of(reviews);
    }

    @Override
    public GetReviewsResponse getReviewsByMember(GetReviewsByMemberRequest request) {
        List<Review> reviews = reviewRepository.findByMemberId(request.memberId());
        if(reviews.isEmpty()) {throw new ReviewException(ReviewExceptionType.REVIEW_NOT_FOUND_FOR_MEMBER);}
        return GetReviewsResponse.of(reviews);
    }

    @Override
    public void deleteReview(ReviewRequest request) {
        Review review = reviewRepository.findById(request.reviewId()).orElseThrow(() -> new ReviewException(ReviewExceptionType.REVIEW_NOT_FOUND));
        reviewRepository.delete(review);
    }

    @Override
    public ReviewResponse updateReview(ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(request.reviewId()).orElseThrow(() -> new ReviewException(ReviewExceptionType.REVIEW_NOT_FOUND));
        review.updateReview(request.content(), request.rating());
        reviewRepository.save(review);
        return ReviewResponse.of(review);
    }
}
