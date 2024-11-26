package cloud.zipbob.recipereviewservice.domain.review.request;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record ReviewCreateRequest(
        Long memberId,
        String recipeId,
        String content,
        @Min(value = 1, message = "Rating must be between 1 and 5")
        @Max(value = 5, message = "Rating must be between 1 and 5")
        int rating,
        String authorNickname
) {
    public Review toEntity() {
        return Review.builder()
                .memberId(memberId)
                .recipeId(recipeId)
                .content(content)
                .rating(rating)
                .authorNickname(authorNickname)
                .build();
    }
}
