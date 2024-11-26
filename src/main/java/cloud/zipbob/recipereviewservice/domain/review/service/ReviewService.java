package cloud.zipbob.recipereviewservice.domain.review.service;

import cloud.zipbob.recipereviewservice.domain.review.request.*;
import cloud.zipbob.recipereviewservice.domain.review.response.GetReviewsResponse;
import cloud.zipbob.recipereviewservice.domain.review.response.ReviewResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    ReviewResponse createReview(ReviewCreateRequest request);

    GetReviewsResponse getReviewsByRecipe(GetReviewsByRecipeRequest request);

    GetReviewsResponse getReviewsByMember(GetReviewsByMemberRequest request);

    void deleteReview(ReviewRequest request);

    ReviewResponse updateReview(ReviewUpdateRequest request);
}
