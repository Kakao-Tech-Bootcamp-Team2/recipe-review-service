package cloud.zipbob.recipereviewservice.domain.review.response;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewResponse {
    private String reviewId;
    private Long memberId;
    private String recipeId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static ReviewResponse of(Review review) {
        return new ReviewResponse(review.getId(), review.getMemberId(), review.getRecipeId(), review.getCreatedDate(), review.getUpdatedDate());
    }
}
