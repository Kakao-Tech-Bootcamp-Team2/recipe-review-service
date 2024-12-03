package cloud.zipbob.recipereviewservice.domain.review.request;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public record ReviewCreateRequest(
        Long memberId,
        String recipeId,
        String content,
        @DecimalMin(value = "1.0", message = "Rating must be at least 1.0")
        @DecimalMax(value = "5.0", message = "Rating must be no more than 5.0")
        float rating,
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
