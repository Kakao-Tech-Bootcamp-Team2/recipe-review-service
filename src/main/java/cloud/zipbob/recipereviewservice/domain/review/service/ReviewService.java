package cloud.zipbob.recipereviewservice.domain.review.service;

import cloud.zipbob.recipereviewservice.domain.review.request.*;
import cloud.zipbob.recipereviewservice.domain.review.response.GetReviewsResponse;
import cloud.zipbob.recipereviewservice.domain.review.response.ReviewResponse;

public interface ReviewService {
    ReviewResponse createReview(ReviewCreateRequest request, Long authenticatedMemberId);

    GetReviewsResponse getReviewsByRecipe(GetReviewsByRecipeRequest request);

    GetReviewsResponse getReviewsByMember(GetReviewsByMemberRequest request, Long authenticatedMemberId);

    void deleteReview(ReviewRequest request, Long authenticatedMemberId);

    ReviewResponse updateReview(ReviewUpdateRequest request, Long authenticatedMemberId);
}
